package edu.vserver.exercises.math.essentials.generator;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

import fi.utu.ville.standardutils.MathHelper;
import fi.utu.ville.standardutils.PreciseDecimal;

class Term extends PreciseDecimal implements EquationElement {

	private static final long serialVersionUID = -4597811664125805137L;
	static final Term ZERO = new Term(0, 0);
	static final Term ONE = new Term(1, 0);
	static final Term MINUSONE = new Term(-1, 0);
	static final Random gen = new Random();

	static Term max(Term term1, Term term2) {
		if (term1.getAsDouble() > term2.getAsDouble())
			return term1;
		else
			return term2;
	}

	static Term min(Term term1, Term term2) {
		if (term1.getAsDouble() < term2.getAsDouble())
			return term1;
		else
			return term2;
	}

	static Term getRandomTerm(int lowBound, int upperBound) {
		return new Term(gen.nextInt(upperBound - lowBound + 1) + lowBound, 0);
	}

	static Term getRandomTerm(double lowBound, double upperBound, int decimals) {
		if (decimals == 0)
			return getRandomTerm((int) lowBound, (int) upperBound);

		double newValue = gen.nextDouble() * (upperBound - lowBound);
		newValue += lowBound;
		return new Term(newValue, decimals);
	}

	// private BigDecimal value;

	private final DecimalFormat format;
	private double value = 0.0;
	private int decimals = 0;

	public Term() {
		super(0);
		decimals = 0;
		value = 0.0;
		format = new DecimalFormat();
	}

	public Term(String number) {
		super(number);
		number = number.replace(",", ".");
		value = Double.parseDouble(number);
		decimals = number.indexOf(".") < 0 ? 0 : number.length()
				- number.indexOf(".") - 1;
		format = new DecimalFormat(
				GeneratorUtils.getDecimalFormatPattern(decimals));
	}

	public Term(String number, int decimals) {
		this(Double.valueOf(number), decimals);
	}

	public Term(Number number) {
		this(number.toString());
	}

	/**
	 * This constructor clones the given term
	 * 
	 * @param original
	 *            the term to clone
	 */
	public Term(Term original) {
		super(original.value);
		value = original.value;
		format = original.format;
		decimals = original.decimals;
	}

	public Term(Number number, int decimals) {
		super(number.doubleValue(), decimals);
		this.decimals = decimals;

		format = new DecimalFormat(GeneratorUtils.getDecimalFormatPattern(
				decimals, false));
		format.setRoundingMode(RoundingMode.HALF_UP);
		value = getDouble();
	}

	private int[] convertToFraction() {
		int[] result = new int[2];
		int precision = 10000;
		result[0] = (int) (value * precision);
		result[1] = precision;
		result = MathHelper.simplify(result);
		return result;
	}

	public int getNumerator() {
		return convertToFraction()[0];
	}

	public int getDenominator() {
		return convertToFraction()[1];
	}

	public int[] getIntegerDigits() {

		return parseStringToArray(format.format(value).split("\\.")[0]);
	}

	public int[] getDecimalDigits() {
		int[] result = null;

		String[] separated = format.format(value).split("\\.");
		if (separated.length > 1) {
			result = new int[separated[1].length()];
			result = parseStringToArray(separated[1]);
		}

		return result == null ? new int[0] : result;
	}

	/**
	 * Removes the decimal separator and all trailing zeroes
	 * 
	 * @return this number without a decimal separator and trailing decimal
	 * zeros.
	 */
	public int getWithoutDecimalSeparator() {
		return getWithoutDecimalSeparator(false);
	}

	/**
	 * Returns this number without a decimal separator.
	 * 
	 * @param showTrailingZeros
	 *            If true, include all trailing zeros, else hide them.
	 * @return this number without a decimal separator.
	 */
	public int getWithoutDecimalSeparator(boolean showTrailingZeros) {
		String result = toString();
		if (!showTrailingZeros && result.contains("."))
			result = result.replaceAll("[^0-9\\.]*0*$", "");
		result = result.replaceAll("\\.", "");
		return result.length() == 0 ? 0 : Integer.parseInt(result);
	}

