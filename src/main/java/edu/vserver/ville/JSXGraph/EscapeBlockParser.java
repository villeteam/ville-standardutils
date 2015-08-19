package edu.vserver.ville.JSXGraph;

import java.util.HashMap;

public class EscapeBlockParser {

	public static HashMap<String, String> parseBlock(String blockText) {
		// &nbsp; and &shy; to spaces, otherwise you'll get problems with trims and copy/paste.
		blockText = blockText.replaceAll("\u00A0", " ").replaceAll("\u00ad", " ").replaceAll("\u2013", "-");
		
		//System.out.println("Parsing esacape block:'" + blockText + "'");
		HashMap<String, String> blockContents = new HashMap<String, String>();
		
		String lines[] = blockText.split("[\\r\\n]+|<br>|<br\\s+/>");
		//System.out.println("Split into " + lines.length + " lines.");
		for(String line : lines) {
			String split[] = line.trim().split("\\s+", 2);

			if(split.length == 2) {
				String key = split[0].trim();
				String value = split[1].trim();
				//System.out.println("Key: " + key + "; Value: " + value);
				blockContents.put(key, value);
			}
				

		}

		return blockContents;

	}

}
