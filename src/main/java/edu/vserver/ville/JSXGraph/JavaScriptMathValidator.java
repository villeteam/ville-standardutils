package edu.vserver.ville.JSXGraph;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaScriptMathValidator {
	
	private static final Pattern whitelist = Pattern.compile(
		
		// numbers
		"[0-9]+(\\.[0-9]*)?" 	+ "|" +

		// 1 character length variables
		"[a-z](?![a-zA-Z0-9])" 	+ "|" +

		// whitespace
		"\\s"					+ "|" +

		"Math" 	+ "|" +

		"PI"	+ "|" +
		"E"		+ "|" +
		"LN10"	+ "|" +
		
		"sin" 	+ "|" +
		"cos" 	+ "|" +
		"tan" 	+ "|" +
		"atan" 	+ "|" +
		"acos" 	+ "|" +
		"asin" 	+ "|" +

		"pow" 	+ "|" +
		"sqrt" 	+ "|" +
		"abs" 	+ "|" +
		"exp" 	+ "|" +
		"log"	+ "|" +
		"ceil"	+ "|" +
		"floor"	+ "|" +

		"\\." 	+ "|" +
		"\\+" 	+ "|" +
		"\\-" 	+ "|" +
		"\\*" 	+ "|" +
		"\\/" 	+ "|" +
		"\\(" 	+ "|" +
		"\\)"
		
	);

	public static String validate(String str) {

		Matcher matcher = whitelist.matcher(str);
		String consumed = matcher.replaceAll("");
		if(consumed.isEmpty())
			return str;
		else
			return "";

	}

}
