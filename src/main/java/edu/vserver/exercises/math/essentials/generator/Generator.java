package edu.vserver.exercises.math.essentials.generator;

import java.util.ArrayList;

public interface Generator {
	
	ArrayList<String> generateExpression(GeneratorData options) throws GeneratorException;

}
