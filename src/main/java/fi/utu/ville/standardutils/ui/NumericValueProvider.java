package fi.utu.ville.standardutils.ui;

import com.vaadin.data.Property.ReadOnlyException;

import fi.utu.ville.standardutils.PreciseDecimal;

public interface NumericValueProvider {
	PreciseDecimal getPreciseDecimal();
	
	double getDouble();
	
	void setValue(NumericValueProvider valueProvider) throws ReadOnlyException;
	
	boolean isMutable();
	
	boolean canChangeValueTo(double newValue);
}