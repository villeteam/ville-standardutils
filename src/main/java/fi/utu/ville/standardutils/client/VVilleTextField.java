package fi.utu.ville.standardutils.client;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.user.client.Event;
import com.vaadin.client.ui.VTextField;

public class VVilleTextField extends VTextField {
	
	private PasteHandler pasteHandler = null;
	private boolean fireValueChangeOnPaste = false;
	
	public VVilleTextField() {
		super();
		sinkEvents(Event.ONPASTE);
	}
	
    @Override
    public void onBrowserEvent(Event event) {
    	super.onBrowserEvent(event);
    	switch(event.getTypeInt()) {
	    	case Event.ONPASTE: {
	    		if(pasteHandler != null) {
	    			pasteHandler.onPaste(new PasteEvent(event));
	    		}
	    		if(fireValueChangeOnPaste) {
		    		Scheduler.get().scheduleDeferred(new ScheduledCommand() {
	
	                    @Override
	                    public void execute() {
	                        ValueChangeEvent.fire(VVilleTextField.this, getText());
	                    }
	                });
	    		}
	    		break;
	    	}
	    	default: {
	    	}
    	}
    }
    
    public void setFireValueChangeOnPaste(boolean value) {
    	this.fireValueChangeOnPaste = value;
    }
    
    public void addPasteEventHandler(PasteHandler handler) {
    	pasteHandler = handler;
    }
    
	
}
