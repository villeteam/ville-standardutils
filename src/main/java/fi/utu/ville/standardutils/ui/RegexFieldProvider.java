package fi.utu.ville.standardutils.ui;

interface RegexFieldProvider {
	
	/**
	 * Returns the RegexFieldExtender used.
	 * @return RegexFieldExtender
	 */
	public RegexFieldExtender getRegexFieldExtender();
	
	/**
	 *  Provides server-side validation for this field. 
	 *  Implementations can simply delegate the call to RegexFieldExtender.
	 **/
	public boolean isValid();
}
