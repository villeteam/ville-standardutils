package edu.vserver.exercises.math.essentials.generator;

//BoundingType should really not be a nested enum. Moving it out will break old exercises...
import edu.vserver.exercises.math.essentials.generator.MathGeneratorExerciseData.BoundingType;

public interface GeneratorData {

	BoundingType getBoundingType();
	int getNumberOfDecimalsInSolution();
}
