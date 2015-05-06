package fi.utu.ville.standardutils;

import java.io.Serializable;

/**
 * Class for constants that are used to retrieve correct content for ViLLE's UI. <br>
 * <br>
 * <strong>Note!</strong> Do NOT edit the string values in this class!<br>
 * <br>
 * The values of constants are used to retrieve correct text in correct language
 * using UILanguage class.<br>
 * If you wish to change a UI text, edit the file <code>English.lan</code> which
 * can be found in edu.vserver.resources.language package.
 * 
 * @author ertaka
 * 
 */
public class MathUIConstants implements Serializable {

	private static final long serialVersionUID = -4111712512819095369L;

	// private static final String PREFIX = "MATH.";
	private static final String PREFIX = "";

	/*
	 * ***
	 * 
	 * Type names and descriptions
	 * 
	 * ***
	 */

	public static final String MATH_AUDIO_ARITHMETIC_NAME = PREFIX
			+ "Math audio arithmetic";

	public static final String MATH_AUDIO_ARITHMETIC_DESC = PREFIX
			+ "Math audio arithmetic desc";

	public static final String MATH_POLYNOMIAL_NAME = PREFIX
			+ "Solving quadratic equations";

	public static final String MATH_POLYNOMIAL_DESC = PREFIX
			+ "The exercise type trains the usage of solution formula for the quadratic equations.";

	public static final String MATH_INEQUALITY_NAME = PREFIX
			+ "Inequality equations and sign charts";
	public static final String MATH_INEQUALITY_DESC = PREFIX
			+ "Inequality equations and sign charts desc";

	public static final String MATH_DERIVATION_NAME = PREFIX
			+ "Calculation rules for derivatives";

	public static final String MATH_DERIVATION_DESC = PREFIX
			+ "Training of different calculation rules for derivation, special emphasis on derivation of products, rational functions and composite functions, that can be dissected to smaller pieces.";

	public static final String MATH_MULTIPLY_NAME = PREFIX + "Multiplication";

	public static final String MATH_MULTIPLY_DESC = PREFIX
			+ "Practise multiplication against the clock. Multiplications with numbers between 0-12.";

	// MATH_CONTINUENL

	public static final String MATH_CONTINUENL_NAME = PREFIX
			+ "Fill the sequence";

	public static final String MATH_CONTINUENL_DESC = PREFIX
			+ "Fill in the wholes in sequence.";

	// MATH_FORMCALCULATION

	public static final String MATH_FORM_CALC_NAME = PREFIX + "What's missing?";

	public static final String MATH_FORM_CALC_DESC = PREFIX
			+ "Figure out what number is missing from calculation. Drag and drop the correct number or numbers to the answer area.";

	// MATH_BUILDNUMBER

	public static final String MATH_BUILD_NUMBER_NAME = PREFIX + "Build number";

	public static final String MATH_BUILD_NUMBER_DESC = PREFIX
			+ "Build asked number with the pieces provided.";

	// MATH_EQUALAMOUNT

	public static final String MATH_EQUAL_AMOUNT_NAME = PREFIX
			+ "Combine equal items";

	public static final String MATH_EQUAL_AMOUNT_DESC = PREFIX
			+ "Can you pick up equal items? Drag and drop them in to the answer area.";

	// MATH_WHATNUMBER

	public static final String MATH_WHAT_NUMBER_NAME = PREFIX
			+ "Recognize the number";

	public static final String MATH_WHAT_NUMBER_DESC = PREFIX
			+ "Recognize the number visualized by items, 10-base boxes, currency or some other form.";

	// MATH_DDNUMBERLINEEXER

	public static final String MATH_DDNUMBER_LINE_NAME = PREFIX
			+ "Drag and drop numbers to number line";

	public static final String MATH_DDNUMBER_LINE_DESC = PREFIX
			+ "Can you find the right places for the numbers on number line?";

	// MATH_NUMBERLINEEXER

	public static final String MATH_NUMBER_LINE_NAME = PREFIX + "Number line";

	public static final String MATH_NUMBER_LINE_DESC = PREFIX
			+ "What number is hiding between two given values?";

	// MATH_LONGDIVISION

	public static final String MATH_LONG_DIVISION_NAME = PREFIX
			+ "Long division";

	public static final String MATH_LONG_DIVISION_DESC = PREFIX
			+ "Practise long division.";

	// MATH_CALCROW

	public static final String MATH_CALCROW_NAME = PREFIX
			+ "Calculate in a row";

	public static final String MATH_CALCROW_DESC = PREFIX
			+ "Sum, subtract or multiply. It is easier in a row. You can also hide the values and try to figure out what is missing.";

	// MATH_CALCORDER
	public static final String MATH_CALCORDER_NAME = PREFIX
			+ "MATH_CALCORDER_NAME";

	public static final String MATH_CALCORDER_DESC = PREFIX
			+ "MATH_CALCORDER_DESC";

	// MATH_GEOMETRY

	public static final String MATH_GEOMETRY_NAME = PREFIX
			+ "MATH_GEOMETRY_NAME";

	public static final String MATH_GEOMETRY_DESC = PREFIX
			+ "MATH_GEOMETRY_DESC";

	// MATH_WHOLENUMBER

	public static final String MATH_WHOLENUMBER_NAME = PREFIX + "Calculate";

	public static final String MATH_WHOLENUMBER_DESC = PREFIX
			+ "Sum, subtraction and multiplication with natural numbers. If you are calculating with three terms, don't forget the correct calculation order.";

	// MATH_DECIMAL

	public static final String MATH_DECIMAL_NAME = PREFIX
			+ "Calculate decimals";

	public static final String MATH_DECIMAL_DESC = PREFIX
			+ "Select or write the answer of the calculation.";

	// MATH_CHART

	public static final String MATH_CHART_NAME = PREFIX + "Bar chart exercise";

	public static final String MATH_CHART_DESC = PREFIX
			+ "Read the values from bar chart and calculate decimal calculations. Can you figure out if it is a sum or subtraction?";

	// MATH_CALCFRACTIONS

	public static final String MATH_CALC_FRACS_NAME = PREFIX
			+ "Calculate fractions";

	public static final String MATH_CALC_FRACS_DESC = PREFIX
			+ "Sum, subtraction, multiplication and division of fractions.";

	// MATH_CONVERT_FRACTIONS

	public static final String MATH_CONVERT_FRACS_NAME = PREFIX
			+ "Convert fractions to decimals and decimals to fractions";

	public static final String MATH_CONVERT_FRACS_DESC = PREFIX
			+ "Convert decimals to fractions and other way around. Conversion can be made by selecting the correct decimal or by writing the correct answer.";

