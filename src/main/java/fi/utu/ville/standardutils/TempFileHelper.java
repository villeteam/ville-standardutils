package fi.utu.ville.standardutils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.JSONException;
import org.json.JSONObject;

public class TempFileHelper {

	private static final Logger logger = Logger.getLogger(TempFileHelper.class
			.getName());

	private File tempFile;

	public boolean hasFile() {
		return tempFile != null;
	}

	public String getFileName() {
		return tempFile.getName();
	}

	public File getFile() {
		return tempFile;
	}

	public void setFile(File file) {
		this.tempFile = file;
	}

	public String asJson() {
		if (tempFile == null) {
			return null;
		}

		String res = null;
		JSONObject json = new JSONObject();

		try {
			json.put("name", tempFile.getName());

			json.put("data",
					BinaryStringConversionHelper.fileToString(tempFile));
			res = json.toString();
		} catch (JSONException e) {
			logger.log(Level.SEVERE, "Error saving to JSON", e);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error converting file to base64", e);
		}
		return res;

	}

	public void loadFromJson(String jsonStr, TempFilesManager tempMan) {

		if (jsonStr == null) {
			tempFile = null;
			return;
		}

		try {
			JSONObject json = new JSONObject(jsonStr);

			tempFile = BinaryStringConversionHelper.base64toNonConflictingFile(
					json.getString("data"), tempMan, json.getString("name"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
