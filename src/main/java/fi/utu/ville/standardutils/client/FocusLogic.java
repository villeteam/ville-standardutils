package fi.utu.ville.standardutils.client;

import java.util.HashMap;

import fi.utu.ville.standardutils.client.FocusChangingTextFieldConnector.Direction;
import fi.utu.ville.standardutils.client.FocusChangingTextFieldConnector.StateHelper;

public class FocusLogic {
	final protected StateHelper state;
	
	/***
	 * Order:
	 * Set all text changes in the order they were specified
	 * Set focus
	 * Set cursor position
	 * Set selection
	 * @author almale
	 *
	 */
	public static class FocusAction {
		
		public static final FocusAction DO_NOTHING = new FocusAction(Direction.THIS);
		
		@Override
		public String toString() {
			return "FocusAction [direction=" + direction + ", cursorPos=" + cursorPos + ", setText=" + setText
					+ ", selectionLength=" + selectionLength + "]";
		}

		Direction direction;
		private int cursorPos = -1;
		private HashMap<Direction, String> setText;
		private int selectionLength = -1;
		public FocusAction(Direction direction) {
			this.direction = direction;
		}
		
		public FocusAction() {
			this.direction = Direction.THIS;
		}
		
		public int getActualCursorPos(String text) {
			return Math.min(cursorPos, text.length());
		}

		public void setCursorPos(int cursorPos) {
			this.cursorPos = cursorPos;
		}

		public Direction getDirection() {
			return direction;
		}
		
		public void setDirection(Direction direction) {
			this.direction = direction;
		}

		public boolean hasSelectionLength() {
			return selectionLength >= 0;
		}
		
		public int getSelectionLength() {
			return selectionLength;
		}

		/**
		 * Sets the cursor position in focus target (which may be current field)
		 */
		public void setCursorPosition(int cursorPos) {
			this.cursorPos = cursorPos;
		}
		
		public boolean hasChangeCursorPos() {
			return cursorPos != -1;
		}
		
		/**
		 * Not calling setText does not mean that text is not set, it merely cancels the native behavior and overrides it
		 * with a new call.
		 * @param where
		 * @param toText
		 */
		public void setText(Direction where, String toText) {
			if(setText == null) {
				setText = new HashMap<>();
			}
			setText.put(where, toText);
		}
		
		public boolean hasTextChangeCommands() {
			return setText != null;
		}
		
		public HashMap<Direction, String> getTextChangeCommands() {
			return setText;
		}
		
		public void setSelectionLength(int selectionLength) {
			this.selectionLength = selectionLength;
		}

		public void setSelectionFull() {
			this.selectionLength = Integer.MAX_VALUE;
		}
		
		public boolean hasSelectionFull() {
			return this.selectionLength == Integer.MAX_VALUE;
		}

		public int getActualSelectionLength(int cursorPos, String text) {
			return Math.min(text.length()-cursorPos, selectionLength);
		}
		
		
	}

	public FocusLogic(StateHelper state) {
		this.state = state;
	}
	
	public FocusAction keyPress(String oldText, String newText, char newChar, int cursorPosition, int selectionLength, boolean fieldFull) {
		FocusAction action;
		if(newText.length() >= state.getState().getChangeAfter()) {
			action = new FocusAction(isReversed() ? Direction.LEFT : Direction.RIGHT);
			action.setSelectionFull();
			if(newText.length() > state.getState().getChangeAfter()) {
				action.setText(Direction.THIS, oldText);
			}
		}
		else {
			action = new FocusAction(Direction.THIS);
		}
		return action;
	}
	
	public boolean isReversed() {
		return false;
	}
	
	/**
	 * Return true if you want to handle setting new textfield values. Otherwise it is done automatically.
	 * @return
	 */
	public boolean handlesInput() {
		return false;
	}
	
	public FocusAction arrowPress(Direction direction, int cursorPos, String curText) {
		FocusAction action = new FocusAction(Direction.THIS);
		if(direction == Direction.DOWN || direction == Direction.UP) {
			action =  new FocusAction(direction);
			action.setSelectionFull();
		}
		else {
			int rightLimit = curText.length();
			int leftLimit = 0;

			Direction leftDir = Direction.LEFT;
			if((direction != leftDir && rightLimit == cursorPos) ||
					(direction == leftDir && cursorPos == leftLimit)) {
				action.setDirection(direction);
				action.setSelectionFull();

			}
		}
		return action;
	}
	
	public FocusAction backspacePress(String oldText, String newText, int cursorPosition, int selectionLength) {
		FocusAction action;
		if(cursorPosition == 0) {
			action = new FocusAction(isReversed() ? Direction.RIGHT : Direction.LEFT);
			action.setSelectionFull();
		}
		else {
			action = FocusAction.DO_NOTHING;
		}
		return action;
	}

	public void onFocus(StateHelper fromState) {
		
	}
	
}