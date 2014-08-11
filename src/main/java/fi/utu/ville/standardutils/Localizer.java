package fi.utu.ville.standardutils;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Locale;
import java.util.Map;

/**
 * <p>
 * Implementors of this class provide localization to the current session.
 * </p>
 * <p>
 * To use the {@link #getUIText(String)} you must define a ViLLE-specific
 * language file (.trl) and add it to the used language-files directory.
 * </p>
 * <p>
 * When using stub-ViLLE the language file directory is defined in the class
 * implementing {@link AbstractExerStubUI} and used as (main)-UI for the vaadin
 * session. The language file directory is in "ville-stub-base"/lang .
 * </p>
 * <p>
 * ViLLE-language file-format (eg. example.trl):
 * 
 * <pre>
 * // for comment (must start line)
 * &#64;key:KEY_CONSTANT
 * &#64;en:english translation
 * &#64;fi:finnish translation
 * 
 * etc...
 * 
 * &#64;key:another key constant
 * 
 * etc...
 * </pre>
 * 
 * Empty lines are allowed and will be ignored. Any constant or translation can
 * span multiple lines; explicit line breaks \n etc must be added explicitly.
 * Every comment line must start with "//"; this is the only supported
 * comment-syntax. The defined translation tags must be of format &#64;'some
 * valid ISO Language Code'. (see {@link Locale})
 * </p>
 * <p>
 * The file name of a .trl-file will be added implicitly in upper-case to all
 * keys defined in a file to avoid conflicts between keys defined in different
 * loaded .trl-files. To get a translation defined in the aforementioned file
 * you can call {@link #getUIText(String)} with eg. "EXAMPLE.KEY_CONSTANT" or
 * "EXAMPLE.another key constant".
 * </p>
 * <p>
 * It is possible to reference the translations directly with Strings eg.
 * "EXAMPLE.KEY_CONSTANT" but it is generally advisable to collect the keys to a
 * constants file to avoid typos and to allow automatic testing.
 * </p>
 * <p>
 * The translations can also contain parameters. (For more info see
 * {@link #getUIText(String, String...) getUIText(key, params...)}.) Example:
 * 
 * <pre>
 * &#64;key:KEY_WITH_PARAMS
 * &#64;en:&#64;0 is equal to &#64;0 but not necessarily to &#64;1
 * 
 * getUIText("EXAMPLE.KEY_WITH_PARAMS", "" + 1, "" + 3)
 * would return:
 * 1 is equal to 1 but not necessarily to 3
 * </pre>
 * 
 * </p>
 * 
 * @author Riku Haavisto, Johannes Holvitie
 * 
 */
public interface Localizer extends Serializable {

	/**
	 * <p>
	 * Return a chunk of UI text, usually a single caption or a label, in
	 * currently selected language.
	 * </p>
	 * <p>
	 * If translation in current language (as defined by
	 * {@link #getCurrentLocale()}'s {@link Locale #getLanguage() getLanguage()}
	 * ) is not found translation in {@link Locale #ENGLISH} is returned. If
	 * translation in {@link Locale #ENGLISH} is not found the key-parameter is
	 * returned as such.
	 * </p>
	 * 
	 * @param key
	 *            the key of the UI text to be returned
	 * @return the UI text for given key.
	 */
	String getUIText(String key);

	/**
	 * <p>
	 * Return a chunk of UI text, usually a single caption or a label, in
	 * currently selected language..<br>
	 * The parameters given are inserted into UI text, replacing all the
	 * <code>@0...@n</code> tags, where <code>n</code> is the index of last
	 * parameter.
	 * </p>
	 * <p>
	 * If translation in current language is not found to situation is handled
	 * similarly as in {@link #getUIText(String)}. If the returned translation
	 * does not contain the needed <code>@i</code>-tags no error is raised but
	 * the i'th param is simply ignored.
	 * </p>
	 * 
	 * @param key
	 *            the key of the UI text to be returned
	 * @param params
	 *            the parameters inserted in this UI text in correct order.
	 * @return the UI text for given key with parameters inserted.
	 */
	String getUIText(String key, String... params);

	/**
	 * <p>
	 * Return a chunk of UI text, usually a single caption or a label, in
	 * currently selected language..<br>
	 * The parameters given are inserted into UI text, replacing all the
	 * <code>@{param-name}</code> tags, where <code>param-name</code> is the key
	 * of certain value in the provided params-map.
	 * </p>
	 * <p>
	 * If translation in current language is not found the situation is handled
	 * similarly as in {@link #getUIText(String)}. If the returned translation
	 * does not contain the needed <code>@{param-name}</code>-tags no error is
	 * raised but the parameter is not substituted. The same is true when the
	 * provided params-map does not contain value for certain parameter found in
	 * the translation template.
	 * </p>
	 * 
	 * @param key
	 *            the key of the UI text to be returned
	 * @param params
	 *            the map of param-name to substition value to use
	 * @return the UI text for given key with parameters inserted.
	 */
	String getUIText(String key, Map<String, String> params);

	/**
	 * <p>
	 * Locale used in the current user session can be used for localization of
	 * for example dates (eg. {@link DateFormat #getDateInstance(int, Locale)}.
	 * </p>
	 * <p>
	 * The {@link #getUIText(String)} and related mechanisms should be used for
	 * UI-text translations.
	 * </p>
	 * 
	 * @return the locale used in the current user session
	 */
	Locale getCurrentLocale();

	/**
	 * Localizes the number based on user preferences. Localizing is done by changing the decimal separator.  
	 * @param number The number to localize.
	 * @return The localized number. 
	 */
	public String getLocalizedNumber(double number);

	/**
	 * Returns the decimal separator set in the user preferences.
	 * @return The appropriate decimal separator for the user.
	 */
	public char getDecimalSeparator();
}
