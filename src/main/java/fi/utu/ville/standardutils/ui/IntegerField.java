package fi.utu.ville.standardutils.ui;


public class IntegerField extends DecimalField implements NumericValueProvider {

	private static final long serialVersionUID = 8265248112948780531L;
	
	public IntegerField(String caption, Integer maxIntegers, FieldParameter... parameters) {
		super(caption, maxIntegers, 0, parameters);
	}
	
	public IntegerField(String caption, FieldParameter... parameters) {
		this(caption, null, parameters);
	}
	
	public IntegerField(FieldParameter... parameters) {
		this(null, null, parameters);
	}
	
	public IntegerField(Integer maxIntegers, FieldParameter... parameters) {
		this(null, maxIntegers, parameters);
	}
	
	public long getLong() {
		if(super.getValue().equals("") || !isValid()) {
			return 0;
		}
		else {
			return Long.parseLong(this.getValue());
		}
	}
	
	public int getInteger() {
		return (int) getLong();
	}
	
	public void setValue(long value) {
		this.setValue("" + value);
	}

	@Override
	public void setValue(NumericValueProvider preciseDecimal) {
		this.setValue(preciseDecimal.getPreciseDecimal().getIntegerPart() + "");
	}
}