package edu.vserver.mathgenerator;

public enum BoundingType {
	BOTH("EXPRESSION_GENERATOR_BOTH"), 
	SOLUTION("EXPRESSION_GENEARTOR_SOLUTION"),
	TERMS("EXPRESSION_GENERATOR_TERMS"),
	MANUAL("EXPRESSION_GENERATOR_MANUAL");

	private String localizerString;

	private BoundingType(String name) {
		this.localizerString = name;
	}

	public String getLocalizerString() {
		return localizerString;
	}
}