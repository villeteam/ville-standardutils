package fi.utu.ville.standardutils.client;



import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.VConsole;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.VTextArea;
import com.vaadin.shared.ui.Connect;

import fi.utu.ville.standardutils.ui.RegexAreaExtension;
import fi.utu.ville.standardutils.ui.RegexFieldExtension;


// TODO: This is currently pretty much copy paste from RegexField. Combine them if time available > 0.
// TODO: Doesn't support pasting.
@Connect(RegexAreaExtension.class)
public class RegexAreaExtensionConnector extends AbstractExtensionConnector implements PasteHandler {

	private static final long serialVersionUID = -2732210610021560697L;
            
	private VTextArea textField;
	private KeyPressHandler keyPressHandler = new KeyPressHandler() {
	    @Override
	    public void onKeyPress(KeyPressEvent event) {
	        if (textField.isReadOnly() || !textField.isEnabled()) {
	            return;
	        }
	        int keyCode = event.getCharCode();
	        
	        
	        if(keyCode == 0) { // Control keys seem pretty reliably to have charCode value of 0, 
	        	
	        	return;		   // but very unreliably to map to correct KeyCodes. (below)
	        }

//	        }
	        if (!isValueValid(event)) {
	            textField.cancelKey();
	        }
	    }
	};
	

	@Override
	protected void extend(ServerConnector target) {
	    textField = (VTextArea) ((ComponentConnector) target).getWidget();
	    textField.addKeyPressHandler(keyPressHandler);
//	    textField.addChangeListener(listener);
	    textField.setImmediate(true);
	    
	    ValueChangeHandler<String> handler = new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {
				
				String text = textField.getValue();
				int newCursorPos = textField.getCursorPos();
				for(int i = textField.getCursorPos()-1; i >= 0; i--) {
					if(!text.matches(getState().getPattern())) {
						text = text.substring(0, i) + text.substring(i+1);
						newCursorPos--;
					}
				}
				if(!text.matches(getState().getPattern())) { 
					// making sure browsers that don't process keyPresses remove invalid content
					text = "";
					newCursorPos = 0;
				}
				
				if(textField.getValue() != text) {
					textField.setValue(text);
				}
				textField.setCursorPos(newCursorPos);

			}

		};
		textField.addValueChangeHandler(handler);
		textField.addKeyDownHandler(new KeyDownHandler() {
			
			@Override
			public void onKeyDown(KeyDownEvent event) {

				if(event.getNativeKeyCode() == 8) {
					String newText = getFieldValueAfterKeyPress('\b');
					if(!newText.matches(getState().getPattern())) {
						textField.cancelKey();
					}
					
				}
			}
		});
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
		
		
		if (textField.getSelectionLength() > 0) {
			if(charCode != '\b')
				buffer.append(charCode);
			buffer.append(previousText.substring(index + textField.getSelectionLength(),
					previousText.length()));
		} else {
			if(charCode != '\b')
				buffer.append(charCode);
			else
				buffer.deleteCharAt(buffer.length()-1);
			buffer.append(previousText.substring(index, previousText.length()));
		}
		return buffer.toString();
	}
	
	@Override
	public RegexFieldExtensionState getState() {
		return (RegexFieldExtensionState) super.getState();
	}

	@Override
	public void onPaste(PasteEvent event) {
	}
}
