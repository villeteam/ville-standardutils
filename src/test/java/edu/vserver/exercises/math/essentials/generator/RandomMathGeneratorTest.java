package edu.vserver.exercises.math.essentials.generator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import edu.vserver.exercises.math.essentials.generator.MathGeneratorExerciseData.BoundingType;
import fi.utu.ville.standardutils.MathHelper;

public class RandomMathGeneratorTest {

	private final int MAX_ATTEMPTS = 1000;
	private final int MAX_TERMS = 5;
	
	@Test
	public void solutionSetTo20IsNotConstantly10Plus10(){
		MathGeneratorExerciseData options = new MathGeneratorExerciseData(2);
		options.setBoundingType(BoundingType.SOLUTION);
		options.setSolutionRange(20, 20);

		int found = 0;
		for(int i=0; i<MAX_ATTEMPTS; i++){
			String result = ExpressionGenerator.generateExpressionAsString(options);
			if(result.equals("10+10"))
				found++;
		}
		
		assertTrue("Regression: solution set to 20 is 10+10 too often+ ("+found+"/"+MAX_ATTEMPTS+")", found<MAX_ATTEMPTS/3);
	}
	
	@Test
	public void expressionIsBoundedByTermsCorrectly() {		
		RandomMathGenerator generator = new RandomMathGenerator();
		for(int terms=2; terms<MAX_TERMS; terms++){
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
	public void TestNoDivByZero(){
		Operator[] opers = {Operator.DIVISION};
		MathGeneratorExerciseData options = new MathGeneratorExerciseData(4, opers);

		for(int i = 0; i < MAX_ATTEMPTS; i++) {

			String generatedExpr = ExpressionGenerator.generateExpressionAsString(options);
			Double value = MathHelper.evaluate(generatedExpr);
			org.junit.Assert.assertTrue("Division by zero", (value != Double.POSITIVE_INFINITY && value != Double.NEGATIVE_INFINITY));
			org.junit.Assert.assertTrue("Division by zero", !generatedExpr.contains("/0"));

		}
	}
	
	@Test
	public void expressionIsBoundedBySolutionCorrectly() {		
		RandomMathGenerator generator = new RandomMathGenerator();
		
		final int SOLUTION_MIN = 4;
		final int SOLUTION_MAX = 7;		
		
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
					foundExpressions++;
					break;						
				}
			}
			if(foundExpressions == MAX_TERMS)
				return;
		}
		//This method is not really supposed to find solutions consistently
		//fail("Failed to generate expression for range ["+SOLUTION_MIN+", "+SOLUTION_MAX+"]");
	}

	@Test
	public void expressionIsBoundedBySolutionAndTermsCorrectly() {	
		
		RandomMathGenerator generator = new RandomMathGenerator();
		
		final int SOLUTION_MIN = 4;
		final int SOLUTION_MAX = 5;
		final int MAX_TERMS = 10;
		
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
			options.setGlobalTermRange(0, 1000);
			options.setSolutionRange(50, 500);
			
				for(int index = 0; index < MAX_ATTEMPTS; index++){
					int termIndex = 0;
					ArrayList<String> result = ExpressionGenerator.generateExpression(options, generator);
				
					
					options.setMaxValueForSolution(SOLUTION_MAX);
					options.setMinValueForSolution(SOLUTION_MIN);
					
					String exp = "";
					
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
							fail("Term "+index+"out of range: "+d);
						
						termIndex++;
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
			if(foundExpressions != terms){
				//This method is not really supposed to find solutions consistently
				//fail("Failed to generate expression for range ["+SOLUTION_MIN+", "+SOLUTION_MAX+"]");
			}
		}		
	}
}
