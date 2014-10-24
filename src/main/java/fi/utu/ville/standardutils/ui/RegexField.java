package fi.utu.ville.standardutils.ui;


public class RegexField extends CleanTextField implements RegexFieldProvider {

	private static final long serialVersionUID = -4809165513564827832L;
	RegexFieldExtender extender;
	
	public RegexField(String caption, String regexPattern) {
		this.extender = new RegexFieldExtender(this, regexPattern);
		this.setCaption(caption);
		this.setImmediate(true);
	}

	@Override
	public RegexFieldExtender getRegexFieldExtender() {
		return extender;
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
