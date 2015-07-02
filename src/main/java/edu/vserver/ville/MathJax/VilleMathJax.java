package edu.vserver.ville.MathJax;

import org.json.JSONArray;
import org.json.JSONException;

import com.vaadin.annotations.JavaScript;
import com.vaadin.annotations.StyleSheet;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

@JavaScript({
	"public/js/VilleMathJaxConfig.js",
	/*"https://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML.js",*/
	"https://ville.utu.fi/static_resources/MathJax/MathJax.js?config=TeX-AMS_HTML.js",
	"public/js/VilleMathJax.js"
})
@StyleSheet({"public/css/VilleMathJax.css"})
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
			public void call(JSONArray arguments) throws JSONException {
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
			public void call(JSONArray arguments) throws JSONException {
				getState().repaintDone = true;
			}

		});

	}

	public void needsRepaint() {
		this.getState().repaintDone = false;
		if(this.getState().loaded)
			this.callFunction("needsRepaint");
	}

	protected VilleMathJaxState getState() {
		return (VilleMathJaxState) super.getState();
	}

}
