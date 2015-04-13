package fi.utu.ville.standardutils.ui;

import com.vaadin.ui.TextArea;

public class RegexAreaExtender {
	String pattern;
	RegexAreaExtension extension;
	TextArea field;
	
	public RegexAreaExtender(TextArea field, String pattern) {
		this.pattern = pattern;
		this.field = field;
		extension = RegexAreaExtension.extend(field, pattern);
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