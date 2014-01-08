package edu.vserver.standardutils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashSet;

import org.apache.commons.io.FileUtils;

import com.vaadin.server.FileDownloader;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.FailedEvent;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.themes.BaseTheme;
import com.vaadin.util.FileTypeResolver;

/**
 * A class that can be used to allow the user to upload files meeting certain
 * constraints and to store them to temporary folder managed by
 * {@link TempFilesManager}. The class also provides {@link UploadListener}
 * -interface for listening on successful upload events.
 * 
 * @author Riku Haavisto
 * 
 */
public class SimpleFileUploader extends HorizontalLayout {

	/**
	* 
	*/
	private static final long serialVersionUID = 8306954723102500190L;

	private final Localizer localizer;

	private final int maxSize;
	private final String mimeTypeFilter;
	private final TempFilesManager tempManager;

	/* upload component, and progress-bar for showing upload's progress */
	private Upload upload;
	private ProgressBar uploadProgressBar;

	/* used to avoid printing too many error messages */
	private boolean uploadErrorAlreadyHandled = false;

	/* output stream for storing the uploaded-file */
	private File uploadedFile;

	/* store some other data about the file for quick access */
	private String fileName;
	private String mtype;

	/* show these buttons when there is a valid uploaded file present */
	private Button dlUploadedBtn;
	private Button removeUploadedBtn;

	/* listeners for succesfull uploads */
	private final HashSet<UploaderListener> uploaderListeners =

	new HashSet<UploaderListener>();

	/**
	 * Constructs a new {@link SimpleFileUploader} for uploading files and
	 * adding them to a {@link EditorMaterialManager} with if they meet certain
	 * limitations set by the parameters.
	 * 
	 * @param caption
	 *            caption for the upload-field
	 * @param localizer
	 *            {@link Localizer} used for localizing this instance
	 * @param tempManager
	 *            {@link TempFilesManager} which is used to get temp-directory
	 *            for storing uploaded files
	 * @param maxUploadSize
	 *            maximum-size of files that should be accepted (in kilobytes)
	 * @param mimeTypeFilter
	 *            a regexp that the MIME-type of the uploaded file must match in
	 *            order to be accepted
	 */
	public SimpleFileUploader(Localizer localizer,
			TempFilesManager tempManager, int maxUploadSize,
			String mimeTypeFilter) {
		this.setSpacing(true);
		this.setMargin(true);
		this.localizer = localizer;
		this.tempManager = tempManager;
		maxSize = maxUploadSize;
		this.mimeTypeFilter = mimeTypeFilter;
		createUploadField();
	}

	/**
	 * {@link UploadListener}s can be registered through this method to listen
	 * for successful file-uploads
	 * 
	 * @param listener
	 *            {@link UploadListener} to be registered
	 */
	public void registerUploaderListener(UploaderListener listener) {
		uploaderListeners.add(listener);
	}

	/**
	 * <p>
	 * Returns a {@link File}-object representing the copy of the uploaded file
	 * made to the folder managed by {@link TempFilesManager}.
	 * </p>
	 * <p>
	 * The uploaded file is null if there has been no upload, or the upload
	 * failed, or the user has deleted the upload file with the remove button
	 * after a successfull upload.
	 * </p>
	 * 
	 * @return The uploaded {@link File}, or null if there is no uploaded file
	 *         currently
	 */
	public File getUploadedFile() {
		return uploadedFile;
	}

	/**
	 * Sets a new file as the uploaded-file. This method
	 * {@link #uploadProgrammatically(File)} can be used to load the
	 * {@link SimpleFileUploader}'s state to match a previously uploaded file.
	 * 
	 * @param uplFile
	 *            {@link File} object to set as uploaded-file
	 * @param fireUploadEvent
	 *            whether to also fire upload-events or to only set the
	 *            uploaded-file
	 */
	public void setUploadedFile(File uplFile, boolean fireUploadEvent) {
		if (fireUploadEvent) {
			uploadProgrammatically(uplFile);
		} else {
			this.uploadedFile = uplFile;
		}
	}

	public void setAbstractUploadedFile(AbstractFile abstFile) {
		if (uploadedFile != null) {
			removeUploadedFile();
		}
		this.uploadedFile = null;
		this.fileName = abstFile.getName();
		this.mtype = FileTypeResolver.getMIMEType(this.fileName);
		virtualUplDone(abstFile);
	}