	public static final String MATH_CHART_NATURAL_NAME = PREFIX
			+ "Math chart natural";

	public static final String MATH_CHART_NATURAL_DESC = PREFIX
			+ "Math chart desc";

	public static final String MATH_FIRST_DEGREE_NAME = PREFIX
			+ "First degree equations";

	public static final String MATH_FIRST_DEGREE_DESC = PREFIX
			+ "First degree equations desc";

	/*
	 * ***
	 * 
	 * "In-type" constants
	 * 
	 * ***
	 */

	public static final String MATH_CHART = PREFIX + "Math chart";

	public static final String MATH_DECIMAL = PREFIX + "Math decimal";

	public static final String EXPLANATION_MATH_CHART = PREFIX
			+ "Explanation math chart";

	public static final String EXPLANATION_MATH_DECIMAL = PREFIX
			+ "Explanation math decimal";

	public static final String MATH_CONVERT_FRACTIONS = PREFIX
			+ "Math convert fractions";

	public static final String EXPLANATION_MATH_CONVERT_FRACTIONS = PREFIX
			+ "Explanation math convert fractions";

	public static final String MATH_PREV = PREFIX + "Previous math question";
	public static final String MATH_CHECK = PREFIX + "Check your answer";
	public static final String MATH_NEXT = PREFIX + "Next math question";

	/* Einari's localizations */
	public static final String MATH_EXER_CHART = PREFIX
			+ "Reading from chart and calculating";
	public static final String BUILD_NUMBER = PREFIX + "Construct a number";
	public static final String CALC_DECIMAL = PREFIX
			+ "Calculating with decimals";
	public static final String CALC_FRACTIONS = PREFIX
			+ "Calculating with fractions";
	public static final String CALC_ROW = PREFIX + "Calculating in a row";
	public static final String CALC_WHOLEN = PREFIX
			+ "Calculating with wholenumbers";
	public static final String CONVERT_FRACTIONS = PREFIX
			+ "Convert fractions and decimals";
	public static final String DDNUMBERLINE = PREFIX + "Sort numbers";
	public static final String MULTIPLY = PREFIX + "Practising multiplication";
	public static final String MATH_NUMBERLINE = PREFIX + "Numberline";
	public static final String WHATNUMBER = PREFIX + "What number is this?";

	public static final String USE_VISUALIZATION = PREFIX
			+ "Use visualization, recommended with small values.";
	public static final String CHOOSE_TO_ANSWER = PREFIX + "Answer by choosing";
	public static final String ONLY_DECIMALS = PREFIX
			+ "Only decimals (not 1 for example)";

	public static final String MATH_HEIGHTS = PREFIX + "Heights";
	public static final String MATH_SETTINGS = PREFIX + "Settings";
	public static final String MATH_MINVALUE = PREFIX + "Minimum";
	public static final String MATH_MAXVALUE = PREFIX + "Maximum";
	public static final String MATH_ANSWERMAX = PREFIX + "Max. answer";
	public static final String MATH_ANSWERMIN = PREFIX + "Min. answer";
	public static final String MATH_AMOUNT = PREFIX + "Amount of questions";
	public static final String MATH_NAMES = PREFIX + "Names";
	public static final String MATH_STORY = PREFIX
			+ "Once up on a time there was a forrest, where lived a lot of ants. On of the anthills were living ants called";
	public static final String MATH_CHART_ANSWER = PREFIX
			+ ". Answer questions using the bar chart.";
	public static final String MATH_WRITE_STORY = PREFIX + "Write story";
	public static final String SAME_DENOMINATOR = PREFIX + "Same denominator";
	public static final String SMALLER_THAN_ONE = PREFIX
			+ "Calculating with nubmers smaller than one";

	public static final String OPERATION_SUM = PREFIX + "Sum";
	public static final String OPERATION_SUBT = PREFIX + "Subtraction";
	public static final String OPERATION_DIV = PREFIX + "Division";

	public static final String VISUAL_OBJECTS = PREFIX + "Objects";
	public static final String VISUAL_MIX_COLOR = PREFIX
			+ "Mix the color of objects";
	public static final String VISUAL_BOXES = PREFIX + "10-base boxes";
	public static final String VISUAL_WRITTEN = PREFIX + "Written";
	public static final String VISUAL_NUMBER = PREFIX + "Number";
	public static final String VISUAL_FRACTION = PREFIX + "Fraction";
	public static final String VISUAL_MONEY = PREFIX + "Money";
	public static final String VISUAL_CHOOSE = PREFIX + "Choose visualization";

	public static final String ANSWER_CORRECT = PREFIX + "Correct!";
	public static final String ANSWER_WRONG = PREFIX
			+ "Just a little more precision";
	public static final String GIVEN_ANSWER = PREFIX + "Your answer";
	public static final String FEEDBACK_CORRECT = PREFIX + "Correct answer";
	public static final String MATH_TENTH = PREFIX + "Tenths";
	public static final String MATH_UNITS = PREFIX + "Units";
	public static final String MATH_TENS = PREFIX + "Tens";
	public static final String MATH_HUNDREDS = PREFIX + "Hundreds";
	public static final String MATH_U = PREFIX + "U";
	public static final String MATH_T = PREFIX + "T";
	public static final String MATH_H = PREFIX + "H";
	public static final String MATH_TH = PREFIX + "TH";
	public static final String MATH_TTH = PREFIX + "TTH";
	public static final String MATH_HTH = PREFIX + "HTH";

	public static final String MATH_THOUSANDS = PREFIX + "Thousands";
	public static final String MATH_TENTHOUSANDS = PREFIX + "Tens thousands";
	public static final String MATH_HUNDREDTHOUSANDS = PREFIX
			+ "Hundred thousands";
	public static final String MATH_MILLIONS = PREFIX + "Millions";
	public static final String END_OF_THE_UNIVERSE = PREFIX
			+ "Thou shall not divide by zero!";

	public static final String MATH_WRITE_EQ = PREFIX + "Write an equation";
	public static final String CHART_LONGER = PREFIX + "How much longer is";
	public static final String CHART_TOGETHER = PREFIX
			+ "How long are together";
	public static final String MATH_AND = PREFIX + "and";
	public static final String MATH_THAN = PREFIX + "than";
	public static final String MATH_LENGTH = PREFIX + "'s length";

	public static final String MEMORY_NUMBER = PREFIX + "Use memory numbers";
	public static final String MULTIPLIER_TWO = PREFIX
			+ "Use multiplier with two digits";
	public static final String MULTIPLIER_ONE = PREFIX
			+ "Use multiplier with one digit";

