package fi.utu.ville.standardutils.client;

import fi.utu.ville.standardutils.client.FocusChangingTextFieldConnector.Direction;
import fi.utu.ville.standardutils.client.FocusChangingTextFieldConnector.StateHelper;

public class CrosswordLogic extends FocusLogic {

	public CrosswordLogic(StateHelper state) {
		super(state);
	}

	@Override
	public FocusAction keyPress(String oldText, String newText, char newChar,
			int cursorPosition, int selectionLength, boolean fieldFull) {
		FocusAction action = new FocusAction();
		action.setText(Direction.THIS, newChar + "");
		action.setSelectionFull();

		Direction dir = state.getState().getIncomeDirection();
		if (dir == null || dir == Direction.THIS
				|| !state.hasComponentAtDirection(dir)) {
			if ((!state.hasComponentAtDirection(Direction.RIGHT) || !state
					.getComponentAtDirection(Direction.RIGHT).getValue()
					.equals(""))
					&& state.hasComponentAtDirection(Direction.DOWN)) {
				dir = Direction.DOWN;
			} else if (state.hasComponentAtDirection(Direction.RIGHT)) {
				dir = Direction.RIGHT;
			}
		}
		// Avoid typing to the wrong direction after backspace
		if (dir == Direction.LEFT || dir == Direction.UP) {
			dir = Direction.invert(dir);
		}
		action.setDirection(dir);

		return action;
	}

	@Override
	public FocusAction backspacePress(String oldText, String newText,
			int cursorPosition, int selectionLength) {
		FocusAction action = new FocusAction();

		Direction dir = Direction.invert(state.getState().getIncomeDirection());
		if (dir == Direction.RIGHT) {
			dir = Direction.LEFT;
		}
		if (dir == Direction.DOWN) {
			dir = Direction.UP;
		}
		action.setText(Direction.THIS, "");
		action.setDirection(dir);
		action.setSelectionFull();

		return action;
	}

}
