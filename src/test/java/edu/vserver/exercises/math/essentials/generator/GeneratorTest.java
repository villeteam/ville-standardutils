package edu.vserver.exercises.math.essentials.generator;

import org.junit.Test;

public class GeneratorTest {

	private final int NUM_ITERS = 100; // < 100 fails infrequently

	private final int NUM_TERMS = 4; // > 4 fails

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


}
