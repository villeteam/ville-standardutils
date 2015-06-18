package edu.vserver.ville.JSXGraph;

import org.json.JSONException;
import org.json.JSONObject;

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

	public JSXPoint updateFromJSON(JSONObject json) {

		// Duck type it to fit.
		try {

			if (json.has("type") && (json.getString("type") == "point")) {
				if (json.has("id"))
					setId(json.getString("id"));
				if (json.has("x"))
					setId(json.getString("x"));
				if (json.has("y"))
					setId(json.getString("y"));
				if (json.has("name"))
					setId(json.getString("name"));
			} else {
				// Handled by program design.
			}
			return this;
		} catch (JSONException e) {
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
