package fi.utu.ville.standardutils.ui;

import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Slider;

import fi.utu.ville.standardutils.PreciseDecimal;
import fi.utu.ville.standardutils.ui.MinMaxFieldValidator.ModifyPreference;

public class MinMaxFieldValidator {
	
	private NumericValueProvider minValue;
	private NumericValueProvider maxValue;
	final private ControlWithNumericValue smallerField;
	final private ControlWithNumericValue largerField;
	private boolean internalValidationInProgress = false;
	private final MinMaxValueChangeListener listener1, listener2;

	public MinMaxFieldValidator(NumericValueProvider minValue, ControlWithNumericValue field, NumericValueProvider maxValue, ModifyPreference modifyPreference) {
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.smallerField = field;
		this.largerField = smallerField;
		this.listener1 = new MinMaxValueChangeListener(PreciseDecimal.MIN_VALUE, minValue, field, maxValue, PreciseDecimal.MAX_VALUE, modifyPreference, PreciseDecimal.ZERO);
		listener2 = null;
//		System.out.println("Added valuechangelistener: " + minValue.getDouble() + " < x < " + maxValue.getDouble() + modifyPreference.toString());
		if(modifyPreference != ModifyPreference.DONT_MODIFY) {
			field.addValueChangeListener(listener1);
		}
	}
	
	public MinMaxFieldValidator(NumericValueProvider minValue, ControlWithNumericValue field1, ControlWithNumericValue field2, NumericValueProvider maxValue, NumericValueProvider difference) {
		if(difference == null) {
			difference = PreciseDecimal.ZERO;
		}
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.smallerField = field1;
		this.largerField = field2;
		
		this.listener1 = new MinMaxValueChangeListener(PreciseDecimal.MIN_VALUE, minValue, field1, field2, maxValue, ModifyPreference.MODIFY_OTHER, difference);
		this.listener2 = new MinMaxValueChangeListener(minValue, field1, field2, maxValue, PreciseDecimal.MAX_VALUE, ModifyPreference.MODIFY_OTHER, difference);
		
		field1.addValueChangeListener(listener1);
		field2.addValueChangeListener(listener2);
	}
	
	public MinMaxFieldValidator(NumericValueProvider minValue, DecimalField field, NumericValueProvider maxValue) {
		this(minValue, field, maxValue, ModifyPreference.MODIFY_OTHER);
	}
	
	public MinMaxFieldValidator(DecimalField field) {
		this(PreciseDecimal.MIN_VALUE, field, PreciseDecimal.MAX_VALUE, ModifyPreference.MODIFY_OTHER);
	}
	
	public MinMaxFieldValidator(NumericValueProvider minValue, DecimalField field1, DecimalField field2, NumericValueProvider maxValue) {
		this(minValue, field1, field2, maxValue, PreciseDecimal.ZERO);
	}
	
	public MinMaxFieldValidator(DecimalField minField, DecimalField maxField) {
		this(PreciseDecimal.MIN_VALUE, minField, maxField, PreciseDecimal.MAX_VALUE, PreciseDecimal.ZERO);
	}
	
	public MinMaxFieldValidator(Slider minField, Slider maxField, NumericValueProvider difference) {
		this(new PreciseDecimal(minField.getMin()), new SliderWithValidation(minField), 
				new SliderWithValidation(maxField), new PreciseDecimal(maxField.getMax()), difference);
	}
	
	public void setMinValue(NumericValueProvider value) {
		this.minValue = value;
	}

	public void setMaxValue(NumericValueProvider value) {
		this.maxValue = value;
	}
	
	// TODO: doesn't validate difference
	public boolean isValid() {
		if(internalValidationInProgress) {
			return true;
		}
		internalValidationInProgress = true;
		boolean validationResult = 
				(minValue.getDouble() <= smallerField.getDouble()   &&
				smallerField.getDouble() <= largerField.getDouble() &&
				largerField.getDouble() <= maxValue.getDouble());
		internalValidationInProgress = false;
		return validationResult;
	}
	
	public NumericValueProvider getMinValue() {
		return minValue;
	}
	
	public NumericValueProvider getMaxValue() {
		return maxValue;
	}
	
//	public DecimalField getSmallerField() {
//		return smallerField;
//	}
//	
//	public DecimalField getLargerField() {
//		return largerField;
//	}
	
//	public DecimalField getField() {
//		return smallerField;
//	}
	
	public void setDifferenceBetweenFields(NumericValueProvider difference) {
		listener1.setDifferenceBetweenFields(difference);
		if(listener2 != null) {
			listener2.setDifferenceBetweenFields(difference);
		}
	}
	
	enum ModifyPreference {
		DONT_MODIFY,
		MODIFY_OTHER,
		MODIFY_THIS
	}
}
// TODO: if field1 > field2 = max, and field1 has just been changed, change field1 to field2.

class MinMaxValueChangeListener implements ValueChangeListener {
	
	private static final long serialVersionUID = 2069147246134308941L;
	
