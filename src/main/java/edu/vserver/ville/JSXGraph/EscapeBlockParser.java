package edu.vserver.ville.JSXGraph;

import java.util.HashMap;

public class EscapeBlockParser {

	public static HashMap<String, String> parseBlock(String blockText) {

		HashMap<String, String> blockContents
			= new HashMap<String, String>();

		String lines[] = blockText.split("[\\r\\n]+");

		for(String line : lines) {
			String split[] =
				line.trim().split("\\s+", 2);

			if(split.length == 2)
				blockContents.put(split[0], split[1]);

		}

		return blockContents;

	}

}
