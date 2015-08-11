package edu.vserver.ville.JSXGraph;

import elemental.json.JsonException;
import elemental.json.JsonObject;

public class JSXGlider extends JSXPoint {

	public JSXGlider(JSXGraphComponent parent) {
		super(parent);
	}

	public JSXGlider(JSXGraphComponent parent, String id, String name) {
		super(parent, id, name);
	}

	public JSXGlider(JSXGraphComponent parent, String id, String name, double x,
			double y) {
		super(parent, id, name, x, y);
	}

	@Override
	public JSXGlider updateFromJSON(JsonObject json) {

		// Duck type it to fit.
		try {

			if (json.hasKey("type") && (json.getString("type") == "glider")) {
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
}
