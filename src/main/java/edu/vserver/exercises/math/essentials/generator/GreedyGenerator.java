package edu.vserver.exercises.math.essentials.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import fi.utu.ville.standardutils.PreciseDecimal;

public class GreedyGenerator implements Generator{

	private static final int MAX_ATTEMPTS = 10000;
	Random random = new Random();
	
	@Override
	public ArrayList<String> generateExpression(
			GeneratorData options) throws GeneratorException {
		
		switch(options.getBoundingType()){
		case SOLUTION:
			return generateExpressionBySolution(options);
		case BOTH:
			return generateExpressionByBoth(options);
		default:
			throw new GeneratorException();		
		}
	}

	private ArrayList<String> generateExpressionByBoth(
			GeneratorData generatorData ) throws GeneratorException {
		
		if(!(generatorData instanceof MathGeneratorExerciseData))
			throw new GeneratorException();
		
		MathGeneratorExerciseData options = (MathGeneratorExerciseData)generatorData;
		
		ArrayList<String> result = null;
		boolean done = false;
		int attempts = 0;
		while(!done && attempts < MAX_ATTEMPTS){
			
			if(Thread.interrupted()){
				return null;
			}
			
			done = true;
			PreciseDecimal answer = options.getRandomSolution();
			
			Node head = populateOperators(options);	
						
			PreciseDecimal newLowBound = PreciseDecimal.multiply(new PreciseDecimal(options.getRangeForSolution()[0]), new PreciseDecimal("1000"));
			PreciseDecimal newHighBound = PreciseDecimal.multiply(new PreciseDecimal(options.getRangeForSolution()[1]), new PreciseDecimal("1000"));
			setIntermediateRanges(options, head, new PreciseDecimal[]{newLowBound, newHighBound});
			setTermRanges(options, head.findTerms());
						
			head.setIntermediateResult(answer);
						
			try{
				generateIntermediateTerms(options, head);
			}catch (GeneratorException e){
				attempts++;
				continue;
			}
			
//			System.out.println("After intermediate terms, Current expression: "+head.toInFixExpression());
			ArrayList<Node> terms = head.findTerms();
			for(int i=0; i<terms.size(); i++){
				Node n = terms.get(i);
//				System.out.println("got term "+n.getIntermediateResult(options)+" termRange "+options.getRangeAsPreciseDecimal(i)[0]+" -- "+ options.getRangeAsPreciseDecimal(i)[1]);
				if(n.getIntermediateResult(options).doubleValue()<options.getRangeAsPreciseDecimal(i)[0].doubleValue() &&
						n.getIntermediateResult(options).doubleValue()>options.getRangeAsPreciseDecimal(i)[1].doubleValue()){
					done = false;
					attempts++;
					break;
				}
			}
			result = head.toInFixExpression();
		}
		return result;
	}

	private void setIntermediateRanges(MathGeneratorExerciseData options,
			Node node, PreciseDecimal[] preciseDecimals) {
		
		if(node.leftChild != null && node.rightChild != null){
			setIntermediateRanges(options, node.leftChild, preciseDecimals);
			setIntermediateRanges(options, node.rightChild, preciseDecimals);
			
			node.leftChild.setRange(preciseDecimals);
			node.rightChild.setRange(preciseDecimals);
		}

		
	}

	private void generateIntermediateTerms(MathGeneratorExerciseData options, Node node) throws GeneratorException {
		if(node.isLeafNode())
			return;
		
		Operator o = node.getOperator();
				
		Node leftChild = node.getChildren()[0];
		Node rightChild = node.getChildren()[1];
		
//		System.out.println("Obscuring "+node.getIntermediateResult(options)+" into "+Arrays.toString(leftChild.getRange())+" and "+Arrays.toString(rightChild.getRange()));
		
		PreciseDecimal[] leftRange = new PreciseDecimal[]{new PreciseDecimal(leftChild.getRange()[1].getInverse()),new PreciseDecimal(leftChild.getRange()[1])};
		PreciseDecimal[] rightRange = new PreciseDecimal[]{new PreciseDecimal(rightChild.getRange()[1].getInverse()),new PreciseDecimal(rightChild.getRange()[1])};
		
		PreciseDecimal[] newValues = o.obscure(node.getIntermediateResult(options), leftRange, rightRange);
		
		if(newValues == null)
			throw new GeneratorException();
		
		leftChild.setIntermediateResult(newValues[0]);
		rightChild.setIntermediateResult(newValues[1]);
		
		generateIntermediateTerms(options, leftChild);
		generateIntermediateTerms(options, rightChild);
	}

	private void setTermRanges(MathGeneratorExerciseData options,
			ArrayList<Node> terms) {
		for(int i=0; i< terms.size(); i++){
			terms.get(i).setRange(options.getRangeAsPreciseDecimal(i));
		}
	}

	/**
	 * Populates the operators appropriately for this expression.
	 * 
	 * @param options
	 * @return the head node for the expression tree
	 */
	private Node populateOperators(MathGeneratorExerciseData options) {
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
		
		return head;
	}
	
	private <T> T getRandomElementFromList(ArrayList<T> list) {
		return list.get(random.nextInt(list.size()));
	}
	
	private ArrayList<String> generateExpressionBySolution(
			GeneratorData options) throws GeneratorException {
		return generateExpressionByBoth(options);
	}

	/**
	 * A node in the expression tree.
	 * 
	 * @author Erno
	 * 
	 */
	public static class Node {

		private Random random = new Random();
		private Node leftChild;
		private Node rightChild;
		private final Node parent;

		private PreciseDecimal[] range;

