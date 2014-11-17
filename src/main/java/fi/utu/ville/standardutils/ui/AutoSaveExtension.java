package fi.utu.ville.standardutils.ui;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.AbstractTextField;

import fi.utu.ville.standardutils.client.RegexFieldExtensionState;


public class AutoSaveExtension extends AbstractExtension {

	private static final long serialVersionUID = 8986814555711778351L;

	public static AutoSaveExtension extend(AbstractTextField field) {
        AutoSaveExtension extension = new AutoSaveExtension();
		extension.extend((AbstractClientConnector) field);
		return extension;
    }
	
}