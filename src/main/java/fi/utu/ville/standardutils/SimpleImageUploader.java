package fi.utu.ville.standardutils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;

import com.vaadin.ui.VerticalLayout;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.server.Resource;
import com.vaadin.server.StreamResource;
import com.vaadin.server.StreamResource.StreamSource;
import com.vaadin.ui.Image;
import fi.utu.ville.standardutils.SimpleFileUploader.UploaderListener;

import org.vaadin.risto.stepper.IntStepper;

public class SimpleImageUploader extends VerticalLayout {

	private static final long serialVersionUID = 3281090786118827523L;

	private final String mimeTypeFilter = "^image/.*$";
	
	private final SimpleFileUploader uploader;
	private final IntStepper maxWidthStepper;
	private final VerticalLayout imageContainer;
	
	private float maxWidth = ScaledImage.DEFAULT_MAX_WIDTH;
	
	private boolean showStepper = true;
	private boolean showImage = false;
	
	public SimpleImageUploader(Localizer localizer,
			TempFilesManager tempManager, int maxUploadSize) {
		this.uploader = new SimpleFileUploader(localizer,tempManager,maxUploadSize,mimeTypeFilter);
		this.maxWidthStepper = new IntStepper(StandardUIConstants.MAX_WIDTH);
		this.imageContainer = new VerticalLayout();
		doLayout();
	}
	
	public void registerUploaderListener(UploaderListener listener) {
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
		uploader.setUploadedFile(uplFile, fireUploadEvent);
	}

	public void setAbstractUploadedFile(AbstractFile abstFile) {
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
		
		maxWidthStepper.addValueChangeListener(new ValueChangeListener() {

			private static final long serialVersionUID = -2756336993178151135L;

			@Override
			public void valueChange(ValueChangeEvent event) {
				maxWidth = maxWidthStepper.getValue();				
			}
			
		});
	}
	
	public abstract class ImageUploaderListener implements UploaderListener{

		private static final long serialVersionUID = 891682132265510102L;

		@Override
		public void fileUploadSucceeded(File tempFile, String fileName,
				String mimeType) {
			AbstractFile newFile = new AFFile(tempFile);
			
			ScaledImage result = new ScaledImage();
			result.setMaxWidth(maxWidth);
			result.setSource(newFile.getRawData(), fileName);
			if(showImage) {imageContainer.removeAllComponents();imageContainer.addComponent(result);}
			
			fileUploadSucceeded(result,fileName);			
		}
		
		public abstract void fileUploadSucceeded(Image image, String fileName);
		
	}
	
	public class ScaledImage extends Image implements Serializable {

		private static final long serialVersionUID = -2183720246344657143L;

		private byte[] bytes;
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

		public Resource setSource(final byte[] bytes,String fileName) {
			if(bytes == null) return null;
			this.bytes = bytes;
			this.fileName = fileName;
			resize();
			StreamSource strSrc = new StreamSource() {

				private static final long serialVersionUID = 1L;

				public InputStream getStream() {
					ByteArrayInputStream bis = new ByteArrayInputStream(ScaledImage.this.bytes);

					return bis;
				}

			};

			StreamResource strRes = new StreamResource(strSrc, fileName);
			
			super.setSource(strRes);
			return strRes;
		}
		

		public byte[] getBytes() {
			return bytes;
		}

		public String getFileName() {
			return fileName;
		}

		public void resize() {

			BufferedImage bimg = null;

			try {
				bimg = ImageIO.read(new ByteArrayInputStream(bytes));
				
				this.setWidth(bimg.getWidth() + "px");
				this.setHeight(bimg.getHeight() + "px");

				// Check if width or height is too large. Otherwise no need to
				// scale.
				if (getMaxWidth() / this.getWidth() < 1) {
					double scale = getMaxWidth() / this.getWidth();

					writeNewImage(scale,bimg);
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void  writeNewImage(double scale, BufferedImage bimg) {
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

			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			boolean resizeRes;
			try {
				resizeRes = ImageIO.write(buffered, fileName.split("\\.")[fileName.split("\\.").length-1], bout);
				System.out.println("resize-res: " + resizeRes);
			} catch (IOException e) {
				e.printStackTrace();
			}
						 
			bytes = bout.toByteArray();
						
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
