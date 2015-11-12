package edu.vserver.exercises.math.essentials.generator;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Random;

import fi.utu.ville.standardutils.LocalizableEnum;
import fi.utu.ville.standardutils.PreciseDecimal;

public class MathGeneratorExerciseData implements Serializable, GeneratorData {
	
	public enum BoundingType implements LocalizableEnum{
		BOTH("EXPRESSION_GENERATOR_BOTH"), 
		SOLUTION("EXPRESSION_GENEARTOR_SOLUTION"),
		TERMS("EXPRESSION_GENERATOR_TERMS"),
		MANUAL("EXPRESSION_GENERATOR_MANUAL"),
		CUSTOM(LocalizableEnum.HIDDEN);

		private String localizerString;

		private BoundingType(String name) {
			this.localizerString = name;
		}

		public String getLocalizerString() {
			return localizerString;
		}
	}
	
	private static final long serialVersionUID = 8505981692063360701L;
	private static final int UNBOUNDDECIMALS = 16;
	private static final int MAX_NUM_OF_TERMS = 10;

	private final StringBuilder builder = new StringBuilder();
	private final Random gen;
	private int numberOfTerms;
	private ArrayList<Operator> allowedOperators;
	private final ArrayList<Range> termRange;
	private ManualCalculationSet manualCalculations;
	private final Range answerRange;
	private boolean allowParenthesis = true;
	private boolean forceParenthesis = false;
	private BoundingType boundingType;
	private boolean separateRanges;
	
	MathGeneratorExerciseData(){
		gen = new Random();
		termRange = new ArrayList<Range>();
		numberOfTerms = 0;

		answerRange = new Range(0, 10);
		allowParenthesis = true;
		forceParenthesis = false;
		this.allowedOperators = new ArrayList<Operator>();
		setBoundingType(BoundingType.TERMS);
		separateRanges = false;
		manualCalculations = new ManualCalculationSet();		
	}
	
	public MathGeneratorExerciseData(MathGeneratorExerciseData oldData) {
		gen = new Random();
		numberOfTerms = oldData.getNumberOfTerms();
		allowedOperators = new ArrayList<Operator>(oldData.allowedOperators);
		termRange = new ArrayList<Range>(oldData.termRange);
		answerRange = new Range(oldData.answerRange);
		allowParenthesis = oldData.allowParenthesis;
		setBoundingType(oldData.boundingType);
		separateRanges = oldData.getSeparateTermRangesFlag();
		manualCalculations = oldData.manualCalculations == null ? 
				new ManualCalculationSet() : oldData.manualCalculations ;
		forceParenthesis = oldData.forceParenthesis;
	}

	public MathGeneratorExerciseData(int numberOfTerms) {
		this();
		setNumberOfTerms(numberOfTerms);
		
		allowedOperators.add(Operator.SUM);
	}

	public MathGeneratorExerciseData(int numberOfTerms,
			Operator[] allowedOperators) {
		this();
		setNumberOfTerms(numberOfTerms);
		for (Operator o : allowedOperators)
			this.allowedOperators.add(o);
	}

	public void addTerm() {
		if (numberOfTerms < MAX_NUM_OF_TERMS) {
			numberOfTerms++;
			if(termRange.size() == 0)
				termRange.add(new Range(0,10));
			else
				termRange.add(new Range(termRange.get(0)));
		} else{
			numberOfTerms = MAX_NUM_OF_TERMS;
		}
	}

	public void decreaseTerm() {
		numberOfTerms = Math.max(numberOfTerms - 1, 2);
		if (numberOfTerms > 2)
			termRange.remove(termRange.size() - 1);
	}

	/**
	 * Sets the bounding type for the generator options.
	 * @param type The bounding type to use.
	 */
	public void setBoundingType(BoundingType type) {
		switch (type) {
		case BOTH:
			setSolutionBound(true);
			setTermsBound(true);
			break;
		case TERMS:
			setTermsBound(true);
			setSolutionBound(false);
			break;
		case SOLUTION:
			setSolutionBound(true);
			setTermsBound(false);
			break;
		case MANUAL:
			setSolutionBound(false);
			setTermsBound(false);
			break;
		default:
			break;
		}
		boundingType = type;
	}

