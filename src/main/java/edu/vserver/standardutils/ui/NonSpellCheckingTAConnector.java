package edu.vserver.standardutils.ui;

import com.vaadin.client.ui.textfield.TextFieldConnector;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.textarea.TextAreaState;

@Connect(NonSpellcheckingTextArea.class)
public class NonSpellCheckingTAConnector extends TextFieldConnector {

	// TODO FIXME does this work (was changed from 6 to 7)

	/**
	 * 
	 */
	private static final long serialVersionUID = -6094322100455974478L;

	@Override
	public TextAreaState getState() {
		return (TextAreaState) super.getState();
	}

	@Override
	public VNonSpellcheckingTextArea getWidget() {
		return (VNonSpellcheckingTextArea) super.getWidget();
	}
}
