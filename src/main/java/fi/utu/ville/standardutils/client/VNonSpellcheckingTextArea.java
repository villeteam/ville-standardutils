package fi.utu.ville.standardutils.client;

import com.vaadin.client.ui.VTextArea;

/**
 * Client side widget which communicates with the server. Messages from the
 * server are shown as HTML and mouse clicks are sent to the server.
 */

public class VNonSpellcheckingTextArea extends VTextArea {

	/**
	 * Constructs an empty TextArea.
	 */
	public VNonSpellcheckingTextArea() {
		super();
		this.getElement().setAttribute("spellcheck", "false");
	}

}
