package fi.utu.ville.standardutils;

import java.io.Serializable;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import com.vaadin.data.Property.ReadOnlyException;

import fi.utu.ville.standardutils.ui.NumericValueProvider;

// The value of this class is immutable.
public class PreciseDecimal implements NumericValueProvider,
		Comparable<PreciseDecimal>, Serializable {

	private static final long serialVersionUID = 5481020391938646615L;

	private static final String[] DECIMAL_FORMATS;
	private static final int MAX_DECIMALS = 20;
	public static final PreciseDecimal ZERO = new PreciseDecimal(0L);
	public static final PreciseDecimal ONE = new PreciseDecimal(1L);
	public static final PreciseDecimal MINUS_ONE = new PreciseDecimal(-1L);
	public static final PreciseDecimal MIN_VALUE = new PreciseDecimal(
			Long.MIN_VALUE);
	public static final PreciseDecimal MAX_VALUE = new PreciseDecimal(
			Long.MAX_VALUE);
	private DecimalFormatSymbols formatSymbols;

	long value;
	int decPoint = 0; // offset from the right

	public PreciseDecimal(PreciseDecimal toClone) {
		this.value = toClone.value;
		this.decPoint = toClone.decPoint;
	}

	public PreciseDecimal(long value) {
		this.value = value;
	}

	// Very imprecise way of initializing PreciseDecimal
	public PreciseDecimal(double value) {
		this(value + "");
		optimizePresentation();
	}

	// Slightly more precise way of initializing PreciseDecimal than passing
	// only double value
	public PreciseDecimal(double value, int numDecimals) {
		this(getDecimalFormatter(numDecimals).format(value));
		optimizePresentation();
	}

	public PreciseDecimal(long value, int decimalPoint) {
		this.value = value;
		this.decPoint = decimalPoint;
		optimizePresentation();
	}

	public PreciseDecimal(String str) {
		long[] parts = parseDecimalFromString(str);
		value = parts[0];
		decPoint = (int) parts[1];
		optimizePresentation();
	}

	public static PreciseDecimal createFromFractionArray(int[] array,
			int maxDecimals) {
		int numIndex = 0;
		if (array.length == 3) {
			array[1] = array[1] + array[0] * array[2];
			numIndex = 1;
		}
		return new PreciseDecimal(array[numIndex]
				/ (double) array[numIndex + 1], maxDecimals);
	}

	public long getIntegerPart() {
		return (long) (value / Math.pow(10, decPoint));
	}

	// Warning: type long can't handle leading zeros
	public long getDecimalPartValue() {
		return Math.abs(value
				- (long) (getIntegerPart() * Math.pow(10, decPoint)));
	}

	public String getDecimalPart() {
		if (getNumDecimals() == 0) {
			return "";
		}
		long lval = getDecimalPartValue();
		return getDecimalPartFormatter().format(lval);
	}

	public int getNumDecimals() {
		return decPoint;
	}

	public double toDouble() {
		return value / Math.pow(10, decPoint);
	}

	public int toInteger() {
		return (int) getIntegerPart();
	}

	/* These functions are provided to use with old Ville code which uses arrays extensively */
	public long[] toFractionWithUnits() {
		long[] fraction = new long[3];
		fraction[0] = getIntegerPart();
		fraction[1] = getDecimalPartValue();
		fraction[2] = (long) Math.pow(10, getNumDecimals());
		return fraction;
	}

	public int[] toFractionWithUnitsInt() {
		long[] longFrac = toFractionWithUnits();
		return convertArray(longFrac);
	}

	//
	// public int[] toIntegerDecimalArrayInt() {
	// return convertArray(toIntegerDecimalArray());
	// }
	//
	// public long[] toIntegerDecimalArray() {
	// long[] result = new long[2];
	// result[0] = getIntegerPart();
	// result[1] = getDecimalPart();
	// return result;
	// }
	//
	// public static int[] fractionToDecimalArray(int[] array) {
	// int[] result = new int[2];
	// if(array.length == 3) {
	// result[0] = array[0];
	// // TODO: Support for divisors not powers of 10
	// result[1] = array[1];
	// }
	// }

	// Returns [0] = value, [1] = decimal point from the right.
	public static long[] parseDecimalFromString(String str) {
		long value = 0;
		long decPoint = 0;
		if (str.length() == 0
				|| (str.length() == 1 && Character.DASH_PUNCTUATION == Character
						.getType(str.charAt(0)))) {

		}
		boolean decSeparator = false;
		boolean negative = false;
		int numDigits = 0;
		for (int i = 0; i < str.length() && numDigits < 18; i++) {
			char c = str.charAt(i);
			if (Character.isWhitespace(c)) {
				continue;
			}
			if (Character.DASH_PUNCTUATION == Character.getType(c)) {
				negative = true;
				if (value != 0) {
					throw new NumberFormatException(
							"Dash symbol can only appear at the beginning of string, input: "
									+ str);
				}
				continue;
			}
			if (c == '.' || c == ',') {
				if (decSeparator) {
					throw new NumberFormatException("The input string \"" + str
							+ "\" has two decimal separators");
				}
				decSeparator = true;
				continue;
			}
			if(c == 'E' || c == 'e') { // trying to parse exponential notation
				try {
					int exp = Integer.parseInt(str.substring(i+1));
					if(exp <= 0) {
						decPoint += -exp;
					}
					else {
						value *= (long)Math.pow(10, exp);
					}
				}
				catch(Exception ex) {
					throw new NumberFormatException("Error while parsing exponent in input string: " + str);
				}
				break;
			}
			if ('0' > c || '9' < c) {
				throw new NumberFormatException("Invalid character \'" + c
						+ "\' in string \"" + str + "\"");
			}
			int digit = c - '0';
			value *= 10;
			value += digit;
			numDigits++;
			if (decSeparator) {
				decPoint++;
			}
		}
		if (negative) {
			value *= -1;
		}
		return new long[] { value, decPoint };
	}

	public static double parseDoubleFromString(String str, int allowedDecimals) {
		long[] parts = parseDecimalFromString(str);
		for (long i = parts[1]; i > allowedDecimals; i--) {
			parts[0] /= 10;
			parts[1]--;
		}
		return parts[0] / Math.pow(10, parts[1]);
	}

	public static double parseDoubleFromString(String str) {
		long[] parts = parseDecimalFromString(str);
		return parts[0] / Math.pow(10, parts[1]);
	}

	// Operators

	public static PreciseDecimal add(PreciseDecimal a, PreciseDecimal b) {
		long value = 0;
		if (a.decPoint > b.decPoint) { // ensure a.decPoint <= b.decPoint
			PreciseDecimal t = a;
			a = b;
			b = t;
		}
		value = (long) (a.value * Math.pow(10, b.decPoint - a.decPoint))
				+ b.value;
		int decPoint = b.decPoint;
		return new PreciseDecimal(value, decPoint);
	}

	public static PreciseDecimal subtract(PreciseDecimal a, PreciseDecimal b) {
		return add(a, b.getInverse());
	}

	public static PreciseDecimal multiply(PreciseDecimal a, PreciseDecimal b) {
		long value = a.value * b.value;
		int decPoint = a.getNumDecimals() + b.getNumDecimals();
		return new PreciseDecimal(value, decPoint);
	}

	public static PreciseDecimal divide(PreciseDecimal a, PreciseDecimal b) {
		long value = a.value / b.value;
		long remainder = a.value % b.value;
		int decPoint = a.decPoint;
		while (remainder != 0 && Math.log10(value) < 18) {
			decPoint += 1;
			remainder *= 10;
			value *= 10;
			value += remainder / b.value;
			remainder = remainder % b.value;
		}
		return new PreciseDecimal(value, decPoint);
	}
	
	public static PreciseDecimal divide(long a, long b) {
		return PreciseDecimal.divide(new PreciseDecimal(a), new PreciseDecimal(b));
	}

	public PreciseDecimal getInverse() {
		return new PreciseDecimal(-this.value, this.decPoint);
	}

	@Override
	public String toString() {
		return getDecimalFormatter().format(toDouble());
	}

	public String toString(int numDecimals) {
		return getDecimalFormatter(numDecimals, formatSymbols).format(
				toDouble());
	}

	public DecimalFormat getDecimalFormatter() {
		int numDecimals = getNumDecimals();
		return getDecimalFormatter(numDecimals, formatSymbols);
	}

	public static DecimalFormat getDecimalFormatter(int numDecimals) {
		return getDecimalFormatter(numDecimals, null);
	}

	public static DecimalFormat getDecimalFormatter(int numDecimals,
			DecimalFormatSymbols formatSymbols) {
		String format = "0";
		if (numDecimals > 0) {
			format += "." + DECIMAL_FORMATS[numDecimals];
		}
		DecimalFormat df;
		if (formatSymbols != null) {
			df = new DecimalFormat(format, formatSymbols);
		} else {
			df = new DecimalFormat(format);
		}
		df.setRoundingMode(RoundingMode.HALF_UP);
		return df;
	}

	private DecimalFormat getDecimalPartFormatter() {
		DecimalFormat df = new DecimalFormat(DECIMAL_FORMATS[getNumDecimals()]);
		return df;
	}

	public boolean isApproximately(double other) {
		// TODO: Check this implementation
		DecimalFormat df = getDecimalFormatter();
		String curValStr = df.format(toDouble());
		String otherValStr = df.format(other);
		// System.out.println("other: " + otherValStr + "this: " + curValStr);
		return curValStr.equals(otherValStr);
	}

	@Override
	public boolean equals(Object other) {
		if (other == null) {
			return false;
		}
		if (other instanceof Double) {
			return new PreciseDecimal((Double) other).equals(this);
		}
		if (other instanceof Integer) {
			return (this.decPoint == 0 && ((Integer) other).equals((int)this
					.getIntegerPart()));
		}
		if (other instanceof String) {
			try {
				return equals(new PreciseDecimal((String) other));
			} catch (NumberFormatException ex) {
				return false;
			}
		}
		if (other instanceof PreciseDecimal) {
			PreciseDecimal dec = (PreciseDecimal) other;
			return (dec.value == this.value && dec.decPoint == this.decPoint);
		}
		return false;
	}

	public void setGroupingSeparator(char value) {
		formatSymbols = new DecimalFormatSymbols();
		formatSymbols.setDecimalSeparator(value);
	}

	private void optimizePresentation() {
		while (decPoint > 0) {
			if (value % 10 == 0) {
				decPoint--;
				value /= 10;
			} else {
				break;
			}
		}
	}
	
	@SuppressWarnings("unused")
	private PreciseDecimal copy() {
		return new PreciseDecimal(this.value, this.decPoint);
	}

	private static int[] convertArray(long[] array) {
		int[] result = new int[array.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = (int) array[i];
		}
		return result;
	}

	static {
		DECIMAL_FORMATS = new String[MAX_DECIMALS];
		String f = "";
		for (int i = 0; i < MAX_DECIMALS; i++) {
			DECIMAL_FORMATS[i] = f;
			f += "0";
		}
	}

	@Override
	public PreciseDecimal getPreciseDecimal() {
		return new PreciseDecimal(this);
	}

	@Override
	public double getDouble() {
		return toDouble();
	}

	@Override
	public void setValue(NumericValueProvider preciseDecimal)
			throws ReadOnlyException {
		throw new ReadOnlyException("PreciseDecimal is immutable");
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public int compareTo(PreciseDecimal other) {
		long tvalue = this.value;
		long ovalue = other.value;
		if (this.decPoint > other.decPoint) {
			ovalue *= Math.pow(10, this.decPoint - other.decPoint);
		}
		if (this.decPoint < other.decPoint) {
			tvalue *= Math.pow(10, other.decPoint - this.decPoint);
		}
		return (int) Math.signum((double) tvalue - (double) ovalue); 
		// silly conversion ensures long overflow doesn't occur
	}

	@Override
	public boolean canChangeValueTo(double newValue) {
		return true;
	}
}