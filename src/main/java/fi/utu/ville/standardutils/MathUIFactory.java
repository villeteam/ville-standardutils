package fi.utu.ville.standardutils;

import java.io.Serializable;

import com.vaadin.ui.Button;

/**
 * Class for generating UI components for layout.
 * 
 * @author ertaka
 * 
 */
public class MathUIFactory implements Serializable {

	private static final long serialVersionUID = 1606699009367781760L;

	protected MathUIFactory() {
		// As so far, only static methods,
		// so no instance needed.
	}

	public static Button getStarButton(String caption, Localizer localizer) {
		Button btn = new Button();
		btn.setHeight("90px");
		btn.setWidth("90px");
		btn.addStyleName("borderless icon-on-top");
		btn.addStyleName("star-button");
		btn.setCaption(caption);
		btn.setIcon(MathIcons.getIcon(MathIcons.STAR_NOT_SELECTED));
		btn.setDescription(caption);
		return btn;
	}

	public static Button getMathPrevButton(Localizer localizer) {
		Button btn = new Button(localizer.getUIText(MathUIConstants.MATH_PREV));
		btn.setHeight("90px");
		btn.addStyleName("borderless icon-on-top");
		btn.addStyleName("math-prev-button");
		btn.setCaption(localizer.getUIText(MathUIConstants.MATH_PREV));
		btn.setIcon(MathIcons.getIcon(MathIcons.MATH_PREV));
		btn.setDescription(localizer.getUIText(MathUIConstants.MATH_PREV));
		return btn;
	}

	public static Button getMathNextButton(Localizer localizer) {
		Button btn = new Button(localizer.getUIText(MathUIConstants.MATH_NEXT));
		btn.setHeight("90px");
		btn.addStyleName("borderless icon-on-top");
		btn.addStyleName("math-next-button");
		btn.setCaption(localizer.getUIText(MathUIConstants.MATH_NEXT));
		btn.setIcon(MathIcons.getIcon(MathIcons.MATH_NEXT));
		btn.setDescription(localizer.getUIText(MathUIConstants.MATH_NEXT));
		return btn;
	}

	public static Button getMathCheckButton(Localizer localizer) {
		Button btn = new Button(localizer.getUIText(MathUIConstants.MATH_CHECK));
		btn.setHeight("90px");
		btn.addStyleName("borderless icon-on-top");
		btn.addStyleName("math-check-button");

		btn.setCaption(localizer.getUIText(MathUIConstants.MATH_CHECK));
		btn.setIcon(MathIcons.getIcon(MathIcons.MATH_CHECK));
		btn.setDescription(localizer.getUIText(MathUIConstants.MATH_CHECK));
		return btn;
	}

}
