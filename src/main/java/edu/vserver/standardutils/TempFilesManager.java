package edu.vserver.standardutils;

import java.io.File;
import java.io.InputStream;
import java.io.Serializable;

/**
 * <p>
 * {@link TempFilesManager}-implementor provides using classes with a writable
 * temporary folder for storing files.
 * </p>
 * <p>
 * TempFilesManager as the classes will share the same {@link TempFilesManager}
 * (to be able to share the temp-files). If {@link TempFilesManager} is used by
 * several classes of an exercise-type, all using classes must call
 * {@link #initialize()} before using temp-manager as their initialization
 * differs depending on the use case.
 * </p>
 * <p>
 * For storing temporary files permanently in {@link PersistenceHandler}, see
 * {@link BinaryStringConversionHelper}. There might of course also be temporary
 * files that do not need to be stored permanently as a {@link ExerciseData} or
 * {@link SubmissionInfo} -representation.
 * </p>
 * 
 * @author Riku Haavisto
 * 
 */
public interface TempFilesManager extends Serializable {

	/**
	 * <p>
	 * Must be called if used before calling any other methods. Initializes all
	 * the needed system resources ie. creates a new temp-folder. On the other
	 * hand, if no temp files are used, there is no need for initializing the
	 * temp-files manager.
	 * </p>
	 * <p>
	 * If {@link TempFilesManager} is used by several classes of an
	 * exercise-type, all using classes must call {@link #initialize()} before
	 * (writing to) using the TempFilesManager as the classes can be called in
	 * different order depending on the situation. Eg. editor is called before
	 * persistence-handler when a new exercise is created, but
	 * persistence-handler is called first if there is an existing exercise that
	 * will be loaded for editing.
	 * </p>
	 * <p>
	 * Calling initiaze on an already initialized {@link TempFilesManager} is a
	 * no-op. This is required as in certain use cases it is not possible to
	 * know in which order certain objects requiring to share a
	 * {@link TempFilesManager} are initialized. Generally it is best to call
	 * this in any class intending to actually use {@link TempFilesManager}.
	 * </p>
	 */
	void initialize();

	/**
	 * 
	 * @return the path to the writable temporary folder in use
	 */
	String getTempFolder();

	/**
	 * Returns a {@link File}-representation of a fileName in current
	 * temp-directory. This is only convenience method and is equivalent to new
	 * File(tempMan.getTempFolder() + File.separator + fileName)
	 * 
	 * @return {@link File} representing given fileName in current
	 *         temp-directory
	 */
	File getTempFile(String fileName);

	/**
	 * Returns a {@link File}-representation of a baseName and possibly a (n) to
	 * avoid conflicts in current temp-directory. This is only convenience
	 * method and is equivalent to new File(tempMan.getTempFolder() +
	 * File.separator + fileName), and testing whether that file exists, in if
	 * it does adding something to the baseName until there is no conflict.
	 * 
	 * @return {@link File} representing given fileName in current
	 *         temp-directory
	 */
	File getNonConflictingTempFile(String baseName);

	/**
	 * Stores the {@link InputStream} to a newly created temporary-file with
	 * given name into the temp-directory in use. This is only a convenience
	 * method as one can create files directly to tempMan.getTempFolder()-folder
	 * 
	 * @param toCopy
	 *            {@link InputStream} to write to file
	 * @param fileName
	 *            name to use for the file
	 * @return {@link File} representing the newly created file
	 */
	File makeTempCopy(InputStream toCopy, String fileName);

	/**
	 * <p>
	 * Shutdown the {@link TempFilesManager}-instance. Deletes any files and
	 * folders created through it and releases any possible system resources.
	 * </p>
	 * <p>
	 * Using classes are <b>NOT</b> allowed to call this method unless they have
	 * created child {@link TempFilesManager}-instances through
	 * {@link #createChild()}-method. The framework providing the
	 * {@link TempFilesManager} takes the responsibility of shutting it down
	 * when appropriate. Calling this method on "framework-owned"
	 * {@link TempFilesManager} might throw an error or cause unintended
	 * behaviour.
	 * </p>
	 */
	void shutdown();

	/**
	 * <p>
	 * Creates a new {@link TempFilesManager} that is dependant on the parent in
	 * the sense that it will be shutdown when the parent is shutdown. The child
	 * will provide independent name-space for temp-files. The child is
	 * essentially a subfolder of the parent temp-folder.
	 * </p>
	 * <p>
	 * Even thought it is not strictly necessary to shutdown the child-
	 * {@link TempFilesManager}s it is recommended especially if there is
	 * potential for stored files to be large.
	 * </p>
	 * 
	 * @return
	 */
	TempFilesManager createChild();

}
