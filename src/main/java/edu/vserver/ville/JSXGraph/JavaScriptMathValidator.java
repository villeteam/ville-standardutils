package edu.vserver.ville.JSXGraph;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JavaScriptMathValidator {

	private static final String reserved =

		"PI"	+ "|" +
		"E"		+ "|" +
		"LN2|LN10"		+ "|" +
		"SQRT2|SQRT1_2" + "|" +
		"LOG2E|LOG10E"	+ "|" +
		
		"sin" 	+ "|" +
		"cos" 	+ "|" +
		"tan" 	+ "|" +
		"atan" 	+ "|" +
		"atan2" + "|" +
		"acos" 	+ "|" +
		"asin" 	+ "|" +

		"pow" 	+ "|" +
		"sqrt" 	+ "|" +
		"abs" 	+ "|" +
		"exp" 	+ "|" +
		"log"	+ "|" +
		"ceil"	+ "|" +
		"floor"	+ "|" +
		"max"	+ "|" +
		"min";
	
	private static final Pattern whitelist = Pattern.compile(

		reserved				+ "|" +
	
		// numbers
		"[0-9]+(\\.[0-9]*)?" 	+ "|" +

		// 1 character length variables
		"[a-z](?![a-zA-Z0-9])"	+ "|" +

		// whitespace
		"\\s"					+ "|" +

		"Math"	+ "|" +

		","		+ "|" +
		"\\." 	+ "|" +
		"\\+" 	+ "|" +
		"\\-" 	+ "|" +
		"\\*" 	+ "|" +
		"\\/" 	+ "|" +
		"\\(" 	+ "|" +
		"\\)"

	);

	public static String validate(String str) {

		str = str.replaceAll(reserved, "Math\\.$0");
		System.out.println(str);

		Matcher matcher = whitelist.matcher(str);
		String consumed = matcher.replaceAll("");
		if(consumed.isEmpty())
			return str;
		else
			return "";

	}

}
