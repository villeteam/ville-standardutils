package edu.vserver.exercises.math.essentials.generator;

public interface Operatable extends EquationElement{

	public Term operate(Term term1, Term term2);
}
