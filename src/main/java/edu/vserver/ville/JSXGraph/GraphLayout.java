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
	
	private static final long serialVersionUID = 815293195464420655L;

	private VilleMathJax mjax = null;
	private String value;

	//	private static CodeHighlight codeHighlight = new CodeHighlight();

	@SuppressWarnings("unused")
	private GraphLayout() {
		setValue("");
		
	}

	public GraphLayout(String input) {
		
		setValue(input);
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
		doLayout();
	}
	
	public void doLayout() {
		// Clean up before drawing.
		removeAllComponents();
		
		TeXParser texParser = new TeXParser(value);
		Iterator<TeXBlock> blockIter = texParser.iterator();
		while (blockIter.hasNext()) {
			
			TeXBlock block = blockIter.next();

			if (block.blockType == BlockType.LATEX) {
				appendLatex(block.blockString);
			} else if (block.blockType == BlockType.ESCAPE_BLOCK) {
				appendGraph(block.blockString);
			}

		}
		
		addStyleName("ville-graphlayout");
		mjax = new VilleMathJax("ville-graphlayout");
		mjax.setStyleName("mjax-invisible");
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

	private void appendGraph(String blockString) throws IllegalArgumentException {
		
		JSXGraphComponentFactory fac = new JSXGraphComponentFactory();
		try {
			
			HashMap<String, String> blockContents = EscapeBlockParser.parseBlock(blockString);
			
			switch (blockContents.get("type")) {
			case "parametricPlot":
			case "linePlot":
			case "pointPlot":
			case "functionPlot":
				JSXGraphComponent graph = fac.makeGraph(blockContents);
				graph.addStyleName("readability");
				this.addComponent(graph);
				setComponentAlignment(graph, Alignment.MIDDLE_CENTER);
				break;
			default:
				Notification.show(
						"Unhandled escape block type '" + blockContents.get("type") + "' in '" + blockString + "'.",
						Notification.Type.WARNING_MESSAGE);
				break;
			}
		} catch (IllegalArgumentException iae) {
			
			Notification.show("Illegal arguments: " +
					iae.getMessage(), Notification.Type.WARNING_MESSAGE);

		}

	}

}
