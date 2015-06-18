package edu.vserver.ville.JSXGraph;

import org.json.JSONException;
import org.json.JSONObject;

public class JSXFunction extends JSXElement {

	private String funcStr;
	private boolean derivative;

	public JSXFunction(JSXGraphComponent parent) {
		super(parent);
	}

	public JSXFunction(JSXGraphComponent parent, String id, String funcStr) {
		super(parent);

		setId(id);
		setFuncStr(funcStr);
	}

	public JSXFunction(JSXGraphComponent parent, String id, String funcStr,
			boolean isDerivative) {
		super(parent);

		setId(id);
		setFuncStr(funcStr);
		setDerivative(isDerivative);
	}

	public JSXFunction updateFromJSON(JSONObject json) {

		// Duck type it to fit.
		try {

			if (json.has("type")
					&& ((json.getString("type") == "curve") || (json
							.getString("type") == "functiongraph"))) {
				if (json.has("id"))
					setId(json.getString("id"));
				if (json.has("func"))
					setId(json.getString("func"));
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

	public String getFuncStr() {
		return funcStr;
	}

	public void setFuncStr(String funcStr) {
		this.funcStr = funcStr;
	}

	public boolean isDerivative() {
		return derivative;
	}

	public void setDerivative(boolean derivative) {
		this.derivative = derivative;
	}
}
