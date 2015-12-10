function CodeHighlight(place, config, callback) {
	this.place = null;
	this.config = {
		// Nothing for now.
		id: 'codeHighliht-' + (Math.random() * 1000000 | 0),
		active: false,
		domCheckerInterval: -1,
		debug: false
	};
	if (this.config.debug === true) console.log('CodeHiglight constructor', place, config, callback);
	
	this.initialize(place, config, callback);
}

CodeHighlight.prototype.initialize = function(place, config, callback) {
	if (this.config.debug === true) console.log('CodeHiglight.initialize()', place, config, callback);
	var self = this;
	
	this.place = place;
	for (var item in config) this.config[item] = config[item];
	var processing = false;
	
	// Make sure you doesn't end up in shadow DOM.
	var head = place.parents('html').find('head');
	var meta = head.find('meta[data-code-highlight]');
	
	// Make sure that you do not create two code highlights.
	// Do not create a new one or there will be a battle that collapses the Universe.
	if ( (meta.length > 0) && (meta.attr('data-code-highlight') === 'on') ) {
		//console.log('There already exists a code highlighter somewhere. Do not create a new one.');
		if (typeof(callback) == 'function') callback({type: 'initDone', active: this.config.active});
		return;
	}
	else {
		// If it wasn't on, it's on now.
		if (meta.length === 0) $('head').append('<meta data-code-highlight="on" />');
		else meta.attr('data-code-highlight', 'on');
		this.config.active = true;
		
		var __actOnDOMChange = function(e) {
			
			/*
			 * Avoid recursion errors with own code, jQuery and highlight.js,
			 * the react only once to modifications.
			 */
			if (!processing) {
				processing = true;
				var newCodeBlocks = $(e.target).find('pre code:not(.codeHighlight)');
				if (newCodeBlocks.length > 0) self.codeHighlight(newCodeBlocks);
				processing = false;
			}
		}
		
		/*
		 * The usage of mutatation events are disabled until I figure out how to reliably
		 * circumvent problems with all versions with Internet Explorer.
		 * 
		 * IE11 "supports" mutation events but hangs the system. Earlier versions do not
		 * support MutationObservers. Modernizr doesn't catch the lack of DOMSubtreeModified
		 * yet. This could probably be done using browser sniffing, but that has some very
		 * serious shortcomings in itself.
		 */
		this.config.hasMutationEvents = false; // ("MutationEvent" in window);
		
		if (this.config.hasMutationEvents) this.place.on('DOMSubtreeModified.' + this.config.id, __actOnDOMChange);
		else this.config.domCheckerInterval = setInterval(function() { __actOnDOMChange({ target: self.place[0] }); }, 333);
		
		setInterval(function(ev) {
			if (self.place.parents('html').length === 0) {
				//console.log('Autodestroy kicks in.');
				self.destroy();
			}
		}, 1000);
		
		// On initialize,  highlight all existing code blocks.
		this.codeHighlight($('pre code:not(.codeHighlight)'));
		if (this.config.debug === true) console.log('intialized a code highligher element')
		if (typeof(callback) == 'function') callback({type: 'initDone', active: this.config.active});
	}
}

CodeHighlight.prototype.destroy = function(callback) {
	if (this.config.debug === true) console.log('CodeHiglight.destroy()', place, config, callback);
	
	if (this.config.active === true) {
		this.place.off('DOMSubtreeModified.' + this.config.id);
		this.place.off('propertychange.' + this.config.id);
		this.config.active = false;
		var head = place.parents('html').find('head');
		var meta = head.find('meta[data-code-highlight]');
		meta.attr('data-code-highlight', 'off');
		//meta.remove();
		if (this.config.domCheckerInterval >= 0) clearInterval(this.config.domCheckerInterval);
		
		if (typeof(callback) == 'function') callback({type: 'destroyDone'});
	}
	else if (typeof(callback) == 'function') callback({type: 'destroyDone'});
}

/**
 * Highlights the blocks (jQuery DOM elements) that are given as parameters.
 * 
 * @param codeBlocks	jQuery DOM elements with code in them.
 */
CodeHighlight.prototype.codeHighlight = function(codeBlocks) {
	if (this.config.debug === true) console.log('CodeHiglight.codeHighlight()', codeBlocks);
	if (codeBlocks.length > 0) {
		codeBlocks.each(function(i, block) {
			hljs.highlightBlock(block);
		});
		codeBlocks.addClass('codeHighlight');
	}
}