	public static final String MATH_HIDE = PREFIX
			+ "Fill in the holes, hide numbers";
	public static final String MATH_HIDE_TWO = PREFIX
			+ "Fill in the holes, hide two numbers";
	public static final String STEP_BY_STEP = PREFIX
			+ "Calculating step by step";
	public static final String MATH_THREE_TERMS = PREFIX + "Three terms";

	public static final String NL_MODIFY_MAX = PREFIX
			+ "Add/remove/multiply/divide number up to";
	public static final String NL_MODIFY_MIN = PREFIX
			+ "Add/remove/multiply/divide number at least";
	public static final String NL_LENGTH = PREFIX + "Length of the numberline";
	public static final String NL_HOLES = PREFIX + "Number of the holes";
	public static final String NL_MIX = PREFIX + "Mix the places of the holes";
	public static final String NL_CONTINUE = PREFIX + "Continue numberline";

	public static final String F2D = PREFIX + "Fraction to decimal";
	public static final String D2F = PREFIX + "Decimal to fraction";

	public static final String MATH_CHOSEN = PREFIX + "Selected";
	public static final String MATH_NMBR_SORT = PREFIX
			+ "Amount of numbers to be sorted";
	public static final String MATH_MAGNITUDE = PREFIX + "Magnitude";

	public static final String NUMBER_OF_BOXES = PREFIX + "Number of boxes";
	public static final String MATH_COMBINE = PREFIX
			+ "Combine equal items into the box below";

	public static final String MATH_NEED_ADD = PREFIX
			+ "What needs to be added into";
	public static final String MATH_FILL_IN_THE_HOLE = PREFIX
			+ "Fill in the hole using numbers below";
	public static final String MATH_TOGET = PREFIX + "to get number";

	public static final String MATH_TENPAIRS = PREFIX + "Practise ten-pairs";
	public static final String MATH_FILL_BLANKS = PREFIX + "Fill in the blanks";
	public static final String MATH_VISUALIZE_QUESTION = PREFIX
			+ "Visualize question";
	public static final String MATH_USE_DRAG_AND_DROP = PREFIX
			+ "Use drag and drop to answer";

	public static final String MATH_DIVIDER = PREFIX + "Divider";
	public static final String MATH_REMINDER = PREFIX + "Reminder";
	public static final String MATH_EVEN_DIV = PREFIX
			+ "Division turns out even";
	public static final String MATH_NMB_SUBT = PREFIX
			+ "Amount of subtractions";

	public static final String MATH_TIME = PREFIX + "Time (s)";
	public static final String MATH_CALC_CORR = PREFIX + "Calculations correct";
	public static final String MULTIPLY_CALC = PREFIX
			+ "Calculate multiplications";
	public static final String MULTIPLY_CORR = PREFIX
			+ "Well done! You managed to calculate all the multiplications. Press check.";
	public static final String MULTIPLY_WRONG = PREFIX
			+ "Let's practise some more. Submit and try again.";
	public static final String MULITPLY_CONTINUE = PREFIX
			+ "Well done! You can continue forward.";

	public static final String MULTIPLY_CALCULATION = PREFIX + "Calculation";
	public static final String MULTIPLY_ANSWER = PREFIX + "Answer";
	public static final String MULTIPLY_CHECK = PREFIX + "Check";
	public static final String MULTIPLY_YOUGOT = PREFIX + "You got";
	public static final String MULTIPLY_USED_TIME = PREFIX + "and used";

	public static final String MATH_SECONDS = PREFIX + "s";
	public static final String ANSWER_EMPTY = PREFIX + "Empty answer";
	public static final String MATH_GREATERTHAN = PREFIX
			+ "What number is greather than";
	public static final String MATH_SMALLERTHAN = PREFIX + "but smaller than";
	public static final String MATH_THRESHOLD = PREFIX
			+ "Threshold of the numbers asked";

	public static final String LEVEL_EASY = PREFIX + "Warm up";
	public static final String LEVEL_NORMAL = PREFIX + "Ok, I'm ready";
	public static final String LEVEL_HARD = PREFIX + "Is that all you got?";

	/* Quadratic equation exercise */
	public static final String EQUATION_GROUP_CAPTION = PREFIX + "Equation";
	public static final String EQUATION_HAS_TWO_REAL_ROOTS = PREFIX
			+ "Equation has two real roots.";
	public static final String EQUATION_HAS_ONE_REAL_ROOT = PREFIX
			+ "Equation has one real root.";
	public static final String EQUATION_HAS_NO_REAL_ROOTS = PREFIX
			+ "Equation has no real roots.";
	public static final String THE_ROOTS_ARE = PREFIX + "Roots are:";
	public static final String THE_ROOT_IS = PREFIX + "Root is:";
	public static final String QUADRATIC_EQUATION_MODEL_SOLUTION = PREFIX
			+ "Quadratic equation solution";
	public static final String QUADRATIC_EQUATION_MODEL_SOLUTION_EXTENSION1 = PREFIX
			+ "Quadratic equation solution appendix 1";
	public static final String QUADRATIC_EQUATION_MODEL_SOLUTION_EXTENSION2 = PREFIX
			+ "Quadratic equation solution appendix 2";
	public static final String HAS_TWO_REAL_ROOTS = PREFIX
			+ "has two real roots";
	public static final String HAS_ONE_REAL_ROOT = PREFIX + "has one real root";
	public static final String HAS_NO_REAL_ROOTS = PREFIX + "has no real roots";

