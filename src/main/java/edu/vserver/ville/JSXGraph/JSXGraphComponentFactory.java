package edu.vserver.ville.JSXGraph;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

//TODO list:
//Custom JSXGraphConfig
//Custom styling

public class JSXGraphComponentFactory {

	public JSXGraphComponent makeGraph(HashMap<String, String> params)
	throws IllegalArgumentException {

		if(!params.containsKey("type"))
			throw new IllegalArgumentException("No type defined");

		String type = params.get("type");
		Method factoryMethod = null;
		try {
			factoryMethod = this.getClass().getMethod(type, HashMap.class);
		} catch (NoSuchMethodException e) {
			throw new IllegalArgumentException(
				"No graphing functionality for this type exists");
		} catch (SecurityException e) {
			e.printStackTrace();

		}

		JSXGraphComponent graph = null;
		try {
			graph = (JSXGraphComponent) factoryMethod.invoke(this, params);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return graph;

	}

	public JSXGraphComponent parametricPlot(HashMap<String, String> params) {
		JSXGraphComponent graph =
			new JSXGraphComponent(new JSXGraphConfig());
		graph.addParametricCurve(
			"someID",
			JavaScriptMathValidator.validate(params.get("x")),
			JavaScriptMathValidator.validate(params.get("y")),
			Double.parseDouble(params.get("tMin")),
			Double.parseDouble(params.get("tMax")),
			new HashMap<String, String>()
		);
		return graph;
	}

	public JSXGraphComponent line(HashMap<String, String> params) {
		JSXGraphComponent graph =
			new JSXGraphComponent(new JSXGraphConfig());
		// TODO graph.addLine...
		return graph;
	}

	public JSXGraphComponent functionPlot(HashMap<String, String> params) {
		JSXGraphComponent graph =
			new JSXGraphComponent(new JSXGraphConfig());
		graph.addFunction(
			"someID",
			JavaScriptMathValidator.validate(params.get("f")),
			new HashMap<String, String>());
		return graph;
		
	}

}
