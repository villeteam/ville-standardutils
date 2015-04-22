package edu.vserver.exercises.math.essentials.generator;

import java.io.Serializable;

interface EquationElement extends Serializable {

	/**
	 * A String representation of this element.
	 * @return the string representation of this element
	 */
	String getSymbol();
	
	/**
	 * The priority for this element. Used to determine parenthesis in the infix expression.
	 * @return the priority for htis element
	 */
	int getPriority();
}
