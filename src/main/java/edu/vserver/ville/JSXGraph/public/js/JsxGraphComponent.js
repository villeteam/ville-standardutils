function JsxGraphComponent(place, config) {
	
	this.place = undefined;
	this.board = undefined;
	this.items = [];
	this.funcs = [];
	
	this.config = {
		boundingBox: {
			x1: -10,
			y1:  10,
			x2:  10,
			y2: -10
		},
		width: 250,
		height: 250,
		axis: true
	};
	
	this.initialize(place, config);
}

JsxGraphComponent.prototype.initialize = function(place, config) {
	this.place = place;
	for (var item in config) this.config[item] = config[item];
	
	var boardCount = $('.jsxboard').length;
	this.boardID = 'board-' + boardCount;
	
	// Fill the element with the board.
	this.place
		.empty()
		.addClass('jsxboard background-color-white')
		.css('width', this.config.width)
		.css('height', this.config.height)
		.attr('id', this.boardID);
	
	this.board = JXG.JSXGraph.initBoard(
		this.boardID,
		{
			originX: 0,
			originY: 0,
			unitX: 20,
			unitY: 20,
			axis: this.config.axis,
			showCopyright: false
		}
	);
	
	this.board.setBoundingBox(
		[
		 	this.config.boundingBox.x1,
		 	this.config.boundingBox.y1,
		 	this.config.boundingBox.x2,
		 	this.config.boundingBox.y2
		],
		true
	);
	
	this.place.find('svg')
		.css('width', this.config.width + 'px')
		.css('height', this.config.height + 'px');
	
	this.board.needsFullUpdate = true;
	this.board.update();
}

JsxGraphComponent.prototype.setWidth = function(wid) {
	this.place.width(wid);
	
	this.board.setBoundingBox(
		[
		 	this.config.boundingBox.x1,
		 	this.config.boundingBox.y1,
		 	this.config.boundingBox.x2,
		 	this.config.boundingBox.y2
		],
		true
	);
	
	this.place.css('width', wid + 'px');
	this.place.find('svg').css('width', wid + 'px');
	
	this.board.needsFullUpdate = true;
	this.board.update();
}

JsxGraphComponent.prototype.setBoundingBox = function(x1, y1, x2, y2) {
	
	this.config.boundingBox.x1 = x1;
 	this.config.boundingBox.y1 = y1;
 	this.config.boundingBox.x2 = x2;
 	this.config.boundingBox.y2 = y2;
	
	this.board.setBoundingBox(
		[
		 	this.config.boundingBox.x1,
		 	this.config.boundingBox.y1,
		 	this.config.boundingBox.x2,
		 	this.config.boundingBox.y2
		],
		true
	);
	
	this.board.needsFullUpdate = true;
	this.board.update();
}

JsxGraphComponent.prototype.setHeight = function(hei) {
	this.place.height(hei);
	
	this.board.setBoundingBox(
		[
		 	this.config.boundingBox.x1,
		 	this.config.boundingBox.y1,
		 	this.config.boundingBox.x2,
		 	this.config.boundingBox.y2
		],
		true
	);
	
	this.place.css('height', hei + 'px');
	this.place.find('svg').css('height', hei + 'px');
	
	this.board.needsFullUpdate = true;
	this.board.update();
}

JsxGraphComponent.prototype.stringToAnything = function(item) {
	if (typeof(this.items[item]) !== undefined) return this.items[item]; // The item is an ID. Return the corresponding item.
	/* else */ if (!isNaN(Number(item))) return Number(item); // The item is a number, return the number.
	/* else */
	try {
		// TODO check that item is constructed only of non-risky pieces.
		var func = new Function("x", 'return ' + item);
		func(Math.random());
		return func;
	}
	catch (e) {
		return item;
	};
}

JsxGraphComponent.prototype.getIdFromJsxId = function(jsxId) {
	for (var id in this.items) if (this.items[id].id === jsxId) return id;
	return null;
}

