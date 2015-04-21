package edu.vserver.mathgenerator;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

public class ManualCalculationSet implements Serializable{
	
	public static final int CALCULATION_LIMIT = 200;
	
	private static final long serialVersionUID = -1368525373757260097L;
	private ArrayList<ManualCalculation> manualCalculations;
	private int currentCalculation = 0;	
	private transient ManualCalculation nullCalc = new ManualCalculation("0=0");
	
	/**
	 * Creates a manually inputted calculation set.
	 * @param calculations a line break (\n) separated string of the expressions (i.e. without the answer)
	 */
	public ManualCalculationSet(String calculations){
		this();
		importCalculations(calculations);
	}
	
	public ManualCalculationSet() {
		manualCalculations = new ArrayList<>();
	}

	/**
	 * Returns a deep copy of the calculation list. 
	 * No changes done in the returned list will have an effect on the original.
	 * @return a deep copy of the calculation list.
	 */
	public ArrayList<ManualCalculation> getCalculations(){
		return new ArrayList<ManualCalculation>(manualCalculations);
	}
	
	public ArrayList<String> getNextCalculation(){		
		ArrayList<String> result = splitString(manualCalculations.get(currentCalculation).getExpression());
		
		currentCalculation++;
		if(!hasNext()){
			shuffleQuestionset();
			currentCalculation = 0;
		}
		return result;
		
	}
	
	private ArrayList<String> splitString(String s){
		return new ArrayList<>(MathHelper.split(s));		
	}
	
	public boolean hasNext(){
		return currentCalculation < manualCalculations.size(); 
	}
	
	public void shuffleQuestionset(){
		Collections.shuffle(manualCalculations);
	}
	
	public class ManualCalculation implements Serializable{
		
		private static final long serialVersionUID = 1426675551090626332L;

		ArrayList<String> expression;
		
		/**
		 * Creates one manual calculation. Handles inputs of the form 2+4=6 (i.e. with the answer and = sign) 
		 * and 2+4 (i.e. only the expression without the answer).
		 * @param expression the expression this manual calculation is. 
		 */
		public ManualCalculation(String expression){
			this(splitString(expression));
		}
		
		public ManualCalculation(ArrayList<String> generatedExpression) {
			this.expression = generatedExpression;
			int lastElement = generatedExpression.size()-1;
			DecimalFormat formatter = new DecimalFormat("0.###############");
			formatter.setMaximumFractionDigits(15);
						
			for(int i=0; i<generatedExpression.size(); i++)
				generatedExpression.set(i, generatedExpression.get(i).replaceAll(",", "."));
			
			if(this.expression.contains("=")){
				if(generatedExpression.get(lastElement-2).equals("=")){
					//combine minus sign to the answer
					String answer = generatedExpression.get(lastElement-1)+generatedExpression.get(lastElement);
					generatedExpression.remove(lastElement);
					lastElement--;
					generatedExpression.set(lastElement, answer);
				}
				generatedExpression.set(lastElement, formatter.format(Double.parseDouble(generatedExpression.get(lastElement))));
				this.expression.remove("=");
			}else{
				//generatedExpression.set(lastElement, formatter.format(Double.parseDouble(generatedExpression.get(lastElement))));
				add(formatter.format(evaluateArrayList(generatedExpression)));
			}
		}

		private double evaluateArrayList(ArrayList<String> generatedExpression){
			StringBuilder b = new StringBuilder();
			
			
			
			for (int i = 0; i < generatedExpression.size(); i++) {
				b.append(generatedExpression.get(i));
			}
			
			return MathHelper.evaluate(b.toString());
		}
		
		public ArrayList<String> getCalculation(){
			return expression;
		}
		
		/**
		 * Changes the answer part of this calculation, i.e. anything right of the equation sign
		 * @param answer the new answer
		 */		
		public void setAnswer(String answer) {
			set(expression.size()-1, answer);
		}

		private void set(int index, String value){
			expression.set(index, value.replaceAll("(,|\\.)0*$", ""));
		}
		
		private void add(String value){
			expression.add(value.replaceAll("(,|\\.)0*$", ""));
		}
		
		/**
		 * Changes the expression part of this calculation, i.e. anything left of the equation sign
		 * @param expression the new expression
		 */
		public void setExpression(String expression) {
			String answer = getAnswer();
			this.expression.clear();
			Vector<String> temp = MathHelper.split(expression);
			for(int i=0; i< temp.size(); i++){
				this.expression.add(temp.get(i));
			}
			this.expression.add(answer);
			
		}
		
		/**
		 * Gets the answer part of this calculation, i.e. anything right of the equation sign
		 * @return the answer in this calculation
		 */
		public String getAnswer() {
			return (expression.size()-1>0) ? expression.get(expression.size()-1) : "0";
		}

		/**
		 * Gets the expression part of this calculation, i.e. anything left of the equation sign
		 * @return the expression in this calculation
		 */
		public String getExpression() {

			StringBuilder b = new StringBuilder();
			for(int i=0; i< expression.size()-1; i++){
				b.append(expression.get(i));
			}
			return b.toString();
		}
		
		/**
		 * ToString, must be symmetric; i.e. new ManualCalculation(oldCalc.toString()) must clone oldCalc
		 */
		@Override
		public String toString() {
			return getExpression()+"="+getAnswer();
		}
	}

	/**
	 * Adds a new calculation to the list. If the limit on calculations has been reached, this method does nothing.
	 * @param generatedExpression the new expression. Can be either a complete expression (with the equation sign)
	 * or shorthand (missing the equality sign and answer). The answer must be in the last index.
	 */
	public void addCalculation(ArrayList<String> generatedExpression) {
		if(manualCalculations.size()>=CALCULATION_LIMIT)
			return;
		
		manualCalculations.add(new ManualCalculation(generatedExpression));	
	}

	/**
	 * Adds a new calculation to the list. If the limit on calculations has been reached, this method does nothing.
	 * @param generatedExpression the new expression. Must be a complete expression, i.e. of the form "2+5=7"
	 */
	public void addCalculation(String generatedExpression) {
		if(manualCalculations.size()>=CALCULATION_LIMIT)
			return;
			
		currentCalculation = 0;
		manualCalculations.add(new ManualCalculation(generatedExpression));
	}
	
	/**
	 * Clears all calculations
	 */
	public void clear() {
		manualCalculations.clear();		
	}

	public int size() {
		return manualCalculations.size();
	}

	public ManualCalculation get(int i) {
		if(i<0 || i>=manualCalculations.size())
			return nullCalc;
		
		return manualCalculations.get(i);
	}

	public void remove(ManualCalculation calculation) {
		currentCalculation = 0;
		manualCalculations.remove(calculation);
	}
	
	/**
	 * Imports the expressions given in calculations to this calculation set. No validation is performed.
	 * @param calculations the calculations to import
	 */
	public void importCalculations(String calculations) throws IllegalArgumentException{
		if(calculations.isEmpty())
			return;
		
		currentCalculation = 0;
		String[] expressions = calculations.split("\n");
		if(expressions.length<=0 || manualCalculations.size()+expressions.length >= CALCULATION_LIMIT)
			throw new IllegalArgumentException("TOO_MANY_CALCULATIONS");
		
		for(String s : expressions){
			manualCalculations.add(new ManualCalculation(s));
		}
		
	}

}
