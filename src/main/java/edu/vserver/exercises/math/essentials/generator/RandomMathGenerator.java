package edu.vserver.exercises.math.essentials.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import edu.vserver.exercises.math.essentials.generator.GreedyGenerator.Node;
import edu.vserver.exercises.math.essentials.generator.MathGeneratorExerciseData.BoundingType;
import fi.utu.ville.standardutils.MathHelper;
import fi.utu.ville.standardutils.PreciseDecimal;

/**
 * This generator generates expressions haphazardly in hopes of stumbling across a suitable one.
 */
class RandomMathGenerator implements Generator {
	
	private final static int MAX_ATTEMPTS = 1000;
	private final static Random r = new Random();
	
	@Override
	public ArrayList<String> generateExpression(GeneratorData options) throws GeneratorException {
		
		switch (options.getBoundingType()) {
		case TERMS:
			ArrayList<String> result = generateExpressionByTerms(options);
			
			return result;
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
			
		if (!(generatorData instanceof MathGeneratorExerciseData))
			throw new GeneratorException();
			
		MathGeneratorExerciseData options = (MathGeneratorExerciseData) generatorData;
		
		ArrayList<String> result = null;
		
		for (int i = 0; i < MAX_ATTEMPTS; i++) {
			
			if (i == MAX_ATTEMPTS - 1)
				throw new GeneratorException();
				
			result = generateExpressionByTerms(options);
			if (result == null)
				continue;
				
			Vector<String> vector = new Vector<String>();
			vector.addAll(result);
			Double a = MathHelper.evaluateVector(vector);
			
			if (a == null || a.isInfinite() || a.isNaN())
				continue;
				
			PreciseDecimal answer = null;
			try{
				answer = new PreciseDecimal(a);
			}catch (NumberFormatException e){
				result = null;
				continue;
			}
			if (answer.doubleValue() >= options.getRangeForSolution()[0] &&
					answer.doubleValue() <= options.getRangeForSolution()[1] &&
					answer.getNumDecimals() == options.getNumberOfDecimalsInSolution()) {
				return result;
			}
			result = null;
		}
		
		return result;
	}
	
	private ArrayList<String> generateExpressionByTerms(
			GeneratorData generatorData) throws GeneratorException {
			
		if (!(generatorData instanceof MathGeneratorExerciseData))
			throw new GeneratorException();
			
		if (Thread.interrupted()) {
			System.out.println("interr");
			return null;
		}
		
		MathGeneratorExerciseData options = (MathGeneratorExerciseData) generatorData;
		
		ArrayList<String> result = null;
		int counter = 0;
		while (result == null && counter < MAX_ATTEMPTS) {
			Node head = populateOperators(options);
			
			ArrayList<Node> terms = head.findTerms();
			
			for (int i = 0; i < terms.size(); i++) {
				terms.get(i).setIntermediateResult(options.getRandomTerm(i));
			}
			
			result = head.toInFixExpression();
			if (!options.getAllowParenthesis())
				for (int i = 0; i < result.size(); i++) {
					if (result.size() > i + 2 && result.get(i).equals("(") && !result.get(i + 2).equals(")")) {
						result.remove(i);
						i--;
					}
					if (i - 2 >= 0 && result.get(i).equals(")") && !result.get(i - 2).equals("(")) {
						result.remove(i);
						i--;
					}
				}
			else if (options.getForceParenthesis()) {
				boolean foundParenthesis = false;
				for (int i = 0; i < result.size(); i++) {
					if (result.size() > i + 2 && result.get(i).equals("(") && !result.get(i + 2).equals(")")) {
						foundParenthesis = true;
					}
				}
				
				if (!foundParenthesis) {
					counter++;
					result = null;
					continue;
				}
			}
			
			if(!options.getAllowNegativesWhenBoundedByTerms() && options.getBoundingType() == BoundingType.TERMS){
				Vector<String> vector = new Vector<String>();
				vector.addAll(result);
				Double a = MathHelper.evaluateVector(vector);
				
				if(a < 0){
					result = null;
				}
			}
			
			counter++;
		}
		
		if (result == null)
			throw new GeneratorException();
		
		for (int i = 0; i < result.size(); i++) {
			Double d = null;;
			try {
				d = Double.parseDouble(result.get(i));
			} catch (NumberFormatException e) {
				continue;
			}
		}
		return result;
	}
	
	private String combineList(ArrayList<String> list) {
		StringBuilder sb = new StringBuilder();
		for (String s : list)
			sb.append(s);
		return sb.toString();
	}
	
	/**
	 * Populates the operators appropriately for this expression.
	 * 
	 * @param options
	 * @return the head node for the expression tree
	 * @throws GeneratorException
	 */
	private Node populateOperators(MathGeneratorExerciseData options) throws GeneratorException {
		Operator randomOperator;
		int attempts = 0;
		do {
			randomOperator = options.getRandomAllowedOperator();
			if (attempts++ > 30) {
				throw new GeneratorException();
			}
		} while (randomOperator.getSymbol().equals("/"));
		
		ArrayList<Node> emptyNodes = new ArrayList<>();
		
		Node head = new Node(randomOperator);
		
		Node currentNode = head;
		emptyNodes.add(head);
		int terms = 1;
		do {
			currentNode = getRandomElementFromList(emptyNodes);
			randomOperator = options.getRandomAllowedOperator();
			currentNode.setElement(randomOperator);
			emptyNodes.remove(currentNode);
			currentNode.createChildren();
			Collections.addAll(emptyNodes, currentNode.getChildren());
			terms++;
		} while (terms < options.getNumberOfTerms());
		
		return head;
	}
	
	private <T> T getRandomElementFromList(ArrayList<T> list) {
		return list.get(r.nextInt(list.size()));
	}
}
