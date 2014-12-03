package fi.utu.ville.standardutils.client;

import com.google.gwt.user.client.Event;

public class PasteEvent {

	private final Event event;
	
	public PasteEvent(Event event) {
		this.event = event;
	}
	
	public Event getEvent() {
		return event;
	}
}