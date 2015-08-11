package edu.vserver.ville.JSXGraph;

import elemental.json.JsonException;
import elemental.json.JsonObject;

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

	public JSXFunction updateFromJSON(JsonObject json) {

		// Duck type it to fit.
		try {

			if (json.hasKey("type") && ((json.getString("type") == "curve")
					|| (json.getString("type") == "functiongraph"))) {
				if (json.hasKey("id"))
					setId(json.getString("id"));
				if (json.hasKey("func"))
					setId(json.getString("func"));
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
