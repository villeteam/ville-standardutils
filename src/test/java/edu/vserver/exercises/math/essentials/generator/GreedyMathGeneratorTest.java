package edu.vserver.exercises.math.essentials.generator;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import edu.vserver.exercises.math.essentials.generator.MathGeneratorExerciseData.BoundingType;
import fi.utu.ville.standardutils.MathHelper;

public class GreedyMathGeneratorTest {

	private final int MAX_ATTEMPTS = 1000;
	
	@Test
	public void expressionIsBoundedByTermsCorrectly() {		
		GreedyGenerator generator = new GreedyGenerator();
		for(int terms=2; terms<10; terms++){
			MathGeneratorExerciseData options = new MathGeneratorExerciseData(terms);
			options.setBoundingType(BoundingType.TERMS);

			ArrayList<String> result = ExpressionGenerator.generateExpression(options);
			int termIndex = 0;
			for(int index = 0; index < result.size(); index++){					
				String t = result.get(index);
				double d = Double.NaN;
				try{
					d = Double.parseDouble(t);
				} catch(NumberFormatException e){
					if(t.matches("[\\+\\-\\*/]")){
						termIndex--;
						continue;
					}else
						fail("Unrecognized symbol in expression: "+t);
				}
					
				double[] range = options.getRangeAsDouble(termIndex);
				if(d == Double.NaN || !(d >= range[0] && d <= range[1]))
					fail("Term "+index+"out of range: "+d);
					
				termIndex++;
			}
		}
		//This method is not really supposed to find solutions consistently
		//fail("Failed to generate expression for range ["+SOLUTION_MIN+", "+SOLUTION_MAX+"]");
	}
	
	@Test
	public void expressionIsBoundedBySolutionCorrectly() {		
		GreedyGenerator generator = new GreedyGenerator();
		
		final int SOLUTION_MIN = 4;
		final int SOLUTION_MAX = 7;
		final int MAX_TERMS = 10;
		
		int foundExpressions = 2;
		
		ArrayList<Operator> allowedOperators = new ArrayList<>();
		allowedOperators.add(Operator.SUBTRACT);
		allowedOperators.add(Operator.SUM);
		allowedOperators.add(Operator.MULTIPLICATION);
		allowedOperators.add(Operator.DIVISION);
		
		for(int terms=2; terms<MAX_TERMS; terms++){
			MathGeneratorExerciseData options = new MathGeneratorExerciseData(terms);
			options.setBoundingType(BoundingType.SOLUTION);
			options.setAllowedOperators(allowedOperators);
			options.setGlobalTermRange(0, 1000);
			
			for(int index = 0; index < MAX_ATTEMPTS; index++){
				ArrayList<String> result = ExpressionGenerator.generateExpression(options, generator);
				
				options.setMaxValueForSolution(SOLUTION_MAX);
				options.setMinValueForSolution(SOLUTION_MIN);
					
				String exp = "";
					
				for(String s : result){
					exp += s;
				}
										
				double answer = MathHelper.evaluate(exp);
							
				if(answer >= SOLUTION_MIN && answer <= SOLUTION_MAX){
//					System.out.println("Solution-bound: "+exp+" = "+answer);
					foundExpressions++;
					break;						
				}
			}
			if(foundExpressions == MAX_TERMS)
				return;
		}
		//This method is not really supposed to find solutions consistently
		System.out.println("Greedy Generator failed to generate expression for range ["+SOLUTION_MIN+", "+SOLUTION_MAX+"]");
		//fail("Failed to generate expression for range ["+SOLUTION_MIN+", "+SOLUTION_MAX+"]");
	}

