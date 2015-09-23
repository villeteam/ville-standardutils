package edu.vserver.exercises.math.essentials.generator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

import edu.vserver.exercises.math.essentials.generator.GreedyGenerator.Node;
import fi.utu.ville.standardutils.MathHelper;
import fi.utu.ville.standardutils.PreciseDecimal;

/**
 * This generator generates expressions haphazardly in hopes of stumbling across a suitable one. 
 * Unlikely to find an expression if bound by something else than TERMS. 
 */
class RandomMathGenerator implements Generator{

	private final static int MAX_ATTEMPTS = 1000;
	private final static Random r = new Random();
	
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
			
			if(i==MAX_ATTEMPTS-1)
				throw new GeneratorException();
			
			result = generateExpressionByTerms(options);
			if(result == null)
				continue;
			
			Vector<String> vector = new Vector<String>();
			vector.addAll(result);
			Double a = MathHelper.evaluateVector(vector);
			boolean ok = true;
			
			if(a == null || a.isInfinite() || a.isNaN())
				ok = false;
			
			if(!ok) continue;
			
			if(!options.getAllowParenthesis()){
				for(String s : result){
					if(s.contains("(") || s.contains(")"))
						ok = false;
				}
			}else if(options.getForceParenthesis()){
				boolean foundParenthesis = false;
				for(String s : result){
					if(s.contains("(") || s.contains(")"))
						foundParenthesis = true;
				}
				
				ok = foundParenthesis;
			}
						
			if(!ok) continue;
			
			PreciseDecimal answer = new PreciseDecimal(a);
			if(answer.doubleValue() >= options.getRangeForSolution()[0] && 
					answer.doubleValue() <= options.getRangeForSolution()[1] &&
					answer.getNumDecimals() == options.getNumberOfDecimalsInSolution()){
				return result;
			}
		}
		
		return result;
	}

	private ArrayList<String> generateExpressionByTerms(
			GeneratorData generatorData) throws GeneratorException {
				
		if(!(generatorData instanceof MathGeneratorExerciseData))
			throw new GeneratorException();
		
		if(Thread.interrupted()){
			System.out.println("interr");
			return null;
		}
		
		MathGeneratorExerciseData options = (MathGeneratorExerciseData) generatorData;
		
		Node head = populateOperators(options);
		
		ArrayList<Node> terms = head.findTerms();
		
		for(int i=0; i<terms.size(); i++){
			terms.get(i).setIntermediateResult(options.getRandomTerm(i));
		}
		
		ArrayList<String> result = head.toInFixExpression();
		
		for(int i=0, term=0; i< result.size(); i++){
			Double d = null;;
			try{
				d = Double.parseDouble(result.get(i));
			}catch(NumberFormatException e){
				continue;
			}
		}
		return result;
	}
	
	private String combineList(ArrayList<String> list){
		StringBuilder sb = new StringBuilder();
		for(String s : list)
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
		do{
			randomOperator = options.getRandomAllowedOperator();
			if(attempts++ > 30){
				throw new GeneratorException();
			}
		}while(randomOperator.getSymbol().equals("/"));		
		
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
