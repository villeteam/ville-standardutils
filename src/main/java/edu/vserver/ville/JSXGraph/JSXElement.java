package edu.vserver.ville.JSXGraph;


public class JSXElement {
	private JSXGraphComponent parent;
	private String id;

	public JSXElement(JSXGraphComponent parent) {
		setParent(parent);
	}

	JSXElement(JSXGraphComponent parent, String id) {
		setId(id);
		setParent(parent);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public JSXGraphComponent getParent() {
		return parent;
	}

	public void setParent(JSXGraphComponent parent) {
		this.parent = parent;
	}
}