	/**
	 * This method fires a upload-event programmatically with given parameters.
	 * Mimetype and filename are deduced from the given {@link File} object.
	 * State of the {@link SimpleFileUploader} is also updated.
	 * 
	 * @param uplFile
	 *            {@link File} to be "uploaded" to this
	 *            {@link SimpleFileUploader}
	 */
	public void uploadProgrammatically(File uplFile) {
		uploadProgrammatically(uplFile, uplFile.getName(),
				FileTypeResolver.getMIMEType(uplFile));
	}

	/**
	 * This method fires a upload-event programmatically with given parameters.
	 * State of the {@link SimpleFileUploader} is also updated.
	 * 
	 * @param uplFile
	 *            {@link File} to be "uploaded" to this
	 *            {@link SimpleFileUploader}
	 * @param fileName
	 *            filename to report to listeners
	 * @param mimeType
	 *            mime-type to report to listeners
	 */
	public void uploadProgrammatically(File uplFile, String fileName,
			String mimeType) {
		if (uploadedFile != null) {
			removeUploadedFile();
		}
		this.uploadedFile = uplFile;
		this.fileName = fileName;
		this.mtype = mimeType;
		uploadDone();
	}

	private void createUploadField() {
		upload = new Upload(null, new Upload.Receiver() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -2892688401105691691L;

			@Override
			public OutputStream receiveUpload(String filename, String mimeType) {

				uploadedFile = tempManager.getNonConflictingTempFile(filename);

				FileOutputStream fos = null;
				try {
					fos = new FileOutputStream(uploadedFile);
				} catch (FileNotFoundException e) {
					// should not happen (as long as the temp-manager is
					// initialized by the using code)
					e.printStackTrace();
				}
				return fos;
			}
		});

		upload.setImmediate(true);

		upload.addProgressListener(new Upload.ProgressListener() {

			private static final long serialVersionUID = 1903929085938914783L;

			@Override
			public void updateProgress(long readBytes, long contentLength) {
				if (contentLength > maxSize * 1024L) {
					abortLongFileUpload();
				} else if (contentLength > 0) {
					uploadProgressBar.setValue((float) readBytes
							/ (float) contentLength);
				}
			}

		});

		upload.addStartedListener(new Upload.StartedListener() {

			private static final long serialVersionUID = -5987541357925933823L;

			@Override
			public void uploadStarted(StartedEvent event) {
				uploadErrorAlreadyHandled = false;
				mtype = event.getMIMEType();
				fileName = event.getFilename();
				startedUpload();
			}
		});