	/* Quadratic equation editor */
	public static final String CAPTION_EQUATIONS_WITH_TWO_REAL_ROOTS = PREFIX
			+ "Equations with two real roots.";
	public static final String CAPTION_EQUATIONS_WITH_ONE_REAL_ROOT = PREFIX
			+ "Equations with one real root.";
	public static final String CAPTION_EQUATIONS_WITH_NO_REAL_ROOTS = PREFIX
			+ "Equations with no real roots.";
	public static final String CAPTION_EQUATIONS_WITH_TERMS_OF_ALL_DEGREES = PREFIX
			+ "Equations with terms of all degrees.";
	public static final String CAPTION_EQUATIONS_WITH_FIRST_DEGREE_TERM_MISSING = PREFIX
			+ "Equations with first degree term missing.";
	public static final String CAPTION_EQUATIONS_WITH_CONSTANT_TERM_MISSING = PREFIX
			+ "Equations with constant term missing.";
	public static final String CAPTION_FIRST_ROOT_RANGE_MIN = PREFIX
			+ "First root range minimum:";
	public static final String CAPTION_FIRST_ROOT_RANGE_MAX = PREFIX
			+ "First root range maximum:";
	public static final String CAPTION_SECOND_ROOT_RANGE_MIN = PREFIX
			+ "Second root range minimum:";
	public static final String CAPTION_SECOND_ROOT_RANGE_MAX = PREFIX
			+ "Second root range maximum:";
	public static final String CAPTION_PARTIAL_CASES = PREFIX
			+ "Partial cases:";
	public static final String CAPTION_ROOT_TYPES = PREFIX + "Root types:";
	public static final String CAPTION_GENERAL = PREFIX + "General:";
	public static final String CALCULATE_ROOTS_FOR_EQUATION = PREFIX
			+ "What are the roots for given equation?";
	public static final String CAPTION_AMOUNT_OF_REPETITIONS = PREFIX
			+ "Amount of repetitions:";
	public static final String CAPTION_AMOUNT_OF_ROOTS = PREFIX
			+ "Amount of roots:";
	public static final String INTEGERS = PREFIX + "Integers";
	public static final String RATIONAL_NUMBERS = PREFIX + "Rational numbers";
	public static final String DECIMAL_NUMBERS = PREFIX + "Decimal numbers";
	public static final String SQUARE_ROOTS = PREFIX + "Square roots";
	public static final String SELECT_AT_LEAST_ONE_ROOT = PREFIX
			+ "SELECT_AT_LEAST_ONE_ROOT";
	public static final String ALWAYS_EXPAND_POLYNOMIALS = PREFIX
			+ "Always expand polynomials.";
	public static final String QUADRATIC_EQUATION_EXERCISE_EDITOR_HELP_PAGE = PREFIX
			+ "<h1 class=\"color-h1\">Quadratic equation exercise</h1>";

	/**** Help texts for editor ****/

	public static final String HELP_BUILDNUMBER = PREFIX + "HELP_BUILDNUMBER";
	public static final String HELP_BUILDNUMBER_LEFT = PREFIX
			+ "HELP_BUILDNUMBER_LEFT";
	public static final String HELP_BUILDNUMBER_CENTER = PREFIX
			+ "HELP_BUILDNUMBER_CENTER";
	public static final String HELP_BUILDNUMBER_RIGHT = PREFIX
			+ "HELP_BUILDNUMBER_RIGHT";

	public static final String HELP_CALCCHART = PREFIX + "HELP_CALCCHART";
	public static final String HELP_CALCCHART_LEFT = PREFIX
			+ "HELP_CALCCHART_LEFT";
	public static final String HELP_CALCCHART_CENTER = PREFIX
			+ "HELP_CALCCHART_CENTER";
	public static final String HELP_CALCCHART_RIGHT = PREFIX
			+ "HELP_CALCCHART_RIGHT";

	public static final String HELP_CALCCHARTNN = PREFIX + "HELP_CALCCHARTNN";
	public static final String HELP_CALCCHARTNN_LEFT = PREFIX
			+ "HELP_CALCCHARTNN_LEFT";
	public static final String HELP_CALCCHARTNN_CENTER = PREFIX
			+ "HELP_CALCCHARTNN_CENTER";
	public static final String HELP_CALCCHARTNN_RIGHT = PREFIX
			+ "HELP_CALCCHARTNN_RIGHT";

	public static final String HELP_CALCDECIMAL = PREFIX + "HELP_CALCDECIMAL";
	public static final String HELP_CALCDECIMAL_LEFT = PREFIX
			+ "HELP_CALCDECIMAL_LEFT";
	public static final String HELP_CALCDECIMAL_CENTER = PREFIX
			+ "HELP_CALCDECIMAL_CENTER";
	public static final String HELP_CALCDECIMAL_RIGHT = PREFIX
			+ "HELP_CALCDECIMAL_RIGHT";

	public static final String HELP_CALCFRACTIONS = PREFIX
			+ "HELP_CALCFRACTIONS";
	public static final String HELP_CALCFRACTIONS_LEFT = PREFIX
			+ "HELP_CALCFRACTIONS_LEFT";
	public static final String HELP_CALCFRACTIONS_CENTER = PREFIX
			+ "HELP_CALCFRACTIONS_CENTER";
	public static final String HELP_CALCFRACTIONS_RIGHT = PREFIX
			+ "HELP_CALCFRACTIONS_RIGHT";

	public static final String HELP_CALCROW = PREFIX + "HELP_CALCROW";
	public static final String HELP_CALCROW_LEFT = PREFIX + "HELP_CALCROW_LEFT";
	public static final String HELP_CALCROW_CENTER = PREFIX
			+ "HELP_CALCROW_CENTER";
	public static final String HELP_CALCROW_RIGHT = PREFIX
			+ "HELP_CALCROW_RIGHT";

	public static final String HELP_CALCWHOLENUMBER = PREFIX
			+ "HELP_CALCWHOLENUMBER";
	public static final String HELP_CALCWHOLENUMBER_LEFT = PREFIX
			+ "HELP_CALCWHOLENUMBER_LEFT";
	public static final String HELP_CALCWHOLENUMBER_CENTER = PREFIX
			+ "HELP_CALCWHOLENUMBER_CENTER";
	public static final String HELP_CALCWHOLENUMBER_RIGHT = PREFIX
			+ "HELP_CALCWHOLENUMBER_RIGHT";

	public static final String HELP_CONTINUENL = PREFIX + "HELP_CONTINUENL";
	public static final String HELP_CONTINUENL_LEFT = PREFIX
			+ "HELP_CONTINUENL_LEFT";
	public static final String HELP_CONTINUENL_CENTER = PREFIX
			+ "HELP_CONTINUENL_CENTER";
	public static final String HELP_CONTINUENL_RIGHT = PREFIX
			+ "HELP_CONTINUENL_RIGHT";

	public static final String HELP_CONVERTFRACTIONS = PREFIX
			+ "HELP_CONVERTFRACTIONS";
	public static final String HELP_CONVERTFRACTIONS_LEFT = PREFIX
			+ "HELP_CONVERTFRACTIONS_LEFT";
	public static final String HELP_CONVERTFRACTIONS_CENTER = PREFIX
			+ "HELP_CONVERTFRACTIONS_CENTER";
	public static final String HELP_CONVERTFRACTIONS_RIGHT = PREFIX
			+ "HELP_CONVERTFRACTIONS_RIGHT";

	public static final String HELP_DDNUMBERLINE = PREFIX + "HELP_DDNUMBERLINE";
	public static final String HELP_DDNUMBERLINE_LEFT = PREFIX
			+ "HELP_DDNUMBERLINE_LEFT";
	public static final String HELP_DDNUMBERLINE_CENTER = PREFIX
			+ "HELP_DDNUMBERLINE_CENTER";
	public static final String HELP_DDNUMBERLINE_RIGHT = PREFIX
			+ "HELP_DDNUMBERLINE_RIGHT";

