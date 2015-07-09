package fi.utu.ville.standardutils.ui;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

import fi.utu.ville.standardutils.client.FocusChangingTextFieldState;


public class FocusChangingTextFieldExtension extends AbstractExtension {

	private static final long serialVersionUID = 8986814555711778351L;
	
	public static FocusChangingTextFieldExtension[] extend(int changeAfter, TextField ... fields) {
		return extend(changeAfter, (String)null, fields);
	}
	
	public static FocusChangingTextFieldExtension[] extend(int changeAfter, String charsToMoveToPrevious, TextField ... fields) {
		FocusChangingTextFieldExtension[] extensions = new FocusChangingTextFieldExtension[fields.length];
		
		for(int i = 0; i < fields.length; i++) {
			int prev = i == 0 ? fields.length-1 : i-1;
			extensions[i] = extend(fields[i], fields[(i+1) % fields.length], fields[prev], changeAfter, charsToMoveToPrevious);
		}
		return extensions;
	}

	/**
	 * 
	 * @param changeAfter
	 * @param fields where 0,0 is the top left corner, x coordinate (column) is the first coordinate and y the second (row)
	 * @return
	 */
	public static FocusChangingTextFieldExtension[][] extend(int changeAfter, TextField[][] fields) {
		if(fields.length == 0) {
			return null;
		}
		FocusChangingTextFieldExtension[][] extensions = new FocusChangingTextFieldExtension[fields.length]
				[fields[0].length];
		for(int x = 0; x < fields.length; x++) {
			for(int y = 0; y < fields[0].length; y++) {
				if(fields[x][y] == null) {
					continue;
				}
				int prevX = x == 0 ? fields.length-1 : x-1;
				
				int prevY = y == 0 ? fields[0].length-1 : y-1;
				int prevXY = x == 0 ? prevY : y;
				int nextX = (x+1) % fields.length;
				int nextY = (y+1) % fields[0].length;
				int nextXY = nextX == 0 ? nextY : y;
				extensions[x][y] = extend(fields[x][y], 
						fields[nextX][nextXY], 
						fields[prevX][prevXY],
						fields[x][prevY],
						fields[x][nextY],
						changeAfter,
						null);
			}
		}
		return extensions;
	}

	public static FocusChangingTextFieldExtension extend(TextField field, Component nextComponent) {
		return extend(field, nextComponent, null, field.getMaxLength(), null);
	}
	
	public static FocusChangingTextFieldExtension extend(TextField field, Component nextComponent, Component previousComponent, int changeAfter, String charsToMoveToPrevious) {
		return extend(field, nextComponent, previousComponent, null, null, changeAfter, charsToMoveToPrevious);
	}
	
	public static FocusChangingTextFieldExtension extend(TextField field, 
			Component nextComponent, 
			Component previousComponent, 
			Component upComponent, 
			Component downComponent, 
			int changeAfter, 
			String charsToMoveToPrevious) {
        FocusChangingTextFieldExtension extension = new FocusChangingTextFieldExtension();
		extension.extend((AbstractClientConnector) field);
		FocusChangingTextFieldState state = extension.getState();
		state.setNextComponent(nextComponent);
		state.setPreviousComponent(previousComponent);
		state.setUpComponent(upComponent);
		state.setDownComponent(downComponent);
		state.setChangeAfter(changeAfter);
		state.setCharsToMoveToPrevious(charsToMoveToPrevious);
		
		return extension;
    }
	
	@Override
	public FocusChangingTextFieldState getState() {
	    return (FocusChangingTextFieldState) super.getState();
	}
	
}