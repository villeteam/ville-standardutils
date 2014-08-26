package fi.utu.ville.standardutils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;

import com.vaadin.server.FileResource;
import com.vaadin.server.Resource;

public class AFFile implements AbstractFile, Serializable {

	private static final long serialVersionUID = 8898413801289382694L;

	private static final Logger logger = Logger.getLogger(AFFile.class
			.getName());

	private final File file;

	public AFFile(File file) {
		this.file = file;
	}

	public File getActFile() {
		return file;
	}

	@Override
	public String getName() {
		return file.getName();
	}

	@Override
	public byte[] getRawData() {
		try {
			return FileUtils.readFileToByteArray(file);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error loading file to byte-array", e);
			return null;
		}
	}

	@Override
	public Resource getAsResource() {
		return new FileResource(file);
	}

	@Override
	public InputStream getAsStream() {
		try {
			return FileUtils.openInputStream(file);
		} catch (IOException e) {
			logger.log(Level.SEVERE, "Error opening file as input-stream", e);
			return null;
		}
	}

}
