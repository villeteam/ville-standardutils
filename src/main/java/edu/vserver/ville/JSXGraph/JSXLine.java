package edu.vserver.ville.JSXGraph;

import elemental.json.JsonException;
import elemental.json.JsonObject;

public class JSXLine extends JSXElement {
	private double length;
	private double rise;
	private double slope;
	private double angle;
	private String p1Id;
	private String p2Id;
	private String name;

	public JSXLine(JSXGraphComponent parent) {
		super(parent);
	}

	public JSXLine(JSXGraphComponent parent, String id, String name,
			String p1Id, String p2Id) {
		super(parent);

		setId(id);
		setName(name);
		setP1Id(p1Id);
		setP2Id(p2Id);
	}

	public JSXLine updateFromJSON(JsonObject json) {

		// Duck type it to fit.
		try {

			if (json.hasKey("type") && (json.getString("type") == "line")) {
				if (json.hasKey("id"))
					setId(json.getString("id"));
				if (json.hasKey("p1"))
					setId(json.getString("p1"));
				if (json.hasKey("p2"))
					setId(json.getString("p2"));
				if (json.hasKey("length"))
					setId(json.getString("length"));
				if (json.hasKey("rise"))
					setId(json.getString("rise"));
				if (json.hasKey("slope"))
					setId(json.getString("slope"));
				if (json.hasKey("angle"))
					setId(json.getString("angle"));
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getRise() {
		return rise;
	}

	public void setRise(double rise) {
		this.rise = rise;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(double angle) {
		this.angle = angle;
	}

	public String getP1Id() {
		return p1Id;
	}

	public void setP1Id(String p1Id) {
		this.p1Id = p1Id;
	}

	public double getSlope() {
		return slope;
	}

	public void setSlope(double slope) {
		this.slope = slope;
	}

	public String getP2Id() {
		return p2Id;
	}

	public void setP2Id(String p2Id) {
		this.p2Id = p2Id;
	}
}
