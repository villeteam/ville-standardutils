package fi.utu.ville.standardutils.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;

public class VilleToggleButton extends HorizontalLayout {
	
	List<String> options;
	List<Button> buttonList;
	String state;
	
	public VilleToggleButton(String[] options) {
		this(new ArrayList<String>(Arrays.asList(options)));
	}
	
	public VilleToggleButton(List<String> options) {
		this.options = new ArrayList<String>(options);
		state = options.get(0);
		generateButtons();
		setValue(options.get(0));
	}
	
	private void generateButtons() {
		buttonList = new LinkedList<Button>();
		
		for (int i = 0; i < options.size(); i++) {
			final String buttonValue = options.get(i);
			Button button = new Button(buttonValue);
			button.addClickListener(event -> setValue(buttonValue));
			buttonList.add(button);
			addComponent(button);
			
			// First button needs to be styled correctly
			if (i == 0) {
				button.addStyleName("toggle-button-left");
			}
			// Last button needs special styling as well
			else if (i == options.size() - 1) {
				button.addStyleName("toggle-button-right");
			}
			// Rest of the buttons
			else {
				button.addStyleName("toggle-button-center");
			}
		}
	}
	
	public String getValue() {
		return state;
	}
	
	/**
	 * Set the value, hilighting the right button. If the input is not a valid button, setValue to options.get(0)
	 * 
	 * @param s
	 */
	public void setValue(String s) {
		buttonList.get(options.indexOf(state)).removeStyleName("toggle-button-selected");
		
		if (options.contains(s)) {
			state = s;
			buttonList.get(options.indexOf(s)).addStyleName("toggle-button-selected");
			// Hilight button
			// dehilight other buttons
		} else {
			state = options.get(0);
			buttonList.get(0).addStyleName("toggle-button-selected");
			// hilight button
			// asd
		}
	}
	
	public ArrayList<String> getOptions() {
		return (ArrayList<String>) options;
	}
	
}
