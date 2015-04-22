package edu.vserver.exercises.math.essentials.generator;

interface Operatable extends EquationElement{

	public Term operate(Term term1, Term term2);
}
