package edu.vserver.exercises.math.essentials.generator;

import java.util.ArrayList;

class ManualInputGenerator implements Generator {

	@Override
	public ArrayList<String> generateExpression(
			GeneratorData generatorData) throws GeneratorException {

		if(!(generatorData instanceof MathGeneratorExerciseData))
			throw new GeneratorException();
		
		return ((MathGeneratorExerciseData)generatorData).getNextManualExpression();
	}

}
