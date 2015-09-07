package fi.utu.ville.standardutils.client;

import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

import fi.utu.ville.standardutils.ui.RegexFieldExtension;

@Connect(RegexFieldExtension.class)
public class RegexFieldExtensionConnector extends AbstractExtensionConnector implements PasteHandler {

	private static final long serialVersionUID = -2732210610021560697L;
            
	private VVilleTextField textField;
	private KeyPressHandler keyPressHandler = new KeyPressHandler() {
	    @Override
	    public void onKeyPress(KeyPressEvent event) {
	        if (textField.isReadOnly() || !textField.isEnabled()) {
	            return;
	        }
	        int keyCode = event.getCharCode();
	        
	        if(keyCode == 0) { // Control keys seem pretty reliably to have charCode value of 0, 
	        	return;		   // but very unreliably to map to correct KeyCodes.
	        }

	        if (!isValueValid(event)) {
	            textField.cancelKey();
	        }
	    }
	};
	

	@Override
	protected void extend(ServerConnector target) {
	    textField = (VVilleTextField) ((ComponentConnector) target).getWidget();
	    textField.addKeyPressHandler(keyPressHandler);
//	    textField.addChangeListener(listener);
	    textField.setImmediate(true);
	    
	    textField.addPasteEventHandler(this);
	    textField.setFireValueChangeOnPaste(true);
	    
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

				String text = textField.getValue();

				switch(event.getNativeKeyCode()) {
				case KeyCodes.KEY_BACKSPACE: 
					// This allows the field to enter into invalid state if the cursor is positioned at the end
					if(textField.getCursorPos() == text.length()) {
						return;
					}
					String newText = getFieldValueAfterKeyPress('\b');
					if(!newText.matches(getState().getPattern())) {
						textField.cancelKey();
					}
					break;
				case KeyCodes.KEY_UP:
					if(getState().isArrowStepper()) {
						step(true);
						textField.cancelKey();
					}
					break;
				case KeyCodes.KEY_DOWN:
					if(getState().isArrowStepper()) {
						step(false);
						textField.cancelKey();
					}
					break;
				}
			}
		});
	}
	
	/**
	 * Increment/decrement field's value by 1.
	 * @param up
	 * 		Increment if true, decrement otherwise
	 */
	private void step(boolean up) {
		String text = textField.getValue();
		String[] defaults = {"0", "1", "-1"};
		if (text.matches("^-?\\d+$")) {
			if (up) {
				text = (Integer.parseInt(text) + 1) + "";
			} else {
				text = (Integer.parseInt(text) - 1) + "";
			}
		} else {
			for (String s : defaults) {
				if (s.matches(getState().getPattern())) {
					text = s;
					break;
				}
			}
		}
		
		if (text.matches(getState().getPattern())) {
			textField.setValue(text);
		}
	}
	
	private boolean isValueValid(KeyPressEvent event) {
	    String newText = getFieldValueAfterKeyPress(event.getCharCode());
    	if(newText.matches(getState().getPattern())) {
    		return true;
    	}
        
        return false;
	}
	
	private String getFieldValueAfterKeyPress(char charCode) {
		return getFieldValueAfterKeyPress(textField, charCode);
	}
	
	public static String getFieldValueAfterKeyPress(VVilleTextField textField, char charCode) {
		return getFieldValueAfterKeyPress(textField.getText(), textField.getCursorPos(), textField.getSelectionLength(), charCode);
	}
	
	
	public static String getFieldValueAfterKeyPress(String previousText, int cursorPos, int selectionLength, char charCode) {
		StringBuffer buffer = new StringBuffer();
		buffer.append(previousText.substring(0, cursorPos));
		
		
		if (selectionLength > 0) {
			if(charCode != '\b') // handle backspace
				buffer.append(charCode);
			buffer.append(previousText.substring(cursorPos + selectionLength,
					previousText.length()));
		} else {
			if(charCode != '\b')  // handle backspace
				buffer.append(charCode);
			else
				buffer.deleteCharAt(buffer.length()-1);
			buffer.append(previousText.substring(cursorPos, previousText.length()));
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
