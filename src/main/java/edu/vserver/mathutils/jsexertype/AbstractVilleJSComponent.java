package edu.vserver.mathutils.jsexertype;

import com.vaadin.ui.AbstractJavaScriptComponent;

//@com.vaadin.annotations.JavaScript({ "public/jquery-1.11.1.js",
//		"public/raphael.js", "public/jquery-ui.js" })
@com.vaadin.annotations.JavaScript({
		"public/compatible_versions/jquery.min.js",
		"public/compatible_versions/jquery-ui.min.js",
		"public/compatible_versions/raphael.js",
		"public/compatible_versions/underscore-min.js" })
public class AbstractVilleJSComponent extends AbstractJavaScriptComponent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8140588014611693869L;

}