	public static final String HELP_EQUALAMOUNT = PREFIX + "HELP_EQUALAMOUNT";
	public static final String HELP_EQUALAMOUNT_LEFT = PREFIX
			+ "HELP_EQUALAMOUNT_LEFT";
	public static final String HELP_EQUALAMOUNT_CENTER = PREFIX
			+ "HELP_EQUALAMOUNT_CENTER";
	public static final String HELP_EQUALAMOUNT_RIGHT = PREFIX
			+ "HELP_EQUALAMOUNT_RIGHT";

	public static final String HELP_FORMCALCULATION = PREFIX
			+ "HELP_FORMCALCULATION";
	public static final String HELP_FORMCALCULATION_LEFT = PREFIX
			+ "HELP_FORMCALCULATION_LEFT";
	public static final String HELP_FORMCALCULATION_CENTER = PREFIX
			+ "HELP_FORMCALCULATION_CENTER";
	public static final String HELP_FORMCALCULATION_RIGHT = PREFIX
			+ "HELP_FORMCALCULATION_RIGHT";

	public static final String HELP_LONGDIVISION = PREFIX + "HELP_LONGDIVISION";
	public static final String HELP_LONGDIVISION_LEFT = PREFIX
			+ "HELP_LONGDIVISION_LEFT";
	public static final String HELP_LONGDIVISION_CENTER = PREFIX
			+ "HELP_LONGDIVISION_CENTER";
	public static final String HELP_LONGDIVISION_RIGHT = PREFIX
			+ "HELP_LONGDIVISION_RIGHT";

	public static final String HELP_MULTIPLY = PREFIX + "HELP_MULTIPLY";
	public static final String HELP_MULTIPLY_LEFT = PREFIX
			+ "HELP_MULTIPLY_LEFT";
	public static final String HELP_MULTIPLY_CENTER = PREFIX
			+ "HELP_MULTIPLY_CENTER";
	public static final String HELP_MULTIPLY_RIGHT = PREFIX
			+ "HELP_MULTIPLY_RIGHT";

	public static final String HELP_NUMBERLINEEXER = PREFIX
			+ "HELP_NUMBERLINEEXER";
	public static final String HELP_NUMBERLINEEXER_LEFT = PREFIX
			+ "HELP_NUMBERLINEEXER_LEFT";
	public static final String HELP_NUMBERLINEEXER_CENTER = PREFIX
			+ "HELP_NUMBERLINEEXER_CENTER";
	public static final String HELP_NUMBERLINEEXER_RIGHT = PREFIX
			+ "HELP_NUMBERLINEEXER_RIGHT";

	public static final String HELP_WHATNUMBER = PREFIX + "HELP_WHATNUMBER";
	public static final String HELP_WHATNUMBER_LEFT = PREFIX
			+ "HELP_WHATNUMBER_LEFT";
	public static final String HELP_WHATNUMBER_CENTER = PREFIX
			+ "HELP_WHATNUMBER_CENTER";
	public static final String HELP_WHATNUMBER_RIGHT = PREFIX
			+ "HELP_WHATNUMBER_RIGHT";

	/* * Inequality exercise * */
	public static final String INEQUALITY_QUESTION = PREFIX
			+ "Inequality question";
	public static final String IDENTICALLY_TRUE = PREFIX
			+ "\\text{Identically true.}";
	public static final String IDENTICALLY_FALSE = PREFIX
			+ "\\text{Identically false.}";
	public static final String CLEAR_THE_SIGN_CHART = PREFIX
			+ "Clear the sign chart";
	public static final String HEADER_SIGN_CHART = PREFIX + "Sign chart";
	public static final String HEADER_SOLVE_INEQUALITY = PREFIX
			+ "Solving inequalites using sign charts";

	/* * Inequality exercise, editor * */
	public static final String INEQUALITY_HELPER_STRING = PREFIX
			+ "Inequality helper string";
	public static final String LEFT_SIDE_NOMINATOR_DEGREE_CAPTION = PREFIX
			+ "Left side nominator degree:";
	public static final String LEFT_SIDE_DENOMINATOR_DEGREE_CAPTION = PREFIX
			+ "Left side denominator degree:";
	public static final String RIGHT_SIDE_NOMINATOR_DEGREE_CAPTION = PREFIX
			+ "Right side nominator degree:";
	public static final String RIGHT_SIDE_DENOMINATOR_DEGREE_CAPTION = PREFIX
			+ "Right side denominator degree:";
	public static final String EXPAND_LEFT_SIDE_NOMINATOR_CAPTION = PREFIX
			+ "Expand left side nominator polynomial.";
	public static final String EXPAND_LEFT_SIDE_DENOMINATOR_CAPTION = PREFIX
			+ "Expand left side denominator polynomial.";
	public static final String EXPAND_RIGHT_SIDE_NOMINATOR_CAPTION = PREFIX
			+ "Expand right side nominator polynomial.";
	public static final String EXPAND_RIGHT_SIDE_DENOMINATOR_CAPTION = PREFIX
			+ "Expand right side denominator polynomial.";
	public static final String LEFT_SIDE_NOMINATOR_IS_FIXED = PREFIX
			+ "Left side nominator is fixed.";
	public static final String LEFT_SIDE_DENOMINATOR_IS_FIXED = PREFIX
			+ "Left side denominator is fixed.";
	public static final String RIGHT_SIDE_NOMINATOR_IS_FIXED = PREFIX
			+ "Right side nominator is fixed.";
	public static final String RIGHT_SIDE_DENOMINATOR_IS_FIXED = PREFIX
			+ "Right side denominator is fixed.";
	public static final String FIXED_VALUE_OF_LEFT_SIDE_NOMINATOR_CAPTION = PREFIX
			+ "Fixed value of left side nominator:";
	public static final String FIXED_VALUE_OF_LEFT_SIDE_DENOMINATOR_CAPTION = PREFIX
			+ "Fixed value of left side denominator:";
	public static final String FIXED_VALUE_OF_RIGHT_SIDE_NOMINATOR_CAPTION = PREFIX
			+ "Fixed value of right side nominator:";
	public static final String FIXED_VALUE_OF_RIGHT_SIDE_DENOMINATOR_CAPTION = PREFIX
			+ "Fixed value of right side denominator:";
	public static final String EXPANSION_OF_POLYNOMIALS_GROUP_CAPTION = PREFIX
			+ "Expansion of polynomials:";
	public static final String FIXED_VALUES_GROUP_CAPTION = PREFIX
			+ "Fixed values:";

	public static final String CE_FIELD_VALUE_ERROR = PREFIX
			+ "Must be a positive integer less than @0";

	public static final String CE_BIN_TO_DEC_COUNT = PREFIX
			+ "How many binary to decimal conversions?";

