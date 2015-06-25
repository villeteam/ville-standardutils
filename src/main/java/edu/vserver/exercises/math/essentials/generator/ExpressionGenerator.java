package edu.vserver.exercises.math.essentials.generator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

import fi.utu.ville.standardutils.MathHelper;

public class ExpressionGenerator implements Serializable {
	
	private static Random rand = new Random();
	private static final long serialVersionUID = 3304489785011970235L;
	private static final int MAX_TIMEOUT = 2000;
	
	private ExpressionGenerator(){}
	
	/**
	 * Generates an expression with the given options using the given generator. <br/>
	 * The generator is given two seconds to finish. If no expression is generated in this time,
	 * the generator is forcefully terminated and 0+0 is returned.
	 * 
	 * @param options The options to use when generating the expression
	 * @param generator The generator to use when generating the expression. If null, a default implementation will be used.
	 * @return An ArrayList containing each element in the expression in its own index; i.e. [11,+,4.21,*,3]
	 */
	public static ArrayList<String> generateExpression(GeneratorData options, Generator generator){
		ArrayList<String> result = null;
		
		Generator[] generators;
		if(generator == null){
			generators = getSuitableGenerators(options);
		}else{
			generators = new Generator[]{generator};
		}
		
		for(Generator gen : generators){
			final GeneratorThread thread = new GeneratorThread(options, gen);
			final Thread t = new Thread(thread);
			
			t.start();
			
			try {
				t.join(MAX_TIMEOUT);
				t.interrupt();
				if(t.isAlive()){					
					//in case the generator does not care for interruptions, 
					//we need to make sure the thread dies
					t.stop();
				}
				result = thread.getResult();
				
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			
			if(result != null && !result.isEmpty())
				return result;
		}
		//FALLBACK
		if(result == null)
			result = new ArrayList<>();
		result.add("0");
		result.add("+");
		result.add("0");
		
		return result; 
	}
	
	/**
	 * Generates an expression with the given options using a default generator.
	 * @param options The options to use when generating the expression
	 * @return An ArrayList containing each element in the expression in its own index; i.e. [11,+,4.21,*,3]
	 */
	public static ArrayList<String> generateExpression(GeneratorData options){
		return generateExpression(options, null);
	}
	
	private static Generator[] getSuitableGenerators(
			GeneratorData options) {
		switch(options.getBoundingType()){
		case MANUAL:
			return new Generator[]{new ManualInputGenerator()};
		default:
			return new Generator[]{new RandomMathGenerator(), new GreedyGenerator(), new OldExpressionGenerator()};
		}
	}

	/**
	 * Generates an expression with the given options as a String.
	 * @param options
	 * @return The expression as a String without the answer; i.e. "2+5".
	 */
	public static String generateExpressionAsString(GeneratorData options){
		return combineExpression(generateExpression(options));
	}
	
	/**
	 * Generates an expression with the given options and the answer to the expression.
	 * @param options
	 * @return An ArrayList containing each element in the expression in its own index and the answer in the last index; i.e. [1,+,2.5,*,2,7]
	 */
	public static ArrayList<String> generateExpressionWithAnswer(GeneratorData options){
		return generateExpressionWithAnswer(options, false);
	}
	
	/**
	 * Generates an expression with the given options and the answer to the expression.
	 * @param options
	 * @param equalitySign should the returned array contain the equality sign. True will return arrays like i.e. [1,+,2.5,=,7], whereas False will return i.e. [1,+,2.5,7]
	 * @return An ArrayList containing each element in the expression in its own index and the answer in the last index.
	 */
	public static ArrayList<String> generateExpressionWithAnswer(GeneratorData options, boolean equalitySign){
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
	public static String generateExpressionAsStringWithAnswer(GeneratorData options){
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
			terms[i] = options.getRandomTerm(i).doubleValue();
		}
		
		String result = options.getFormattedTerm(terms[0],0) + obscurer.getSymbol() + options.getFormattedTerm(terms[1],1);
		return result;
	}

	private static class GeneratorThread implements Runnable{
		
		final GeneratorData options;
		private Generator generator;		
		private ArrayList<String> result;
		
		public GeneratorThread(GeneratorData options, Generator generator){
			this.options = options;
			this.generator = generator;
		}
		
		@Override
		public void run() {
			try {
				result = generator.generateExpression(options);
			} catch (GeneratorException e) {
				//nothing really needs to be done, but receiving an email of some sort would be nice 
			}
		}
		
		public ArrayList<String> getResult(){
			if(result == null)
				result = new ArrayList<>();
			return result;
		}
	}
}
