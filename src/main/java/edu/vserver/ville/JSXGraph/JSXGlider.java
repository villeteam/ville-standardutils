package edu.vserver.ville.JSXGraph;

import org.json.JSONException;
import org.json.JSONObject;

public class JSXGlider extends JSXPoint {

	public JSXGlider(JSXGraphComponent parent) {
		super(parent);
	}

	public JSXGlider(JSXGraphComponent parent, String id, String name) {
		super(parent, id, name);
	}

	public JSXGlider(JSXGraphComponent parent, String id, String name,
			double x, double y) {
		super(parent, id, name, x, y);
	}

	@Override
	public JSXGlider updateFromJSON(JSONObject json) {

		// Duck type it to fit.
		try {

			if (json.has("type") && (json.getString("type") == "glider")) {
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
}
