package edu.vserver.ville.JSXGraph;

import java.util.ArrayList;
import java.util.HashMap;

import com.vaadin.ui.JavaScriptFunction;

import edu.vserver.mathutils.jsexertype.AbstractVilleJSComponent;
import elemental.json.JsonArray;
import elemental.json.JsonException;
import elemental.json.JsonObject;

@com.vaadin.annotations.JavaScript({ "public/lib/jsxgraphcore.js",
		"public/js/init.js", "public/js/JsxGraphComponent.js" })
@com.vaadin.annotations.StyleSheet({
		"vaadin://themes/ville-theme/jsxgraph.css" })
public class JSXGraphComponent extends AbstractVilleJSComponent {

	private static final long serialVersionUID = 1L;

	private JSXGraphConfig config;

	public JSXGraphComponent(JSXGraphConfig conf) {

		this.config = conf;
		getState().config = conf;

		final JSXGraphComponent parent = this;

		addFunction("sendResults", new JavaScriptFunction() {

			private static final long serialVersionUID = -2315647695434533051L;

			@Override
			public void call(JsonArray arguments) {
				// System.out.println("sendResults(): " + arguments);
				try {
					JsonArray realArgs = arguments.getArray(0);
					JsonObject response = realArgs.getObject(0);

					// System.out.println("sendResults(): response = " +
					// response);

					String responseType = response.getString("type");
					if (responseType == "item") {
						// String callerID = response.getString("callerID");
						// String itemID = response.getString("itemID");
						JsonObject item = response.getObject("item");

						@SuppressWarnings("unused")
						JSXElement elem;
						switch (item.getString("type")) {
						case "point":
							elem = (new JSXPoint(parent)).updateFromJSON(item);
							break;
						case "glider":
							elem = (new JSXGlider(parent)).updateFromJSON(item);
							break;
						case "line":
							elem = (new JSXLine(parent)).updateFromJSON(item);
							break;
						case "curve":
						case "functiongraph":
							elem = (new JSXFunction(parent))
									.updateFromJSON(item);
							break;
						}
					} else if (responseType == "config") {
						config.updateFromJSON(response);
						getState().config = config;
						// System.out.println("Updated config = " + config);
					}

				} catch (JsonException e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	protected JSXGraphState getState() {
		return (JSXGraphState) super.getState();
	}

	public void setWidth(int wid) {
		callFunction("setWidth", wid);
	}

	public void setHeight(int hei) {
		callFunction("setHeight", hei);
	}

	public void add(String type, String id, ArrayList<String> params,
			HashMap<String, String> styling) {

		callFunction("add", type, id, params.toArray(), styling);
	}

	public void rem(String id) {
		callFunction("rem", id);
	}

	public void get(String id) {
		callFunction("get", id);
	}

	public JSXPoint addPoint(String id, double x, double y,
			HashMap<String, String> styling) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(Double.toString(x));
		params.add(Double.toString(y));
		add("point", id, params, styling);

		return new JSXPoint(this, id, null, x, y);
	}

	public JSXCircle addCircle(String id, String pointID, double radius,
			HashMap<String, String> styling) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(pointID);
		params.add(Double.toString(radius));
		add("circle", id, params, styling);

		return new JSXCircle(this, id, pointID, null, null, radius);
	}

	public JSXCircle addCircle(String id, String p1, String p2,
			HashMap<String, String> styling) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(p1);
		params.add(p2);
		add("circle", id, params, styling);
		return new JSXCircle(this, id, p1, p2, null, 0);
	}

	public JSXCircle addCircle(String id, String p1, String p2, String p3,
			HashMap<String, String> styling) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(p1);
		params.add(p2);
		params.add(p3);
		add("circle", id, params, styling);
		return new JSXCircle(this, id, p1, p2, p3, 0);
	}

	public JSXLine addLine(String id, String p1, String p2,
			HashMap<String, String> styling) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(p1);
		params.add(p2);
		add("line", id, params, styling);
		return new JSXLine(this, id, null, p1, p2);
	}

	public JSXParametricCurve addParametricCurve(String id, String x_t,
			String y_t, Double tMin, Double tMax,
			HashMap<String, String> styling) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(x_t);
		params.add(y_t);
		params.add(tMin.toString());
		params.add(tMax.toString());
		add("parametricCurve", id, params, styling);
		return new JSXParametricCurve(this, id, x_t, y_t, tMin, tMax);
	}

	public JSXGlider addGlider(String id, String parentID,
			HashMap<String, String> styling) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(parentID);
		add("glider", id, params, styling);

		return new JSXGlider(this, id, null);
	}

	public JSXGlider addGlider(String id, double x, double y, String parentID,
			HashMap<String, String> styling) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(Double.toString(x));
		params.add(Double.toString(y));
		params.add(parentID);
		add("glider", id, params, styling);

		return new JSXGlider(this, id, null, x, y);
	}

	public JSXFunction addFunction(String id, String jsFunc,
			HashMap<String, String> styling) {

		ArrayList<String> params = new ArrayList<String>();
		params.add(jsFunc);
		add("functiongraph", id, params, styling);

		return new JSXFunction(this, id, jsFunc);
	}

	public JSXFunction addDerivative(String id, String jsFunc,
			HashMap<String, String> styling) {
		ArrayList<String> params = new ArrayList<String>();
		params.add(jsFunc);
		add("derivative", id, params, styling);
		return new JSXFunction(this, id, jsFunc, true);
	}

	public void suspendUpdate() {
		callFunction("suspendUpdate");
	}

	public void unSuspendUpdate() {
		callFunction("unSuspendUpdate");
	}

	public void setBoundingBox(int x1, int y1, int x2, int y2) {

		callFunction("setBoundingBox", x1, y1, x2, y2);
	}

}
