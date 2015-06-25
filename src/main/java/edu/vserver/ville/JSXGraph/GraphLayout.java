package edu.vserver.ville.JSXGraph;

import java.util.HashMap;
import java.util.Iterator;

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

	@SuppressWarnings("unused")
	private GraphLayout() { }

	public GraphLayout(String input) {

		this.addStyleName("ville-graphlayout");
		mjax = new VilleMathJax("ville-graphlayout");
		this.addComponent(mjax);

		TeXParser texParser = new TeXParser(input);
		Iterator<TeXBlock> blockIter =
				texParser.iterator();
		while(blockIter.hasNext()) {

			TeXBlock block = blockIter.next();

			if(block.blockType == BlockType.LATEX)
				appendLatex(block.blockString);

			else if(block.blockType == BlockType.ESCAPE_BLOCK)
				appendGraph(block.blockString);

		}

	}

	private void appendLatex(String latexString) {
		Label latexLabel = new Label(latexString);
		this.addComponent(latexLabel);
	}

	private void appendGraph(String blockString) {

		JSXGraphComponentFactory fac =
				new JSXGraphComponentFactory();
		try {

			HashMap<String, String> blockContents =
				EscapeBlockParser.parseBlock(blockString);

			JSXGraphComponent graph = fac.makeGraph(blockContents);
			this.addComponent(graph);
			this.setComponentAlignment(graph, Alignment.MIDDLE_CENTER);

		} catch(IllegalArgumentException iae) {

			Notification.show("Illegal arguments: " +
				iae.getMessage()
				, Notification.Type.WARNING_MESSAGE);

		}

	}

}
