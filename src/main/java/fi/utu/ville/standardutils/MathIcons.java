package fi.utu.ville.standardutils;

import com.vaadin.server.ThemeResource;

/**
 * Class for holding all icons in all views
 * 
 * @author ertaka
 * 
 */
public final class MathIcons {

	public static final int MATH_PREV = 309;

	public static final int MATH_NEXT = 310;

	public static final int MATH_CHECK = 311;

	public static final int STAR_NOT_SELECTED = 313;

	public static final int STAR_EASY = 314;

	public static final int STAR_NORMAL = 315;

	public static final int STAR_HARD = 316;

	// public static final int MATH_POLYNOMIAL_SMALL = 317;
	//
	// public static final int MATH_POLYNOMIAL_MEDIUM = 318;
	//
	// public static final int MATH_POLYNOMIAL_LARGE = 319;
	//
	// public static final int MATH_GENERAL_SMALL = 320;
	//
	// public static final int MATH_GENERAL_MEDIUM = 321;
	//
	// public static final int MATH_GENERAL_LARGE = 322;
	//
	// public static final int MATH_DERIVATION_SMALL = 323;
	//
	// public static final int MATH_DERIVATION_MEDIUM = 324;
	//
	// public static final int MATH_DERIVATION_LARGE = 325;
	//
	// public static final int MATH_INEQUALITY_SMALL = 326;
	//
	// public static final int MATH_INEQUALITY_MEDIUM = 327;
	//
	// public static final int MATH_INEQUALITY_LARGE = 328;
	//
	// public static final int MATH_ELEMENTARY_EXER_SMALL = 329;
	//
	// public static final int MATH_ELEMENTARY_EXER_MEDIUM = 330;
	//
	// public static final int MATH_ELEMENTARY_EXER_LARGE = 331;

	private MathIcons() {

	}

	public static ThemeResource getIcon(int iconId) {

		switch (iconId) {

		case MATH_PREV:
			return getIcon("navigation-left-frame.png");
		case MATH_NEXT:
			return getIcon("navigation-right-frame.png");
		case MATH_CHECK:
			return getIcon("mathcheckicon.png");
		case STAR_NOT_SELECTED:
			return getIcon("oxygen-star-24.png");
		case STAR_EASY:
			return getIcon("star-gold-one.png");
		case STAR_NORMAL:
			return getIcon("star-gold-two.png");
		case STAR_HARD:
			return getIcon("star-gold-three.png");
			// case MATH_POLYNOMIAL_SMALL:
			// return getIcon("polynomial_icon_16.png");
			// case MATH_POLYNOMIAL_MEDIUM:
			// return getIcon("polynomial_icon_32.png");
			// case MATH_POLYNOMIAL_LARGE:
			// return getIcon("polynomial_icon_96.png");
			// case MATH_GENERAL_SMALL:
			// return getIcon("mathexercises_16.png");
			// case MATH_GENERAL_MEDIUM:
			// return getIcon("mathexercises_32.png");
			// case MATH_GENERAL_LARGE:
			// return getIcon("mathexercises_96.png");
			// case MATH_DERIVATION_SMALL:
			// return getIcon("derivation_icon_16.png");
			// case MATH_DERIVATION_MEDIUM:
			// return getIcon("derivation_icon_32.png");
			// case MATH_DERIVATION_LARGE:
			// return getIcon("derivation_icon_96.png");
			// case MATH_INEQUALITY_SMALL:
			// return getIcon("inequality_icon_16.png");
			// case MATH_INEQUALITY_MEDIUM:
			// return getIcon("inequality_icon_32.png");
			// case MATH_INEQUALITY_LARGE:
			// return getIcon("inequality_icon_96.png");
			// case MATH_ELEMENTARY_EXER_SMALL:
			// return getIcon("math_exer16.png");
			// case MATH_ELEMENTARY_EXER_MEDIUM:
			// return getIcon("math_exer32.png");
			// case MATH_ELEMENTARY_EXER_LARGE:
			// return getIcon("math_exer128.png");
		default:
			throw new IllegalArgumentException("No such math-icon: id= "
					+ iconId);
		}

	}

	private static ThemeResource getIcon(String icon) {
		return new ThemeResource("../ville-standardutils/icons/math/" + icon);
	}

}
