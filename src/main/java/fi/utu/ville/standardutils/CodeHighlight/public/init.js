fi_utu_ville_standardutils_CodeHighlight_CodeHighlight = function() {
	//console.log('Initializing a code highlight component.');
	var slice = Array.prototype.slice;
	var self = this;
	
	var place = $(this.getElement()).parents('body');
	
	//TODO change back to local once done with debugging.
	var component = new CodeHighlight(place, {}, function(response) { /* This callback does nothing. */ });
	
	//console.log(component);
	{ // Shared functions.
	
		self.codeHighlight = function(blocks) { component.codeHighlight(blocks); }
	}
};

//console.log('Code highlight init script loaded and executed.');