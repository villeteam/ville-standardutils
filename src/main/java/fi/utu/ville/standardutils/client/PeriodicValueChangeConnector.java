package fi.utu.ville.standardutils.client;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.VTextField;
import com.vaadin.shared.ui.Connect;

import fi.utu.ville.standardutils.ui.PeriodicValueChangeExtension;

@Connect(PeriodicValueChangeExtension.class)
public class PeriodicValueChangeConnector extends AbstractExtensionConnector {

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
				count++;
				String newValue = field.getText();
				if(newValue.equals(lastValue)) {
					// do nothing
				}
				else {
					int lastValueLength = lastValue == null ? 0 : lastValue.length();
					if(count % 17 == 0 || Math.abs((lastValueLength - newValue.length())) >= 50) {
						field.client.updateVariable(textField.paintableId, "text", newValue, true);
						lastValue = newValue;
					}
				}
				
		    	
		    	return true;
			}
		},10000);
	}
}
