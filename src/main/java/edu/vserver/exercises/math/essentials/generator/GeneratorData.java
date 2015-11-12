package edu.vserver.exercises.math.essentials.generator;

//BoundingType should really not be a nested enum. Moving it out will break old exercises...
import edu.vserver.exercises.math.essentials.generator.MathGeneratorExerciseData.BoundingType;
import fi.utu.ville.standardutils.PreciseDecimal;

public interface GeneratorData {

	/**
	 * Returns how the expression generator should bound the generated expression.
	 * @return The bounding type
	 */
	BoundingType getBoundingType();
	
	/**
	 * 
	 * @return how many decimals the solution contains.
	 */
	int getNumberOfDecimalsInSolution();
	
	/**
	 * 
	 * @return a random allowed operator
	 */
	String getRandomOperator();
	
	/**
	 * 
	 * @return a random allowed solution.
	 */
	PreciseDecimal getRandomSolution();
}
 