	public static final String CE_BIN_TO_HEX_COUNT = PREFIX
			+ "How many binary to hexa conversions?";

	public static final String CE_DEC_TO_BIN_COUNT = PREFIX
			+ "How many decimal to binary conversions?";

	public static final String CE_DEC_TO_HEX_COUNT = PREFIX
			+ "How many decimal to hexa conversions?";

	public static final String CE_HEX_TO_BIN_COUNT = PREFIX
			+ "How many hexa to binary conversions?";

	public static final String CE_HEX_TO_DEC_COUNT = PREFIX
			+ "How many hexa to decimal conversions?";

	public static final String CE_LOW_LIMIT = PREFIX
			+ "Minimum (in decimal) for numbers used in conversions";

	public static final String CE_HIGH_LIMIT = PREFIX
			+ "Maximum (in decimal) for numbers used in conversions";

	public static final String CE_LOW_MUST_BE_POSITIVE_INTEGER_LESS_THAN_HIGH = PREFIX
			+ "Minimum must be a positive integer less than maximum";

	public static final String CE_HIGH_MUST_BE_POSITIVE_INTEGER_MORE_THAN_LOW = PREFIX
			+ "Maximum must be a positive integer greater than minimum";

	public static final String CE_BIN_TO_DEC = PREFIX
			+ "Convert from binary to decimal";

	public static final String CE_BIN_TO_HEX = PREFIX
			+ "Convert from binary to hexa";

	public static final String CE_DEC_TO_BIN = PREFIX
			+ "Convert from decimal to binary";

	public static final String CE_DEC_TO_HEX = PREFIX
			+ "Convert from decimal to hexa";

	public static final String CE_HEX_TO_BIN = PREFIX
			+ "Convert from hexa to binary";

	public static final String CE_HEX_TO_DEC = PREFIX
			+ "Convert from hexa to decimal";

	public static final String CE_NAME = PREFIX + "Conversion exercise";

	public static final String CE_DESC = PREFIX
			+ "Do conversions between decimal, hexa and binary numbers";

	public static final String BC_MULTIP_COUNT = PREFIX
			+ "How many multiplication questions?";

	public static final String BC_ADD_COUNT = PREFIX
			+ "How many addition questions?";

	public static final String BC_SUBT_COUNT = PREFIX
			+ "How many subtraction questions?";

	public static final String BC_NAME = PREFIX + "Binary calculations";

	public static final String BC_DESC = PREFIX
			+ "Do binary multiplication, addition and subtraction calculations";

	public static final String BC_HIGH_LIMIT = PREFIX
			+ "Maximum (in decimal) for numbers used in conversions (Locked for multiplications to < 15)";

	public static final String CHART = PREFIX + "Chart";

	public static final String ADD_ROW = PREFIX + "Add row";

	public static final String DELETE_ROW = PREFIX + "Delete row";

	public static final String FIRST_DEGREE_SOLVE_THE_EQUATION = PREFIX
			+ "\\text{What is the value of } x \\text{ in equation }\\\\$$\\\\@0?\\\\$$";
	public static final String FIRST_DEGREE_MODEL_SOLUTION = PREFIX
			+ "place-holder for first degree model solution";
	public static final String FIRST_DEGREE_EXERCISE_EDITOR_HELP_PAGE = PREFIX
			+ "place-holder for first degree editor help text";

	public static final String EXPLANATION_OR = PREFIX + "or";

	public static final String MOD10 = PREFIX + "Divisible by 10";
	public static final String MOD100 = PREFIX + "Divisible by 100";
	public static final String LENGTH_OF_EQUATION = PREFIX
			+ "Length of equation";
	public static final String MAKE_ALL_NUMBERS_EVEN = PREFIX
			+ "Make all numbers even";

	/* * Derivation exercise, editor * */
	public static final String DERIVATION_HELPER_STRING = PREFIX
			+ "Derivation helper string";
	public static final String DERIVATION_CAPTION_FUNCTION_TYPE_GROUP = PREFIX
			+ "Exercise types:";
	public static final String DERIVATION_CAPTION_INNER_FUNCTION_EXERCISES = PREFIX
			+ "Exercises that emphasize derivation of composite functions.";
	public static final String DERIVATION_CAPTION_PRODUCT_FUNCTION_EXERCISES = PREFIX
			+ "Exercises that emphasize derivation of product functions.";
	public static final String DERIVATION_CAPTION_RATIONAL_FUNCTION_EXERCISES = PREFIX
			+ "Exercises that emphasize derivation of rational functions.";
	public static final String DERIVATION_CAPTION_INNER_FUNCTION = PREFIX
			+ "Inner functions:";
	public static final String DERIVATION_CAPTION_OUTER_FUNCTION = PREFIX
			+ "Outer functions:";

	/* * Derivation exercise * */
	public static final String HEADER_DERIVATION_CALCULATION_RULES = PREFIX
			+ "Calculation rules for derivation";
	public static final String HEADER_SOLUTION = PREFIX + "Solution";
	public static final String HEADER_CHECKUP = PREFIX + "Checkup";
	public static final String HEADER_RESULT = PREFIX + "Result";
	public static final String FUNCTION_F_EQUALS = PREFIX + "f(x)=";
	public static final String FUNCTION_F_DERIVATIVE_EQUALS = PREFIX + "f'(x)=";
	public static final String FUNCTION_G_EQUALS = PREFIX + "g(x)=";
	public static final String FUNCTION_G_DERIVATIVE_EQUALS = PREFIX + "g'(x)=";
	public static final String FUNCTION_FG_PRODUCT_DERIVATIVE_EQUALS = PREFIX
			+ "D(f(x) \\cdot g(x))=";
	public static final String FUNCTION_FG_QUOTIENT_DERIVATIVE_EQUALS = PREFIX
			+ "D\\left(\\frac{f(x)}{g(x)}\\right)=";
	public static final String FUNCTION_FG_COMPOSITE_FUNCTION_DERIVATIVE_EQUALS = PREFIX
			+ "D(f(g(x)))=";
	public static final String DERIVATIVE_OF_FUNCTION_F_CALCULATED_CORRECTLY = PREFIX
			+ "Derivative of function f(x) is calculated correctly.";
	public static final String DERIVATIVE_OF_FUNCTION_G_CALCULATED_CORRECTLY = PREFIX
			+ "Derivative of function g(x) is calculated correctly.";
	public static final String GIVEN_DERIVATIVE_IS_NOT_EQUAL_TO_DERIVATIVE_OF_F = PREFIX
			+ "Given derivative f'(x) is not a derivative of function f(x).";
	public static final String GIVEN_DERIVATIVE_IS_NOT_EQUAL_TO_DERIVATIVE_OF_G = PREFIX
			+ "Given derivative g'(x) is not a derivative of function g(x).";
	public static final String COMPOSITE_FUNCTION_HAS_BEEN_FORMED_CORRECTLY = PREFIX
			+ "Composite function has been formed correctly.";
	public static final String GIVEN_COMPOSITE_FUNCTION_DOES_NOT_MATCH_COMPOSITE_FUNCTION_OF_F_AND_G = PREFIX
			+ "Given composite function does not match the composite function of functions f(x) and g(x).";
	public static final String GIVEN_DERIVATIVE_IS_CORRECT = PREFIX
			+ "Given derivative is correct.";
	public static final String GIVEN_DERIVATIVE_DIFFERS_FROM_PROPER_DERIVATIVE = PREFIX
			+ "Given derivative differs from proper derivative.";
	public static final String SOME_OF_THE_FIELDS_ARE_EMPTY = PREFIX
			+ "Some of the fields are empty.";
	public static final String CORRECT_ANSWER_IS = PREFIX
			+ "\\text{Correct answer is }\\\\$$\\\\@0\\\\$$\\\\";
	public static final String COMPOSITE_FUNCTION_DERIVATIVE_QUESTION = PREFIX
			+ "Composite function derivative question";
	public static final String PRODUCT_FUNCTION_DERIVATIVE_QUESTION = PREFIX
			+ "Product function derivative question";
	public static final String RATIONAL_FUNCTION_DERIVATIVE_QUESTION = PREFIX
			+ "Rational function derivative question";

