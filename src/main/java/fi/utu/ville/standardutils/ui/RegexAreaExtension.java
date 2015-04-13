package fi.utu.ville.standardutils.ui;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.TextArea;

import fi.utu.ville.standardutils.client.RegexFieldExtensionState;


public class RegexAreaExtension extends AbstractExtension {

	private static final long serialVersionUID = 8986814555711778351L;

	public static RegexAreaExtension extend(TextArea field, String pattern) {
        RegexAreaExtension extension = new RegexAreaExtension();
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