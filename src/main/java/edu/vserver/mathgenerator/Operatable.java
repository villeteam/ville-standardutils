package edu.vserver.mathgenerator;

interface Operatable extends EquationElement{

	public Term operate(Term term1, Term term2);
}
