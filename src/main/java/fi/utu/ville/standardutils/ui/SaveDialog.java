package fi.utu.ville.standardutils.ui;

import java.util.HashSet;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import fi.utu.ville.standardutils.Localizer;
import fi.utu.ville.standardutils.StandardIcon.Icon;
import fi.utu.ville.standardutils.StandardUIConstants;
import fi.utu.ville.standardutils.StandardUIFactory;

public class SaveDialog extends Window {

	private static final long serialVersionUID = 5507789226291905179L;

	private boolean ok;

	private final Localizer mainServer;

	private final Component content;

	private Button saveButton, cancelButton;

	private final HashSet<OkValidator> validators = new HashSet<OkValidator>();

	public SaveDialog(String caption, Component content, Localizer mainServer) {

		setCaption(caption);
		this.mainServer = mainServer;
		this.content = content;
		init();
	}

	public void init() {

		setModal(true);

		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);
		layout.setSizeUndefined();

		layout.addComponent(content);

		saveButton = StandardUIFactory.getButton(
				mainServer.getUIText(StandardUIConstants.SAVE), Icon.SAVE);
		saveButton.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = 6733002983063367991L;

			@Override
			public void buttonClick(ClickEvent event) {
				// close only if state is valid
				if (testValidators()) {
					ok = true;
					close();
				}
			}
		});

		cancelButton = StandardUIFactory.getButton(
				mainServer.getUIText(StandardUIConstants.CANCEL), Icon.DELETE);
		cancelButton.addClickListener(new Button.ClickListener() {

			private static final long serialVersionUID = 6837211321471486909L;

			@Override
			public void buttonClick(ClickEvent event) {
				close();
			}
		});

		HorizontalLayout hlay = new HorizontalLayout();
		hlay.setSpacing(true);
		hlay.addComponent(saveButton);
		hlay.addComponent(cancelButton);

		layout.addComponent(hlay);

		layout.setComponentAlignment(hlay, Alignment.BOTTOM_CENTER);

		setContent(layout);

	}

	public boolean isOk() {
		return ok;
	}

	public void enableSaveButton(boolean enabled) {
		saveButton.setEnabled(enabled);
	}

	public void setButtonsVisible(boolean visible) {
		saveButton.setVisible(visible);
		cancelButton.setVisible(visible);
	}

	public Button getSaveButton() {
		return saveButton;
	}

	public void registerValidator(OkValidator toReg) {
		validators.add(toReg);
	}

	public void removeValidator(OkValidator toRem) {
		validators.remove(toRem);
	}

	private boolean testValidators() {

		for (OkValidator aValidator : validators) {
			if (!aValidator.testValidness()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This interface allows adding validity tests to sequence that must all
	 * return true before OK-button is registered as 'ok'. Validators are run on
	 * click to 'ok' and if one validator fails validity-test is ended and the
	 * dialog is left open.
	 */
	public interface OkValidator {

		/**
		 * Test for validness. If the state is not valid some notification
		 * should be shown to the user (either in the tested component, or as a
		 * notification) and false returned. Validity test is stopped on first
		 * validness-fail.
		 * 
		 * @return false if the state of the component shown in dialog is not
		 *         valid
		 */
		boolean testValidness();

	}

}
