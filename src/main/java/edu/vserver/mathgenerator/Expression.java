package edu.vserver.mathgenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

class Expression {

	static final int MAXATTEMPTS = 100;
	static Random random = new Random();

	/**
	 * Generates an expression according to the given options.
	 * 
	 * @param options
	 * @return
	 */
	public static ArrayList<String> generateExpression(
			MathGeneratorExerciseData options) {

		Node head;
		int counter = 0;
		do {
			counter++;
			int operatorCounter = 0;
			do{
				head = populateOperators(options);
				if(operatorCounter++ > 20) //giving up
					break;
			}while(options.getForceParenthesis() && !head.toInFixExpression().toString().contains(")"));

			// System.out.println("operators are "+head.toInFixExpression().toString());

			populateTermBounds(head, options);

			if (!calculateOperatorBounds(head, options)) {
				counter--;
				continue;
			}
			// this method could be used to limit the range in intermediate
			// calculations, which is not yet implemented.
			// setOperatorBounds(head, options);

		} while (!populateTerms(head, options) && counter < MAXATTEMPTS);

		// System.out.println("postfix: "+head.toPostfixExpression().toString());

		return head.toInFixExpression();
	}

	/**
	 * Sets the bounds for all nodes in the subtree starting from the given
	 * head.
	 * 
	 * @param head
	 *            The node to start applying from.
	 * @param operators
	 *            If true, the range will be applied only to operators. If
	 *            false, the range will be applied only to the terms.
	 */
	private static void setBounds(Node head, double[] range, boolean operators) {
		head.setOperatorBounds(range, operators);
	}

	/**
	 * Sets the bounds from the options to terms in the subtree starting from
	 * the given head.
	 * 
	 * @param head
	 * @param options
	 */
	private static void populateTermBounds(Node head,
			MathGeneratorExerciseData options) {
		if (options.getBoundingType() == BoundingType.SOLUTION) {
			double[] range = options.getRangeForSolution();
			range[0] = 0;
			range[1] *= 10.0;
			setBounds(head, range, false);
		} else {
			ArrayList<Node> terms = head.findTerms();

			for (int i = 0; i < terms.size(); i++) {
				terms.get(i).setRange(options.getRangeAsDouble(i));
			}
		}
	}

	/**
	 * Sets the range for the appropriate value for each operator. Each operator
	 * is calculated an intermediate range which makes it possible to get a
	 * valid solution.
	 * 
	 * @param head
	 * @param options
	 */
	private static boolean calculateOperatorBounds(Node head,
			MathGeneratorExerciseData options) {
		head.setRange(options.getRangeForSolution());
		return head.calculateOperatorBoundsRecursive(options);
	}

	/**
	 * Populates the terms for this expression appropriately.
	 * 
	 * @param head
	 * @param options
	 * @return True if term population was successful, false otherwise.
	 */
	private static boolean populateTerms(Node head,
			MathGeneratorExerciseData options) {
		if (options.getBoundingType() == BoundingType.TERMS) {
			populateTermsWhenBoundByTerms(head, options);
		} else {
			int counter = 0;
			do {
				head.setIntermediateResult(new Term(options.getRandomSolution()));
				counter++;
			} while (!head.populateTermsRecursively(options)
					&& counter < MAXATTEMPTS);

			if (counter == MAXATTEMPTS) {
				// we didn't find an expression that fits the bounds, so we just
				// ignore the bounds
				populateTermsWhenBoundByTerms(head, options);
			} else {
				// we succeeded, so all that needs to be done is set the correct
				// number of decimals
				ArrayList<Node> terms = head.findTerms();
				for (int i = 0; i < terms.size(); i++) {
					Node node = terms.get(i);
					if (node.element != null) {
						((Term) node.element).setDecimals(options
								.getNumberOfDecimalsInTerm(i));
					}
				}
			}
			// return head.withinRange( head.evaluate().getAsDouble(),
			// head.getRange() ) ;

		}
		return true;
	}

	private static void populateTermsWhenBoundByTerms(Node head,
			MathGeneratorExerciseData options) {
		ArrayList<Node> terms = head.findTerms();

		for (int i = 0; i < terms.size(); i++) {
			Node n = terms.get(i);
			Term term;
			do {
				term = new Term(options.getRandomTerm(i));
			} while (term.isApproximately(Term.ZERO, 1));
			n.setElement(term);
		}
	}