	private void setTermsBound(boolean bound) {
		for (Range r : termRange) {
			r.boundDecimals = bound;
		}
	}

	void setTermBound(boolean bound, int index) {
		termRange.get(index).boundDecimals = bound;
	}
	
	void setSolutionBound(boolean bound) {
		answerRange.boundDecimals = bound;
	}

	public BoundingType getBoundingType() {
		return boundingType;
	}

	public void setSeparateTermsFlag(boolean flag){
		separateRanges = flag;
	}
	
	public boolean getSeparateTermRangesFlag(){
		return separateRanges;
	}
	
	public void setForcedMultiplier(int termIndex, double multiplier) {
		termRange.get(termIndex).forcedMultiplier = multiplier;
	}

	public double getForcedMultiplier(int termIndex) {
		return termRange.get(termIndex).forcedMultiplier;
	}

	public double[] getForcedMultipliers() {
		double[] result = new double[termRange.size()];
		int i = 0;
		for (Range r : termRange) {
			result[i] = r.forcedMultiplier;
			i++;
		}
		return result;
	}

	public boolean hasForcedMultiplier(int term) {
		return termRange.get(term).forcedMultiplier != 0;
	}

	/**
	 * Gets the minimum value for all terms. It is the users responsibility to
	 * either have called setTermRange(int, int) or otherwise ensure the term
	 * ranges are all the same.
	 * 
	 * @return the minimum value for the first term.
	 */
	public Number getMinValueForTerms() {
		return termRange.get(0).min;
	}

	/**
	 * Gets the maximum value for all terms. It is the users responsibility to
	 * either have called setTermRange(int, int) or otherwise ensure the term
	 * ranges are all the same.
	 * 
	 * @return the maximum value for the first term.
	 */
	public Number getMaxValueForTerms() {
		return termRange.get(0).max;
	}

	/**
	 * Gets the minimum value for the given term index.
	 * 
	 * @param index
	 *            The index of the term whose range we're interested in.
	 * @return the minimum range for this term.
	 */
	public Number getMinValueForTerm(int index) {
		return termRange.get(index).min;
	}

	/**
	 * Gets the maximum value for the given term index.
	 * 
	 * @param index
	 *            The index of the term whose range we're interested in.
	 * @return the maximum range for this term.
	 */
	public Number getMaxValueForTerm(int index) {
		return termRange.get(index).max;
	}

	public double[] getRangeForSolution() {
		return new double[] { answerRange.min, answerRange.max };
	}

	/**
	 * Gets the maximum value for the solution.
	 * 
	 * @return the maximum range for the solution.
	 */
	public Number getMaxValueForSolution() {
		return answerRange.max;
	}

	/**
	 * Gets the minimum value for the solution.
	 * 
	 * @return the minimum range for the solution.
	 */
	public Number getMinValueForSolution() {
		return answerRange.min;
	}

	/**
	 * Gets the number of decimals in the solution
	 * 
	 * @return The number of decimals in the solution.
	 */
	public int getNumberOfDecimalsInSolution() {
		if (answerRange.boundDecimals)
			return answerRange.allowedDecimals;
		return UNBOUNDDECIMALS;
	}

	public int getNumberOfDecimalsInTerm(int i) {
		if (termRange.get(i).boundDecimals)
			return termRange.get(i).allowedDecimals;
		return UNBOUNDDECIMALS;
	}

	/**
	 * Returns the number of allowed decimals in each of the terms.
	 * 
	 * @return an int array containing the number of decimals allowed in the term indicated by the index of the array. I.e. if the first term has 2 decimals and the second term has only 1 decimal, then this method returns [2,1]
	 */
	public int[] getNumberOfDecimalsInTerms() {
		int[] result = new int[termRange.size()];

		for (int i = 0; i < termRange.size(); i++) {
			result[i] = getNumberOfDecimalsInTerm(i);
		}
		return result;
	}

