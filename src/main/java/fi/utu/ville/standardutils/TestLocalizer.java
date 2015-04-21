package fi.utu.ville.standardutils;

import java.util.Locale;
import java.util.Map;

/**
 * A minimal (and non-functional) implementation of {@link Localizer} that can
 * be used in testing components that in real use cases would receive a "real"
 * {@link Localizer} through constructor etc..
 * 
 * @author Riku Haavisto
 * 
 */
public class TestLocalizer implements Localizer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7957438714198114555L;

	@Override
	public String getUIText(String key) {
		return key;
	}

	@Override
	public String getUIText(String key, String... params) {
		return key;
	}

	@Override
	public Locale getCurrentLocale() {
		return Locale.ENGLISH;
	}

	@Override
	public String getUIText(String key, Map<String, String> params) {
		return key;
	}

	@Override
	public String getLocalizedNumber(double number) {
		return number+"";
	}

	@Override
	public char getDecimalSeparator() {
		return '.';
	}

	@Override
	public String getDateFormat() {
		return "MM/DD/YYYY";
	}

}