	public static final String MATH_SHOWHIGHLIGHT = PREFIX
			+ "Show values in bar chart on hover";

	public static final String MATH_SHOWPOINTLABELS = PREFIX
			+ "Show values in bar chart";

	public static final String MATH_QUESTION_PLUS = PREFIX
			+ "Question when adding";

	public static final String MATH_QUESTION_MINUS = PREFIX
			+ "Question when subtracting";

	public static final String MATH_SHOW_OPERATIONS = PREFIX
			+ "Show operations";

	public static final String MATH_SHOW_NUMBERS = PREFIX + "Show numbers";
	public static final String MATH_USE_VOICE = PREFIX + "Use voice";
	public static final String MATH_SHOW_CONTINUUM_IN_ANSWER = PREFIX
			+ "Show continuum in answer";

	public static final String DIVIDER = PREFIX + "Divider";
	public static final String DIVIDEND = PREFIX + "DIVIDEND";

	public static final String DENOMINATOR = PREFIX + "Denominator";
	public static final String NUMERATOR = PREFIX + "Numerator";

	public static final String MATH_MIXED_FRACTION = PREFIX
			+ "Show as mixed fraction";

	public static final String MATH_SHOW_MY_ANSWER = PREFIX + "SHOW_MY_ANSWER";

	public static final String MATH_SHOW_CORRECT_ANSWER = PREFIX
			+ "Show correct answer";

	public static final String MATH_HERE_IS_CORRECT_ANSWER = PREFIX
			+ "Here is the correct answer";

	public static final String CHECK_SETTINGS = PREFIX + "Check given settings";

	public static final String MATH_DO_NOT_DIVID_BY_ZERO = PREFIX
			+ "Don't divide by zero";

	public static final String NO_ANSWER = PREFIX + "No answer";

	public static final String MATH_AMOUNT_OF_DECIMALS = PREFIX
			+ "Number of visible decimals";

	public static final String FEEDBACK_CORRECT_NICE_JOB = PREFIX
			+ "That's correct, nice job!";

	public static final String FEEDBACK_GOOD_JOB = PREFIX + "Good job!";

	public static final String FEEDBACK_BRILLIANT = PREFIX + "Brilliant!";

	public static final String FEEDBACK_GREAT = PREFIX + "Great!";

	public static final String FEEDBACK_OOPS_HOW_DID_THAT_HAPPEN = PREFIX
			+ "Oops, how did that happen?";

	public static final String FEEDBACK_LITTLE_MORE_PRECISION = PREFIX
			+ "A little more precision";

	public static final String FEEDBACK_BETTER_LUCK_NEXT_TIME = PREFIX
			+ "Better luck next time";

	public static final String FEEDBACK_OOPS_THAT_DIDNT_WORK = PREFIX
			+ "Oops, that didn't work";

	public static final String MATH_POINTS = PREFIX + "Points";

	public static final String MATH_TRIES = PREFIX + "Tries";

	public static final String QUESTION = PREFIX + "Question";

	public static final String ANSWERED = PREFIX + "Answered";

	public static final String CORRECT_ANSWER = PREFIX + "Correct answer";

	public static final String CORRECT = PREFIX + "Correct";

	public static final String SUBMIT = PREFIX + "Submit answers";

	public static final String CANCEL = PREFIX + "Cancel";

	public static final String GENERATE = PREFIX + "GENERATE";

	public static final String NOT_A_NUMBER_ERROR = PREFIX
			+ "NOT A NUMBER ERROR";

	public static final String NOT_A_OPERATOR_ERROR = PREFIX
			+ "NOT A OPERATOR ERROR";

	public static final String EMPTY_FIELDS_ERROR = PREFIX
			+ "EMPTY FIELDS ERROR";

	public static final String WRONG_ANSWER_ERROR = PREFIX
			+ "WRONG ANSWER ERROR";

	public static final String NOT_IN_POOL_ERROR = PREFIX + "Not in pool error";

	public static final String CALCULATION_ERROR = PREFIX + "Calculation error";

	public static final String POOL_ELEMENTS_ARE_REUSED = PREFIX
			+ "Pool elements are reusable";

	public static final String POOL_ELEMENTS_ARE_DISPOSABLE = PREFIX
			+ "Pool elements are disposable";

	public static final String NUMBERS = PREFIX + "Numbers";

	public static final String OPERATORS = PREFIX + "Operators";

	public static final String NUMBERFIELD = PREFIX + "Numberfield";

	public static final String OPERATORFIELD = PREFIX + "Operatorfield";

	public static final String EXERCISE = PREFIX + "Exercise";

	public static final String UPDATE_VALUES = PREFIX + "Update values";

	public static final String FILL_EQUATION = PREFIX + "Fill Equation";

	public static final String SETTINGS = PREFIX + "Settings";

	public static final String EXERCISES = PREFIX + "Exercises";

	public static final String AVAILABLE_OPERATORS = PREFIX
			+ "Available operators";

	public static final String RANDOMIZE_CALCULATIONS = PREFIX
			+ "RANDOMIZE_CALCULATIONS";

	// Timedlevel test

	public static final String TIMEDLEVELTEST = PREFIX + "Timedleveltest";

