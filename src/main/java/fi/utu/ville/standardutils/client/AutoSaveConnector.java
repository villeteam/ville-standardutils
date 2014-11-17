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

	private static final long serialVersionUID = -2732210610021560697L;

            
	private VTextField textField;
	private KeyPressHandler keyPressHandler = new KeyPressHandler() {
	    @Override
	    public void onKeyPress(KeyPressEvent event) {
	    	Logger logger = Logger.getLogger("oaeeoa");
	    	logger.log(Level.SEVERE, "KeyDown8");
	        if (textField.isReadOnly() || !textField.isEnabled()) {
	            return;
	        }

	       
//	        textField.client.sendPendingVariableChanges();
	        int keyCode = event.getCharCode();
	        
	        if(keyCode == 0) { // Control keys seem pretty reliably to have charCode value of 0, 
	        	return;		   // but very unreliably to map to correct KeyCodes. (below)
	        }
//	        textField.client.updateVariable(textField.paintableId, "text", getFieldValueAfterKeyPress(event.getCharCode()),true);
	    }
	};

	@Override
	protected void extend(ServerConnector target) {
		
	    textField = (VTextField) ((ComponentConnector) target).getWidget();
	    textField.addKeyPressHandler(keyPressHandler);
	    final VTextField field = textField;
	    
//	    scheduler.scheduleAtFixedRate(new Runnable() {
//	    	public void run() {
//
//	    	}
//	    }, 0, 1000, TimeUnit.MILLISECONDS);
	    Scheduler.get().scheduleFixedPeriod(new RepeatingCommand() {
			String lastValue = null;
			int count = 0;
			
			@Override
			public boolean execute() {
				
				Logger logger = Logger.getLogger("oaeeoa");
				logger.log(Level.SEVERE, "Count: " + count);
				String newValue = field.getText();
				if(newValue.equals(lastValue)) {
					logger.log(Level.SEVERE, "No change");
				}
				else {
					if(count % 18 == 0 || Math.abs((lastValue.length()-newValue.length())) >= 50) {
						if(count % 18 == 0) {
							logger.log(Level.SEVERE, "COUNT update");
						}
						else {
							logger.log(Level.SEVERE, "DIFF update " + Math.abs((lastValue.length()-newValue.length())) );
						}
						field.client.updateVariable(textField.paintableId, "text", newValue,true);
						logger.log(Level.SEVERE, "pulse");
						lastValue = newValue;
					}
				}
				count++;
		    	
		    	return true;
			}
		},1000);
	}
	
	@Override
	public RegexFieldExtensionState getState() {
	    return (RegexFieldExtensionState) super.getState();
	}
}
