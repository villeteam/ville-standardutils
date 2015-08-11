package fi.utu.ville.standardutils.client;

import com.vaadin.shared.AbstractComponentState;

public class RegexFieldExtensionState extends AbstractComponentState {

	private static final long serialVersionUID = -4506168043573400970L;

	private String pattern;
	private boolean arrowStepper;
	public String getPattern() {
		return pattern;
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}
	
	public void setArrowStepper(boolean enabled) {
		this.arrowStepper = enabled;
	}
	
	public boolean isArrowStepper() {
		return arrowStepper;
	}
}