		upload.addSucceededListener(new Upload.SucceededListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = -5087217989133112622L;

			@Override
			public void uploadSucceeded(SucceededEvent event) {
				if (uploadedFile != null) {
					uploadDone();
				}

			}
		});
		upload.addFailedListener(new Upload.FailedListener() {

			private static final long serialVersionUID = 1940987602961941311L;

			@Override
			public void uploadFailed(FailedEvent event) {
				if (!uploadErrorAlreadyHandled) {
					showUploadErrorDialog();
				}
			}
		});
		upload.setButtonCaption(localizer.getUIText(StandardUIConstants.UPLOAD));

		this.addComponent(upload);
	}

	private void showUploadErrorDialog() {

		removeAllComponents();

		addComponent(upload);
		Notification.show(
				localizer.getUIText(StandardUIConstants.ERROR_IN_UPLOAD),
				Notification.Type.ERROR_MESSAGE);

	}

	private void abortLongFileUpload() {
		removeAllComponents();

		addComponent(upload);

		uploadErrorAlreadyHandled = true;
		if (upload.isUploading()) {
			upload.interruptUpload();
		}

		Notification.show(localizer.getUIText(
				StandardUIConstants.ERROR_FILE_TOO_LARGE, "" + maxSize),
				Notification.Type.ERROR_MESSAGE);

	}

	private void startedUpload() {
		if (mtype.matches(mimeTypeFilter)) {

			removeAllComponents();

			uploadProgressBar = new ProgressBar();
			uploadProgressBar
					.setCaption(localizer
							.getUIText(StandardUIConstants.NOTIFICATION_UPLOADING_FILE));
			uploadProgressBar.setIndeterminate(true);
			this.addComponent(uploadProgressBar);
		} else {
			if (upload.isUploading()) {
				upload.interruptUpload();
			}
			Notification
					.show(localizer
							.getUIText(StandardUIConstants.UPLOAD_ERROR_WRONG_FILE_TYPE),
							Notification.Type.ERROR_MESSAGE);
			uploadErrorAlreadyHandled = true;
		}
	}

	private void removeUploadedFile() {

		informDelete(uploadedFile);

		FileUtils.deleteQuietly(uploadedFile);

		uploadedFile = null;
		fileName = null;
		mtype = null;

		removeAllComponents();

		addComponent(upload);

	}

	/**
	 * Load the UI to look like an act like a file with given name as abstFile's
	 * name would have been uploaded.
	 * 
	 * @param abstFile
	 */
	private void virtualUplDone(AbstractFile abstFile) {
		removeAllComponents();

		dlUploadedBtn = new Button(fileName);
		dlUploadedBtn.setStyleName(BaseTheme.BUTTON_LINK);
		dlUploadedBtn.setIcon(StandardIcon.getMIMETypeIcon(mtype, ""));

		FileDownloader dl = new FileDownloader(abstFile.getAsResource());

		dl.extend(dlUploadedBtn);

		this.addComponent(dlUploadedBtn);

		removeUploadedBtn = new Button(
				localizer.getUIText(StandardUIConstants.DELETE));
		removeUploadedBtn.setIcon(StandardIcon.DELETE_ICON.getIcon());
		removeUploadedBtn.addClickListener(new Button.ClickListener() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				removeUploadedFile();
			}
		});

		this.addComponent(removeUploadedBtn);

	}

	private void uploadDone() {

		if (FileUtils.sizeOf(uploadedFile) > maxSize * 1024L) {
			abortLongFileUpload();
		} else {

			removeAllComponents();

			dlUploadedBtn = new Button(fileName);
			dlUploadedBtn.setStyleName(BaseTheme.BUTTON_LINK);
			dlUploadedBtn.setIcon(StandardIcon.getMIMETypeIcon(mtype, ""));

			FileDownloader dl = new FileDownloader(new FileResource(
					uploadedFile));

			dl.extend(dlUploadedBtn);

			this.addComponent(dlUploadedBtn);

			removeUploadedBtn = new Button(
					localizer.getUIText(StandardUIConstants.DELETE));
			removeUploadedBtn.setIcon(StandardIcon.DELETE_ICON.getIcon());
			removeUploadedBtn.addClickListener(new Button.ClickListener() {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				@Override
				public void buttonClick(ClickEvent event) {
					removeUploadedFile();
				}
			});

			this.addComponent(removeUploadedBtn);

			informListeners(uploadedFile, fileName, mtype);

		}

	}

	private void informListeners(File tempFile, String fileName, String mimeType) {
		for (UploaderListener listener : uploaderListeners) {
			listener.fileUploadSucceeded(tempFile, fileName, mimeType);
		}
	}

	private void informDelete(File delFile) {
		for (UploaderListener listener : uploaderListeners) {
			listener.uploadedFileDeleted(delFile);
		}
	}

	/**
	 * Implementors of this interface can be registered to a
	 * {@link SimpleFileUploader} through
	 * {@link SimpleFileUploader #registerSuccessListener(UploadListener)
	 * registerSuccessListener()}. Registered listeners will be informed with
	 * the newly created temp {@link File} after a successful upload.
	 * 
	 * @author Riku Haavisto
	 * 
	 */
	public interface UploaderListener extends Serializable {

		/**
		 * <p>
		 * After a successful upload in {@link SimpleFileUploader} this method
		 * is called for all registered {@link UploadListener}s with the newly
		 * created temp {@link File}.
		 * </p>
		 * <p>
		 * <b>Remember that temp {@link File}s will be lost if they are not
		 * saved by {@link PersistenceHandler}!</b>
		 * </p>
		 * 
		 * @param tempFile
		 *            the newly added temp-{@link File}
		 * @param fileName
		 *            the name of the uploaded file
		 * @param mimeType
		 *            the mimeType of the uploaded file
		 * 
		 * @see TempFilesManager
		 */
		void fileUploadSucceeded(File tempFile, String fileName, String mimeType);

		/**
		 * <p>
		 * This method is called if the user chooses to delete an already
		 * uploaded file.
		 * </p>
		 * <p>
		 * The {@link File} object returned will be only to do any possible
		 * extra clean-up of the using object's state. The actual file in the
		 * file system will be <b>deleted</b> by {@link SimpleFileUploader}
		 * after all listeners are called.
		 * </p>
		 * 
		 * @param tempFile
		 *            {@link File} object that was deleted;
		 */
		void uploadedFileDeleted(File tempFile);

	}

}