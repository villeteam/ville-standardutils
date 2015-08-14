package edu.vserver.ville.JSXGraph;

import java.io.Serializable;
import java.util.ArrayList;

import elemental.json.JsonArray;
import elemental.json.JsonObject;

public class JSXGraphConfig implements Serializable {
	private static final long serialVersionUID = -5252954104056737799L;
	private ArrayList<String> itemIDs;
	private String width;
	private String height;
	private boolean axis;

	public JSXGraphConfig() {
		ArrayList<String> itemArr = new ArrayList<String>();
		setWidth("250");
		setHeight("250");
		setAxis(true);
		setItemIDs(itemArr);
	}

	public JSXGraphConfig(String width, String height, boolean axis, ArrayList<String> itemIDs) {
		setWidth(width);
		setHeight(height);
		setAxis(axis);
		setItemIDs(itemIDs);
	}

	public void updateFromJSON(JsonObject configObj) {
		if (configObj.hasKey("width")) this.setWidth(configObj.getString("width"));
		if (configObj.hasKey("height")) this.setHeight(configObj.getString("height"));
		if (configObj.hasKey("axis")) this.setAxis(configObj.getBoolean("axis"));
		if (configObj.hasKey("itemIDs")) {
			JsonArray itemIDArr = configObj.getArray("itemIDs");

			if (itemIDArr.length() > 0) {
				ArrayList<String> al_itemIDs = new ArrayList<String>();
				for (int i = 0; i < itemIDArr.length(); ++i)
					al_itemIDs.add(itemIDArr.getString(i));
				this.setItemIDs(al_itemIDs);
			}
		}
	}

	public ArrayList<String> getItemIDs() {
		return itemIDs;
	}

	public void setItemIDs(ArrayList<String> itemIDs) {
		this.itemIDs = itemIDs;
	}

	public String getWidth() {
		return width;
	}

	public void setWidth(String width) {
		this.width = width;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public boolean hasAxis() {
		return axis;
	}

	public void setAxis(boolean axis) {
		this.axis = axis;
	}

}