	/**
	 * sets the number of decimals in the given term
	 * 
	 * @param termIndex
	 * @param decimals
	 */
	public void setNumberOfDecimalsInTerm(int termIndex, int decimals) {
		if (decimals < 0)
			throw new IllegalArgumentException();
		termRange.get(termIndex).allowedDecimals = decimals;
	}

	/**
	 * Sets the number of decimals in all terms
	 * 
	 * @param decimals
	 */
	public void setNumberOfDecimalsInAllTerms(int decimals) {
		for (Range r : termRange)
			r.allowedDecimals = decimals;
	}

	/**
	 * Sets the number of decimals in the solution.
	 * 
	 * @param decimals
	 */
	public void setNumberOfDecimalsInSolution(int decimals) {
		decimals = Math.max(0, decimals);
		answerRange.allowedDecimals = decimals;
	}

	/**
	 * Sets the minimum value for the given term index.
	 * 
	 * @param minValue
	 *            the new minimum value
	 * @param index
	 *            The index of the term whose range we're interested in.
	 */
	public void setMinValueForTerm(Number minValue, int index) {
		this.termRange.get(index).set(minValue.doubleValue(),
				termRange.get(index).max);
	}

	/**
	 * Sets the maximum value for the given term index.
	 * 
	 * @param maxValue
	 *            the new maximum value
	 * @param index
	 *            The index of the term whose range we're interested in.
	 */
	public void setMaxValueForTerm(Number maxValue, int index) {
		this.termRange.get(index).set(termRange.get(index).min,
				maxValue.doubleValue());
	}

	/**
	 * Sets the maximum value for the solution.
	 * 
	 * @param maxValue
	 *            the new maximum value for the solution
	 */
	public void setMaxValueForSolution(Number maxValue) {
		this.answerRange.set(answerRange.min, maxValue.doubleValue());
	}

	public void setMinValueForSolution(Number minValue) {
		this.answerRange.set(minValue.doubleValue(), answerRange.max);
	}

	public void setSolutionRange(Number lowBound, Number upBound) {
		this.answerRange.set(lowBound.doubleValue(), upBound.doubleValue());
	}

	/**
	 * Sets the given range for all terms.
	 * 
	 * @param lowBound
	 * @param upBound
	 */
	public void setGlobalTermRange(Number lowBound, Number upBound) {
		for (Range r : termRange) {
			r.set(lowBound.doubleValue(), upBound.doubleValue());
		}
	}

	public void setTermRange(Number lowBound, Number upBound, int index) {
		this.termRange.get(index).set(lowBound.doubleValue(),
				upBound.doubleValue());
	}

	public int getNumberOfTerms() {
		return numberOfTerms;
	}

	public void setAdditionAllowed(boolean allowed) {
		setAllowedOperator(Operator.SUM, allowed);
	}

	public void setSubtractionAllowed(boolean allowed) {
		setAllowedOperator(Operator.SUBTRACT, allowed);
	}

	public void setMultiplicationAllowed(boolean allowed) {
		setAllowedOperator(Operator.MULTIPLICATION, allowed);
	}

	public void setDivisionAllowed(boolean allowed) {
		setAllowedOperator(Operator.DIVISION, allowed);
	}

	public ArrayList<Operator> getOperators() {
		return allowedOperators;
	}

	public boolean getAllowFractions() {
		for (Range r : termRange)
			if (r.allowedDecimals > 0)
				return true;

		if (answerRange.allowedDecimals > 0)
			return true;

		return false;
	}

	public void setAllowParenthesis(boolean allow) {
		allowParenthesis = allow;
	}

	public boolean getAllowParenthesis() {
		return allowParenthesis;
	}