	private final NumericValueProvider minValue;
	private final NumericValueProvider maxValue;
	private final NumericValueProvider maxOfMax;
	private final NumericValueProvider minOfMin;
	private final NumericValueProvider parent;
	private final ModifyPreference mode;
	private boolean hasChanged = false;
	private NumericValueProvider differenceMin;
	private NumericValueProvider differenceMax;
	
	public MinMaxValueChangeListener(NumericValueProvider minOfMin, NumericValueProvider minValue, 
			NumericValueProvider parent, NumericValueProvider maxValue, NumericValueProvider maxOfMax, 
			ModifyPreference mode, NumericValueProvider difference) {
		this.minOfMin = minOfMin;
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.maxOfMax = maxOfMax;
		this.parent = parent;
		this.mode = mode;
		setDifferenceBetweenFields(difference);
	}
	
	public void setDifferenceBetweenFields(NumericValueProvider difference) {
		if(minValue.isMutable()) {
			differenceMin = difference;
		}
		else {
			differenceMin = PreciseDecimal.ZERO;
		}
		if(maxValue.isMutable()) { 
			differenceMax = difference;
		}
		else {
			differenceMax = PreciseDecimal.ZERO;
		}
//		System.out.println("diffMin: " + differenceMin.getDouble() + " diffMax:" + differenceMax.getDouble());
		valueChange(null);
	}
	
	@Override
	public void valueChange(
			com.vaadin.data.Property.ValueChangeEvent event) {
        if(hasChanged){
            hasChanged = false;
            return;
        }
		double newValue = parent.getDouble();
//		System.out.println("first: " + (newValue - minValue.getDouble()));
//		System.out.println("second: " + (maxValue.getDouble() - newValue));
		PreciseDecimal minOfParent = PreciseDecimal.add(minOfMin.getPreciseDecimal(), differenceMin.getPreciseDecimal());
		PreciseDecimal maxOfParent = PreciseDecimal.subtract(maxOfMax.getPreciseDecimal(), differenceMax.getPreciseDecimal());
		if(minOfParent.compareTo(parent.getPreciseDecimal()) > 0) {
			hasChanged = true;
			parent.setValue(minOfParent);
		}
		if(maxOfParent.compareTo(parent.getPreciseDecimal()) < 0) {
			hasChanged = true;
			parent.setValue(maxOfParent);
		}
		if(newValue - minValue.getDouble() < differenceMin.getDouble()) {
//			System.out.println("Calling changeValue because of min criteria");
			changeValue(minValue, differenceMin.getPreciseDecimal().getInverse());
		}
		if(maxValue.getDouble() - newValue < differenceMax.getDouble()) {
//			System.out.println("Calling changeValue because of max criteria");
			changeValue(maxValue, differenceMax.getPreciseDecimal());
		}
	}
	
	private void changeValue(NumericValueProvider restrictor, PreciseDecimal diff) {
//		System.out.println("Change: " + parent.getDouble() + " changevalue" + restrictor.getDouble());
		try {
			if(mode == ModifyPreference.MODIFY_OTHER) {
				PreciseDecimal parentPlusDiff = PreciseDecimal.add(parent.getPreciseDecimal(), diff);
				if(restrictor.isMutable()) {
//					System.out.println("Changed restrictor1: " + restrictor.getDouble() + "->" + parent.getPreciseDecimal().toString());
					restrictor.setValue(parentPlusDiff);
				} 
				else {
					hasChanged = true;
//					System.out.println("Changed parent2: " + parent.getDouble() + "->" + restrictor.getPreciseDecimal().toString());
					parent.setValue(PreciseDecimal.add(restrictor.getPreciseDecimal(), diff.getInverse()));
				}
			}
			else {
//				System.out.println("Changed parent3: " + parent.getDouble() + "->" + restrictor.getPreciseDecimal().toString());
				hasChanged = true;
				parent.setValue(PreciseDecimal.add(restrictor.getPreciseDecimal(), diff.getInverse()));
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
		} // won't happen
	}
}

class SliderWithValidation implements ControlWithNumericValue {

	private static final long serialVersionUID = -129662737356410488L;
	
	private final Slider slider;
	
	public SliderWithValidation(Slider slider) {
		this.slider = slider;
	}
	
	@Override
	public PreciseDecimal getPreciseDecimal() {
		return new PreciseDecimal(slider.getValue());
	}

	@Override
	public double getDouble() {
		return slider.getValue();
	}

	@Override
	public void setValue(NumericValueProvider preciseDecimal)
			throws com.vaadin.data.Property.ReadOnlyException {
		slider.setValue(preciseDecimal.getDouble());
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public void addValueChangeListener(ValueChangeListener listener) {
		slider.addValueChangeListener(listener);
		
	}

	@Override
	public void addListener(ValueChangeListener listener) {
		slider.addValueChangeListener(listener);
	}

	@Override
	public void removeValueChangeListener(ValueChangeListener listener) {
		slider.removeValueChangeListener(listener);
	}

	@Override
	public void removeListener(ValueChangeListener listener) {
		slider.removeValueChangeListener(listener);
	}

	@Override
	public boolean canChangeValueTo(double newValue) {
		return (newValue >= slider.getMin() && newValue <= slider.getMax());
	}
	
}
