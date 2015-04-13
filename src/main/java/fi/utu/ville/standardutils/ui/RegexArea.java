package fi.utu.ville.standardutils.ui;


public class RegexArea extends CleanTextArea {

	private static final long serialVersionUID = -4809165513564827832L;
	RegexAreaExtender extender;
	
	public RegexArea(String caption, String regexPattern) {
		this.extender = new RegexAreaExtender(this, regexPattern);
		this.setCaption(caption);
		this.setImmediate(true);
	}

	public void setPattern(String pattern) {
		extender.setPattern(pattern);
	}
	
	public String getPattern() {
		return extender.getPattern();
	}
	
	@Override
	public boolean isValid() {
		return extender.isValid() && super.isValid();
	}
}
