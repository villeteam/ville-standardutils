package fi.utu.ville.standardutils.client;

import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.UIDL;
import com.vaadin.client.ui.textarea.TextAreaConnector;
import com.vaadin.shared.ui.Connect;

import fi.utu.ville.standardutils.ui.NonSpellcheckingTextArea;


@Connect(NonSpellcheckingTextArea.class)
public class SpellcheckingTextAreaConnector extends TextAreaConnector {

	private static final long serialVersionUID = 1L;

	@Override
	public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
		super.updateFromUIDL(uidl, client);

		getWidget().getElement().setAttribute("spellcheck", "false");

	}
}
