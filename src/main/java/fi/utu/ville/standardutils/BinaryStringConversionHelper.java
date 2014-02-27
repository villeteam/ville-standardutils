package fi.utu.ville.standardutils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;

/**
 * <p>
 * This class is a wrapper for certain Apache-Commons implementations for
 * converting binary data to XML-safe String-representation and vice versa.
 * </p>
 * <p>
 * Can be used for embedding temp-files from {@link TempFilesManager} to
 * persistent {@link ExerciseData} or {@link SubmissionInfo} representations
 * handled by {@link PersistenceHandler}.
 * <p>
 * 
 * @author Riku Haavisto
 * 
 */
public final class BinaryStringConversionHelper {

	// no instance needed, all methods static
	private BinaryStringConversionHelper() {
	}

	/**
	 * Converts a byte array to Base64-encoded string.
	 * 
	 * @param input
	 *            byte-array to convert
	 * @return Base64-string representation of the bytes
	 */
	public static String bytesToString(byte[] input) {

		return Base64.encodeBase64String(input);
	}

	/**
	 * Converts a Base64-encoded string to a byte array.
	 * 
	 * @param input
	 *            Base64-string to decode
	 * @return decoded bytes
	 */
	public static byte[] stringToBytes(String input) {

		return Base64.decodeBase64(input);

	}

	/**
	 * Converts the binary data of a {@link File} to a Base64-encoded String
	 * 
	 * @param input
	 *            file to convert
	 * @return Base64-encoded string of file's data
	 * @throws IOException
	 */
	public static String fileToString(File input) throws IOException {

		byte[] fileBytes = FileUtils.readFileToByteArray(input);

		return bytesToString(fileBytes);
	}

	/**
	 * <p>
	 * Decodes a Base64-encoded string to binary data and writes the data to a
	 * newly created file. This method is meant to be used in conjunction with
	 * {@link TempFilesManager} from which a temp-folder can be fetched.
	 * </p>
	 * <p>
	 * 
	 * <pre>
	 * Example usage:
	 * 
	 * File loadedFile = 
	 * 		BinaryStringConversionHelper.base64toFile(
	 * 			dataStr, tempMan.getTempFolder(), fileName);
	 * 
	 * </pre>
	 * 
	 * </p>
	 * 
	 * @param base64src
	 *            Base64-encoded data string
	 * @param tempFolder
	 *            folder that can be used for temporary files
	 * @param fileName
	 *            filename to use
	 * @return {@link File} object representing the newly created file
	 * @throws IOException
	 */
	public static File base64toFile(String base64src, String tempFolder,
			String fileName) throws IOException {

		if (fileName == null || "".equals(fileName)) {
			fileName = UUID.randomUUID().toString();
		}

		File dest = new File(tempFolder + File.separator + fileName);

		FileUtils.writeByteArrayToFile(dest, stringToBytes(base64src));

		return dest;
	}

	public static File base64toNonConflictingFile(String base64src,
			TempFilesManager tempMan, String baseName) throws IOException {

		File dest = tempMan.getNonConflictingTempFile(baseName);

		FileUtils.writeByteArrayToFile(dest, stringToBytes(base64src));

		return dest;
	}

}
