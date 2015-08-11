package edu.vserver.ville.MathJax;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

import elemental.json.JsonArray;
import elemental.json.JsonException;

@JavaScript({ "public/js/VilleMathJaxConfig.js",
		/* "https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML.js", */
		"https://ville.utu.fi/static_resources/MathJax/MathJax.js?config=TeX-AMS_HTML.js",
		"public/js/VilleMathJax.js" })
@StyleSheet({ "public/css/VilleMathJax.css" })
public class VilleMathJax extends AbstractJavaScriptComponent {

	/**
	 *
	 */
	private static final long serialVersionUID = 1166094083275017010L;

	public VilleMathJax(String processClass) {

		this.getState().processClass = processClass;

		this.getState().loaded = false;

		// callback when loaded
		this.addFunction("loadingDone", new JavaScriptFunction() {

			/**
			 *
			 */
			private static final long serialVersionUID = -1367248736833126685L;

			@Override
			public void call(JsonArray arguments) throws JsonException {
				getState().loaded = true;
			}

		});

		// callback from mathjax
		this.addFunction("repaintDone", new JavaScriptFunction() {

			/**
			 *
			 */
			private static final long serialVersionUID = -1367248736833126685L;

			@Override
			public void call(JsonArray arguments) throws JsonException {
				getState().repaintDone = true;
			}

		});

	}

	public void needsRepaint() {
		this.getState().repaintDone = false;
		if (this.getState().loaded)
			this.callFunction("needsRepaint");
	}

	@Override
	protected VilleMathJaxState getState() {
		return (VilleMathJaxState) super.getState();
	}

}
