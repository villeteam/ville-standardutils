package fi.utu.ville.standardutils.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.RepeatingCommand;
import com.google.gwt.event.logical.shared.AttachEvent;
import com.google.gwt.event.logical.shared.AttachEvent.Handler;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.VTextField;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.textfield.TextFieldConstants;

import fi.utu.ville.standardutils.ui.PeriodicValueChangeExtension;

@Connect(PeriodicValueChangeExtension.class)
public class PeriodicValueChangeConnector extends AbstractExtensionConnector {

	private static final long serialVersionUID = -2732221560697L;
            
	private VTextField textField;
	private boolean isRunning = false;

	@Override
	protected void extend(ServerConnector target) {
		
	    textField = (VTextField) ((ComponentConnector) target).getWidget();
//	    textField.addKeyPressHandler(keyPressHandler);
	    final VTextField field = textField;
	    textField.addAttachHandler(new Handler() {
			
			@Override
			public void onAttachOrDetach(AttachEvent event) {
				if(event.isAttached()) {
					runCommand(field);
				}
				
			}
		});

	}
	
	private void runCommand(final VTextField field) {
		if(isRunning) {
			return;
		}
		isRunning = true;
	    Scheduler.get().scheduleFixedPeriod(new RepeatingCommand() {
			String lastValue = null;
			int count = 0;
			
			@Override
			public boolean execute() {
				
				if(!field.isAttached()) {
					isRunning = false;
					return false;
				}
				count++;
				String newValue = field.getText();
				if(newValue.equals(lastValue)) {
					// do nothing
				}
				else {
					int lastValueLength = lastValue == null ? 0 : lastValue.length();
					if(count % 17 == 0 || Math.abs((lastValueLength - newValue.length())) >= 50) {
						//final String previousConstant = "text"; // if VAR_CUR_TEXT causes issues, use this 
						field.client.updateVariable(textField.paintableId, TextFieldConstants.VAR_CUR_TEXT, newValue, true);
						int cursorPos = field.getCursorPos(); //  VERY IMPORTANT, fixes #1062
						//field.client.updateVariable(textField.paintableId, TextFieldConstants.VAR_CURSOR, cursorPos, true);
						lastValue = newValue;
					}
				}
				
		    	
		    	return true;
			}
		},10000);
	}
}