	/**
	 * Gets a random term for the given index. If there is a forced multiplier for that term, it will be enforced.
	 * @param index
	 * @return a random term respecting all bounds.
	 */
	public PreciseDecimal getRandomTerm(int index) {
		int max = (int) Math.rint(termRange.get(index).max);
		int min = (int) Math.rint(termRange.get(index).min);
		
		if(boundingType == BoundingType.SOLUTION){
			max = (int)(answerRange.max*2);
			min = -max;
		}
				
		double solution = gen.nextInt(Math.abs(max-min) + 1) + min;
		
		// add decimals to the int solution
		if (termRange.get(index).allowedDecimals > 0) {
			solution = Math.min(solution + gen.nextDouble(),
					getMaxValueForTerm(index).doubleValue());
		}

		double result;
		try{
			result = Double.parseDouble(getFormattedNumber(solution,
				termRange.get(index).allowedDecimals));
		}catch(NumberFormatException e){
			result = 0;
		}
		

		if (hasForcedMultiplier(index)) {
			result = Math.floor(result / termRange.get(index).forcedMultiplier);
			result *= termRange.get(index).forcedMultiplier;			
		}

		if( (max-min) < 0)
			result *= -1;
		
		return new PreciseDecimal(result, termRange.get(index).allowedDecimals);
	}
		
	public Term getRandomSolution() {
		Term result = Term.getRandomTerm(answerRange.min, answerRange.max,
				getNumberOfDecimalsInSolution());
		return result;
	}

	public String getFormattedNumber(double number) {
		return getFormattedNumber(number, termRange.get(0).allowedDecimals);
	}

	public String getFormattedNumber(double number, int decimals) {
		return getFormattedNumber(number, decimals, true);
	}

	public String getFormattedNumber(double number, int decimals,
			boolean showDecimals) {
		if (Double.isInfinite(number) || Double.isNaN(number))
			return "0";
		return getNumberFormatter(decimals, showDecimals).format(number);
	}

	public String getFormattedTerm(double number, int termIndex) {
		return getFormattedNumber(number, getNumberOfDecimalsInTerm(termIndex));
	}

	public void setAllowedOperator(Operator operator, Boolean allowed) {
		if (allowed) {
			if (!allowedOperators.contains(operator)){
				allowedOperators.add(operator);
			}
		} else {
			allowedOperators.remove(operator);
		}
	}

	int[] getRangeAsInt(int termIndex) {
		return termRange.get(termIndex).getRangeAsInt();
	}

	public double[] getRangeAsDouble(int termIndex) {
		return termRange.get(termIndex).getRangeAsDouble();
	}

	private class Range implements Serializable {

		private static final long serialVersionUID = -6733279593203743564L;
		public double min;
		public double max;
		public int allowedDecimals;
		public double forcedMultiplier;
		public boolean boundDecimals = false;

		public Range(Range other) {
			this(other.min, other.max, other.allowedDecimals,
					other.forcedMultiplier, other.boundDecimals);
		}

		public Range(double min, double max) {
			this(min, max, 0, 0, true);
		}

		public Range(double min, double max, int decimals, double multiplier,
				boolean boundDecimals) {
			this.min = min;
			this.max = max;
			allowedDecimals = decimals;
			forcedMultiplier = multiplier;
			this.boundDecimals = boundDecimals;
		}

		void set(double min, double max) {
			this.min = min;
			this.max = max;
		}

		int[] getRangeAsInt() {
			return new int[] { (int) (min * Math.pow(10, allowedDecimals)),
					(int) (max * Math.pow(10, allowedDecimals)) };
		}

		double[] getRangeAsDouble() {
			return new double[] { min, max };
		}

	}

	public boolean additionAllowed() {
		return allowedOperators.contains(Operator.SUM);
	}

	public boolean subtractionAllowed() {
		return allowedOperators.contains(Operator.SUBTRACT);
	}

	public boolean multiplicationAllowed() {
		return allowedOperators.contains(Operator.MULTIPLICATION);
	}

	public boolean divisionAllowed() {
		return allowedOperators.contains(Operator.DIVISION);
	}