		// both are needed to ensure even operators have an intermediate result
		private Operator element;
		private PreciseDecimal intermediateResult;

		Node() {
			this(null, null);
		}

		Node(Operator element, Node parent) {
			leftChild = null;
			rightChild = null;
			this.parent = parent;

			this.element = element;

			range = new PreciseDecimal[0];
		}

		Node(Node parent) {
			this(null, parent);
		}

		Node(Operator element) {
			this(element, null);
		}

		public boolean hasRange() {
			return range.length == 2;
		}

		public PreciseDecimal[] getRange() {
			return range;
		}

		public void setRange(PreciseDecimal[] newRange) {
			range = newRange;
		}

		public int getDecimals() {
			return intermediateResult == null ? 0 : intermediateResult
					.getNumDecimals();
		}

		public void setInfiniteRange() {
			range = new PreciseDecimal[] { PreciseDecimal.MIN_VALUE, PreciseDecimal.MAX_VALUE };
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
		public void setOperatorBounds(PreciseDecimal[] operatorRange, boolean operators) {
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
		 * Returns a list of all the terms in this expression.
		 * 
		 * @return a list of all leaf nodes in this tree (the terms)
		 */
		public ArrayList<Node> findTerms() {
			ArrayList<Node> result = new ArrayList<Node>();
			findTermsRecursive(result);
			return result;
		}

		private void findTermsRecursive(ArrayList<Node> list) {
			if (element == null)
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
						getIntermediateResult(options),
						getRange());
			}
			double multiplier = Math.pow(10,
					options.getNumberOfDecimalsInSolution());

			boolean everythingOK = true;
			Operator operator = (Operator) element;
			int decimalTarget = options.getNumberOfDecimalsInSolution();

			PreciseDecimal[] results = tryObscure(operator);

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
					results = tryObscure(o);
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
						results[0],
						leftChild.getRange())
						&& !withinRange(
								results[1],
								rightChild.getRange())
						&& attempts < maxAttempts);

				if (attempts == maxAttempts)
					return false;
			}

			leftChild.setIntermediateResult(results[0]);
			rightChild.setIntermediateResult(results[1]);

			everythingOK &= leftChild.populateTermsRecursively(options);
			// no point going further if we've already failed
			if (!everythingOK) {
				return false;
			}

			everythingOK &= rightChild.populateTermsRecursively(options);

			return everythingOK;
		}

		private PreciseDecimal[] tryObscure(Operator o) {
			return o.obscure(intermediateResult,
					leftChild.getRange(),
					rightChild.getRange());
		}

		private boolean withinRange(PreciseDecimal value, PreciseDecimal[] range2) {
			double v = value.doubleValue();
			return range2[0].doubleValue() <= v && range2[1].doubleValue() >= v;
		}

		public boolean isLeafNode() {
			return (leftChild == null && rightChild == null);
		}

		public void setIntermediateResult(PreciseDecimal result) {
			intermediateResult = result;
		}

		public PreciseDecimal getIntermediateResult(MathGeneratorExerciseData options) {
			return intermediateResult;
		}

		/**
		 * Evaluates the expression starting from this node, i.e the subtree
		 * where this node is the head.
		 * 
		 * @return the value of this evaluated subtree
		 */
		PreciseDecimal evaluate() {
			if(isLeafNode())
				return intermediateResult == null ? 
						PreciseDecimal.ZERO : 
							intermediateResult;
			
			else if (element != null) {
				Operator o = (Operator) element;
				return o.operate(leftChild.evaluate(), rightChild.evaluate());
			}

			return PreciseDecimal.ZERO;
		}

		/**
		 * Returns this a postfix expression starting from this node.
		 * 
		 * @return this tree as a postfix expression
		 */
		public Vector<String> toPostfixExpression() {
			ArrayList<Node> list = new ArrayList<Node>();
			getPostFix(list);
			Vector<String> result = new Vector<>();
			for (Node n : list) {
				if(n.element == null && n.intermediateResult == null)
					result.add("_");
				else if(n.element != null)
					result.add(n.element.getSymbol());
				else if(n.intermediateResult != null)
					result.add(n.intermediateResult.toString());
			}
			return result;
		}

		/**
		 * Returns this an infix expression starting from this node.
		 * 
		 * @return this tree as an infix expression
		 */
		public ArrayList<String> toInFixExpression() {
			ArrayList<String> list = new ArrayList<String>();
			getInFix(list, false);
			return list;
		}

		/**
		 * Recursive method to generate a postfix expression.
		 * 
		 * @param list the list to use to form the postfix expression
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
		 * @param list the list to use to form the infix expression
		 * @param rightSide
		 *            are we on the right side of an operator. Used for
		 *            determining parenthesis
		 */
		private void getInFix(ArrayList<String> list, boolean rightSide) {

			//add parenthesis to negative single terms, except the first
			if (this.element == null && this.intermediateResult != null) {
				if(!list.isEmpty() && intermediateResult.compareTo(PreciseDecimal.ZERO) < 0)
					list.add("(");
				list.add(this.intermediateResult.toString());
				if(list.size() > 1 && intermediateResult.compareTo(PreciseDecimal.ZERO) < 0)
					list.add(")");
				
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
		 * @param randomOperator the operator to set
		 */
		public void setElement(Operator randomOperator) {
			element = randomOperator;
		}

		public EquationElement getElement(){
			return element;
		}
		
		public Operator getOperator(){
			if(element instanceof Operator)
				return (Operator) element;
			
			return Operator.NOOP;
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
		 * @return the children of this node.
		 */
		public Node[] getChildren() {
			return new Node[] { leftChild, rightChild };
		}
	}
}
