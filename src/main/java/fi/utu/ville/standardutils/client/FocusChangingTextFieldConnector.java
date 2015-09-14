package fi.utu.ville.standardutils.client;

import java.util.Map;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.FocusWidget;
import com.vaadin.client.ComponentConnector;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.shared.Connector;
import com.vaadin.shared.communication.SharedState;
import com.vaadin.shared.ui.Connect;

import fi.utu.ville.standardutils.client.FocusLogic.FocusAction;
import fi.utu.ville.standardutils.ui.FocusChangingTextFieldExtension;

/**
 * GWT doesn't support Java 8 yet, so this simple thing has to be done via an
 * interface
 **/
interface StateProvider {
	SharedState getState();
}

@Connect(FocusChangingTextFieldExtension.class)
public class FocusChangingTextFieldConnector extends AbstractExtensionConnector
		implements StateProvider {

	public enum Direction {
		UP, RIGHT, DOWN, LEFT, THIS;

		public static Direction keycodeToDirection(int code) {
			switch (code) {
			case KeyCodes.KEY_UP:
				return UP;
			case KeyCodes.KEY_RIGHT:
				return RIGHT;
			case KeyCodes.KEY_DOWN:
				return DOWN;
			case KeyCodes.KEY_LEFT:
				return LEFT;
			}
			return THIS;
		}

		public static Direction invert(Direction dir) {
			switch (dir) {
			case UP:
				return DOWN;
			case DOWN:
				return UP;
			case LEFT:
				return RIGHT;
			case RIGHT:
				return LEFT;
			default:
				return THIS;
			}
		}
	}

	public static class StateHelper {
		public FocusChangingTextFieldState getState() {
			return (FocusChangingTextFieldState) state.getState();
		}

		public ComponentConnector getThisComponent() {
			return thisComponent;
		}

		final ComponentConnector thisComponent;
		final StateProvider state;

		public StateHelper(StateProvider state, ComponentConnector thisComponent) {
			this.thisComponent = thisComponent;
			this.state = state;
		}

		public VVilleTextField getComponentAtDirection(Direction direction) {
			Connector connector = null;
			FocusChangingTextFieldState state = getState();
			switch (direction) {
			case UP:
				connector = state.getUpComponent();
				break;
			case RIGHT:
				connector = state.getRightComponent();
				break;
			case DOWN:
				connector = state.getDownComponent();
				break;
			case LEFT:
				connector = state.getLeftComponent();
				break;
			case THIS:
				connector = thisComponent;
			}
			if (connector != null) {
				return (VVilleTextField) ((ComponentConnector) connector)
						.getWidget();
			}
			return null;
		}

		public boolean hasComponentAtDirection(Direction direction) {
			FocusChangingTextFieldState state = getState();
			switch (direction) {
			case UP:
				return state.hasUpComponent();
			case DOWN:
				return state.hasDownComponent();
			case LEFT:
				return state.hasLeftComponent();
			case RIGHT:
				return state.hasRightComponent();
			default:
				return true;
			}
		}

		public String getTextAt(Direction direction) {
			VVilleTextField field = getComponentAtDirection(direction);
			if (field == null) {
				return null;
			}
			return field.getText();
		}
	}

	private static final long serialVersionUID = -2732210610021560697L;
	private FocusLogic logic;
	private VVilleTextField textField;
	private StateHelper state;
	// private Logger log = Logger.getLogger("Focus");

	private KeyPressHandler keyPressHandler = new KeyPressHandler() {
		@SuppressWarnings("unused")
		@Override
		public void onKeyPress(KeyPressEvent event) {

			if (textField.isReadOnly() || !textField.isEnabled()) {
				return;
			}
			int keyCode = event.getCharCode();

			if (keyCode == 0) { // Control keys seem pretty reliably to have
								// charCode value of 0,
				return; // but very unreliably to map to correct KeyCodes.
			}

			int textLength = textField.getText().length();
			int cursorPos = textField.getCursorPos();
			int selectionLength = textField.getSelectedText().length();
			char charCode = event.getCharCode();
			String oldText = textField.getText();
			String newText = RegexFieldExtensionConnector
					.getFieldValueAfterKeyPress(textField, charCode);

			boolean isFull = newText.length() >= getState().getChangeAfter();

			// log.log(Level.SEVERE, "Keypress: " + oldText + "," + newText +
			// "," + charCode + "," + cursorPos + "," + selectionLength + "," +
			// isFull);

			FocusAction focusAction = logic.keyPress(oldText, newText,
					charCode, cursorPos, selectionLength, isFull);
			// log.log(Level.SEVERE, "FocusAction: " + focusAction.toString());
			executeAction(focusAction);
		}
	};

	@Override
	protected void extend(ServerConnector target) {
		textField = (VVilleTextField) ((ComponentConnector) target).getWidget();
		textField.setConnector(this);
		textField.addKeyPressHandler(keyPressHandler);
		// textField.addChangeListener(listener);
		textField.setImmediate(true);
		textField.setFireValueChangeOnPaste(true);
		state = new StateHelper(this, (ComponentConnector) target);
		this.logic = getState().getFocusLogic().create(state);
		// if(logic.isReversed()) {
		// textField.setDirection(com.google.gwt.i18n.client.HasDirection.Direction.RTL);
		// }
		textField.addKeyDownHandler(new KeyDownHandler() {

			@Override
			public void onKeyDown(KeyDownEvent event) {

				if (event.getNativeKeyCode() == KeyCodes.KEY_BACKSPACE) {
					FocusAction action = logic.backspacePress(textField
							.getText(), RegexFieldExtensionConnector
							.getFieldValueAfterKeyPress(textField, '\b'),
							textField.getCursorPos(), textField
									.getSelectionLength());
					executeAction(action);
				}

				Direction arrowDirection = Direction.keycodeToDirection(event
						.getNativeKeyCode());
				if (arrowDirection != Direction.THIS) {
					FocusAction action = logic.arrowPress(arrowDirection,
							textField.getCursorPos(), textField.getText());
					executeAction(action);

				}
			}

		});
	}

	@OnStateChange("focusLogic")
	private void updateFocusLogic() {
		if (state != null)
			this.logic = getState().getFocusLogic().create(state);
	}

	private void executeAction(FocusAction focusAction) {
		if (focusAction.hasTextChangeCommands()) {
			for (Map.Entry<Direction, String> textChange : focusAction
					.getTextChangeCommands().entrySet()) {
				VVilleTextField field = state
						.getComponentAtDirection(textChange.getKey());
				if (field != null) {
					field.cancelKey();
					if (!field.getText().equals(textChange.getValue())) {
						field.setText(textChange.getValue());
					}
				}

			}
		}
		focusAndSelect(focusAction);

	}

	private void focusAndSelect(final FocusAction focusAction) {
		final FocusWidget widget = state.getComponentAtDirection(focusAction
				.getDirection());
		if (widget == null) {
			return;
		}
		Scheduler.get().scheduleDeferred(new Scheduler.ScheduledCommand() {
			public void execute() {
				if (focusAction.getDirection() != Direction.THIS) {
					widget.setFocus(true);
				}

				if (widget instanceof VVilleTextField) {
					VVilleTextField field = ((VVilleTextField) widget);
					((FocusChangingTextFieldConnector) field.getConnector()).state
							.getState().setIncomeDirection(
									focusAction.getDirection());
					if (field.getText().length() > 0) {

						int cursorPos = focusAction.getActualCursorPos(field
								.getText());
						if (focusAction.hasChangeCursorPos()) {
							// log.log(Level.SEVERE, "Changing cursor pos");
							if (cursorPos >= 0) {
								field.setCursorPos(cursorPos);
							}

						}
						if (focusAction.hasSelectionLength()) {
							// log.log(Level.SEVERE, "Changing selection");
							cursorPos = Math.max(0, cursorPos);
							field.setSelectionRange(cursorPos, focusAction
									.getActualSelectionLength(cursorPos,
											field.getText()));
						}
					}
				}
			}
		});

	}

	@Override
	public FocusChangingTextFieldState getState() {
		return (FocusChangingTextFieldState) super.getState();
	}

}