	/**
	 * Populates the operators appropriately for this expression.
	 * 
	 * @param options
	 * @return
	 */
	private static Node populateOperators(MathGeneratorExerciseData options) {
		Operator randomOperator;
		if(options.getAllowParenthesis())
			randomOperator = options.getRandomAllowedOperator();
		else{
			randomOperator = Operator.SUM;
		}
		
		ArrayList<Node> emptyNodes = new ArrayList<>();

		Node head = new Node(randomOperator);

		Node currentNode = head;
		emptyNodes.add(head);
		int terms = 1;
		do {
			currentNode = getRandomElementFromList(emptyNodes);
			randomOperator = options.getRandomAllowedOperator();
			currentNode.setElement(randomOperator);
			emptyNodes.remove(currentNode);
			currentNode.createChildren();
			Collections.addAll(emptyNodes, currentNode.getChildren());
			terms++;
		} while (terms < options.getNumberOfTerms());

		
		if(options.getAllowParenthesis() && !options.getForceParenthesis()){
		//do nothing
		}else{			
			adjustOperatorsForParenthesis(head, options);
		}
		
		return head;
	}

	private static void adjustOperatorsForParenthesis(Node node, MathGeneratorExerciseData options) {
		if(node.isLeafNode())
			return;
		
		Operator randomOperator = Operator.SUM;
		
		Node nextNode;
		if(options.getAllowParenthesis() && options.getForceParenthesis())
			nextNode = node.leftChild;
		else
			nextNode = node.rightChild;
		
		if(nextNode.isLeafNode()){
			randomOperator = options.getRandomAllowedOperator();
		}
		node.setElement(randomOperator);
		
		if(node.leftChild != null)
			adjustOperatorsForParenthesis(node.leftChild, options);
		if(node.rightChild != null)
			adjustOperatorsForParenthesis(node.rightChild, options);
		
	}
	
	private static ArrayList<Operator> getOperatorsForNoParenthesis(EquationElement element, MathGeneratorExerciseData options) {
		ArrayList<Operator> result = new ArrayList<>();
		for(Operator o : options.getOperators()){
			if(element.getPriority() > o.getPriority()){
				result.add(o);
			}
		}
		if(result.isEmpty())
			result.add(Operator.SUM);
		return result;
	}

	private static <T> T getRandomElementFromList(ArrayList<T> list) {
		return list.get(random.nextInt(list.size()));
	}

	/**
	 * A node in the expression tree.
	 * 
	 * @author Erno
	 * 
	 */
	private static class Node {

		private Node leftChild;
		private Node rightChild;
		private final Node parent;

		private double[] range;
		private final int allowedDecimals = 0;

		// both are needed to ensure even operators have an intermediate result
		private EquationElement element;
		private Term intermediateResult;

		Node() {
			this(null, null);
		}

		Node(EquationElement element, Node parent) {
			leftChild = null;
			rightChild = null;
			this.parent = parent;

			this.element = element;

			range = new double[0];
		}

		Node(Node parent) {
			this(null, parent);
		}

		Node(EquationElement element) {
			this(element, null);
		}

		public boolean hasRange() {
			return range.length == 2;
		}

		public double[] getRange() {
			return range;
		}

		public void setRange(double[] newRange) {
			range = newRange;
		}

		public int getDecimals() {
			return intermediateResult == null ? 0 : intermediateResult
					.getDecimals();
		}

		public void setInfiniteRange() {
			range = new double[] { Double.MIN_VALUE, Double.MAX_VALUE };
		}

		/**
		 * Sets the given range to nodes in this subtree recursively.
		 * 
		 * @param operatorRange
		 *            the range to apply
		 * @param operators
		 *            If true, set the range to operators, if false set it to
		 *            terms.
		 */
		public void setOperatorBounds(double[] operatorRange, boolean operators) {
			if (isLeafNode()) {
				if (!operators)
					range = operatorRange;
				return;
			}
			leftChild.setOperatorBounds(operatorRange, operators);
			rightChild.setOperatorBounds(operatorRange, operators);

			if (operators) {
				range = operatorRange;
			}
		}

