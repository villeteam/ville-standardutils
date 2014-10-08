package fi.utu.ville.standardutils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.io.Serializable;

import javax.imageio.ImageIO;

import com.vaadin.ui.VerticalLayout;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.ui.Image;

import fi.utu.ville.standardutils.SimpleFileUploader.UploaderListener;

import org.vaadin.risto.stepper.IntStepper;

public class SimpleImageUploader extends VerticalLayout {

	private static final long serialVersionUID = 3281090786118827523L;

	private final static String MIMETYPEFILTER = "^image/.*$";
	private final TempFilesManager tempManager;
	
	private final SimpleFileUploader uploader;
	private final IntStepper maxWidthStepper;
	private final VerticalLayout imageContainer;
	
	private float maxWidth = ScaledImage.DEFAULT_MAX_WIDTH;
	
	private boolean showStepper = true;
	private boolean showImage = false;
	
	public SimpleImageUploader(Localizer localizer,
			TempFilesManager tempManager, int maxUploadSize) {
		this.uploader = new SimpleFileUploader(localizer,tempManager,maxUploadSize,MIMETYPEFILTER);
		this.maxWidthStepper = new IntStepper(localizer.getUIText(StandardUIConstants.MAX_WIDTH));
		this.imageContainer = new VerticalLayout();
		this.tempManager = tempManager;
		doLayout();
	}
	
	public void registerUploaderListener(ImageUploaderListener listener) {
		uploader.registerUploaderListener(listener);
	}
	
	public File getUploadedFile() {
		return uploader.getUploadedFile();
	}

	public String getMIMEType() {
		return uploader.getMIMEType();
	}

	public String getFileName() {
		return uploader.getFileName();
	}

	public void setUploadedFile(File uplFile, boolean fireUploadEvent) {
		maxWidthStepper.setEnabled(false);
		uploader.setUploadedFile(uplFile, fireUploadEvent);
	}

	public void setAbstractUploadedFile(AbstractFile abstFile) {
		maxWidthStepper.setEnabled(false);
		uploader.setAbstractUploadedFile(abstFile);
	}

	public void uploadProgrammatically(File uplFile) {
		uploader.uploadProgrammatically(uplFile);
	}

	public void uploadProgrammatically(File uplFile, String fileName,
			String mimeType) {
		uploader.uploadProgrammatically(uplFile, fileName, mimeType);
	}
	
	public void setMaxWidth(float maxWidth) {
		maxWidthStepper.setValue((int)maxWidth);
	}
	
	public float getMaxWidth() {
		return maxWidth;
	}
	
	public void showImage(boolean newValue) {
		this.showImage = newValue;
		if(!showImage) {
			imageContainer.removeAllComponents();
		}
	}
	
	public void showWidthStepper(boolean newValue) {
		this.showStepper = newValue;
		maxWidthStepper.setVisible(showStepper);
	}
	
	private void doLayout() {
		this.setMargin(true);
		this.setSpacing(true);
		this.addComponent(maxWidthStepper);
		this.addComponent(uploader);
		this.addComponent(imageContainer);
		
		this.maxWidthStepper.setMinValue(1);
		this.maxWidthStepper.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = -2756336993178151135L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				maxWidth = maxWidthStepper.getValue();				
			}
			
		});
		this.maxWidthStepper.setValue((int)ScaledImage.DEFAULT_MAX_WIDTH);
	}
	
	public abstract class ImageUploaderListener implements UploaderListener{

		private static final long serialVersionUID = 891682132265510102L;
		private transient ScaledImage uploadedImage = null;

		@Override
		public void fileUploadSucceeded(File tempFile, String fileName,
				String mimeType) {
			
			ScaledImage result = new ScaledImage();
			result.setMaxWidth(maxWidth);
			result.setSource(tempFile, fileName, tempManager);
			if(showImage) {imageContainer.removeAllComponents();imageContainer.addComponent(result);}
			maxWidthStepper.setEnabled(false);
			uploadedImage =  result;
			fileUploadSucceeded(result,fileName);
		}
		
		public abstract void fileUploadSucceeded(ScaledImage image, String fileName);
		
		@Override
		public void uploadedFileDeleted(File tempFile) {
			imageContainer.removeAllComponents();		
			ScaledImage result = uploadedImage;
			uploadedImage = null;
			maxWidthStepper.setEnabled(true);
			uploadedFileDeleted(result);			

		}

		public abstract void uploadedFileDeleted(ScaledImage image);
		
		
	}
	
	public static class ScaledImage extends Image implements Serializable {

		private static final long serialVersionUID = -2183720246344657143L;

		private File file;
		private String fileName;
		
		public static final float DEFAULT_MAX_WIDTH = 1280;
		private float maxWidth;
		
		public ScaledImage(String caption) {
			super(caption);
			maxWidth = DEFAULT_MAX_WIDTH;
		}

		public ScaledImage() {
			this(null);
		}

		public void setSource(File file, String fileName,TempFilesManager tempManager) {
			if(file == null) return;
			this.file = file;
			this.fileName = fileName;
			if(tempManager != null) {resize(tempManager);}

			FileResource filRes = new FileResource(file);
			
			super.setSource(filRes);
			
		}
		

		public AbstractFile getAbstractFile() {
			return new AFFile(file);
		}

		public String getFileName() {
			return fileName;
		}
		
		public File getFile() {
			return file;
		}

		public void resize(TempFilesManager tempManager) {

			BufferedImage bimg = null;

			try(FileInputStream fin = new FileInputStream(file)){
				bimg = ImageIO.read(fin);
				
				this.setWidth(bimg.getWidth() + "px");
				this.setHeight(bimg.getHeight() + "px");

				// Check if width or height is too large. Otherwise no need to
				// scale.
				if (getMaxWidth() / this.getWidth() < 1) {
					double scale = getMaxWidth() / this.getWidth();

					writeNewImage(scale,bimg, tempManager);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void  writeNewImage(double scale, BufferedImage bimg, TempFilesManager tempManager) {
			java.awt.Image image = bimg.getScaledInstance(
					(int) (scale * bimg.getWidth()),
					(int) (scale * bimg.getHeight()),
					java.awt.Image.SCALE_SMOOTH);

			BufferedImage buffered = new BufferedImage(
					(int) (scale * bimg.getWidth()),
					(int) (scale * bimg.getHeight()),
					BufferedImage.TYPE_INT_RGB);

			buffered.getGraphics().drawImage(image, 0, 0, null);
			buffered.getGraphics().dispose();

			try(FileOutputStream bout = new FileOutputStream(tempManager.getTempFile(fileName))) {

				ImageIO.write(buffered, fileName.split("\\.")[fileName.split("\\.").length-1], bout);
				
				bout.flush();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
						
			this.setWidth(buffered.getWidth() + "px");
			this.setHeight(buffered.getHeight() + "px");
		}


		public float getMaxWidth() {
			return maxWidth;
		}

		public void setMaxWidth(float newWidth) {
			this.maxWidth = newWidth;			
		}
	}
	
}
