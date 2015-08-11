package edu.vserver.ville.JSXGraph;

import java.util.ArrayList;

import elemental.json.JsonObject;

public class JSXGraphConfig {

	private ArrayList<String> itemIDs;

	public JSXGraphConfig() {
		ArrayList<String> itemArr = new ArrayList<String>();
		setItemIDs(itemArr);
	}

	public JSXGraphConfig(ArrayList<String> itemIDs2) {
		setItemIDs(itemIDs2);
	}

	public void updateFromJSON(JsonObject configObj) {
		// TODO complete
	}

	public ArrayList<String> getItemIDs() {
		return itemIDs;
	}

	public void setItemIDs(ArrayList<String> itemIDs) {
		this.itemIDs = itemIDs;
	}

}