		/**
		 * Calculates the bounds for each intermediate result (operator) so that
		 * at least one result can be found within them.
		 * 
		 * @param options
		 * @return True if operator bounds are set correctly, false otherwise
		 */
		public boolean calculateOperatorBoundsRecursive(
				MathGeneratorExerciseData options) {
			if (!(element instanceof Operator)) { // sanity check
				return true;
			}

			Operator operator = (Operator) element;
			if (hasRange()) {
				if (leftChild.hasRange() && rightChild.hasRange()) {
					// last subtree: if this expression is possible, then the
					// whole tree is valid, and at least one solution can be
					// found.
					return operator.validateBounds(leftChild.getRange(),
							rightChild.getRange(), getRange());
				}

				if (!leftChild.hasRange()) {
					if (rightChild.hasRange()) {
						leftChild.setRange(operator.getTermRange(
								rightChild.getRange(), getRange()));
					}
					leftChild.calculateOperatorBoundsRecursive(options);
				}
				if (!rightChild.hasRange()) {
					if (leftChild.hasRange()) {
						rightChild.setRange(operator.getTermRange(
								leftChild.getRange(), getRange()));
					}
					rightChild.calculateOperatorBoundsRecursive(options);
				}

			} else { // no range for this operator; basically the left branch of
						// the tree
				if (!leftChild.hasRange()) {
					leftChild.calculateOperatorBoundsRecursive(options);
				}
				if (!rightChild.hasRange()) {
					rightChild.calculateOperatorBoundsRecursive(options);
				}
				setRange(operator.getSolutionRange(leftChild.getRange(),
						rightChild.getRange()));
			}
			return true;
		}

		/**
		 * Returns a list of all the terms in this expression.
		 * 
		 * @return
		 */
		public ArrayList<Node> findTerms() {
			ArrayList<Node> result = new ArrayList<Node>();
			findTermsRecursive(result);
			return result;
		}

		private void findTermsRecursive(ArrayList<Node> list) {
			if (element == null || element instanceof Term)
				list.add(this);
			if (leftChild != null)
				leftChild.findTermsRecursive(list);
			if (rightChild != null)
				rightChild.findTermsRecursive(list);
		}

		/**
		 * Populates the terms using intermediate results such that the
		 * generated expression is bounded by both the terms and the solution.
		 * Assumes the head node has an intermediate result (i.e the solution)
		 * set
		 * 
		 * @param options
		 * @return true if generation succeeded, false if it failed.
		 */
		public boolean populateTermsRecursively(
				MathGeneratorExerciseData options) {

			if (isLeafNode()) {
				// should always return true, but just in case...

				// if(!withinRange(getIntermediateResult(options).getAsDouble(),
				// getRange()))
				// System.out.println("isLeadNode check returned false");

				return withinRange(
						getIntermediateResult(options).getAsDouble(),
						getRange());
			}
			double multiplier = Math.pow(10,
					options.getNumberOfDecimalsInSolution());

			boolean everythingOK = true;
			Operator operator = (Operator) element;
			int decimalTarget = options.getNumberOfDecimalsInSolution();

			int[] results = tryObscure(operator, multiplier);

			if (results == null) {
				// first random operator was no good
				ArrayList<Operator> list = options.getOperators();
				Collections.shuffle(list);
				for (Operator o : list) {
					if (o.equals(operator)) {
						// no point in wasting cpu cycles trying to obscure with
						// the same operator...
						continue;
					}
					results = tryObscure(o, multiplier);
					if (results != null) {
						// found a more suitable operator
						element = o;
						operator = o;
						break;
					}
				}
				if (results == null) {
					// no luck, gotta generate the whole tree again...
					return false;
				}
			}

			int leftIntermediate = 0;
			int rightIntermediate = 0;
			// still need to divide the decimal places to the results
			if (operator.equals(Operator.SUM)
					|| operator.equals(Operator.SUBTRACT)) {
				leftIntermediate = decimalTarget;
				rightIntermediate = decimalTarget;
			} else if (operator.equals(Operator.DIVISION)) {
				leftIntermediate = decimalTarget;
				rightIntermediate = 0;
			} else {
				int maxAttempts = decimalTarget * 3;
				int attempts = 0;
				do {
					leftIntermediate = 0;
					rightIntermediate = 0;
					while (leftIntermediate + rightIntermediate < decimalTarget) {
						if (random.nextBoolean()) {
							leftIntermediate++;
						} else {
							rightIntermediate++;
						}
					}
					attempts++;
				} while (!withinRange(
						results[0] / Math.pow(10, leftIntermediate),
						leftChild.getRange())
						&& !withinRange(
								results[1] / Math.pow(10, rightIntermediate),
								rightChild.getRange())
						&& attempts < maxAttempts);

				if (attempts == maxAttempts)
					return false;
			}

			leftChild.setIntermediateResult(new Term(GeneratorUtils
					.getDecimalFormat(leftIntermediate, true).format(
							results[0] / Math.pow(10, leftIntermediate))));
			rightChild.setIntermediateResult(new Term(GeneratorUtils
					.getDecimalFormat(rightIntermediate, true).format(
							results[1] / Math.pow(10, rightIntermediate))));

			everythingOK &= leftChild.populateTermsRecursively(options);
			// no point going further if we've already failed
			if (!everythingOK) {
				return false;
			}

			everythingOK &= rightChild.populateTermsRecursively(options);

			return everythingOK;
		}

