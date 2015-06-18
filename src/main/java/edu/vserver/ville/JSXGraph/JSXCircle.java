package edu.vserver.ville.JSXGraph;

public class JSXCircle extends JSXElement {

	private String p1;
	private String p2;
	private String p3;
	private double radius;

	public JSXCircle(JSXGraphComponent parent) {

		super(parent);
	}

	public JSXCircle(JSXGraphComponent parent, String id, String p1, String p2,
			String p3, double radius) {

		super(parent);
		setId(id);
		setP1(p1);
		setP1(p2);
		setP1(p3);
		setRadius(radius);
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

	public String getP3() {
		return p3;
	}

	public void setP3(String p3) {
		this.p3 = p3;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
}