	public void clearOperators() {
		allowedOperators.clear();
	}

	public void setAllowedOperators(ArrayList<Operator> newOperators) {
		allowedOperators = newOperators;

	}

	/**
	 * Checks if at least one operator is chosen.
	 * @return true if at least one operator is chosen.
	 */
	public boolean atLeastOneOperatorChosen() {
		return allowedOperators.size() > 0;
	}
	
	DecimalFormat getNumberFormatter(int decimals) {
		return getNumberFormatter(decimals, true);
	}

	DecimalFormat getNumberFormatter(int decimals, boolean showTrailingZeros) {
		builder.delete(0, builder.length());

		builder.append("0");
		if (decimals > 0)
			builder.append(".");
		for (int i = 0; i < decimals; i++) {
			builder.append(showTrailingZeros ? "0" : "#");
		}
		DecimalFormat format = new DecimalFormat(builder.toString());
		format.setRoundingMode(RoundingMode.HALF_UP);
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		format.setDecimalFormatSymbols(symbols);
		
		return format;
	}

	int[] getRangeForObscuring(int termIndex) {
		int multiplier = (int) Math.pow(10,
				termRange.get(termIndex).allowedDecimals);
		Range range = termRange.get(termIndex);
		return new int[] { (int) range.min * multiplier,
				(int) range.max * multiplier };

	}

	@Override
	public String getRandomOperator(){
		return getRandomAllowedOperator().getSymbol();
	}
	
	public Operator getRandomAllowedOperator() {
		return allowedOperators.get(gen.nextInt(allowedOperators.size()));
	}

	public void setGlobalForcedMultiplier(double forcedMultiplier) {
		for (Range r : termRange) {
			r.forcedMultiplier = forcedMultiplier;
		}
	}

	public void setGlobalNumberOfDecimals(int decimals) {
		for (Range r : termRange)
			r.allowedDecimals = decimals;
	}

	public void setGlobalMaxTermRange(double max) {
		for (Range r : termRange)
			r.set(r.min, max);
	}

	public void setGlobalMinTermRange(double min) {
		for (Range r : termRange)
			r.set(min, r.max);
	}
	
	public ManualCalculationSet getManualCalculations() {
		return manualCalculations;
	}

	public void setManualCalculations(String manualCalculations) {
		this.manualCalculations = new ManualCalculationSet(manualCalculations);
	}

	public DecimalFormat getFormatterForSolution() {
		return getNumberFormatter(getNumberOfDecimalsInSolution());
	}

	public ArrayList<String> getNextManualExpression() {
		return manualCalculations.getNextCalculation();
	}

	public boolean areRangesValid() {
		for(int i=0; i<getNumberOfTerms(); i++){
			if(getMinValueForTerm(i).doubleValue() > getMaxValueForTerm(i).doubleValue()){
				return false;
			}
		}		
		return true;
	}

	public void setForceParenthesis(boolean value) {
		forceParenthesis = value;
	}
	
	public boolean getForceParenthesis(){
		return forceParenthesis;
	}

	void setNumberOfTerms(int terms) {
		if(numberOfTerms > terms){
			while(numberOfTerms > terms)
				decreaseTerm();
		}
		if(numberOfTerms < terms){
			while(numberOfTerms < terms)
				addTerm();
		}
	}

	public PreciseDecimal[] getRangeAsPreciseDecimal(int i) {
		Range range = termRange.get(i);
		return new PreciseDecimal[]{
				new PreciseDecimal(range.min,range.allowedDecimals),
				new PreciseDecimal(range.max,range.allowedDecimals)};
	}

	public boolean forcedMultiplierOK() {
		for(int i=0; i<getNumberOfTerms(); i++){
			double absMin = Math.abs(getMinValueForTerm(i).doubleValue());
			double absMax = Math.abs(getMaxValueForTerm(i).doubleValue());		
			if(getForcedMultiplier(i) > Math.max(absMax, absMin)){
				return false;
			}
		}
		return true;
	}
}
