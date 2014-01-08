package edu.vserver.standardutils.ui;

import com.vaadin.server.Page;
import com.vaadin.server.Page.Styles;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Component;

public class DynamicStyles {

	public static DynamicStylesEditor newStylesEditor() {
		DynamicStylesFactory factory = VaadinSession.getCurrent().getAttribute(
				DynamicStylesFactory.class);
		if (factory == null) {
			throw new IllegalStateException(
					"StyleSettingsDialogFactory not found!");
		} else {
			return factory.newDynStyles();
		}
	}

	public static StyleSettings newStylesFromJson(String json) {
		StyleSettings res = newStyleSettings();
		res.fromJson(json);
		return res;
	}

	public static StyleSettings newStyleSettings() {
		DynamicStylesFactory factory = VaadinSession.getCurrent().getAttribute(
				DynamicStylesFactory.class);
		if (factory == null) {
			throw new IllegalStateException(
					"StyleSettingsDialogFactory not found!");
		} else {
			return factory.newStyleSettings();
		}
	}

	public static void registerDynamicStylesFactory(
			DynamicStylesFactory toRegister) {
		// there are other methods to do this, but
		// some methods with handling static singletons etc.
		// might cause odd behaviour in environments such as Tomcat
		// saving to session-state should be safe
		// There is no guarantee that this method is or will be used
		// on live-ville; always use the static getter methods for accessing
		// this
		VaadinSession.getCurrent().setAttribute(DynamicStylesFactory.class,
				toRegister);
	}

	public static void applyStyles(String className, StyleSettings toApply) {
		Styles currStyles = Page.getCurrent().getStyles();

		currStyles.add("." + className + " {" + toApply.getAsCss() + "}");

	}

	public interface DynamicStylesFactory {
		DynamicStylesEditor newDynStyles();

		StyleSettings newStyleSettings();
	}

	public interface DynamicStylesEditor {

		Component getStylesEditor();

		void loadStyles(StyleSettings toLoad);

		StyleSettings getCurrStyles();

	}

	public interface StyleSettings {

		public enum BorderStyle {
			SOLID("solid"), DOTTED("dotted"), NONE("none");

			private final String style;

			private BorderStyle(String style) {
				this.style = style;
			}

			public String getStyle() {
				return style;
			}

			public static BorderStyle getFromStyle(String styleStr) {
				if (styleStr.equals(BorderStyle.NONE.style)) {
					return BorderStyle.NONE;
				} else if (styleStr.equals(BorderStyle.DOTTED.style)) {
					return BorderStyle.DOTTED;
				} else if (styleStr.equals(BorderStyle.SOLID.style)) {
					return BorderStyle.SOLID;
				} else {
					throw new IllegalArgumentException(
							"Unknown border-style-str: " + styleStr);
				}
			}
		}

		/**
		 * Sets the border property of this style
		 * 
		 * @param style
		 *            the style of the border
		 * @param width
		 *            the width of the border in pixels
		 * @param borderColor
		 *            the color of the border in CSS compatible hexadecimal
		 *            representation, starting with #
		 * @param roundedAmount
		 *            the amount of rounding applied in pixels. Note, that this
		 *            may not work in all browsers.
		 */
		void setBorder(BorderStyle style, int width, String borderColor,
				int roundedAmount);

		/**
		 * Sets the color properties of this style. Colors are given in CSS
		 * compatible hexadecimal representation, starting with #
		 * 
		 * @param foregroundColor
		 *            the text color
		 * @param backgroundColor
		 *            the background color or "transparent"
		 */
		void setColors(String foregroundColor, String backgroundColor);

		/**
		 * Sets all margins in symmetric form.
		 * 
		 * @param marginInPixels
		 *            margin in pixels
		 */
		void setMargin(int marginInPixels);

		/**
		 * Sets the padding property in symmetric form.
		 * 
		 * @param paddingInPixels
		 *            padding in pixels
		 */
		void setPadding(int paddingInPixels);

		/**
		 * Sets the margin individually for all sides.
		 * 
		 * @param top
		 *            top margin in pixels
		 * @param right
		 *            right margin in pixels
		 * @param bottom
		 *            bottom margin in pixels
		 * @param left
		 *            left margin in pixels
		 */
		void setMargin(int top, int right, int bottom, int left);

		/**
		 * Sets the padding individually for all sides.
		 * 
		 * @param top
		 *            top padding in pixels
		 * @param right
		 *            right padding in pixels
		 * @param bottom
		 *            bottom padding in pixels
		 * @param left
		 *            left padding in pixels
		 */
		void setPadding(int top, int right, int bottom, int left);

		/**
		 * <p>
		 * Sets the font property for this style.
		 * <p>
		 * Note, that components other properties may override these settings.
		 * Typical example is using the rich text editor to enter label content.
		 * 
		 * @param fontFamily
		 *            font family; please prefer generic font names
		 * @param fontSize
		 *            size of the font with unit added (such as "21px", "105%"
		 *            or "1.5em")
		 * @param bolded
		 *            if true, font is displayed in bold
		 * @param italic
		 *            if true, font is displayed in bold.
		 */
		void setFont(String fontFamily, String fontSize, boolean bolded,
				boolean italic);

		String getBackgroundColor();

		void setBackgroundColor(String backgroundColor);

		String getForegroundColor();

		void setForegroundColor(String foregroundColor);

		String getBorderColor();

		int getBorderWidth();

		int getBorderRounded();

		BorderStyle getBorderStyle();

		String getFontFamily();

		String getFontSize();

		boolean isFontBolded();

		boolean isFontItalic();

		int[] getMargin();

		int[] getPadding();

		String toJson();

		void fromJson(String json);

		/**
		 * Returns these settings as a CSS string.
		 * 
		 * @return settings in CSS.
		 */
		String getAsCss();

	}

}
