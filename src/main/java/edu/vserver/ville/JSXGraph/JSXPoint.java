package edu.vserver.ville.JSXGraph;

import elemental.json.JsonException;
import elemental.json.JsonObject;

public class JSXPoint extends JSXElement {
	private double x;
	private double y;
	private String name;

	public JSXPoint(JSXGraphComponent parent) {
		super(parent);
	}

	public JSXPoint(JSXGraphComponent parent, String id, String name) {
		super(parent);

		setId(id);
		setName(name);
	}

	public JSXPoint(JSXGraphComponent parent, String id, String name, double x,
			double y) {
		super(parent);

		setId(id);
		setName(name);
		setX(x);
		setY(y);
	}

	public JSXPoint updateFromJSON(JsonObject json) {

		// Duck type it to fit.
		try {

			if (json.hasKey("type") && (json.getString("type") == "point")) {
				if (json.hasKey("id"))
					setId(json.getString("id"));
				if (json.hasKey("x"))
					setId(json.getString("x"));
				if (json.hasKey("y"))
					setId(json.getString("y"));
				if (json.hasKey("name"))
					setId(json.getString("name"));
			} else {
				// Handled by program design.
			}
			return this;
		} catch (JsonException e) {
			// This should never be executed. Print the error.
			System.err.println(e.getStackTrace());
		}
		return null;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
