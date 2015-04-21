package edu.vserver.mathgenerator;

import java.text.DecimalFormat;

class GeneratorUtils {

	/**
	 * Gets a DecimalFormat that will format a decimal to the given decimals. Will show all trailing zeros
	 * @param decimals
	 * @return
	 */
	static DecimalFormat getDecimalFormat(int decimals){
		return new DecimalFormat(getDecimalFormatPattern(decimals, true));
	}
	
	/**
	 * Gets a DecimalFormat that will format a decimal to the given decimals.
	 * @param decimals
	 * @param showTrailingZeros If true, will show trailing zeros e.g. 4 decimals = 2.4300. If false, will not show the trailing zeros.
	 * @return
	 */
	static DecimalFormat getDecimalFormat(int decimals, boolean showTrailingZeros){
		return new DecimalFormat(getDecimalFormatPattern(decimals, showTrailingZeros));
	}
	
	/**
	 * Gets a pattern for formatting decimals to the given number of decimals with a formatter. Will show all trailing zeros.
	 * @param decimals
	 * @return
	 */
	static String getDecimalFormatPattern(int decimals){
		return getDecimalFormatPattern(decimals, true);
	}
	
	/**
	 * Gets a pattern for formatting decimals to the given number of decimals with a formatter.
	 * @param decimals
	 * @param showTrailingZeros If true, will show all trailing zeros. If false, will not show them.
	 * @return
	 */
	static String getDecimalFormatPattern(int decimals, boolean showTrailingZeros) {
		StringBuilder builder = new StringBuilder("0");

		if (decimals > 0) {
			builder.append(".");
			for (int i = 0; i < decimals; i++) {
				builder.append(showTrailingZeros ? "0" : "#");
			}
		}
		return builder.toString();
	}
}
