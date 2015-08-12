package edu.vserver.ville.JSXGraph;

import java.util.HashMap;
import java.util.Iterator;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;

import edu.vserver.ville.MathJax.VilleMathJax;

public class GraphLayout extends VerticalLayout {

	/**
	 *
	 */
	private static final long serialVersionUID = 815293195464420655L;

	private VilleMathJax mjax = null;
	private String value;

	@SuppressWarnings("unused")
	private GraphLayout() {
		setValue("");
	}

	public GraphLayout(String input) {
		
		setValue(input);
	}
	
	public String getValue() {
		return this.value;
	}
	
	public void setValue(String value) {
		this.value = value;
		doLayout();
	}
	
	public void doLayout() {
		// Clean up before drawing.
		this.removeAllComponents();
		
		TeXParser texParser = new TeXParser(value);
		Iterator<TeXBlock> blockIter =
				texParser.iterator();
		while(blockIter.hasNext()) {

			TeXBlock block = blockIter.next();

			if(block.blockType == BlockType.LATEX)
				appendLatex(block.blockString);

			else if(block.blockType == BlockType.ESCAPE_BLOCK)
				appendGraph(block.blockString);

		}
		
		this.addStyleName("ville-graphlayout");
		mjax = new VilleMathJax("ville-graphlayout");
		
		this.addComponent(mjax);
	}

	private void appendLatex(String latexString) {
		//String[] paragraphs = latexString.split("\\r?\\n");
		//for(String s : paragraphs) {
			Label latexLabel = new Label(latexString, ContentMode.HTML);
			latexLabel.addStyleName("readability");
			this.addComponent(latexLabel);
		//}
	}

	private void appendGraph(String blockString) {

		JSXGraphComponentFactory fac =
				new JSXGraphComponentFactory();
		try {

			HashMap<String, String> blockContents =
				EscapeBlockParser.parseBlock(blockString);

			JSXGraphComponent graph = fac.makeGraph(blockContents);
			graph.addStyleName("readability");
			this.addComponent(graph);
			this.setComponentAlignment(graph, Alignment.MIDDLE_CENTER);

		} catch(IllegalArgumentException iae) {

			Notification.show("Illegal arguments: " +
				iae.getMessage()
				, Notification.Type.WARNING_MESSAGE);

		}

	}

}
