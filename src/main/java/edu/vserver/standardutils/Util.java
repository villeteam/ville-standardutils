package edu.vserver.standardutils;

import java.io.File;

import com.vaadin.shared.ui.colorpicker.Color;

public class Util {

	/**
	 * <p>
	 * Returns a css compatible hexadecimal representation of the given Color
	 * object.
	 * <p>
	 * For example, for Color.WHITE, the method would return
	 * <code>#ffffff</code>
	 * 
	 * @param c
	 *            the color to be coded
	 * @return css representation of the given color
	 */
	public static String colorToHexString(Color c) {
		return "#" + Integer.toHexString(c.getRGB() & 0x00ffffff);
	}

	/**
	 * <p>
	 * Returns a css compatible hexadecimal representation of the given Color
	 * object.
	 * <p>
	 * For example, for Color.WHITE, the method would return
	 * <code>#ffffff</code>
	 * 
	 * @param c
	 *            the color to be coded
	 * @return css representation of the given color
	 */
	public static Color colorFromHexString(String c) {

		// remove-the possible #
		if (c.startsWith("#")) {
			c = c.substring(1);
		}

		// has to know that the string represents a hex value
		// for correct parsing (and no errors)
		int hexValue = Integer.parseInt(c, 16);

		// this constructor should know how to decode the hex-string
		return new Color(hexValue);
	}

	/**
	 * 
	 * @param fileName
	 *            String from which to parse extension
	 * @return whats behind last '.' or "" if there is no '.' in fileName
	 */
	public static String getExtension(String fileName) {
		String res = "";
		String[] parts = fileName.split("\\.");
		if (parts.length > 1) {
			// just return the last part
			res = parts[parts.length - 1];
		}
		// no extension
		else {
			res = "";
		}
		return res;
	}

	public static File getNonConflictingFile(String folder, String baseName) {

		File res = new File(folder + File.separator + baseName);
		int extra = 1;
		String ext = null;
		// most of the times the loop is executed 0 times
		while (res.exists()) {
			if (ext == null) {
				int extInd = baseName.lastIndexOf('.');
				if (extInd > 0) {
					ext = baseName.substring(extInd);
					baseName = baseName.substring(0, extInd);
				} else {
					// mark the extension search as done in any case
					ext = "";
				}
			}
			res = new File(folder + File.separator + baseName + "(" + extra
					+ ")" + ext);
			extra++;
		}

		return res;
	}

}
