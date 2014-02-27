package fi.utu.ville.standardutils;

import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;

/**
 * Factory methods for fetching certain "standard"-ViLLE icons.
 * 
 * Medium icons are 32x32, small icons are 16x16 (at least the heights will
 * match 16 or 32).
 * 
 * @author Erkki Kaila, Riku Haavisto
 * 
 */
public enum StandardIcon {

	VERY_SMALL_ARROW_UP("vsmall_arrow_up.png"),

	VERY_SMALL_ARROW_DOWN("vsmall_arrow_down.png"),

	SUBMIT_ICON("submit.gif"),

	EDIT_ICON_SMALL("edit_icon_small.png"),

	BACK_MEDIUM("back_medium.png"),

	SUBMIT_ICON_MEDIUM("submit_medium.png"),

	RESET_ICON_MEDIUM("reset_medium.png"),

	SAVE_ICON("save_icon.png"),

	SAVE_MEDIUM("save_medium.png"),

	VILLE_CONSTRUCT_ICON("ville_construct.png"),

	PREVIOUS_MEDIUM("prev_medium.png"),

	NEXT_MEDIUM("next_medium.png"),

	CORRECT_MEDIUM("correct.png"),

	INCORRECT_MEDIUM("false.png"),

	OK_ICON("ok_icon.png"),

	DELETE_ICON("delete_icon.png"),

	MIME_WORD("mime_word.png"),

	MIME_EXCEL("mime_excel.png"),

	MIME_POWERPOINT("mime_pp.png"),

	MIME_PICTURE("mime_picture.png"),

	MIME_AUDIO("mime_sound.png"),

	MIME_VIDEO("mime_movie.png"),

	MIME_TEXT("mime_text.png"),

	MIME_PDF("mime_pdf.png"),

	MIME_OTHER("mime_other.png"),

	MIME_JAVA("mime_java.png"),

	MIME_CSHARP("mime_csharp.png"),

	MIME_CPP("mime_cpp.png"),

	INFO("info.png"),

	HELP_SMALL("help_small.png"),

	HELP_MEDIUM("help_medium.png"),

	ADD_MEDIUM("add_medium.png"),

	ADD_SMALL("add_small.png"),

	ATTACH("attach.gif"),

	ATTACHED("attached.png"),

	CALCULATOR("calculator.png"),

	CALCULATOR_MEDIUM("calculator_medium.png"),

	EXCLAM_RED_MEDIUM("exclam-red-medium.png"),

	EXCLAM_RED_SMALL("exclam-red-small.png"),

	PREVIEW("preview.gif"),

	SETTINGS("settings.png"),

	SETTINGS_MEDIUM("settings_medium.png"),

	ZOOM_ICON("zoom_icon.png"),

	ZOOM_MEDIUM("zoom_medium.png"),

	CLOCK_MEDIUM("clock_medium.png"),

	CLOCK_SMALL("clock_small.png"),

	PARENTHESES_MEDIUM("parentheses_medium.png"),

	PARENTHESES_SMALL("parentheses_small.png"),

	TODO_LIST_MEDIUM("todo-list-medium.png"),

	TODO_LIST_SMALL("todo-list-small.png"),

	GREEN_UNDERSCORE_SMALL("green_underscore_small.png"),

	GREEN_UNDERSCORE_MEDIUM("green_underscore_medium.png"),

	STOP_WATCH_SMALL("stop_watch_small.png"),

	STOP_WATCH_MEDIUM("stop_watch_medium.png"),

	STAR_SMALL("star.png"),

	STAR_MEDIUM("star_medium.png"),

	CLEAR_SMALL("clear_small.png"),

	CLEAR_MEDIUM("clear_medium.png"),

	MIME_AUDIO_MEDIUM("mime_sound_medium.png"),

	MIME_MOVIE_MEDIUM("mime_movie_medium.png"),

	MIME_TEXT_MEDIUM("mime_text_medium.png"),

	MIME_IMAGE_MEDIUM("mime_picture_medium.png"),

	MIME_OBJECT_MEDIUM("mime_object_medium.png"),

	PDF_MEDIUM("pdf_medium.png"),

	EXPLANATION_SMALL("explanation_icon_small.png"),

	EXPLANATION_MEDIUM("explanation_icon.png"),

	UPLOAD_SMALL("upload_icon_small.png"),

	UPLOAD_MEDIUM("upload_icon.png"),

	STYLES("styles_small.png")

	;

	// get out of the 'current-theme' and to the correct theme (even if starting
	// in correct theme)
	private static final String iconsBasePath = "../ville-standardutils/icons";
	private final String iconPath;

	private StandardIcon(String iconPath) {
		this.iconPath = iconPath;
	}

	/**
	 * @return represented icon as a {@link Resource}
	 */
	public Resource getIcon() {
		return new ThemeResource(iconsBasePath + "/" + iconPath);
	}

	/**
	 * Get icon for given file type.<br>
	 * The file type is first checked by the MIME type provided. If no matches
	 * are found, the filename extension is checked next.<br>
	 * If that neither is recognized, a generic icon is returned.
	 * 
	 * @param mimeType
	 *            the MIME type of the file
	 * @param filename
	 *            the name of the file with file extension included
	 * @return the icon for the given document type.
	 */
	public static Resource getMIMETypeIcon(String mimeType, String filename) {
		if (mimeType == null) {
			return MIME_OTHER.getIcon();
		}

		if (mimeType.startsWith("audio")) {
			return MIME_AUDIO.getIcon();
		}
		if (mimeType.startsWith("image")) {
			return MIME_PICTURE.getIcon();
		}
		if (mimeType.startsWith("video")) {
			return MIME_VIDEO.getIcon();
		}
		if (mimeType.contains("msword")) {
			return MIME_WORD.getIcon();
		}
		if (mimeType.contains("pdf")) {
			return MIME_PDF.getIcon();
		}
		if (mimeType.contains("ms-excel")) {
			return MIME_EXCEL.getIcon();
		}
		if (mimeType.contains("powerpoint")) {
			return MIME_POWERPOINT.getIcon();
		}
		if (mimeType.startsWith("text")) {
			return MIME_TEXT.getIcon();
		}

		// Try to identify by file name
		if (filename.endsWith("java") || filename.endsWith("class")
				|| filename.endsWith("jar")) {
			return MIME_JAVA.getIcon();
		}
		if (filename.endsWith("cpp")) {
			return MIME_CPP.getIcon();
		}
		if (filename.endsWith("cs")) {
			return MIME_CSHARP.getIcon();
		}
		if (filename.endsWith("docx")) {
			return MIME_WORD.getIcon();
		}
		if (filename.endsWith("xlsx")) {
			return MIME_EXCEL.getIcon();
		}

		return MIME_OTHER.getIcon();
	}

}
