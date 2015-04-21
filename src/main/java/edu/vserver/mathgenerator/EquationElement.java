package edu.vserver.mathgenerator;

import java.io.Serializable;

interface EquationElement extends Serializable {

	/**
	 * A String representation of this element.
	 * @return
	 */
	String getSymbol();
	
	/**
	 * The priority for this element. Used to determine parenthesis in the infix expression.
	 * @return
	 */
	int getPriority();
}