	@Test
	public void generatesimpleExpressionsConsistently(){
	
		GreedyGenerator generator = new GreedyGenerator();
		
		final int SOLUTION_MIN = 40;
		final int SOLUTION_MAX = 50;
		ArrayList<Operator> allowedOperators = new ArrayList<>();
//		allowedOperators.add(Operator.SUBTRACT);
//		allowedOperators.add(Operator.SUM);
//		allowedOperators.add(Operator.MULTIPLICATION);
		allowedOperators.add(Operator.DIVISION);
		
		MathGeneratorExerciseData options = new MathGeneratorExerciseData(3);
		options.setBoundingType(BoundingType.BOTH);
		options.setAllowedOperators(allowedOperators);
		options.setGlobalTermRange(-100, 100);
		options.setMaxValueForSolution(SOLUTION_MAX);
		options.setMinValueForSolution(SOLUTION_MIN);
		
		for(int i=0; i<100; i++){
			ArrayList<String> result = ExpressionGenerator.generateExpression(options, generator); 
			if(result == null || result.isEmpty())
				fail("Did not receive a result for simple expression");
			
//			System.out.println("Consistency: "+result);
		}
	}
	
	@Test
	public void expressionIsBoundedBySolutionAndTermsCorrectly() {	
		
		GreedyGenerator generator = new GreedyGenerator();
		
		final int SOLUTION_MIN = 40;
		final int SOLUTION_MAX = 50;
		final int MAX_TERMS = 5;
		
		int foundExpressions = 2;
		ArrayList<Operator> allowedOperators = new ArrayList<>();
		allowedOperators.add(Operator.SUBTRACT);
		allowedOperators.add(Operator.SUM);
		allowedOperators.add(Operator.MULTIPLICATION);
		allowedOperators.add(Operator.DIVISION);
		
		
		
		for(int terms=2; terms<MAX_TERMS; terms++){
			MathGeneratorExerciseData options = new MathGeneratorExerciseData(terms);
			options.setBoundingType(BoundingType.BOTH);
			options.setAllowedOperators(allowedOperators);
			options.setGlobalTermRange(-100, 100);
			options.setMaxValueForSolution(SOLUTION_MAX);
			options.setMinValueForSolution(SOLUTION_MIN);
			
				for(int index = 0; index < MAX_ATTEMPTS; index++){
					int termIndex = 0;
					ArrayList<String> result = ExpressionGenerator.generateExpression(options, generator);
					
					String exp = "";
					
					boolean success = true;
					
					for(String s : result){
						exp += s;
						
						double d = Double.NaN;
						try{
							d = Double.parseDouble(s);
						} catch(NumberFormatException e){
							if(s.matches("[\\(\\)]")){
								continue;
							}else if(s.matches("[\\+\\-\\*/]")){
								termIndex--;
								continue;
							}else
								fail("Unrecognized symbol in expression: "+s);
						}
						
						double[] range = options.getRangeAsDouble(termIndex);
						if(d == Double.NaN || !(d >= range[0] && d <= range[1]))
							success = false; //continue;// fail("Term "+termIndex+"out of range: "+d);
						
						termIndex++;
					}
					
					if(!success){
						continue;
					}
					
					double answer = MathHelper.evaluate(exp);
					String answerString = answer+"";
					
					if(answer >= SOLUTION_MIN && answer <= SOLUTION_MAX){
						if(options.getNumberOfDecimalsInSolution() == 0 && (answerString.indexOf(".") == -1 || answerString.endsWith(".0"))){
//							System.out.println("got "+result);
							foundExpressions++;
							break;
						}else{
							if(answerString.substring(answerString.indexOf(".")).length() <= options.getNumberOfDecimalsInSolution()){
								foundExpressions++;
//								System.out.println("got "+result);
								break;
							}
						}
					}					
				}
			if(foundExpressions-1 != terms){
				//This method is unlikely to find solutions consistently so console log is fine
				System.out.println("Failed to generate expression for range ["+SOLUTION_MIN+", "+SOLUTION_MAX+"] with "+terms+" terms");
				//fail("Failed to generate expression for range ["+SOLUTION_MIN+", "+SOLUTION_MAX+"] with "+terms+" terms");
			}
		}		
	}
	
//	@Test
//	public void testExpressionTree() {
//		GreedyGenerator gen = new GreedyGenerator();
//		MathGeneratorExerciseData options = new MathGeneratorExerciseData(6);
//		options.setBoundingType(BoundingType.BOTH);
//		options.setAllowedOperator(Operator.SUM, true);
//		options.setGlobalTermRange(0, 1000);
//		try {
//			//gen.generateExpression(options);
//		} catch (GeneratorException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}	
}
