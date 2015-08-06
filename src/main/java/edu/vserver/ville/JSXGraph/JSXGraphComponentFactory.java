package edu.vserver.ville.JSXGraph;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		try {
			graph.addParametricCurve(
				"someID",
				JavaScriptMathValidator.validate(params.get("x")),
				JavaScriptMathValidator.validate(params.get("y")),
				Double.parseDouble(params.get("tMin")),
				Double.parseDouble(params.get("tMax")),
				new HashMap<String, String>()
			);
		}
		catch (Exception e) {
			// Malformed user input
			// TODO draw text on the graph indicating the error?
		}
		return graph;
	}

	public JSXGraphComponent linePlot(HashMap<String, String> params) {
		JSXGraphComponent graph =
			new JSXGraphComponent(new JSXGraphConfig());
		try {
			graph.addLine(
				"someID",
				params.get("p1"),
				params.get("p2"),
				new HashMap<String, String>()
			);
		}
		catch (Exception e) {
			// Malformed user input
			// TODO draw text on the graph indicating the error?
		}
		return graph;
	}

	public JSXGraphComponent functionPlot(HashMap<String, String> params) {
		JSXGraphComponent graph =
			new JSXGraphComponent(new JSXGraphConfig());
		try {
			graph.addFunction(
				"someID",
				JavaScriptMathValidator.validate(params.get("f")),
				new HashMap<String, String>());
		}
		catch (Exception e) {
			// Malformed user input
			// TODO draw text on the graph indicating the error?
		}
		return graph;
		
	}

	public JSXGraphComponent pointPlot(HashMap<String, String> params) {
		JSXGraphComponent graph =
			new JSXGraphComponent(new JSXGraphConfig());
		try {

			String points = params.get("points");

			// Add all points
			String regex =
				"\\{\\s*(\\+|-)?(\\d+(\\.\\d+)*)\\s*,"
				+ "\\s*(\\+|-)?(\\d+(\\.\\d+)*)\\s*\\}";
			Matcher m = Pattern.compile(regex).matcher(points);

			while(!m.hitEnd()) {
				if(m.find()) {
					double xcoord = Double.parseDouble(m.group(2));
					double ycoord = Double.parseDouble(m.group(5));
					graph.addPoint("id", xcoord, ycoord, new HashMap<String, String>());
				}
			}
			
		}
		catch (Exception e) {
			// Malformed user input
			// TODO draw text on the graph indicating the error?
		}
		return graph;
	}

}

