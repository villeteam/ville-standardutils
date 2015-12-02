package fi.utu.ville.standardutils.CodeHighlight;

import edu.vserver.mathutils.jsexertype.AbstractVilleJSComponent;

@com.vaadin.annotations.JavaScript({ "public/CodeHighlight.js",	"public/init.js" })
@com.vaadin.annotations.StyleSheet({ "public/styles/github.css" })
public class CodeHighlight extends AbstractVilleJSComponent {

	private static final long serialVersionUID = 2417058951200101316L;

	public CodeHighlight() {
		//System.out.println("Created a CodeHighlight element.");
	}
}
