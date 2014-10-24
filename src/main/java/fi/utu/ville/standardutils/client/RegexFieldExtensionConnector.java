package fi.utu.ville.standardutils.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.VTextField;
import com.vaadin.shared.ui.Connect;

import fi.utu.ville.standardutils.ui.RegexFieldExtension;

@Connect(RegexFieldExtension.class)
public class RegexFieldExtensionConnector extends AbstractExtensionConnector {

	private static final long serialVersionUID = -2732210610021560697L;


	protected boolean integersOnly = false;
            
	private VTextField textField;
	private KeyPressHandler keyPressHandler = new KeyPressHandler() {
	    @Override
	    public void onKeyPress(KeyPressEvent event) {
	    	GWT.log("Keydown");
	        if (textField.isReadOnly() || !textField.isEnabled()) {
	            return;
	        }
	        int keyCode = event.getCharCode();
	        
	        if(keyCode == 0) { // Control keys seem pretty reliably to have charCode value of 0, 
	        	return;		   // but very unreliably to map to correct KeyCodes. (below)
	        }
	        
//	        switch (keyCode) {
//		        case KeyCodes.KEY_LEFT: // one of LEFT, RIGHT, BACKSPACE, DELETE is . and %
//		        case KeyCodes.KEY_RIGHT:
//		        case KeyCodes.KEY_BACKSPACE:
//		        case KeyCodes.KEY_DELETE:
//		        case KeyCodes.KEY_TAB:
//		        case KeyCodes.KEY_UP: // One of UP or DOWN is & or (
//		        case KeyCodes.KEY_DOWN:
//		        case KeyCodes.KEY_SHIFT:
//		        	return;
//	        }
	        
	        if (!isValueValid(event)) {
	            textField.cancelKey();
	        }
	    }
	};

	@Override
	protected void extend(ServerConnector target) {
		
	    textField = (VTextField) ((ComponentConnector) target).getWidget();
	    textField.addKeyPressHandler(keyPressHandler);
	}
	
	private boolean isValueValid(KeyPressEvent event) {
	    String newText = getFieldValueAfterKeyPress(event.getCharCode());
    	if(newText.matches(getState().getPattern())) {
    		return true;
    	}
        
        return false;
	}
	
	private String getFieldValueAfterKeyPress(char charCode) {
	    int index = textField.getCursorPos();
	    String previousText = textField.getText();
	    StringBuffer buffer = new StringBuffer();
	    buffer.append(previousText.substring(0, index));
	    buffer.append(charCode);
	    if (textField.getSelectionLength() > 0) {
	        buffer.append(previousText.substring(index + textField.getSelectionLength(),
	                previousText.length()));
	    } else {
	        buffer.append(previousText.substring(index, previousText.length()));
	    }
	    return buffer.toString();
	}
	
	@Override
	public RegexFieldExtensionState getState() {
	    return (RegexFieldExtensionState) super.getState();
	}
}
