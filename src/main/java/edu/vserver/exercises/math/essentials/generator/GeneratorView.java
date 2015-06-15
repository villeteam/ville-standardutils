package edu.vserver.exercises.math.essentials.generator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Layout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Slider;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import edu.vserver.exercises.math.essentials.generator.ManualCalculationSet.ManualCalculation;
import edu.vserver.exercises.math.essentials.generator.MathGeneratorExerciseData.BoundingType;
import fi.utu.ville.standardutils.Localizer;
import fi.utu.ville.standardutils.MathHelper;
import fi.utu.ville.standardutils.StandardIcon.Icon;
import fi.utu.ville.standardutils.StandardUIFactory;
import fi.utu.ville.standardutils.StandardUIFactory.PanelStyle;
import fi.utu.ville.standardutils.UIConstants;
import fi.utu.ville.standardutils.ui.CleanTextArea;
import fi.utu.ville.standardutils.ui.CleanTextField;
import fi.utu.ville.standardutils.ui.DecimalField;
import fi.utu.ville.standardutils.ui.FieldParameter;
import fi.utu.ville.standardutils.ui.IntegerField;

public class GeneratorView implements Serializable {

	private static final long serialVersionUID = 5611161972887417441L;
	private static final int MIN_TERM_VALUE = -1000000000;
	private static final int MAX_TERM_VALUE =  1000000000;
	
	private final MathGeneratorExerciseData options;
	private final Localizer localizer;

	private final VerticalLayout termLayout = new VerticalLayout();
	private final VerticalLayout boundSelectionLayout = StandardUIFactory.getVerticalGrayContentLayout(PanelStyle.DEFAULT);
	private final CheckBox individualTermRangesCheckBox;
	private final CheckBox[] operatorCheckBoxes;
	private final ArrayList<Component> loadedComponents;
	private static final String FORM_PANEL_TITLE_WIDTH = "200px";

	private transient boolean[] operatorsShown;
	private static int TEXTFIELDWIDTH = 50;

	public GeneratorView(Localizer localizer) {
		this(localizer, new MathGeneratorExerciseData(2));
	}

	public GeneratorView(Localizer localizer, MathGeneratorExerciseData oldData) {
		if (oldData == null){
			System.out.println("oldData was null!");
			oldData = new MathGeneratorExerciseData(2);
		}
		this.localizer = localizer;
		options = oldData;
		operatorsShown = new boolean[]{true,true,true,true};
		individualTermRangesCheckBox = new CheckBox(
				localizer.getUIText(UIConstants.Separate_Term_Ranges),
				options.getSeparateTermRangesFlag());
		operatorCheckBoxes = new CheckBox[] {
				createSelectOperatorCheckBox(localizer.getUIText("Sum"),
						Operator.SUM, options.additionAllowed()),
				createSelectOperatorCheckBox(
						localizer.getUIText("Subtraction"), Operator.SUBTRACT,
						options.subtractionAllowed()),
				createSelectOperatorCheckBox(
						localizer.getUIText("Multiplication"),
						Operator.MULTIPLICATION,
						options.multiplicationAllowed()),
				createSelectOperatorCheckBox(localizer.getUIText("Division"),
						Operator.DIVISION, options.divisionAllowed()) };
		loadedComponents= new ArrayList<Component>();
	}

