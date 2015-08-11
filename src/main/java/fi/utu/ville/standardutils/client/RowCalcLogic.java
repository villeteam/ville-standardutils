package fi.utu.ville.standardutils.client;

import fi.utu.ville.standardutils.client.FocusChangingTextFieldConnector.Direction;
import fi.utu.ville.standardutils.client.FocusChangingTextFieldConnector.StateHelper;

public class RowCalcLogic extends FocusLogic {
	private static final String DELIMS = ",.";
	
	public RowCalcLogic(StateHelper state) {
		super(state);
	}

	@Override
	public FocusAction keyPress(String oldText, String newText, char newChar, int cursorPosition, int selectionLength,
			boolean fieldFull) {
		FocusAction action = new FocusAction();
		if(DELIMS.indexOf(newChar) >= 0) {
			
			// Handles cases where the comma is inserted in this field
			// Simply write the comma right here, and set the cursor position to the left of it
			// [] or [2|] -> [|,] or [2|,]
			if(oldText.length() == 0 
					|| (cursorPosition == 1 && oldText.length() == 1 && Character.isDigit(oldText.charAt(0)))) {
				action.setText(Direction.THIS, newText);
				action.setCursorPos(cursorPosition);
				return action;
			}
			
			// Handles cases where the comma is inserted to the left field
			String leftText = state.getTextAt(Direction.LEFT);
			// [*][|2]
			if(leftText != null && oldText.length() == 1) { 
				//[][|2] or [2][|2]
				if(leftText.length() == 0 || (leftText.length() == 1 && Character.isDigit(leftText.charAt(0)))) {
					action.setText(Direction.LEFT, leftText + newChar);
					action.setText(Direction.THIS, oldText);
					action.setDirection(Direction.LEFT);
					action.setCursorPos(0);
					return action;
				}
				
			}
			action.setText(Direction.THIS, oldText);
			action.setCursorPos(cursorPosition);
			return action;
		}
		else if(Character.isDigit(newChar)) {
			// [,|] or [|,]
			if(DELIMS.indexOf(oldText.charAt(0)) >= 0) {
				// [|,]
				if(cursorPosition == 0) {
					action.setText(Direction.THIS, newText);
					action.setDirection(Direction.LEFT);
					selectOne(action);
					return action;
				}
				// [,|]
				else {
					String leftText = state.getTextAt(Direction.LEFT);
					//[][,|] or //[2][,|]
					if(leftText != null && (leftText.length() == 0 || (leftText.length() == 1 && Character.isDigit(leftText.charAt(0))))) {
						action.setText(Direction.THIS, "" + newChar);
						action.setText(Direction.LEFT, leftText + oldText);
					}
					else {
						action.setText(Direction.THIS, oldText);
					}
				}
				return action;
			} else {
				action.setDirection(Direction.LEFT);
				if(newText.length() == 1) {
					action.setText(Direction.THIS, newText);
				}
				selectOne(action);
				return action;
			}
		}
		else {
			action.setText(Direction.THIS, oldText);
//			action.setCursorPos(cursorPosition);
			return action;
		}

	}
	
	private void selectOne(FocusAction action) {
		if(state.getComponentAtDirection(action.getDirection()) == null) {
			action.setDirection(Direction.THIS);
		}
		String text = state.getTextAt(action.getDirection());
		if(text.length() > 0) {
			action.setCursorPos(text.length()-1);
			action.setSelectionLength(1);
		}
		
	}
	
	
	@Override
	public boolean isReversed() {
		return true;
	}
	
	@Override
	public FocusAction backspacePress(String oldText, String newText, int cursorPosition, int selectionLength) {
		FocusAction action = new FocusAction();
		if(cursorPosition == oldText.length()) {
			action.setDirection(Direction.RIGHT);
			action.setText(Direction.THIS, oldText);
			action.setCursorPos(0);
		}
		else {
			action.setText(Direction.THIS, 
					RegexFieldExtensionConnector.getFieldValueAfterKeyPress(
							new StringBuffer(oldText).reverse().toString()
							, oldText.length()-cursorPosition, selectionLength, '\b'));
			action.setCursorPos(cursorPosition);
		}
		return action;
	}

	@Override
	public FocusAction arrowPress(Direction direction, int cursorPos, String curText) {
		FocusAction action =  super.arrowPress(direction, cursorPos, curText);
		action.setSelectionLength(-1);
		if(action.getDirection() == Direction.RIGHT) {
			action.setCursorPos(0);
		}
		if(action.getDirection() == Direction.LEFT) {
			action.setCursorPos(999);
		}
		return action;
	}
	
	
}
