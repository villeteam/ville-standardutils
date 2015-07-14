edu_vserver_ville_MathJax_VilleMathJax =
function() {

	var self = this;
	var processClasses = document.getElementsByClassName(this.getState().processClass);

	function typeset() {
		if(MathJax.isReady) {
			MathJax.Hub.Queue(["Typeset", MathJax.Hub, processClasses], self.loadingDone());
		}
		else {
			setTimeout(typeset, 100);
		}
	}
	typeset();

	this.needsRepaint = function() {
		MathJax.Hub.Queue(["Typeset", MathJax.Hub, processClasses], self.repaintDone());
	}

}
