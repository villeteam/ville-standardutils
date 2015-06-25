package fi.utu.ville.standardutils;

public interface LocalizableEnum {

	public static final String UNLOCALIZED = "#########";
	public static final String HIDDEN = "########";
	
	/**
	 * Get the localizer string used to produce a translation from the translation files. 
	 * I.e. localizer.getText(getLocalizerString()); should produce a valid translation.
	 * @return A key found in the translation files or <br>
	 * the UNLOCALIZABLE constant for elements that are not supposed to be localized. or <br>
	 * the HIDDEN constant for elements that will not be shown in the localized enum.
	 */
	public String getLocalizerString();

}
