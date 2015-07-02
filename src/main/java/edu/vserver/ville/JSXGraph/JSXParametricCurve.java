package edu.vserver.ville.JSXGraph;

public class JSXParametricCurve extends JSXElement {


	public Double tMin;
	public Double tMax;
	public String x_t;
	public String y_t;

	public JSXParametricCurve(
		JSXGraphComponent parent,
		String id,
		String x_t, String y_t,
		Double tMin, Double tMax) {

		super(parent, id);
		
		this.tMin = tMin;
		this.tMax = tMax;
		this.x_t = x_t;
		this.y_t = y_t;

	}
}
