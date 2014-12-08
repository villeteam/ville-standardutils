package fi.utu.ville.standardutils.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.Connect.LoadStyle;


@Connect(value =fi.utu.ville.standardutils.ui.VilleTextField.class, loadStyle=LoadStyle.EAGER)
public class VilleTextFieldConnector extends TextFieldConnector {

	private static final long serialVersionUID = 5162644024572013961L;

	@Override
	protected Widget createWidget() {
		return GWT.create(VVilleTextField.class);
	}
	
	@Override
	public VVilleTextField getWidget() {
		return (VVilleTextField)super.getWidget();
	}
}
