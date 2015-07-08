package fi.utu.ville.standardutils.ui;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.AbstractTextField;

public class PeriodicValueChangeExtension extends AbstractExtension {

	private static final long serialVersionUID = 8986814555711778351L;

	public static PeriodicValueChangeExtension extend(AbstractTextField field) {
        PeriodicValueChangeExtension extension = new PeriodicValueChangeExtension();
		extension.extend((AbstractClientConnector) field);
		return extension;
    }
	
}