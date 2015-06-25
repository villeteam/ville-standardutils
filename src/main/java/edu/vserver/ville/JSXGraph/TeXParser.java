package edu.vserver.ville.JSXGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

enum BlockType {
	LATEX,
	ESCAPE_BLOCK
}

class TeXBlock {
	public TeXBlock(BlockType type, String str) {
		this.blockType 		= type;
		this.blockString 	= str;
	}
	public BlockType blockType;
	public String blockString;
}

public class TeXParser implements Iterable<TeXBlock> {

	private static final Pattern pattern =
				Pattern.compile(
					"(.*?)"					+ // group 1
					"\\\\begin\\{escapeblock\\}"	+
					"(.*?)"					+ // group 2
					"\\\\end\\{escapeblock\\}"
				, Pattern.MULTILINE | Pattern.DOTALL);

	private final ArrayList<TeXBlock> blocks;

	@SuppressWarnings("unused")
	private TeXParser() {
		this.blocks = new ArrayList<TeXBlock>();
	}

	public TeXParser(String input) {

		this.blocks = new ArrayList<TeXBlock>();

		final Matcher matcher =
				pattern.matcher(input);

		while(matcher.find()) {
			this.appendTeX		  (	matcher.group(1));
			this.appendEscapeBlock(	matcher.group(2));
		}

		appendTeX(matcher.replaceAll(""));

	}

	@Override
	public Iterator<TeXBlock> iterator() {
		return blocks.iterator();
	}

	private void appendTeX(String str) {
		if(str.length() > 0)
			blocks.add(new TeXBlock(BlockType.LATEX, str));
	}

	private void appendEscapeBlock(String str) {
		if(str.length() > 0)
			blocks.add(new TeXBlock(BlockType.ESCAPE_BLOCK, str));
	}

}
