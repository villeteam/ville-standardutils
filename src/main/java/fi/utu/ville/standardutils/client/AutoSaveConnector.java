package fi.utu.ville.standardutils.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.VTextField;
import com.vaadin.shared.ui.Connect;

import fi.utu.ville.standardutils.ui.AutoSaveExtension;

@Connect(AutoSaveExtension.class)
public class AutoSaveConnector extends AbstractExtensionConnector {

	private static final long serialVersionUID = -2732221560697L;
            
	private VTextField textField;

	@Override
	protected void extend(ServerConnector target) {
		
	    textField = (VTextField) ((ComponentConnector) target).getWidget();
//	    textField.addKeyPressHandler(keyPressHandler);
	    final VTextField field = textField;
	    
	    Scheduler.get().scheduleFixedPeriod(new RepeatingCommand() {
			String lastValue = null;
			int count = 0;
			
			@Override
			public boolean execute() {
				String newValue = field.getText();
				if(newValue.equals(lastValue)) {
					// do nothing
				}
				else {
					int lastValueLength = lastValue == null ? 0 : lastValue.length();
					if(count % 18 == 0 || Math.abs((lastValueLength - newValue.length())) >= 50) {
						field.client.updateVariable(textField.paintableId, "text", newValue, true);
						lastValue = newValue;
					}
				}
				count++;
		    	
		    	return true;
			}
		},10000);
	}
}
