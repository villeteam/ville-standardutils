package edu.vserver.mathgenerator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class ExpressionGenerator implements Serializable {
	
	private static Random rand = new Random();
	private static final long serialVersionUID = 3304489785011970235L;

	private ExpressionGenerator(){}
	
	/**
	 * Generates an expression with the given options.
	 * @param options
	 * @return An ArrayList containing each element in the expression in its own index; i.e. [11,+,4.21,*,3]
	 */
	public static ArrayList<String> generateExpression(MathGeneratorExerciseData options){
		if(options.getBoundingType()==BoundingType.MANUAL){
			return options.getNextManualExpression();
		}else
			return Expression.generateExpression(options);
	}
	
	/**
	 * Generates an expression with the given options as a String.
	 * @param options
	 * @return The expression as a String without the answer; i.e. "2+5".
	 */
	public static String generateExpressionAsString(MathGeneratorExerciseData options){
		return combineExpression(generateExpression(options));
	}
	
	/**
	 * Generates an expression with the given options and the answer to the expression.
	 * @param options
	 * @return An ArrayList containing each element in the expression in its own index and the answer in the last index; i.e. [1,+,2.5,*,2,7]
	 */
	public static ArrayList<String> generateExpressionWithAnswer(MathGeneratorExerciseData options){
		return generateExpressionWithAnswer(options, false);
	}
	
	/**
	 * Generates an expression with the given options and the answer to the expression.
	 * @param options
	 * @return An ArrayList containing each element in the expression in its own index and the answer in the last index; i.e. [1,+,2.5,*,2,7]
	 */
	public static ArrayList<String> generateExpressionWithAnswer(MathGeneratorExerciseData options, boolean equalitySign){
		ArrayList<String> result = generateExpression(options);
		double answer = MathHelper.evaluate(combineExpression(result));
		if(equalitySign)
			result.add("=");
		result.add(answer+"");
		return result;
	}
	
	/**
	 * Generates an expression with the given options as a String with the answer.
	 * @param options
	 * @return The expression as a String with the answer; i.e. "2+5=2" 
	 */
	public static String generateExpressionAsStringWithAnswer(MathGeneratorExerciseData options){
		ArrayList<String> result = generateExpressionWithAnswer(options);
		result.add(result.size()-1, "=");
		return combineExpression(result);
	}	
	
	/**
	 * Returns the string made by concatenating each element of an ArrayList
	 * @param expression the arraylist to combine
	 * @return the string made by concatenating each element
	 */
	private static String combineExpression(ArrayList<String> expression){
		StringBuilder builder = new StringBuilder();
		for(int i=0; i< expression.size(); i++){
			builder.append(expression.get(i));
		}
		
		return builder.toString();
	}
	
	/**
	 * Generates an expression with two terms, bound by the ranges set for
	 * the first two terms. Solution is unbound. This method is faster than generateExpression.
	 * 
	 * @param options
	 *            The GeneratorOptions
	 * @return An expression where each term is within range.
	 */
	public static String generate2TermExpression(MathGeneratorExerciseData options) {

		Operator obscurer = options.getOperators().get(rand.nextInt(options.getOperators().size()));

		double[] terms = new double[2];
		for(int i=0; i<2; i++){
			terms[i] = options.getRandomTerm(i);
		}
		
		String result = options.getFormattedTerm(terms[0],0) + obscurer.getSymbol() + options.getFormattedTerm(terms[1],1);
		return result;

	}

}
