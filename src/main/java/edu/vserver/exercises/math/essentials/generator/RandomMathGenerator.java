package edu.vserver.exercises.math.essentials.generator;

import java.util.ArrayList;
import java.util.Vector;

import edu.vserver.exercises.math.essentials.generator.MathGeneratorExerciseData.BoundingType;
import fi.utu.ville.standardutils.MathHelper;
import fi.utu.ville.standardutils.PreciseDecimal;

/**
 * This generator generates expressions haphazardly in hopes of stumbling across a suitable one. 
 * Unlikely to find an expression if bound by something else than TERMS. 
 */
class RandomMathGenerator implements Generator{

	private final static int MAX_ATTEMPTS = 1000;
	
	@Override
	public ArrayList<String> generateExpression (GeneratorData options) throws GeneratorException{
		
		switch(options.getBoundingType()){
		case TERMS:
			return generateExpressionByTerms(options);
		case SOLUTION:
			return generateExpressionBySolution(options);
		case BOTH:
			return generateExpressionBySolutionAndTerms(options);
		default:
			throw new GeneratorException();		
		}
	}

	private ArrayList<String> generateExpressionBySolutionAndTerms(
			GeneratorData generatorData) throws GeneratorException {
		
		return generateExpressionBySolution(generatorData);
	}

	private ArrayList<String> generateExpressionBySolution(
			GeneratorData generatorData) throws GeneratorException {
		
		if(!(generatorData instanceof MathGeneratorExerciseData))
			throw new GeneratorException();
		
		MathGeneratorExerciseData options = (MathGeneratorExerciseData) generatorData;
		
		ArrayList<String> result = null;
		
		for(int i=0; i<MAX_ATTEMPTS;i++){
			result = generateExpressionByTerms(options);
			Vector<String> vector = new Vector<String>();
			vector.addAll(result);
			Double a = MathHelper.evaluateVector(vector);
			
			if(a == null)
				continue;
			
			PreciseDecimal answer = new PreciseDecimal(a);
			
			if(answer.doubleValue() >= options.getRangeForSolution()[0] && 
					answer.doubleValue() <= options.getRangeForSolution()[1] &&
					answer.getNumDecimals() == options.getNumberOfDecimalsInSolution())
				return result;
		}
		
		return result;
	}

	private ArrayList<String> generateExpressionByTerms(
			GeneratorData generatorData) throws GeneratorException {
		
		if(!(generatorData instanceof MathGeneratorExerciseData))
			throw new GeneratorException();
		
		MathGeneratorExerciseData options = (MathGeneratorExerciseData) generatorData;
		
		ArrayList<String> result = new ArrayList<>();
		
		for(int i=0; i<options.getNumberOfTerms(); i++){
			PreciseDecimal term = options.getRandomTerm(i);
			if(i>0 && term.compareTo(PreciseDecimal.ZERO) < 0)
				result.add("(");
			result.add(term+"");
			if(i>0 && term.compareTo(PreciseDecimal.ZERO) < 0)
				result.add(")");
			
			String operator = options.getRandomAllowedOperator().getSymbol();
			if(options.getBoundingType() != BoundingType.TERMS && operator.equals("/"))
				throw new GeneratorException();
			result.add(operator);
		}
		result.remove(result.size()-1);
		return result;
	}

}