	/**
	 * Returns a layout for setting the range for the solution. The method does
	 * not set the bounding mode; it must be set manually with the
	 * {@link MathGeneratorExerciseData#setBoundingType(BoundingType type)}
	 * method.
	 * 
	 * @return
	 */
	public VerticalLayout getSolutionRangeLayout() {

		final DecimalField minSolution = new DecimalField("Min");
		minSolution.setValue(options.getMinValueForSolution().intValue());
		final DecimalField maxSolution = new DecimalField("Max");
		maxSolution.setValue(options.getMaxValueForSolution().intValue());
		minSolution.setRange(MIN_TERM_VALUE, MAX_TERM_VALUE);
		maxSolution.setRange(MIN_TERM_VALUE, MAX_TERM_VALUE);
		ValueChangeListener listener = new ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (minSolution.getDouble() > maxSolution.getDouble())
					maxSolution.setValue(minSolution.getValue());
				if (maxSolution.getDouble() < minSolution.getDouble())
					minSolution.setValue(maxSolution.getValue());

				options.setSolutionRange(minSolution.getDouble(),
						maxSolution.getDouble());
			}
		};

		minSolution.setWidth(TEXTFIELDWIDTH, Unit.PIXELS);
		minSolution.addValueChangeListener(listener);

		maxSolution.setWidth(TEXTFIELDWIDTH, Unit.PIXELS);
		maxSolution.addValueChangeListener(listener);

		final IntegerField solutionDecimals = new IntegerField(
				localizer.getUIText("Decimal numbers"), FieldParameter.NONNEGATIVE_ONLY);
		solutionDecimals.setValue(options.getNumberOfDecimalsInSolution() + "");
		solutionDecimals.setWidth(TEXTFIELDWIDTH, Unit.PIXELS);
		solutionDecimals.setRange(0, 5);
		solutionDecimals.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				options.setNumberOfDecimalsInSolution(solutionDecimals
						.getInteger());
			}
		});

		VerticalLayout result = StandardUIFactory.getFormPanel(
				localizer.getUIText(GeneratorUIConstants.RANGEFORSOLUTION),
				Icon.RESULT, FORM_PANEL_TITLE_WIDTH, minSolution, maxSolution,
				solutionDecimals);

		loadedComponents.add(result);
		
		return result;
	}

	/**
	 * Gets a VerticalLayout containing the selector for the bounding mode and
	 * the appropriate components to modify the selected bounds.
	 * 
	 * @param boundingTypes
	 *            The allowed bounding types for this selector. If no parameters
	 *            are given, all bounding types are allowed.
	 * @return A VerticalLayout containing everything necessary to set the
	 *         bounds for the generator.
	 */
	public VerticalLayout getBoundSelectionComponent(
			BoundingType... boundingTypes) {
		
		// allow the whole enum if nothing is passed
		final BoundingType[] allowedTypes;
		if (boundingTypes == null || boundingTypes.length == 0)
			allowedTypes = BoundingType.values();
		else
			allowedTypes = boundingTypes;

		// localize the native select options
		boundSelectionLayout.setCaption(localizer
				.getUIText(GeneratorUIConstants.EXPRESSIONBOUNDS));
		final String[] values = new String[allowedTypes.length];
		for (int i = 0; i < allowedTypes.length; i++) {
			values[i] = localizer.getUIText(allowedTypes[i]
					.getLocalizerString());
		}

		// add the localized native selections to the NativeSelect
		final NativeSelect boundSelector = new NativeSelect(
				localizer.getUIText(GeneratorUIConstants.BOUNDEDBY),
				Arrays.asList(values));
		boundSelector.setNullSelectionAllowed(false);

		boundSelector.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = 7579214773526006640L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				boundSelectionLayout.removeAllComponents();
				if (allowedTypes.length > 1)
					boundSelectionLayout.addComponent(boundSelector);

				for (int i = 0; i < values.length; i++) {
					if (values[i].equals(boundSelector.getValue()))
						options.setBoundingType(allowedTypes[i]);
				}

				showComponents(true);
				
				switch (options.getBoundingType()) {
				case BOTH:
					boundSelectionLayout.addComponent(getSolutionRangeLayout());
					boundSelectionLayout.addComponent(getTermRangeLayout());
					break;
				case SOLUTION:
					boundSelectionLayout.addComponent(getSolutionRangeLayout());
					break;
				case TERMS:
					boundSelectionLayout.addComponent(getTermRangeLayout());
					break;
				case MANUAL:
					showComponents(false);
					boundSelectionLayout.addComponent(getManualInputLayout());
					break;
				default:
					break;
				}
			}
		});

		boundSelector.select(localizer.getUIText(options.getBoundingType()
				.getLocalizerString()));

		return boundSelectionLayout;
	}

	private void showComponents(boolean show){
		for(Component c : loadedComponents)
			c.setVisible(show);
	}
	
	/**
	 * Returns a layout for inputting calculations manually. Each calculation is entered on its own row.
	 * @return a layout that contains a everything necessary for inputting calculations manually.
	 */
	public Component getManualInputLayout() {
		VerticalLayout result = new VerticalLayout();
		Panel content = StandardUIFactory.getFixedWidthPanel("100%");//.getVerticalGrayContentLayout(PanelStyle.DEFAULT, Border.ALL);
		VerticalLayout panelLayout = new VerticalLayout();
		content.setHeight("500px");
		content.setContent(panelLayout);
		
		result.addComponent(content);
		
		final VerticalLayout manualCalculationFields = new VerticalLayout();
		final ManualCalculationSet calculations = options.getManualCalculations();
		addManualInputFields(manualCalculationFields, calculations);

		final HorizontalLayout calculationEntryFields = new HorizontalLayout();
		final CleanTextField expression = new CleanTextField(localizer.getUIText(UIConstants.GENERATOR_EXPRESSION));
		final CleanTextField answer = new CleanTextField(localizer.getUIText(UIConstants.ANSWER));
		answer.setReadOnly(true);
		
		expression.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = -6546328205853830702L;

			@Override
			public void valueChange(ValueChangeEvent event) {
								
				String expressionValue = expression.getValue().replaceAll(" ", "");
				
				if(expressionValue.isEmpty())
					return;
				
				if(!isValidExpression(expressionValue)){
					Notification.show(localizer.getUIText(UIConstants.INVALID_EXPRESSION)+": "+
							expressionValue, Notification.Type.WARNING_MESSAGE);
					return;
				}
				
				String answerString = (Double.toString(MathHelper.evaluate(expressionValue.replace(',', '.'))));
				calculations.addCalculation(expressionValue+"="+answerString);
				addManualInputFields(manualCalculationFields, calculations);
				expression.setValue("");
				answer.setValue("");
			}
		});
		expression.setInputPrompt("0");
		expression.addStyleName("expressiongenerator-manual-calc expressiongenerator-manual-input");
		//answer.setInputPrompt("0");
		answer.addStyleName("expressiongenerator-manual-calc expressiongenerator-manual-input");
		calculationEntryFields.addComponents(expression, answer);
		
		panelLayout.addComponent(calculationEntryFields);
		panelLayout.addComponent(manualCalculationFields);
		HorizontalLayout settingsLayout = new HorizontalLayout();
		settingsLayout.addComponent(getGenerateCalculationsButton(manualCalculationFields, options.getManualCalculations()));
		settingsLayout.addComponent(getShuffleButton(manualCalculationFields, options.getManualCalculations()));
		settingsLayout.addComponent(getImportManualCalculationsButton(manualCalculationFields, options.getManualCalculations()));
		settingsLayout.addComponent(getClearAllButton(manualCalculationFields, options.getManualCalculations()));
		result.addComponent(settingsLayout);
		
		return result;
	}
	
	private Button getShuffleButton(final VerticalLayout manualCalculationFields, final ManualCalculationSet manualCalculationSet) {
		Button b = StandardUIFactory.getButton(localizer.getUIText(UIConstants.SHUFFLE), Icon.FOLD);
		
		b.addClickListener(new ClickListener() {
			
			private static final long serialVersionUID = 6710876523688235560L;

			@Override
			public void buttonClick(ClickEvent event) {
				manualCalculationSet.shuffleQuestionset();
				addManualInputFields(manualCalculationFields, manualCalculationSet);
			}
		});
		return b;
	}

	private Component getImportManualCalculationsButton(final Layout manualCalculationFields, final ManualCalculationSet manualCalculationSet){
		final VerticalLayout layout = new VerticalLayout();
		final CleanTextArea field = new CleanTextArea();
				
		field.setHeight("500px");
		Button result = StandardUIFactory.getButton(localizer.getUIText(UIConstants.IMPORT), Icon.ATTACH);
		Button savebutton = StandardUIFactory.getButton(localizer.getUIText(UIConstants.SAVE), Icon.SAVE);
		
		final Window win = StandardUIFactory.getModalWindow("60%", localizer.getUIText(UIConstants.IMPORT));
		win.setContent(layout);
		
		result.addClickListener(new ClickListener() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {				
				UI.getCurrent().addWindow(win);
			}
		});
		
		savebutton.addClickListener(new ClickListener() {
	
			private static final long serialVersionUID = 3133418786180355572L;

			@Override
			public void buttonClick(ClickEvent event) {
				String[] expressions = field.getValue().split("\n");
				for(int i=0; i<expressions.length; i++){
					if(!isValidExpression(expressions[i])){
						Notification.show(localizer.getUIText(UIConstants.INVALID_EXPRESSION)+": "+
								expressions[i], Notification.Type.WARNING_MESSAGE);
						return;
					}
				}
				try{
					manualCalculationSet.importCalculations(field.getValue());
				}catch(IllegalArgumentException e){
					Notification.show(localizer.getUIText(UIConstants.CHECK)+": "+
							localizer.getUIText(UIConstants.NUMBER_OF_QUESTIONS),Notification.Type.WARNING_MESSAGE);
					win.close();
					return;
				}
				addManualInputFields(manualCalculationFields, manualCalculationSet);
				field.setValue("");
				win.close();
			}
		});
		
		layout.addComponent(field);
		layout.addComponent(savebutton);
		return result;
	}
	
	private Component getClearAllButton(final VerticalLayout manualCalculationFields, final ManualCalculationSet manualCalculationSet) {
		Button result = StandardUIFactory.getButton(localizer.getUIText(UIConstants.CLEAR), Icon.DELETE);
		
		result.addClickListener(new ClickListener() {

			private static final long serialVersionUID = 4380401102973703014L;

			@Override
			public void buttonClick(ClickEvent event) {
				manualCalculationSet.clear();
				addManualInputFields(manualCalculationFields, manualCalculationSet);
			}
		});
		
		return result;

	}

	private Component getGenerateCalculationsButton(final Layout manualFieldsLayout, final ManualCalculationSet calculationSet) {
		final VerticalLayout windowLayout = new VerticalLayout();
		final Window win = StandardUIFactory.getModalWindow("60%", localizer.getUIText(UIConstants.GENERATE));
		win.setContent(windowLayout);
		Button result = StandardUIFactory.getButton(localizer.getUIText(UIConstants.GENERATE), Icon.GENERATE);//, windowLayout);
		result.addClickListener(new ClickListener() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().addWindow(win);
			}
		});
		
		final GeneratorView newView = new GeneratorView(localizer);
		final Slider numberOfQuestions = new Slider(localizer.getUIText(UIConstants.NUMBER_OF_EXERCISES),0,ManualCalculationSet.CALCULATION_LIMIT);
		numberOfQuestions.setWidth("200px");
		Button saveButton = StandardUIFactory.getButton(localizer.getUIText(UIConstants.SAVE), Icon.SAVE);
		
		saveButton.addClickListener(new ClickListener() {
			private static final long serialVersionUID = 1164633510100836603L;

			@Override
			public void buttonClick(ClickEvent event) {
				if(!newView.isDataValid()){
					win.close();
					return;
				}
				
				for(int i=0; i<numberOfQuestions.getValue(); i++){
					calculationSet.addCalculation(ExpressionGenerator.generateExpressionWithAnswer(newView.getOptions(), true));
				}
				addManualInputFields(manualFieldsLayout, calculationSet);
				win.close();
			}
		});
		
		windowLayout.setMargin(true);
		windowLayout.addComponents(
				numberOfQuestions,
				newView.getTermNumberLayout(),
				newView.getBoundSelectionComponent(BoundingType.BOTH,BoundingType.SOLUTION,BoundingType.TERMS),
				newView.getOperatorTypeSelector(operatorsShown),
				saveButton);
		
		return result;
	}

	private boolean isValidExpression(String expression){
		if(expression.isEmpty()){
			System.out.println("expression was empty");
			return false;
		}
		
		 
		if(!expression.matches("(\\(*\\d+(,|\\.)?\\d*\\)*[+\\-*/])*(\\d+(,|\\.)?\\d*)\\)*")){
			System.out.println("expression was invalid");
			return false;
		}
		//check equal number of parenthesis
		int openingParenthesis = 0;
		int closingParenthesis = 0;
		for(int i=0; i<expression.length();i++){
			if(expression.charAt(i) == '(')
				openingParenthesis++;
			if(expression.charAt(i) == ')')
				closingParenthesis++;
		}
		if(openingParenthesis != closingParenthesis){
			System.out.println("expression had invalid number of parenthesis");
			return false;
		}
		return true;
	}
	
	private void addManualInputFields(final Layout layout, final ManualCalculationSet calculations){
		layout.removeAllComponents();
		for(int i=0;i<calculations.size();i++){
			final ManualCalculation calculation = calculations.get(i);
			HorizontalLayout horizontalLayout = new HorizontalLayout();
			horizontalLayout.setSizeFull();
			Button deleteButton = StandardUIFactory.getIconOnlyButton(Icon.DELETE);
			deleteButton.addClickListener(new ClickListener() {
				private static final long serialVersionUID = 4335765911260233275L;

				@Override
				public void buttonClick(ClickEvent event) {
					calculations.remove(calculation);
					addManualInputFields(layout, calculations);
				}
			});
			
			horizontalLayout.addComponent(addOneManualCalculationField(calculation));
			horizontalLayout.addComponent(deleteButton);
			horizontalLayout.setComponentAlignment(deleteButton, Alignment.MIDDLE_LEFT);
			layout.addComponent(horizontalLayout);
		}
	}
	
	private Layout addOneManualCalculationField(final ManualCalculation calculation){
		final HorizontalLayout layout = new HorizontalLayout();
		final CleanTextField expression = new CleanTextField(null, calculation.getExpression());
		final Label answer = new Label(calculation.getAnswer());
		
		expression.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 2419103747934191053L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				String expressionValue = expression.getValue();
				
				if(!isValidExpression(expressionValue)){
					Notification.show("Invalid expression", Notification.Type.WARNING_MESSAGE);
					return;
				}
				
				String answerString = Double.toString(MathHelper.evaluate(expressionValue.replace(',', '.')));
				
				calculation.setExpression(expressionValue);
				calculation.setAnswer(answerString);
				
				expression.setValue(calculation.getExpression());
				answer.setValue(calculation.getAnswer());
				
			}
		});
		
		answer.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = -3075492735739688530L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if(MathHelper.isParsableToDouble(answer.getValue()));
			}
		});
		expression.addStyleName("expressiongenerator-manual-calc");
		answer.addStyleName("expressiongenerator-manual-calc");
		
		layout.addComponents(expression,new Label("="), answer);
		
		return layout;
	}
	
	/**
	 * Returns a VerticalLayout that contains everything necessary to set the
	 * term ranges. The method does not set the bounding mode; it must be set
	 * manually with the
	 * {@link MathGeneratorExerciseData#setBoundingType(BoundingType type)}
	 * method.
	 * 
	 * @return
	 */
	public Layout getTermRangeLayout() {
		individualTermRangesCheckBox
				.addValueChangeListener(new ValueChangeListener() {

					private static final long serialVersionUID = 1L;

					@Override
					public void valueChange(ValueChangeEvent event) {
						options.setSeparateTermsFlag(individualTermRangesCheckBox.getValue());
						createTermTextFields(
								options.getSeparateTermRangesFlag(),
								termLayout);
						if (!options.getSeparateTermRangesFlag()) {
							options.setGlobalTermRange(
									options.getMinValueForTerms(),
									options.getMaxValueForTerms());
							options.setGlobalForcedMultiplier(options
									.getForcedMultiplier(0));
							options.setGlobalNumberOfDecimals(options.getNumberOfDecimalsInTerm(0));
						}
					}
				});

		VerticalLayout container = StandardUIFactory.getFormPanel(
				localizer.getUIText(localizer
						.getUIText(UIConstants.RANGE_FOR_TERMS)),
				Icon.TERM_RANGE,
				FORM_PANEL_TITLE_WIDTH,
				new VerticalLayout(individualTermRangesCheckBox),
				createTermTextFields(options.getSeparateTermRangesFlag(),
						termLayout));
		
		loadedComponents.add(container);
		
		return container;
	}

	/**
	 * Returns a VerticalLayout that contains checkboxes for all the specified
	 * oprators.
	 * 
	 * @param operators
	 *            The operators that should be added to the container.
	 * @return
	 */
	public Layout getOperatorTypeSelector(boolean sum,
			boolean subtract, boolean multiplication, boolean division) {
		operatorsShown = new boolean[] { sum, subtract,
				multiplication, division };

		int allowed = 0;
		for (boolean b : operatorsShown) {
			if (b)
				allowed++;
		}

		CheckBox[] cboxes = new CheckBox[allowed];
		for (int i = 0; i < allowed; i++) {
			if (operatorsShown[i]) {
				cboxes[i] = operatorCheckBoxes[i];
			}
		}
		
		VerticalLayout result = StandardUIFactory.getFormPanel(
				localizer.getUIText(UIConstants.OPERATORS), Icon.OPERATORS,
				FORM_PANEL_TITLE_WIDTH, cboxes);
		
		loadedComponents.add(result);
		
		return result;
	}

	private Layout getOperatorTypeSelector(boolean[] operators) {
		return getOperatorTypeSelector(operators[0],operators[1],operators[2],operators[3]);
	}
	
	/**
	 * Returns everything needed to set whether to allow or force parenthesis 
	 * in the equation or not.
	 * @return a Layout for setting parenthesis options.
	 */
	public Layout getAllowParenthesisLayout(){
		
		final CheckBox allowParenthesis = new CheckBox(
				localizer.getUIText(UIConstants.ALLOW_PARENTHESIS), 
				options.getAllowParenthesis());
		final CheckBox forceParenthesis = new CheckBox(
				localizer.getUIText(UIConstants.FORCE_PARENTHESIS), 
				options.getForceParenthesis());
		
		forceParenthesis.setEnabled(options.getAllowParenthesis());
		
		forceParenthesis.addValueChangeListener(new ValueChangeListener() {
			
			private static final long serialVersionUID = 6193618982108693002L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				options.setForceParenthesis(forceParenthesis.getValue());
			}
		});
		
		allowParenthesis.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = -2386497123263722619L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				boolean value = allowParenthesis.getValue();
				options.setAllowParenthesis(value);
				forceParenthesis.setEnabled(value);
				if(!value){
					forceParenthesis.setValue(false);
					options.setForceParenthesis(false);
				}
			}
		});	
		
		VerticalLayout result = StandardUIFactory.getFormPanel(
				localizer.getUIText(UIConstants.PARENTHESIS), Icon.OPERATORS,
				FORM_PANEL_TITLE_WIDTH, allowParenthesis, forceParenthesis);
		
		loadedComponents.add(result);
		return result;
	}
	
	/**
	 * Returns a layout for selecting how many terms the generated equations
	 * have.
	 */
	public VerticalLayout getTermNumberLayout() {
		HorizontalLayout container = new HorizontalLayout();
		container.setSpacing(true);
		container.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

		final Label label = new Label(options.getNumberOfTerms() + "");
		label.addStyleName("math-text-small");
		VerticalLayout layout = new VerticalLayout();
		final Button addTermButton = StandardUIFactory
				.getIconOnlyButton(Icon.INCREASE);
		addTermButton.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				options.addTerm();
				label.setValue(options.getNumberOfTerms() + "");
				createTermTextFields(options.getSeparateTermRangesFlag(),
						termLayout);
			}
		});

		Button decreaseTermButton = StandardUIFactory.getIconOnlyButton(Icon.DECREASE);
		decreaseTermButton.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				options.decreaseTerm();
				label.setValue(options.getNumberOfTerms() + "");
				createTermTextFields(options.getSeparateTermRangesFlag(),
						termLayout);
			}
		});

		container.addComponent(label);
		layout.addComponent(addTermButton);
		layout.addComponent(decreaseTermButton);
		container.addComponent(layout);

		VerticalLayout wrapper = StandardUIFactory.getFormPanel(
				localizer.getUIText(UIConstants.NUMBEROFTERMS),
				Icon.AMOUNT, FORM_PANEL_TITLE_WIDTH, container);

		loadedComponents.add(wrapper);
		
		return wrapper;
	}

	/**
	 * Adds the required controls to modify the forced multiplier of the terms
	 * in the expression. For example, if the forced multiplier is 2, all terms
	 * in the equation will be even.
	 * 
	 * @param container
	 *            The container that will contain the controls for the forced
	 *            multiplier.
	 */
	private AbstractOrderedLayout getForcedMultiplierComponent(
			final int termIndex) {
		VerticalLayout result = new VerticalLayout();

		if (options.getBoundingType() != BoundingType.TERMS)
			// I never could figure out how to force the multiplier when also
			// bound by either solution or both the solution and the terms
			return result;

		final CheckBox enabled = new CheckBox(
				localizer.getUIText("FORCEDIVISIBILITY"), options.getForcedMultiplier(termIndex) != 0.0);
		final DecimalField multiplier = new DecimalField();
		multiplier.setValue(options.getForcedMultiplier(termIndex) + "");
		multiplier.setRange(MIN_TERM_VALUE, MAX_TERM_VALUE);
		enabled.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				multiplier.setEnabled(enabled.getValue());
				if (!enabled.getValue())
					options.setForcedMultiplier(termIndex, 0);
				else {
					if (!options.getSeparateTermRangesFlag()) {
						options.setGlobalForcedMultiplier(Double
								.valueOf(multiplier.getValue().replace(",", ".")));
					} else {
						options.setForcedMultiplier(termIndex,
								Double.valueOf(multiplier.getValue().replace(",", ".")));
					}
				}
			}
		});

		multiplier.setWidth(TEXTFIELDWIDTH, Unit.PIXELS);
		multiplier.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				String value = multiplier.getValue();
				value = value.replaceAll("[^\\d+((\\.|,)\\d+)?]?", "");
				options.setForcedMultiplier(termIndex,
						Double.valueOf(value.replaceAll(",", ".")));
				// System.out.println("set forced multiplier"
				// + Double.valueOf(value.replaceAll(",", "."))
				// + " for term " + termIndex);
				multiplier.setValue(value);
			}
		});

		multiplier.setImmediate(true);
		multiplier.setEnabled(enabled.getValue());

		result.addComponent(enabled);
		result.addComponent(multiplier);

		return result;
	}

	/**
	 * Creates one checkbox for setting an allowed operator
	 * 
	 * @param caption
	 *            the caption for the checkbox
	 * @param operator
	 *            the operator to (dis)allow
	 * @param initialValue
	 *            the starting value
	 * @return the checkbox
	 */
	private CheckBox createSelectOperatorCheckBox(String caption,
			final Operator operator, boolean initialValue) {
		final CheckBox checkbox = new CheckBox(caption, initialValue);
		checkbox.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				try {
					options.setAllowedOperator(operator, checkbox.getValue());
				} catch (IllegalStateException e) {
					checkbox.setValue(!checkbox.getValue());
					Notification.show("Unable to set operator; invalid range",
							Notification.Type.ERROR_MESSAGE);
				}
			}
		});
		return checkbox;
	}

	/**
	 * Creates TextFields for both the min and max term ranges.
	 * 
	 * @param showIndividualTerms
	 *            a boolean to determine wether all term ranges should be shown
	 * @param oldLayout
	 *            the layout where to add the textfields.
	 * @return a layout that contains term ranges for setting the min and max
	 *         ranges for terms.
	 */
	private AbstractOrderedLayout createTermTextFields(
			boolean showIndividualTerms, AbstractOrderedLayout oldLayout) {
		HorizontalLayout hLayout = new HorizontalLayout();
		oldLayout.removeAllComponents();
		oldLayout.setSizeUndefined();

		if (showIndividualTerms) {
			for (int i = 0; i < options.getNumberOfTerms(); i++) {
				final int index = i;
				hLayout = new HorizontalLayout();
				DecimalField minTermRange = createMinTermRangeTextField(i,
						options.getMinValueForTerm(i).intValue());
				DecimalField maxTermRange = createMaxTermRangeTextField(i,
						options.getMaxValueForTerm(i).intValue());

				linkTextFields(minTermRange, maxTermRange, index);

				hLayout.addComponent(minTermRange);
				hLayout.addComponent(maxTermRange);
				hLayout.addComponent(getDecimalTextField(index));
				hLayout.addComponent(getForcedMultiplierComponent(index));
				oldLayout.addComponent(hLayout);
			}
		} else {
			DecimalField minTermRange = createMinTermRangeTextField(0, options
					.getMinValueForTerms().intValue());
			DecimalField maxTermRange = createMaxTermRangeTextField(0, options
					.getMaxValueForTerms().intValue());

			linkTextFields(minTermRange, maxTermRange, 0);

			hLayout.addComponent(minTermRange);
			hLayout.addComponent(maxTermRange);
			hLayout.addComponent(getDecimalTextField(0));
			hLayout.addComponent(getForcedMultiplierComponent(0));
			oldLayout.addComponent(hLayout);
		}

		return oldLayout;
	}

	/**
	 * Links textfields such that the value of the smaller textfield is always
	 * lesser than or equal to that of the larger textfield and vice versa.
	 * 
	 * @param smaller
	 * @param larger
	 */
	private void linkTextFields(final DecimalField smaller,
			final DecimalField larger, final int index) {
		smaller.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (smaller.getDouble() > larger.getDouble()) {
					larger.setValue(smaller.getValue());
					options.setTermRange(smaller.getDouble(),
							smaller.getDouble(), index);
					// System.out.println("set term range to "
					// + smaller.getDouble());
				}
			}
		});

		larger.addValueChangeListener(new ValueChangeListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (larger.getDouble() < smaller.getDouble()) {
					smaller.setValue(larger.getValue());
					options.setTermRange(larger.getDouble(),
							larger.getDouble(), index);
					// System.out.println("set term range to "
					// + larger.getDouble());
				}
			}
		});

	}

	private CleanTextField getDecimalTextField(final int termIndex) {
		final IntegerField decimals = new IntegerField(
				localizer.getUIText("Decimal numbers"), 1, FieldParameter.NONNEGATIVE_ONLY);
		decimals.setValue(options.getNumberOfDecimalsInTerm(termIndex) + "");
		decimals.setWidth(TEXTFIELDWIDTH, Unit.PIXELS);
		decimals.setImmediate(true);
		decimals.setNullRepresentation("0");
		decimals.setRange(0, 5);
		decimals.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				decimals.setValue(decimals.getValue().replaceAll("\\D", ""));
				if (options.getSeparateTermRangesFlag()) {
					/*System.out.println("set individual decimals "
							+ Integer.parseInt(decimals.getValue())
							+ " for index " + termIndex);*/
					options.setNumberOfDecimalsInTerm(termIndex,
							decimals.getInteger());
				} else {
					/*System.out.println("set global decimals "
							+ Integer.parseInt(decimals.getValue()));*/
					options.setGlobalNumberOfDecimals(decimals.getInteger());
				}
			}
		});
		return decimals;
	}

	/**
	 * Creates a textfield for the min term range
	 * 
	 * @param index
	 *            The index of the term whose range we want to set.
	 * @param startValue
	 *            The new value
	 * @return a TextField that sets the min term range.
	 */
	private DecimalField createMinTermRangeTextField(final int index,
			final int startValue) {
		final DecimalField minValue = new DecimalField(
				localizer.getUIText("Minimum"));
		minValue.setValue(startValue + "");
		minValue.setWidth(TEXTFIELDWIDTH, Unit.PIXELS);
		minValue.setImmediate(true);
		minValue.setNullRepresentation("0");
		minValue.setRange(MIN_TERM_VALUE, MAX_TERM_VALUE);
		minValue.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (options.getSeparateTermRangesFlag()) {
					options.setMinValueForTerm(minValue.getDouble(), index);
				} else {
					options.setGlobalMinTermRange(minValue.getDouble());
				}
			}
		});

		return minValue;
	}

	/**
	 * Creates a textfield for the max term range
	 * 
	 * @param index
	 *            The index of the term whose range we want to set.
	 * @param startValue
	 *            The new value
	 * @return a TextField that sets the max term range.
	 */
	private DecimalField createMaxTermRangeTextField(final int index,
			final int startValue) {
		final DecimalField maxValue = new DecimalField(
				localizer.getUIText("Maximum"));
		maxValue.setValue(startValue + "");
		maxValue.setImmediate(true);
		maxValue.setNullRepresentation("0");
		maxValue.setRange(MIN_TERM_VALUE, MAX_TERM_VALUE);
		maxValue.setWidth(TEXTFIELDWIDTH, Unit.PIXELS);
		maxValue.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = 1L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				if (options.getSeparateTermRangesFlag())
					options.setMaxValueForTerm(maxValue.getDouble(), index);
				else
					options.setGlobalMaxTermRange(maxValue.getDouble());
			}
		});

		return maxValue;
	}
	
	/**
	 * Checks that the data is valid.
	 * 
	 * @return true if all data is valid.
	 */
	public boolean isDataValid() {

		if (!options.atLeastOneOperatorChosen()) {
			Notification.show(localizer
					.getUIText(GeneratorUIConstants.GENERATOR_ATLEAST_ONE_OPERATOR));
			return false;
		}

		if(!options.areRangesValid()){
			Notification.show(localizer
					.getUIText(GeneratorUIConstants.GENERATOR_MULTIPLIER_TOO_HIGH));
			return false;
		}
		
		if(options.getManualCalculations().size() == 0 && options.getBoundingType()==BoundingType.MANUAL){
			Notification.show(localizer.getUIText(GeneratorUIConstants.GENERATOR_NO_MANUAL_CALCULATIONS));
			return false;
		}
		
		return true;
	}

	public int getNumberOfTerms() {
		return options.getNumberOfTerms();
	}

	public int getNumberOfDecimals() {
		return options.getNumberOfDecimalsInSolution();
	}

	public boolean isAdditionAllowed() {
		return options.additionAllowed();
	}

	public boolean isSubtractionAllowed() {
		return options.subtractionAllowed();
	}

	public boolean isMultiplicationAllowed() {
		return options.multiplicationAllowed();
	}

	public boolean isDivisionAllowed() {
		return options.divisionAllowed();
	}

	public double getSolutionMax() {
		return options.getMaxValueForSolution().doubleValue();
	}

	public double getSolutionMin() {
		return options.getMinValueForSolution().doubleValue();
	}

	public int getMinValueForTerm(int i) {
		return options.getMinValueForTerm(i).intValue();
	}

	public int getMaxValueForTerm(int i) {
		return options.getMaxValueForTerm(i).intValue();
	}

	public int numberOfDecimals() {
		return options.getNumberOfDecimalsInSolution();
	}

	public int[] getNumberOfDecimalsInTerms() {
		return options.getNumberOfDecimalsInTerms();
	}

	public double getForcedMultiplier(int term) {
		return options.getForcedMultiplier(term);
	}

	public double[] getForcedMultipliers() {
		return options.getForcedMultipliers();
	}
	
	public MathGeneratorExerciseData getOptions() {
		return options;
	}

}
