package fi.utu.ville.standardutils.ui;

import com.vaadin.server.AbstractClientConnector;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.Component;
import com.vaadin.ui.TextField;

import fi.utu.ville.standardutils.client.FocusChangingTextFieldState;
import fi.utu.ville.standardutils.client.FocusChangingTextFieldState.FocusLogicType;


public class FocusChangingTextFieldExtension extends AbstractExtension {

	private static final long serialVersionUID = 8986814555711778351L;
	
	public static FocusChangingTextFieldExtension[] extend(int changeAfter, TextField ... fields) {
		return extend(1, FocusLogicType.DEFAULT, fields);
	}
	
	public static FocusChangingTextFieldExtension[] extend(int changeAfter, FocusLogicType logic, TextField ... fields) {
		FocusChangingTextFieldExtension[] extensions = new FocusChangingTextFieldExtension[fields.length];
		
		for(int i = 0; i < fields.length; i++) {
			Component prevComp = null;
			Component nextComp = null;
			if(i > 0) {
				prevComp = fields[i-1];
			}
			if(i + 1 < fields.length) {
				nextComp = fields[i+1];
			}
			extensions[i] = extend(fields[i], nextComp, prevComp, changeAfter, logic);
		}
		return extensions;
	}

	/**
	 * 
	 * @param changeAfter
	 * @param fields where 0,0 is the top left corner, x coordinate (column) is the first coordinate and y the second (row)
	 * @return
	 */
	public static FocusChangingTextFieldExtension[][] extend(int changeAfter, FocusLogicType logic, TextField[][] fields) {
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
						logic);
			}
		}
		return extensions;
	}
	
	public static FocusChangingTextFieldExtension extend(TextField field, Component nextComponent, Component previousComponent, int changeAfter, FocusLogicType logic) {
		return extend(field, nextComponent, previousComponent, null, null, changeAfter, logic);
	}
	
	public static FocusChangingTextFieldExtension extend(TextField field, 
			Component nextComponent, 
			Component previousComponent, 
			Component upComponent, 
			Component downComponent, 
			int changeAfter,
			FocusLogicType logic) {
        FocusChangingTextFieldExtension extension = new FocusChangingTextFieldExtension();
		extension.extend((AbstractClientConnector) field);
		FocusChangingTextFieldState state = extension.getState();
		state.setRightComponent(nextComponent);
		state.setLeftComponent(previousComponent);
		state.setUpComponent(upComponent);
		state.setDownComponent(downComponent);
		state.setChangeAfter(changeAfter);
		state.setFocusLogic(logic);
		return extension;
    }
	
	@Override
	public FocusChangingTextFieldState getState() {
	    return (FocusChangingTextFieldState) super.getState();
	}
	
}