	private int[] parseStringToArray(String number) {
		int digits = number.length();
		int[] result = new int[digits];
		for (int i = 0; i < digits; i++) {
			result[i] = Integer.valueOf(number.charAt(i) + "");
		}
		return result;
	}

	public boolean isInteger() {
		return value % 1 == 0;
	}

	public int getAsInteger() {
		return (int) value;
	}

	/**
	 * Gets this term with as much precision as possible
	 * 
	 * @return this term as a double
	 */
	public double getAsDouble() {
		return value;
	}

	/**
	 * Gets this term with the given precision. If there is not enough precision
	 * in this term, trailing zeroes are added.
	 * 
	 * @param decimals
	 *            how many decimals are required
	 * @return this term with as many decimal places as given as the parameter.
	 */
	public String getAsDouble(int decimals) {
		return getAsDouble(decimals, true);
	}

	/**
	 * Returns this terms with the given number of decimals.
	 * 
	 * @param decimals
	 * @param showTrailingZeros
	 *            Are trailing zeroes shown or hidden
	 * @return this term with the specified number of decimals
	 */
	public String getAsDouble(int decimals, boolean showTrailingZeros) {
		DecimalFormat format = new DecimalFormat(
				GeneratorUtils.getDecimalFormatPattern(decimals,
						showTrailingZeros));
		// format.setMinimumFractionDigits(0);
		// format.setMaximumFractionDigits(decimals);
		format.setRoundingMode(RoundingMode.HALF_UP);
		return format.format(value);
	}

	/**
	 * Returns the amount of decimals in this number.
	 * 
	 * @return the number of decimals in this number
	 */
	public int getDecimals() {
		return decimals;
	}

	/***
	 * Returns the sign of this Term. +1 if it is positive or 0, -1 if it is
	 * negative. The returned value is never 0.
	 * 
	 * @return The sign of this term (+1/-1).
	 */
	public int getSign() {
		return value < 0 ? -1 : 1;
	}

	public boolean isPositive() {
		return getSign() > 0;
	}

	@Override
	public String toString() {
		return getAsDouble(decimals) + "";
	}

	public Term add(Term other) {
		return new Term(this.value + other.value);
	}

	public Term subtract(Term other) {
		return new Term(this.value - other.value);
	}

	public Term multiply(Term other) {
		Term result = new Term(other.value * this.value);
		return result;
	}

	public Term multiply(int multiplier, int scale) {
		return new Term(value * multiplier);
	}

	public Term multiply(int multiplier) {
		return new Term(value * multiplier);
	}

	public Term divide(Term dividend, int scale) {
		return new Term(value / dividend.value);
	}

	public Term divide(Term dividend) {
		return new Term(value / dividend.value);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Term) {
			Term t = (Term) obj;
			return this.value == t.value;
		}
		return false;
	}

	/**
	 * Compares this Term to the given term using the given decimal precision.
	 * 
	 * @param other
	 *            the term to compare against
	 * @param decimals
	 *            the precision to be used when comparing
	 * @return true if they are equal within the given precision, false
	 *         otherwise
	 */
	public boolean isApproximately(Term other, int decimals) {
		return other.getAsDouble(decimals).equals(getAsDouble(decimals));
	}

	/**
	 * Compares this Term to the given number using the given decimal precision.
	 * 
	 * @param other
	 *            the number to compare against
	 * @param decimals
	 *            the precision to be used when comparing
	 * @return true if they are equal within the given precision, false
	 *         otherwise
	 */
	public boolean isApproximately(Number other, int decimals) {
		return new Term(other).getAsDouble(decimals).equals(
				getAsDouble(decimals));
	}

	@Override
	public String getSymbol() {
		if (isInteger())
			return Math.abs(getAsInteger()) + "";
		else
			return getAsDouble(decimals) + "";
	}

	public Term negate() {
		// throw new NotImplementedException();
		Term result = new Term(this);
		result.value *= -1;
		return result;
	}

	public boolean isLessThan(Number i) {
		return this.value < i.doubleValue();
	}

	public boolean isGreaterThan(Number i) {
		return this.value > i.doubleValue();
	}

	@Override
	public int getPriority() {
		return 0;
	}

	public void setDecimals(int numberOfDecimalsInTerm) {
		decimals = numberOfDecimalsInTerm;
	}
}
