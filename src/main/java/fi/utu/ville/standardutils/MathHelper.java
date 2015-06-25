package fi.utu.ville.standardutils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class MathHelper {

	/** Operators for splitting strings */
	private final static String[] splitOperators = { "+", "-", "*", "/", "%",
			"++", "--", "(", ")", "&", "|", "<=", ">=", "<", ">", "=", "!",
			"~", "<<", ">>" };

	private final static String[] stringpairs = { "(", ")", "{", "}", "<", ">",
			"[", "]", "/", "/" };

	private final static String[] addition = { "10+2", "7+5", "15+2", "9+4",
			"4+6", "7+8", "5+3", "5+4", "6+3", "11+4", "11+5" };

	private final static String[] subtraction = { "10-2", "7-5", "15-2", "9-4",
			"6-4", "8-7", "5-3", "5-4", "6-3", "11-4", "11-5" };

	private final static String[] multiplication = { "3*2", "3*3", "3*4",
			"3*5", "3*6", "5*8", "6*7", "2*6", "4*6", "3*8", "7*7", "6*9" };

	private final static String[] division = { "6/2", "3/3", "49/7", "55/5",
			"63/7", "42/6", "35/7", "32/4", "24/3", "24/4", "72/9", "54/9" };

	protected MathHelper() {

	}

	/**
	 * Evaluates the given expression.
	 * 
	 * @param s
	 *            The expression to evaluate.
	 * @return The double value or null if the expression is nonsense.
	 */
	public static Double evaluate(String s) {
		Double ans = null;
		try {
			ans = Double.parseDouble(s);
			return ans;
		} catch (NumberFormatException e) {
			// There is a term, not just a number, so let's continue->
		}
		try {
			s = s.replace(":", "/");
			Vector<String> v = infixToPostfix(s);
			LinkedList<String> stack = new LinkedList<String>();

			for (int i = 0; i < v.size(); i++) {

				if (!(v.get(i).equals("+") || v.get(i).equals("-")
						|| v.get(i).equals("*") || v.get(i).equals("/"))) {

					stack.add(v.get(i));
				} else {

					if (v.get(i).equals("*")) {
						ans = (Double.parseDouble(stack
								.remove(stack.size() - 2).replace(',', '.')) * Double
								.parseDouble(stack.removeLast().replace(',',
										'.')));

						stack.addLast(Double.toString(ans));

					} else if (v.get(i).equals("-")) {
						ans = (Double.parseDouble(stack
								.remove(stack.size() - 2).replace(',', '.')) - Double
								.parseDouble(stack.removeLast().replace(',',
										'.')));
						stack.addLast(Double.toString(ans));

					} else if (v.get(i).equals("+")) {
						ans = (Double.parseDouble(stack
								.remove(stack.size() - 2).replace(',', '.')) + Double
								.parseDouble(stack.removeLast().replace(',',
										'.')));
						stack.addLast(Double.toString(ans));

					} else if (v.get(i).equals("/")) {
						ans = (Double.parseDouble(stack
								.remove(stack.size() - 2).replace(',', '.')) / Double
								.parseDouble(stack.removeLast().replace(',',
										'.')));
						stack.addLast(Double.toString(ans));
					}
				}
			}
		} catch (IndexOutOfBoundsException | NumberFormatException e) { 
			// something went wrong; most likely a nonsense calculation. e.g.
			// 2.6.4+-4-.6 or 5+g3
			return null;
		}

		return ans;
	}

	/**
	 * Return ArrayList with step by step solutions on arithmetic calculations
	 * 
	 * @param s
	 * @return a list containing all steps required to complete the calculation
	 */
	public static ArrayList<Double> stepBySolution(String s) {
		ArrayList<Double> solution = new ArrayList<Double>();

		s = s.replace(":", "/");
		Vector<String> v = infixToPostfix(s);

		// for (int i = 0; i < v.size(); i++) {
		// System.out.print(v.get(i));
		// }

		double ans = 0;
		LinkedList<String> stack = new LinkedList<String>();

		try {
			for (int i = 0; i < v.size(); i++) {

				if (!(v.get(i).equals("+") || v.get(i).equals("-")
						|| v.get(i).equals("*") || v.get(i).equals("/"))) {

					stack.add(v.get(i));
				} else {

					if (v.get(i).equals("*")) {
						ans = (Double.parseDouble(stack
								.remove(stack.size() - 2).replace(',', '.')) * Double
								.parseDouble(stack.removeLast().replace(',',
										'.')));
						solution.add(ans);
						stack.addLast(Double.toString(ans));

					} else if (v.get(i).equals("-")) {
						ans = (Double.parseDouble(stack
								.remove(stack.size() - 2).replace(',', '.')) - Double
								.parseDouble(stack.removeLast().replace(',',
										'.')));
						solution.add(ans);

						stack.addLast(Double.toString(ans));

					} else if (v.get(i).equals("+")) {
						ans = (Double.parseDouble(stack
								.remove(stack.size() - 2).replace(',', '.')) + Double
								.parseDouble(stack.removeLast().replace(',',
										'.')));
						solution.add(ans);

						stack.addLast(Double.toString(ans));

					} else if (v.get(i).equals("/")) {
						ans = (Double.parseDouble(stack
								.remove(stack.size() - 2).replace(',', '.')) / Double
								.parseDouble(stack.removeLast().replace(',',
										'.')));
						solution.add(ans);

						stack.addLast(Double.toString(ans));
					}
				}
			}
		} catch (IndexOutOfBoundsException | NumberFormatException e) {
			// we encountered an unsolvable calculation; thus no steps required
			// to solve it.
			return new ArrayList<Double>();
		}

		return solution;
	}

	/**
	 * Translates the given infix expression to postfix.
	 * @param infixExpression
	 * @return A vector containing the expression in postfix notation
	 */
	public static Vector<String> infixToPostfix(Vector<String> infixExpression){
		Vector<String> supportedOperators = new Vector<String>();
		supportedOperators.add("/");
		supportedOperators.add("*");
		supportedOperators.add("-");
		supportedOperators.add("+");
		
		Vector<String> result = new Vector<>();
		Stack<String> operators = new Stack<String>();
		for(int i=0; i< infixExpression.size(); i++){
			if(infixExpression.get(i).equals("(")){
				continue;
			}
			
			if(supportedOperators.contains(infixExpression.get(i))){
				operators.add(infixExpression.get(i));
				continue;
			}
			
			if(infixExpression.get(i).equals(")")){
				if(!operators.isEmpty())
					result.add(operators.pop());
				if(!operators.isEmpty())
					result.add(operators.pop());				
				continue;
			}
			
			result.add(infixExpression.get(i));
		}
		
		for(int i=operators.size()-1; i>=0; i--){
			result.add(operators.get(i));
		}
		
		return result;
	}
	
	/**
	 * Translates the infix expression to a postfix expression, eliminating the
	 * parenthesis. This way the expression can be easily evaluated in the
	 * ProgramTranslator class. Does not handle cases where negative terms are without parenthesis
	 * such as 4 + -2. However, 4 + (-2) will work.
	 * 
	 * @param s
	 *            a string containing the infix expression
	 * @return new Vector with elements of the postfix expression in order
	 */
	public static Vector<String> infixToPostfix(String s) {
		Vector<String> post = new Vector<String>();
		Vector<String> v = split(s);
		Stack<String> stack = new Stack<String>();

		for (String c : v) {
			String bl = c;
			if (bl.equals("(")) {
				stack.push(c);
			} else if (bl.equals(")")) {
				String pop;
				do {
					pop = stack.pop();
					if (!pop.equals("(")) {
						post.add(pop);
					}
				} while (!stack.empty() && !pop.equals("("));
			} else if (bl.equals("%") || bl.equals("*") || bl.equals("/")
					|| bl.equals("+") || bl.equals("-") || bl.equals("<")
					|| bl.equals(">") || bl.equals("<=") || bl.equals(">=")
					|| bl.equals("&&") || bl.equals("||") || bl.equals("&")
					|| bl.equals("|") || bl.equals("!") || bl.equals("==")
					|| bl.equals("!=") || bl.equals("<<") || bl.equals(">>")
					|| bl.equals("~")) {
				if (stack.empty()) {
					stack.push(c);
				} else {

					String speek = stack.peek();
					int o1 = 0, o2 = 0;
					if (speek.equals("*") || speek.equals("/")
							|| speek.equals("%")) {
						o2 = 1;
					}
					if (speek.equals("+") || speek.equals("-")
							|| speek.equals("<<") || speek.equals(">>")) {
						o2 = 2;
					}
					if (speek.equals("<") || speek.equals(">")
							|| speek.equals("<=") || speek.equals(">=")
							|| speek.equals("==") || speek.equals("!=")) {
						o2 = 3;
					}
					if (speek.equals("&") || speek.equals("|")
							|| speek.equals("&&") || speek.equals("||")) {
						o2 = 4;
					}

					if (bl.equals("*") || bl.equals("/") || bl.equals("%")) {
						o1 = 1;
					}
					if (bl.equals("+") || bl.equals("-")) {
						o1 = 2;
					}
					if (bl.equals("<") || bl.equals(">") || bl.equals("<=")
							|| bl.equals(">=") || bl.equals("==")
							|| bl.equals("!=")) {
						o1 = 3;
					}
					if (bl.equals("&") || bl.equals("|") || bl.equals("&&")
							|| bl.equals("||")) {
						o1 = 4;
					}

					if (speek.equals("(") || speek.equals(")")) {
						o2 = 5;
					}
					if (bl.equals("(") || bl.equals(")")) {
						o1 = 5;
					}

					if (o1 < o2) {
						stack.push(c);
					} else {
						while (o1 >= o2 && !stack.empty()) {

							post.add(stack.pop());
							if (!stack.empty()) {
								speek = stack.peek();
							}
							if (speek.equals("*") || speek.equals("/")
									|| speek.equals("%")) {
								o2 = 1;
							}
							if (speek.equals("+") || speek.equals("-")
									|| speek.equals("<<") || speek.equals(">>")) {
								o2 = 2;
							}
							if (speek.equals("<") || speek.equals(">")
									|| speek.equals("<=") || speek.equals(">=")
									|| speek.equals("==") || speek.equals("!=")) {
								o2 = 3;
							}
							if (speek.equals("&") || speek.equals("|")
									|| speek.equals("&&") || speek.equals("||")) {
								o2 = 4;
							}

							if (bl.equals("*") || bl.equals("/")
									|| bl.equals("%")) {
								o1 = 1;
							}
							if (bl.equals("+") || bl.equals("-")) {
								o1 = 2;
							}
							if (bl.equals("<") || bl.equals(">")
									|| bl.equals("<=") || bl.equals(">=")
									|| bl.equals("==") || bl.equals("!=")) {
								o1 = 3;
							}
							if (bl.equals("&") || bl.equals("|")
									|| bl.equals("&&") || bl.equals("||")) {
								o1 = 4;
							}

							if (speek.equals("(") || speek.equals(")")) {
								o2 = 5;
							}
							if (bl.equals("(") || bl.equals(")")) {
								o1 = 5;
							}

						}
						stack.push(c);
					}
				}
			} else {
				post.add(c);
			}

		}
		// Rest of the elements from the stack
		while (!stack.empty()) {
			post.add(stack.pop());
		}

		return post;
	}

	/**
	 * Split operators, operands and method calls from a string. Splitting is
	 * not done inside quotes. Splitting delimiters are in this.splitOperators.
	 * Spaces outside quotes are stripped.
	 * 
	 * @param s
	 *            a String object to be splitted
	 * @return new vector where each element is an operator, operand or method
	 *         call from string
	 */
	public static Vector<String> split(String s) {
		s = s.replace(":", "/");

		// not used
		// int o = 0;
		if (s.trim().startsWith("-") && !s.trim().startsWith("--")) {
			s = "0" + s;
		}
		Vector<String> v = new Vector<String>();
		String block = "";
		int ind = 0;
		boolean quotaOpen = false;
		while (ind < s.length()) {
			String ch = "" + s.charAt(ind);
			if (ch.equals(" ") && !quotaOpen) { /* Strip spaces */
				ind++;
				continue;
			}
			if (ch.equals("\"")) {
				quotaOpen = !quotaOpen; /* Quota? */
			}
			/* Method call with no parameters */
			if (ch.equals("(") && s.charAt(ind + 1) == ')' && !quotaOpen) {
				block += "()";
				v.add(block.trim());
				ind++;
				block = "";
				ch = "";
			}
			/* Other parenthesis */
			else if (ch.equals("(") && !quotaOpen) {
				// Test if methdod call
				if (!block.trim().equals("")) {
					// Get the parameter block
					String param = solveBlock(s.substring(ind), "(");
					block += "(" + param + ")";
					v.add(new String(block.trim()));
					block = "";
					ch = "";
					ind += param.length() + 1;
				}
			} else if (ch.equals("[") && !quotaOpen) {
				// Test if array cell variable
				String param = solveBlock(s.substring(ind), "[");
				param = "[" + param + "]";

				String intDec = s.substring(param.length() + 1).trim();
				if (intDec.startsWith("++") || intDec.startsWith("--")) {
					param += intDec.substring(0, 2);
				}

				// First : if 2d array
				int ind2 = ind + param.length();
				String ss = s.substring(ind2);
				if (!ss.equals("") && ss.trim().charAt(0) == '[') {
					// 2d-variable
					String param2 = solveBlock(ss, "[");
					param2 = "[" + param2 + "]";
					param += param2;
					String incDec;
					incDec = s.substring(param.length() + 1).trim();
					if (incDec.startsWith("++")) {
						param += "++";
					}
					if (incDec.startsWith("--")) {
						param += "--";
					}
				}

				block += param;
				ch = "";
				v.add(new String(block.trim()));
				block = "";
				ind += param.length() - 1; // ++ in the end of the loop
			}

			if (!ch.equals("") && !quotaOpen) {
				for (String operator : splitOperators) {
					if (ch.equals(operator) && !quotaOpen) {
						// Test ++a and a++
						if (ch.equals("+") && s.charAt(ind + 1) == '+') {
							block += "+"; // add first, second added at the end
											// of the loop
							ind++;
							break;
						}
						if (ch.equals("-") && s.charAt(ind + 1) == '-') {
							block += "-";
							ind++;
							break;
						}
						// Test << and >>
						if (ch.equals(">") && s.charAt(ind + 1) == '>') {
							operator = ">>";
							ind++;
						}
						if (ch.equals("<") && s.charAt(ind + 1) == '<') {
							operator = "<<";
							ind++;
						}
						// Test && and ||
						if (ch.equals("&") && s.charAt(ind + 1) == '&') {
							operator = "&&";
							ind++;
						}
						if (ch.equals("|") && s.charAt(ind + 1) == '|') {
							operator = "||";
							ind++;
						}

						// Test <= and >=
						if (ch.equals("<") && s.charAt(ind + 1) == '=') {
							operator = "<=";
							ind++;
						}
						if (ch.equals(">") && s.charAt(ind + 1) == '=') {
							operator = ">=";
							ind++;
						}
						// Test == and !=
						if (ch.equals("=") && s.charAt(ind + 1) == '=') {
							operator = "==";
							ind++;
						}
						if (ch.equals("!") && s.charAt(ind + 1) == '=') {
							operator = "!=";
							ind++;
						}

						String sss = s.substring(0, ind).trim();

						if (ch.equals("-") && !v.isEmpty() && sss.endsWith("(")) {
							break;
						}

						String lastComponent = "";
						if (v.size() > 0) {
							lastComponent = v.lastElement();
						}

						if (ch.equals("-")
								&& (lastComponent.equals("<") // Check for e.g.
																// a < -2
										|| lastComponent.equals(">")
										|| lastComponent.equals("==")
										|| lastComponent.equals(">=")
										|| lastComponent.equals("<=") || lastComponent
											.equals("!="))) {
							break;
						}

						if (operator.trim().equals("(")
								|| operator.trim().equals(")")) {
						}
						v.add(new String(block.trim()));
						v.add(new String(operator));
						block = "";
						ch = "";
						break;

					}
				}
			}
			block += ch;
			ind++;
		}
		v.add(new String(block.trim()));
		/* Finally: delete empty elements, if any */
		for (int i = 0; i < v.size(); i++) {
			if (v.elementAt(i) == null || v.elementAt(i).equals("")
					|| v.elementAt(i).equals(" ")) {
				v.remove(i);
			}
		}
		return v;
	}

	public static String solveBlock(String s, String alkumerkki) {
		String loppumerkki = "";
		boolean quoteOpen = false;
		for (int i = 0; i < stringpairs.length; i++) {
			if (stringpairs[i].equals(alkumerkki)) {
				loppumerkki = stringpairs[i + 1];
			}
		}
		int alkuindeksi = s.indexOf(alkumerkki);

		if (alkuindeksi == -1) {
			return null;
		}
		int sulkeita = 1;
		int indeksi = alkuindeksi;
		while (sulkeita > 0) {
			indeksi++;
			if (s.charAt(indeksi) == '"') {
				// Test if the quote is escaped
				if (indeksi == 0) {
					quoteOpen = !quoteOpen;
				} else if (s.charAt(indeksi - 1) != '\\') {
					quoteOpen = !quoteOpen;
				}
			}
			if (alkumerkki.equals("" + s.charAt(indeksi)) && !quoteOpen) {
				sulkeita++;
			}
			if (loppumerkki.equals("" + s.charAt(indeksi)) && !quoteOpen) {
				sulkeita--;
			}
		}
		return s.substring(alkuindeksi + 1, indeksi); // sulut pois
	}

	public static double calculateFraction(int[] fraction) {
		return fraction[0] + (fraction[1] / (double) fraction[2]);
	}

	public static String evaluateUsingDifferentOperators(String equation,
			double ans) {

		Vector<String> vector = split(equation);
		String original = "";
		for (int i = 0; i < vector.size(); i++) {
			String str = vector.get(i);

			if (str.equals("+") || str.equals("-") || str.equals("*")
					|| str.equals("/")) {
				original = operatorToSpeak(str);
				vector.set(i, "+");
				if (evaluateVector(vector) == ans) {
					return "Taisit sekoittaa " + original + "n ja yhteenlaskun";
				}

				vector.set(i, "-");
				if (evaluateVector(vector) == ans) {
					return "Taisit sekoittaa " + original
							+ "n ja vähennyslaskun";
				}

				vector.set(i, "*");
				if (evaluateVector(vector) == ans) {
					return "Taisit sekoittaa " + original + "n ja kertolaskun";
				}

				vector.set(i, "/");
				if (evaluateVector(vector) == ans) {
					return "Taisit sekoittaa " + original + "n ja jakolaskun";
				}

				return "fail";

			}

		}

		return "fail";
	}

	public static String operatorToSpeak(String str) {
		if (str.equals("-")) {
			return "vähennyslasku";
		} else if (str.equals("+")) {
			return "yhteenlasku";
		} else if (str.equals("*")) {
			return "kertolasku";
		} else if (str.equals("/")) {
			return "jakolasku";
		}

		else
			return "älytöntä";

	}

	public static double evaluateVector(Vector<String> vector) {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < vector.size(); i++) {
			builder.append(vector.get(i));
		}

		return evaluate(builder.toString());
	}

	public static boolean isParsableToInt(String i) {
		try {
			Integer.parseInt(i);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	/**
	 * Checks if the given string is parsable to a double
	 * 
	 * @param number
	 * @return true if the parameter can be parsed to double, false otherwise.
	 */
	public static boolean isParsableToDouble(String number) {
		try {
			Double.parseDouble(number);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static Label getEqualsSign() {
		Label eq = new Label("=");
		eq.addStyleName("math-text-large");

		return eq;
	}

	public static VerticalLayout getSadFace() {
		VerticalLayout sf = new VerticalLayout();
		sf.setWidth("128px");
		sf.setHeight("128px");
		sf.setMargin(true);

		ThemeResource sad = new ThemeResource("../vexer-math/icons/sadface.png");
		Embedded e = new Embedded(null, sad);
		e.setWidth("128px");
		e.setHeight("128px");

		sf.addComponent(e);

		return sf;
	}

	public static boolean hasSmallerThanZero(String equation) {
		ArrayList<Double> solution = stepBySolution(equation);
		for (int i = 0; i < solution.size(); i++) {
			if (solution.get(i) < 0) {
				return true;
			}
		}
		return false;
	}

	public static String getRandomAddition() {
		Random rnd = new Random();
		return addition[rnd.nextInt(addition.length)];
	}

	public static String getRandomSubtraction() {
		Random rnd = new Random();
		return subtraction[rnd.nextInt(subtraction.length)];
	}

	public static String getRandomDivision() {
		Random rnd = new Random();
		return division[rnd.nextInt(division.length)];
	}

	public static String getRandomMultiplication() {
		Random rnd = new Random();
		return multiplication[rnd.nextInt(multiplication.length)];
	}

	public static ArrayList<String> getOperatorStrings() {
		ArrayList<String> opers = new ArrayList<String>();
		opers.add("+");
		opers.add("-");
		opers.add("*");
		opers.add("/");
		opers.add(":");

		return opers;
	}

	/**
	 * Separates all digits in the given string to an array so that the least
	 * significant digit is at the last index. Does not ensure that the given
	 * string is actually a number
	 * 
	 * @param number
	 *            The string to turn into an array
	 * @return the given integer in MSB order
	 */
	public static int[] splitDigits(String number) {
		int[] result = new int[number.length()];

		for (int i = 0; i < number.length(); i++) {
			result[number.length() - 1 - i] = Integer.valueOf(number.charAt(i)
					+ "");
		}

		return result;
	}

	/**
	 * Separates all digits in the given integer to an array so that units are
	 * at index 0, tens at index 1 hundreds at index 2 etc.
	 * 
	 * @param number
	 *            the integer to turn into an array
	 * @return the given integer in MSB order
	 */
	public static int[] splitDigits(int number) {
		return splitDigits(Integer.toString(number));
	}

	//
	// class used to represent intermediate expressions on the stack.
	//
	private static class Intermediate {
		public String expr; // subexpression string
		public String oper; // the operator used to create this expression

		public Intermediate(String expr, String oper) {
			this.expr = expr;
			this.oper = oper;
		}
	}

	//
	// PostfixToInfix
	//
	public static String postfixToInfix(Vector<String> postfixTokens) {

		// Create stack for holding intermediate infix expressions
		Stack<Intermediate> stack = new Stack<Intermediate>();

		for (String token : postfixTokens) {
			if (token == "+" || token == "-") {
				// Get the left and right operands from the stack.
				// Note that since + and - are lowest precedence operators,
				// we do not have to add any parentheses to the operands.
				Intermediate rightIntermediate = stack.pop();
				Intermediate leftIntermediate = stack.pop();

				// construct the new intermediate expression by combining the
				// left and right
				// expressions using the operator (token).
				String newExpr = leftIntermediate.expr + token
						+ rightIntermediate.expr;

				// Push the new intermediate expression on the stack
				stack.push(new Intermediate(newExpr, token));
			} else if (token == "*" || token == "/") {
				String leftExpr, rightExpr;

				// Get the intermediate expressions from the stack.
				// If an intermediate expression was constructed using a lower
				// precedent
				// operator (+ or -), we must place parentheses around it to
				// ensure
				// the proper order of evaluation.

				Intermediate rightIntermediate = stack.pop();
				if (rightIntermediate.oper == "+"
						|| rightIntermediate.oper == "-") {
					rightExpr = "(" + rightIntermediate.expr + ")";
				} else {
					rightExpr = rightIntermediate.expr;
				}

				Intermediate leftIntermediate = stack.pop();
				if (leftIntermediate.oper == "+"
						|| leftIntermediate.oper == "-") {
					leftExpr = "(" + leftIntermediate.expr + ")";
				} else {
					leftExpr = leftIntermediate.expr;
				}

				// construct the new intermediate expression by combining the
				// left and right
				// using the operator (token).
				String newExpr = leftExpr + token + rightExpr;

				// Push the new intermediate expression on the stack
				stack.push(new Intermediate(newExpr, token));
			} else {
				// Must be a number. Push it on the stack.
				stack.push(new Intermediate(token, ""));
			}
		}

		// The loop above leaves the final expression on the top of the stack.
		return stack.peek().expr;
	}

	/**
	 * Simplifies the given fraction. The fraction must be given as a pure
	 * fraction, i.e. 20/5; no units
	 * 
	 * @param fraction
	 *            The fraction to simplify
	 * @return The simplified fraction as a two or three-element array:
	 *         [numerator, denominator], or [units, numerator, denominator].
	 */
	public static int[] simplify(int[] fraction) {
		int numeratorIndex = 0;
		if (fraction.length == 3) {
			numeratorIndex = 1;
			while (fraction[1] >= fraction[2] && fraction[2] != 0) {
				fraction[1] = fraction[1] - fraction[2];
				fraction[0] = fraction[0] + 1;
			}
		}
		fraction = fraction.clone();
		long gcd = Math.abs(gcd(fraction[numeratorIndex],
				fraction[numeratorIndex + 1]));
		fraction[numeratorIndex] /= gcd;
		fraction[numeratorIndex + 1] /= gcd;
		return fraction;
	}

	/**
	 * Calculates the greatest common divisor of the given numbers.
	 * 
	 * @param a
	 * @param b
	 * @return the greatest common divisor 
	 */
	public static long gcd(long a, long b) {
		while (b != 0) {
			long t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

	public static int[] tryToChangeDenominator(int[] fraction,
			int newDenominator) {
		int[] newFraction = simplify(fraction.clone());
		int multiplier = (int) (newDenominator / gcd(newFraction[1],
				newDenominator));
		if (newFraction[1] * multiplier != newDenominator) {
			return null;
		}
		newFraction[0] *= multiplier;
		newFraction[1] *= multiplier;
		return newFraction;
	}

	/**
	 * Returns only the operands (numbers) of the given equation.
	 * 
	 * @param equation
	 * @return All operands in the given equation
	 */
	public static Vector<String> getOperands(String equation) {
		Vector<String> operands = new Vector<>();

		Pattern p = Pattern.compile("\\d+((\\.|,)\\d+)?");
		Matcher m = p.matcher(equation);
		while (m.find()) {
			operands.add(m.group());
		}
		return operands;
	}

	public static Vector<String> getOperators(String eq) {
		Vector<String> operators = new Vector<>();

		for (int i = 0; i < eq.length(); i++) {
			switch (eq.charAt(i)) {
			case '+':
			case '-':
			case '*':
			case '/':
				operators.add(eq.charAt(i) + "");
				break;
			}

		}

		return operators;
	}
}