	public static final String DESC = PREFIX + "DESC";

	public static final String INFO = PREFIX + "TIMED_LEVEL_TEST_INFO";

	public static final String LEVEL_INFO = PREFIX + "LEVEL_INFO";

	public static final String DIVISION_NOTICE = PREFIX + "DIVISION_NOTICE";

	public static final String MOUSEOVER_LEFT = PREFIX + "MOUSEOVER_LEFT";

	public static final String MOUSEOVER_RIGHT = PREFIX + "MOUSEOVER_RIGHT";

	public static final String MOUSEOVER_DIVISION_LEFT = PREFIX
			+ "MOUSEOVER_DIVISION_LEFT";

	public static final String MOUSEOVER_DIVISION_RIGHT = PREFIX
			+ "MOUSEOVER_DIVISION_RIGHT";

	public static final String EXERCISE_LEVEL = PREFIX + "EXERCISE_LEVEL";

	public static final String EXERCISE_START = PREFIX + "EXERCISE_START";

	public static final String EXERCISE_TIME_END = PREFIX + "EXERCISE_TIME_END";

	public static final String EDIT_NUMBERS_ONLY = PREFIX + "EDIT_NUMBERS_ONLY";

	public static final String RESULTS_CORRECT = PREFIX + "RESULTS_CORRECT";

	public static final String RESULTS_LEVEL_UP = PREFIX + "RESULTS_LEVEL_UP";

	public static final String RESULTS_THRESHOLD = PREFIX + "RESULTS_THRESHOLD";

	public static final String RESULTS_TIME = PREFIX + "RESULTS_TIME";

	public static final String NO_LEVELS = PREFIX + "NO_LEVELS";

	public static final String LEVEL = PREFIX + "LEVEL";

	public static final String OPERATOR = PREFIX + "OPERATOR";

	public static final String VALUE_RANGE = PREFIX + "VALUE_RANGE";

	public static final String VALUE_RANGE_ERROR = PREFIX + "VALUE_RANGE_ERROR";

	public static final String NUMBER_OF_QUESTIONS = PREFIX
			+ "NUMBER_OF_QUESTIONS";

	public static final String THRESHOLD = PREFIX + "THRESHOLD";

	public static final String SWAP_SIDES = PREFIX + "SWAP_SIDES";

	public static final String MOUSEOVER_SWAP_SIDES = PREFIX
			+ "MOUSEOVER_SWAP_SIDES";

	public static final String SHOW_TIMER = PREFIX + "SHOW_TIMER";

	public static final String ONE_AT_A_TIME = PREFIX
			+ "SHOW_ONE_QUESTION_AT_A_TIME";

	public static final String QUESTIONS_ASKED_AND_ANSWERED = PREFIX
			+ "QUESTIONS_ASKED_AND_ANSWERED";

	public static final String TIME = PREFIX + "TIME";

	public static final String CORRECTNESS = PREFIX + "CORRECTNESS";

	// Timedlevel test end.

	/* * Rounding exercise constants * */

	public static final String ROUND = PREFIX + "ROUND";

	public static final String NEAREST = PREFIX + "TONEAREST";

	public static final String BYDRAGGING = PREFIX + "BYDRAGGING";

	public static final String MIDDLENUMBER = PREFIX + "MIDDLENUMBER";

	public static final String DDQUESTION = PREFIX + "DDQUESTION";

	public static final String TYPING = PREFIX + "TYPING";

	public static final String CHOOSEPRECISION = PREFIX + "CHOOSEPRECISION";

	public static final String CORRECTANSWERIS = PREFIX + "CORRECTANSWERIS";

	public static final String ONE_ROUNDING_TARGET = PREFIX
			+ "ONE_ROUNDING_TARGET";

	public static final String THOUSANDTH = PREFIX + "THOUSANDTH";
	public static final String HUNDRETH = PREFIX + "HUNDRETH";
	public static final String TENTH = PREFIX + "TENTH";
	public static final String ONE = PREFIX + "ONE";
	public static final String TEN = PREFIX + "TEN";
	public static final String HUNDRED = PREFIX + "HUNDRED";
	public static final String THOUSAND = PREFIX + "THOUSAND";
	public static final String TENTHOUSAND = PREFIX + "TENTHOUSAND";

	public static final String EXERCISE_SETTINGS = "EXERCISE_SETTINGS";

	public static final String RANGE = PREFIX + "RANGE";

	public static final String MATH_MIN_AND_MAX = PREFIX + "MIN_AND_MAX";

	public static final String MATH_ANSWER_MIN_MAX = PREFIX + "ANSWER_MIN_MAX";

	public static final String EVEN_NUMBERS = PREFIX + "EVEN_NUMBERS";

	public static final String Separate_Term_Ranges = PREFIX
			+ "SEPARATE_TERM_RANGES";

	public static final String CHOOSE_LEVEL = PREFIX + "CHOOSE_LEVEL";

	public static final String MATH_INTERACTIVE = PREFIX + "MATH_INTERACTIVE";

	public static final String QUANTITY = PREFIX + "QUANTITY";

	public static final String TASK_TYPE = PREFIX + "TASK_TYPE";

	public static final String PRECISION = PREFIX + "PRECISION";

	public static final String RANGE_FOR_TERMS = PREFIX + "Ranges for terms";

	public static final String OR_ADD_CALCUATIONS_MANUALLY = "Or add calculations manually, one calcualtion on each line. For example 1+2";

	public static final String ADD_NEW_LEVEL = "Add new level";

	public static final String ERROR_PARSING_CALCULATION = "Error parsing calculation";

	public static final String SOLVE_QUADRATIC_EQUATIONS = "Solve quadratic equations.";

	public static final String EASY_CUBIC_EQUATIONS = "Solve easy cubic equations.";

	public static final String CARDGAME_AMOUNT_OF_CARDS = "Amount of Cards";

	public static final String MATH_GEOMETRY_HELP = "MATH_GEOM_HELP";

	public static final String SUBMIT_QUESTION = PREFIX + "Submit answers?";

	public static final String SUBMIT_QUESTION_DESCR = PREFIX
			+ "You can submit answers later yourself by pressing Submit -button";

	public static final String IS_MATH = PREFIX + "Is math";

	public static final String MATH_WRITE_ANSWER_TO_HOLE = PREFIX
			+ "Write answer in to the answer field";

	public static final String ALLOW_PARENTHESIS = PREFIX+"GENERATOR_ALLOW_PARENTHESIS";

	public static final String FORCE_PARENTHESIS = PREFIX+"GENERATOR_FORCE_PARENTHESIS";

	public static final String PARENTHESIS = PREFIX+"PARENTHESIS";

}
