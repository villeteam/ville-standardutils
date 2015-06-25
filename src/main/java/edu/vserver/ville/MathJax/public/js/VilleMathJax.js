edu_vserver_ville_MathJax_VilleMathJax =
function() {

	var processClass = this.getState().processClass;

	var head = document.getElementsByTagName("head")[0], script;
	script = document.createElement("script");
	script.type = "text/x-mathjax-config";
	script[(window.opera ? "innerHTML" : "text")] =
	  "MathJax.Hub.Config({\n" +
	  "  tex2jax: { inlineMath: [['$','$'], ['\\\\(','\\\\)']] },\n" +
	  "  messageStyle: \"none\", \n" +
	  "  ignoreClass: \"[a-zA-Z0-9]*\", \n" +
	  "  processClass: \"" + processClass + "\", \n" +
	  "  TeX: { equationNumbers: { autoNumber: \"AMS\" } } \n" +
	  "});"
	head.appendChild(script);
	script = document.createElement("script");
	script.type = "text/javascript";
	script.src  = "http://cdn.mathjax.org/mathjax/latest/MathJax.js?config=TeX-AMS_HTML.js";
	head.appendChild(script);

	this.needsRepaint = function() {
		MathJax.Callback.Queue(["Typeset", MathJax.Hub], this.repaintDone());
	}

	this.getState().loadingDone = true;
	
}
