package fi.utu.ville.standardutils.ui;

import com.vaadin.ui.TextField;

import fi.utu.ville.standardutils.ui.RegexFieldExtension;

public class RegexFieldExtender {
	String pattern;
	RegexFieldExtension extension;
	TextField field;
	
	public RegexFieldExtender(TextField field, String pattern) {
		this.pattern = pattern;
		this.field = field;
		extension = RegexFieldExtension.extend(field, pattern);
	}
	
	public void setPattern(String pattern) {
		this.pattern = pattern;
		this.extension.getState().setPattern(pattern);
	}
	
	public String getPattern() {
		return pattern;
	}
	
	// Validates this field on the server side.
	public boolean isValid() {
		return field.getValue().matches(pattern);
	}
	
	public boolean isValid(String str) {
		return str.matches(pattern);
	}
}