		private int[] tryObscure(Operator o, double multiplierForRange) {
			return o.obscure(
					(int) (Math.rint(intermediateResult.getAsDouble()
							* multiplierForRange)),
					leftChild.getMultipliedIntRange(multiplierForRange),
					rightChild.getMultipliedIntRange(multiplierForRange));
		}

		private int[] getMultipliedIntRange(double multiplier) {
			return new int[] { (int) (range[0] * multiplier),
					(int) (range[1] * multiplier) };
		}

		private boolean withinRange(double value, double[] range2) {
			return range2[0] <= value && range2[1] >= value;
		}

		public boolean isLeafNode() {
			return (leftChild == null && rightChild == null);
		}

		public void setIntermediateResult(Term result) {
			if (element == null || element instanceof Term)
				element = result;
			intermediateResult = result;
		}

		public Term getIntermediateResult(MathGeneratorExerciseData options) {
			if (intermediateResult == null) {
				Term t = Term.getRandomTerm(range[0], range[1], 0);
				element = t;
				intermediateResult = t;
			}
			return intermediateResult;
		}

		/**
		 * Evaluates the expression starting from this node, i.e the subtree
		 * where this node is the head.
		 * 
		 * @return the value of this evaluated subtree
		 */
		Term evaluate() {
			if (element instanceof Term)
				return (Term) element;
			if (element instanceof Operator) {
				Operator o = (Operator) element;
				return o.operate(leftChild.evaluate(), rightChild.evaluate());
			}

			return Term.ZERO;
		}

		/**
		 * Returns this a postfix expression starting from this node.
		 * 
		 * @return
		 */
		public Vector<String> toPostfixExpression() {
			ArrayList<Node> list = new ArrayList<Node>();
			getPostFix(list);
			Vector<String> result = new Vector<>();
			for (Node n : list) {
				result.add(n.element.getSymbol());
			}
			return result;
		}

		/**
		 * Returns this an infix expression starting from this node.
		 * 
		 * @return
		 */
		public ArrayList<String> toInFixExpression() {
			ArrayList<String> list = new ArrayList<String>();
			getInFix(list, false);
			return list;
		}

		/**
		 * Recursive method to generate a postfix expression.
		 * 
		 * @param list
		 */
		private void getPostFix(ArrayList<Node> list) {
			if (leftChild != null)
				leftChild.getPostFix(list);

			if (rightChild != null)
				rightChild.getPostFix(list);

			list.add(this);

		}

		/**
		 * Recursive method to generate an infix expression.
		 * 
		 * @param list
		 * @param rightSide
		 *            are we on the right side of an operator. Used for
		 *            determining parenthesis
		 */
		private void getInFix(ArrayList<String> list, boolean rightSide) {

			if (this.element == null) { // sanity check
				return;
			}

			boolean addParenthesis = parent != null
					&& (parent.element.getPriority() < this.element
							.getPriority()
							|| (rightSide
									&& parent.element.equals(Operator.SUBTRACT) && this.element
									.getPriority() > 0) || (rightSide
							&& parent.element.equals(Operator.DIVISION) && this.element
							.getPriority() > 0));
			
			if(addParenthesis && !rightSide)
				addParenthesis = false;
			
			if (addParenthesis) {
				list.add("(");
			}

			if (leftChild != null)
				leftChild.getInFix(list, false);

			list.add(this.element.getSymbol());

			if (rightChild != null)
				rightChild.getInFix(list, true);

			if (addParenthesis) {
				list.add(")");
			}
		}

		/**
		 * Sets the element
		 * 
		 * @param randomOperator
		 */
		public void setElement(EquationElement randomOperator) {
			element = randomOperator;
		}

		/**
		 * Creates new children for this node.
		 */
		public void createChildren() {
			leftChild = new Node(this);
			rightChild = new Node(this);
		}

		/**
		 * Returns both children of this Node.
		 * 
		 * @return
		 */
		public Node[] getChildren() {
			return new Node[] { leftChild, rightChild };
		}
	}

}
