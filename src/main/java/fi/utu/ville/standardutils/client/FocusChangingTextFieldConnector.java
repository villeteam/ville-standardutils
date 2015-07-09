package fi.utu.ville.standardutils.client;



import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.FocusEvent;
import com.google.gwt.event.dom.client.FocusHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.ui.FocusWidget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.ui.Connect;

import fi.utu.ville.standardutils.ui.FocusChangingTextFieldExtension;

@Connect(FocusChangingTextFieldExtension.class)
public class FocusChangingTextFieldConnector extends AbstractExtensionConnector {

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

	        int text = textField.getText().length();
	        int sel = textField.getSelectedText().length();
	        if(getState().getCharsToMoveToPrevious().indexOf(event.getCharCode()) >= 0) {
	        	if(getPreviousComponent() != null) {
	        		if(getPreviousComponent() instanceof VVilleTextField) {
	        			VVilleTextField previous = (VVilleTextField)getPreviousComponent();
	        			if(previous.getMaxLength() != previous.getText().length()) {
	        				previous.setText(event.getCharCode() + previous.getText());
	        			}
	        			textField.cancelKey();
	        		}
	        	}
	        }
	        else if((text == getState().getChangeAfter()-1 && sel == 0) || (text == getState().getChangeAfter() && sel <= 1)) {
	        	String textAfter = RegexFieldExtensionConnector.getFieldValueAfterKeyPress(textField, event.getCharCode());
	        	if(textAfter.length() > getState().getChangeAfter())
	        		textField.cancelKey();
		        
		        focusAndSelect(getNextComponent());
	        }
	    }
	};
	

	@Override
	protected void extend(ServerConnector target) {
	    textField = (VVilleTextField) ((ComponentConnector) target).getWidget();
	    textField.addKeyPressHandler(keyPressHandler);
//	    textField.addChangeListener(listener);
	    textField.setImmediate(true);
	    textField.setFireValueChangeOnPaste(true);
	    textField.addFocusHandler(new FocusHandler() {
			
			@Override
			public void onFocus(FocusEvent event) {
				textField.setSelectionRange(0, textField.getText().length());
			}
		});
	    ValueChangeHandler<String> handler = new ValueChangeHandler<String>() {
			
			@Override
			public void onValueChange(ValueChangeEvent<String> event) {


			}

		};
		textField.addValueChangeHandler(handler);
		textField.addKeyDownHandler(new KeyDownHandler() {
			
			@Override
			public void onKeyDown(KeyDownEvent event) {

				if(event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					if(textField.getCursorPos() == 0) {
						focusAndSelect(getPreviousComponent());
					}
				}
				
				if(event.getNativeKeyCode() == KeyCodes.KEY_RIGHT) {
					if(textField.getCursorPos() == textField.getText().length()) {
						focusAndSelect(getNextComponentImpl());
					}
				}
				if(event.getNativeKeyCode() == KeyCodes.KEY_LEFT) {
					if(textField.getCursorPos() == 0) {
						focusAndSelect(getPreviousComponentImpl());
					}
				}
				if(event.getNativeKeyCode() == KeyCodes.KEY_DOWN) {
					focusAndSelect(getDownComponent());
				}
				if(event.getNativeKeyCode() == KeyCodes.KEY_UP) {
					focusAndSelect(getUpComponent());
				}
			}
		});
	}

	private FocusWidget getNextComponent() {
		if(getState().isReversed()) {
			return getPreviousComponentImpl();
		}
		return getNextComponent();
	}
	
	private FocusWidget getPreviousComponent() {
		if(getState().isReversed()) {
			return getNextComponentImpl();
		}
		return getPreviousComponent();
	}
	
	private FocusWidget getNextComponentImpl() {
		return ((FocusWidget)((ComponentConnector)getState().getNextComponent()).getWidget());
	}
	
	private FocusWidget getPreviousComponentImpl() {
		return ((FocusWidget)((ComponentConnector)getState().getPreviousComponent()).getWidget());
	}
	
	private FocusWidget getUpComponent() {
		return ((FocusWidget)((ComponentConnector)getState().getUpComponent()).getWidget());
	}
	
	private FocusWidget getDownComponent() {
		return ((FocusWidget)((ComponentConnector)getState().getDownComponent()).getWidget());
	}
	
	private void focusAndSelect(final FocusWidget widget) {
		if(widget == null) {
			return;
		}
	    Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand () {
	        public void execute () {
	        	widget.setFocus(true);
	    		if(widget instanceof VVilleTextField) {
	    			VVilleTextField field = ((VVilleTextField)widget);
	    			field.setSelectionRange(0, field.getText().length());
	    		}
	        }
	    });
//		widget.setFocus(true);

	}
	
	@Override
	public FocusChangingTextFieldState getState() {
		return (FocusChangingTextFieldState) super.getState();
	}

}
