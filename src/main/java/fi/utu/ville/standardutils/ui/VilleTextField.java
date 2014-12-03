package fi.utu.ville.standardutils.ui;

import com.vaadin.data.Property;
import com.vaadin.ui.TextField;

@SuppressWarnings({ "rawtypes", "serial" })
public class VilleTextField extends TextField {

	public VilleTextField(String caption) {
		super(caption);
	}
	
	
	public VilleTextField(String caption, Property dataSource) {
		super(caption, dataSource);
	}

	public VilleTextField(String caption, String value) {
		super(caption, value);
	}

	public VilleTextField() {
		super();
	}
	
	public VilleTextField(Property dataSource) {
		super(dataSource);
	}
}
