package edu.vserver.exercises.math.essentials.generator;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import edu.vserver.exercises.math.essentials.generator.MathGeneratorExerciseData.BoundingType;
import fi.utu.ville.standardutils.MathHelper;

public class GeneratorTest {

	private final int NUM_ITERS = 100; // < 100 fails infrequently

	private final int NUM_TERMS = 6; // > 4 fails

	private final int EQUALS_TEST = 10;

	private final int MAX_RANGE = 1000;

	private final int MIN_RANGE = 0;

	@Test
	public void solutionEquals() {

		Operator[] opers = {Operator.SUBTRACT, Operator.DIVISION, Operator.SUM, Operator.MULTIPLICATION};
		MathGeneratorExerciseData options = new MathGeneratorExerciseData(NUM_TERMS, opers);

		options.setSolutionRange(EQUALS_TEST, EQUALS_TEST);
		options.setBoundingType(MathGeneratorExerciseData.BoundingType.SOLUTION);

		for(int i = 0; i < NUM_ITERS; i++) {

			String generatedExpr = ExpressionGenerator.generateExpressionAsString(options);
			int value = MathHelper.evaluate(generatedExpr).intValue();

			org.junit.Assert.assertEquals(generatedExpr + " Equals " + EQUALS_TEST, EQUALS_TEST, value);

		}

	}

	@Test
	public void solutionInRange() {

		Operator[] opers = {Operator.SUBTRACT, Operator.DIVISION, Operator.SUM, Operator.MULTIPLICATION};
		MathGeneratorExerciseData options = new MathGeneratorExerciseData(NUM_TERMS, opers);

		options.setSolutionRange(MIN_RANGE, MAX_RANGE);
		options.setBoundingType(MathGeneratorExerciseData.BoundingType.SOLUTION);
		
		for(int i = 0; i < NUM_ITERS; i++) {

			String generatedExpr = ExpressionGenerator.generateExpressionAsString(options);
			int value = MathHelper.evaluate(generatedExpr).intValue();

			org.junit.Assert.assertTrue(
				"Value of generated expression: " + value
				+ ". Expected to be in range " + MIN_RANGE + "-" + MAX_RANGE,
				MIN_RANGE <= value && value <= MAX_RANGE);

		}
		
	}

	@Test
	public void divisionWithZero() {

		Operator[] opers = {Operator.DIVISION};
		MathGeneratorExerciseData options = new MathGeneratorExerciseData(2, opers);

		for(int i = 0; i < NUM_ITERS; i++) {

			String generatedExpr = ExpressionGenerator.generateExpressionAsString(options);
			Double value = MathHelper.evaluate(generatedExpr);
			org.junit.Assert.assertTrue("Division by zero", (value != Double.POSITIVE_INFINITY && value != Double.NEGATIVE_INFINITY));

		}
	}

	@Test
	public void parenthesisAppearEvenIfNotAllowed() {
		
		final int SOLUTION_MIN = 4;
		final int SOLUTION_MAX = 5;
		
		ArrayList<Operator> allowedOperators = new ArrayList<>();
		allowedOperators.add(Operator.SUBTRACT);
		allowedOperators.add(Operator.SUM);
		allowedOperators.add(Operator.MULTIPLICATION);
		allowedOperators.add(Operator.DIVISION);
		
		int terms=3;
		MathGeneratorExerciseData options = new MathGeneratorExerciseData(terms);
		options.setBoundingType(BoundingType.BOTH);
		options.setAllowedOperators(allowedOperators);
		options.setGlobalTermRange(0, 1000);
		options.setAllowParenthesis(false);
		options.setMaxValueForSolution(SOLUTION_MAX);
		options.setMinValueForSolution(SOLUTION_MIN);
		
		if(options.getAllowParenthesis() == true)
			fail("Parenthesis allowed setting broken!");
		
		ArrayList<String> result = ExpressionGenerator.generateExpression(options);

		if(!options.getAllowParenthesis()){
			for (String s : result) {
				if(s.contains("(") || s.contains(")")){
					fail("Expression contained parenthesis even if parenthesis were not allowed! "+result);
				}
			}
		}	
	}	
	
	@Test
	public void parenthesisForcedCorrectly(){
		final int SOLUTION_MIN = 4;
		final int SOLUTION_MAX = 50;
		
		ArrayList<Operator> allowedOperators = new ArrayList<>();
		allowedOperators.add(Operator.SUBTRACT);
		allowedOperators.add(Operator.SUM);
		allowedOperators.add(Operator.MULTIPLICATION);
		allowedOperators.add(Operator.DIVISION);
		
		int terms=3;
		MathGeneratorExerciseData options = new MathGeneratorExerciseData(terms);
		options.setBoundingType(BoundingType.BOTH);
		options.setAllowedOperators(allowedOperators);
		options.setGlobalTermRange(0, 100);
		options.setAllowParenthesis(true);
		options.setForceParenthesis(true);
		options.setMaxValueForSolution(SOLUTION_MAX);
		options.setMinValueForSolution(SOLUTION_MIN);
		
		if(options.getForceParenthesis() == false)
			fail("Parenthesis forced setting broken!");
		
		ArrayList<String> result = ExpressionGenerator.generateExpression(options);

		boolean found = false;
		for (String s : result) {
			found = s.contains("(") || s.contains(")") || found;
		}
				
		if(!found){
			fail("Expression did not contain parenthesis even if parenthesis were forced! "+result);
		}
	}	
}