JsxGraphComponent.prototype.getSendable = function(id) {
	
	var item = this.items[id];
	switch(item.getType()) {
		case "curve": {
			return {
				type: "functiongraph",
				func: this.funcs[id] + "" // As a string.
			}
		}; break;
		case "glider": { // Glider
			return {
				type: "glider",
				id: id,
				name: item.getName(),
				x: item.X(),
				y: item.Y(),
			};
		}; break;
		case "line": { // Line
			return {
				type: "line",
				id: id,
				name: item.getName(),
				length: item.L(),
				rise: item.getRise(),
				slope: item.getSlope(),
				angle: item.getAngle(),
				p1: this.getIdFromJsxId(item.point1.id),
				p2: this.getIdFromJsxId(item.point2.id)
			};
		}; break;
		case "point": { // Point
			return {
				type: "point",
				id: id,
				name: item.getName(),
				x: item.X(),
				y: item.Y(),
			};
		}; break;
		default: return JSON.parse(JSON.stringify(this.items[id]));
	}
}

JsxGraphComponent.prototype.get = function(itemID, callerID) {
	
	// TODO expand to return different objects.
	
	if (typeof(this.config['callback']) === 'function') {
		var result = {
			type: 'item',
			callerID: callerID,
			itemID: itemID,
			item: this.getSendable(itemID) 
		};
		
		this.config.callback(result);
		return result; 
	}
	else throw("Callback has not been defined.");
}

JsxGraphComponent.prototype.add = function(type, id, params, styling) {
	styling = typeof(styling) === 'string' ? JSON.parse(styling) : styling;
	var processed = [];
	var finalType = type;
	var self = this;
	
	switch (type) {
	
		/*
		 * 2D parametric curves
		 */
		case 'parametricCurve': {
			finalType = 'curve';
			processed[0] = new Function("t", "return " + params[0]); // x(t)
			processed[1] = new Function("t", "return " + params[1]); // y(t)
			processed[2] = parseFloat(params[2]); // t min value
			processed[3] = parseFloat(params[3]); // t max value
		}; break;
	
		/*
		 * Point is always defined by two floating point numbers.
		 */
		case 'point': {
			processed[0] = parseFloat(params[0]);
			processed[1] = parseFloat(params[1]);
		}; break;
		
		/*
		 * Circle can be defined either by a point and radius or by
		 * two points. 
		 */
		case 'circle': {
			if (params.length === 3) processed = params;
			else {
				processed[0] = this.items[params[0]];
				processed[1] = typeof(this.items[params[1]]) === 'undefined' ? parseFloat(params[1]) : this.items[params[0]];
			}
		}; break;
		
		/*
		 * Line is defined by two of its (end)points.
		 */
		case 'line': {
			processed[0] = this.items[params[0]];
			processed[1] = this.items[params[1]];
		}; break;
		
		/*
		 * Glider is defined either by a parent object or by a location
		 * and a parent object. 
		 */
		case 'glider': {
			if ( typeof(this.items[params[0]]) === 'undefined' ) {
				processed[0] = parseFloat(params[0]);
				processed[1] = parseFloat(params[1]);
				processed[2] = this.items[params[2]];
			}
			else {
				processed[0] = this.items[params[0]];
			}
		}; break;
	
		/*
		 * Function is defined by a clause / rhs. 
		 */
		case 'functiongraph': {
			
			processed[0] = typeof(params[0]) === 'function' ?
				params[0] :
				new Function("x", "return " + params[0]);
			this.funcs[id] = processed[0];
		}; break;
		
		/*
		 * Derivative is defined by a function. 
		 */
		case 'derivative': {
			
			finalType = 'functiongraph';
			var func = typeof(params[0]) === 'function' ?
				params[0] :
				new Function("x", "return " + params[0]);
			processed[0] = JXG.Math.Numerics.D(func);
			this.funcs[id] = processed[0];
		}; break;
	}
	
	//console.log(type, processed);
	
	this.items[id] = this.board.create(finalType, processed, styling);
	/* Can't think of any use case for callback here. Omitting.
	if (typeof(this.config['callback']) === 'function') this.config.callback(
		{
			type: 'add',
			itemType: finalType,
			id: id,
			data: this.items[id]
		}
	);
	*/
	
}
