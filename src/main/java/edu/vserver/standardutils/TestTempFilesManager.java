package edu.vserver.standardutils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 * <p>
 * A minimal (and quite functional) implementation of {@link TempFilesManager}
 * that can be used in testing components that in real use cases would receive a
 * "real" {@link TempFilesManager} through constructor etc..
 * </p>
 * 
 * @author Riku Haavisto
 * 
 */
public class TestTempFilesManager implements TempFilesManager {

	private final static Logger logger = Logger
			.getLogger(TestTempFilesManager.class.getName());

	/**
	 * 
	 */
	private static final long serialVersionUID = 4156880399387575868L;

	private String tempFolder = null;
	private final String baseFolderPath;

	public TestTempFilesManager(String baseFolderPath) {
		this.baseFolderPath = baseFolderPath;
	}

	@Override
	public void initialize() {
		// allow futher initialize()-calls as no-ops
		// (current implementation requires this)
		if (tempFolder == null) {
			createTempFolder();
		}
	}

	@Override
	public void shutdown() {
		deleteTempFolder();
	}

	@Override
	public File makeTempCopy(InputStream tempStream, String fileName) {
		checkState();
		File usedTempFile = new File(tempFolder + File.separator + fileName);

		try {
			FileOutputStream fileOut = new FileOutputStream(usedTempFile);

			IOUtils.copy(tempStream, fileOut);
		} catch (IOException e) {
			logger.log(
					Level.SEVERE,
					"Could not copy the new material-stream to a new temp-file",
					e);
		}
		return usedTempFile;

	}

	private void checkState() {
		if (tempFolder == null) {
			throw new IllegalStateException(
					"Temp-files manager not initialized!");
		}
	}

	private void createTempFolder() {

		String targetFolder = baseFolderPath + File.separator
				+ UUID.randomUUID();

		if (tempFolder != null) {
			try {
				FileUtils.deleteDirectory(new File(tempFolder));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		tempFolder = targetFolder;

		File file = new File(targetFolder);
		file.mkdir();

		logger.info("CREATED TEMPFOLDER: " + targetFolder);

	}

	private void deleteTempFolder() {

		if (tempFolder != null) {
			try {
				FileUtils.deleteDirectory(new File(tempFolder));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			logger.info("DELETED TEMPFOLDER");
		}

	}

	@Override
	public String getTempFolder() {
		checkState();
		return tempFolder;
	}

	@Override
	public File getTempFile(String fileName) {
		checkState();
		return new File(tempFolder + File.separator + fileName);
	}

	@Override
	public TempFilesManager createChild() {
		checkState();
		// no real house-keeping required (at least for a
		// testing-implementation)
		// as the new folder will be inside tempFolder and thus
		// cleared on shutdown
		return new TestTempFilesManager(tempFolder);
	}

	@Override
	public File getNonConflictingTempFile(String baseName) {
		checkState();

		return Util.getNonConflictingFile(tempFolder, baseName);
	}
}
