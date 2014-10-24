package fi.utu.ville.standardutils.ui;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.TextField;

import fi.utu.ville.standardutils.client.RegexFieldExtensionState;


public class RegexFieldExtension extends AbstractExtension {

	private static final long serialVersionUID = 8986814555711778351L;

	public static RegexFieldExtension extend(TextField field, String pattern) {
        RegexFieldExtension extension = new RegexFieldExtension();
		extension.extend((AbstractClientConnector) field);
		RegexFieldExtensionState state = extension.getState();
		state.setPattern(pattern);
		return extension;
    }
	
	@Override
	public RegexFieldExtensionState getState() {
	    return (RegexFieldExtensionState) super.getState();
	}
	
}