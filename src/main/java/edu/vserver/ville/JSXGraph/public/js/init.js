edu_vserver_ville_JSXGraph_JSXGraphComponent = function() {
	var slice = Array.prototype.slice;
	var self = this;
	
	var config = this.getState().config;
	
	config.callback = function() {
		//console.log("init: config.callback()");
		self.sendResults(slice.apply(arguments)); 
	}; 
	
	var place = $(this.getElement());
	
	//TODO change back to local once done with debugging.
	var component = new JsxGraphComponent(place, config);
	
	{ // Shared functions.
	
		this.suspendUpdate = function() { component.suspendUpdate(); };
		
		this.unSuspendUpdate = function() { component.unSuspendUpdate(); };
		
		this.setWidth = function(wid) { component.setWidth(wid); };
		
		this.setHeight = function(hei) { component.setHeight(hei); };
		
		this.add = function(type, id, params, styling) { component.add(type, id, params, styling); }
		
		this.get = function(itemID, callerID) {
			component.get(itemID, callerID);
		}
		
		this.rem = function(id) {
			component.removeObject(id);
		}
		
		this.setBoundingBox = function(x1, y1, x2, y2) {
			component.setBoundingBox(x1, y1, x2, y2);
		}
	}
};

Rational = function(a, b) { return (a / b) };