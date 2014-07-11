package fi.utu.ville.standardutils;

/**
 * Factory methods for fetching certain "standard"-ViLLE icons.
 * 
 * 
 * @author Erkki Kaila, Riku Haavisto
 * 
 */
import com.porotype.iconfont.FontAwesome;
import com.vaadin.server.ExternalResource;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;

public class StandardIcon {

	// public static final String CDN =
	// "//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css";

	public static final String CDN = "//cdnjs.cloudflare.com/ajax/libs/font-awesome/3.0.2/css/font-awesome.min.css";

	public static void load() {
		load(new ExternalResource(CDN));
	}

	/**
	 * Loads the FontAwesome CSS, and thus actual font, from the given location.
	 * <p>
	 * <code>
	 * FontAwesome.load(new ThemeResource("font-awesome/css/font-awesome.min.css"));
	 * </code>
	 * </p>
	 * 
	 * @param fontAwesomeCss
	 */
	public static void load(Resource fontAwesomeCss) {
		Page.getCurrent().getStyles().add(fontAwesomeCss);
	}

	/**
	 * Icon variant; multiple can be used, but all combinations do not make
	 * sense.
	 * 
	 * @author marc
	 * 
	 */
	public enum IconVariant {
		/**
		 * A larger icon
		 */
		SIZE_LARGE("icon-large"),
		/**
		 * 2x sized icon
		 */
		SIZE_2X("icon-2x"),
		/**
		 * 3x sized icon
		 */
		SIZE_3X("icon-3x"),
		/**
		 * 4x sized icon
		 */
		SIZE_4X("icon-4x"),
		/**
		 * Spinning (animated) icon. Most useful with icons such as
		 * {@link Icon#spinner}.
		 */
		SPIN("icon-spin"),
		/**
		 * Adds a border around the icon
		 */
		BORDER("icon-border"),
		/**
		 * For e.g for easy pull quotes or article graphics, with larger icons
		 * next to text.
		 */
		PULL_LEFT("pull-left"),
		/**
		 * For e.g for easy pull quotes or article graphics, with larger icons
		 * next to text.
		 */
		PULL_RIGHT("pull-right"),

		BLUE("color-blue"),

		GREEN("color-green"),

		RED("color-red"),

		ORANGE("color-orange"),

		WHITE("color-white"),

		BLACK("color-black"),

		SIZE_SMALL("icon-small");

		private final String stylename;

		IconVariant(String stylename) {
			this.stylename = stylename;
		}

		@Override
		public String toString() {
			return stylename;
		}
	}

	/**
	 * Font-Awesome icon.
	 * <p>
	 * The basic {@link #toString()} will produce HTML representing the regular
	 * icon.<br/>
	 * For variants, {@link #variant(IconVariant...)} can be used with one or
	 * more {@link IconVariant}s.<br/>
	 * For custom cases, the stylename is available via {@link #stylename()}.
	 * </p>
	 * <p>
	 * Remember to {@link FontAwesome#load()} (or
	 * {@link FontAwesome#load(Resource)}) first.
	 * </p>
	 * 
	 * @author marc
	 * 
	 */
	public enum RawIcon {
		glass("&#xf000;"), //
		music("&#xf001;"), //
		search("&#xf002;"), //
		envelope("&#xf003;"), //
		heart("&#xf004;"), //
		star("&#xf005;"), //
		star_empty("&#xf006;"), //
		user("&#xf007;"), //
		film("&#xf008;"), //
		th_large("&#xf009;"), //
		th("&#xf00a;"), //
		th_list("&#xf00b;"), //
		ok("&#xf00c;"), //
		remove("&#xf00d;"), //
		zoom_in("&#xf00e;"), //

		zoom_out("&#xf010;"), //
		off("&#xf011;"), //
		signal("&#xf012;"), //
		cog("&#xf013;"), //
		trash("&#xf014;"), //
		home("&#xf015;"), //
		file("&#xf016;"), //
		time("&#xf017;"), //
		road("&#xf018;"), //
		download_alt("&#xf019;"), //
		download("&#xf01a;"), //
		upload("&#xf01b;"), //
		inbox("&#xf01c;"), //
		play_circle("&#xf01d;"), //
		repeat("&#xf01e;"), //

		/* &#xf020 doesn't work in Safari. all shifted one down */
		refresh("&#xf021;"), //
		list_alt("&#xf022;"), //
		lock("&#xf023;"), //
		flag("&#xf024;"), //
		headphones("&#xf025;"), //
		volume_off("&#xf026;"), //
		volume_down("&#xf027;"), //
		volume_up("&#xf028;"), //
		qrcode("&#xf029;"), //
		barcode("&#xf02a;"), //
		tag("&#xf02b;"), //
		tags("&#xf02c;"), //
		book("&#xf02d;"), //
		bookmark("&#xf02e;"), //
		print("&#xf02f;"), //

		camera("&#xf030;"), //
		font("&#xf031;"), //
		bold("&#xf032;"), //
		italic("&#xf033;"), //
		text_height("&#xf034;"), //
		text_width("&#xf035;"), //
		align_left("&#xf036;"), //
		align_center("&#xf037;"), //
		align_right("&#xf038;"), //
		align_justify("&#xf039;"), //
		list("&#xf03a;"), //
		indent_left("&#xf03b;"), //
		indent_right("&#xf03c;"), //
		facetime_video("&#xf03d;"), //
		picture("&#xf03e;"), //

		pencil("&#xf040;"), //
		map_marker("&#xf041;"), //
		adjust("&#xf042;"), //
		tint("&#xf043;"), //
		edit("&#xf044;"), //
		share("&#xf045;"), //
		check("&#xf046;"), //
		move("&#xf047;"), //
		step_backward("&#xf048;"), //
		fast_backward("&#xf049;"), //
		backward("&#xf04a;"), //
		play("&#xf04b;"), //
		pause("&#xf04c;"), //
		stop("&#xf04d;"), //
		forward("&#xf04e;"), //

		fast_forward("&#xf050;"), //
		step_forward("&#xf051;"), //
		eject("&#xf052;"), //
		chevron_left("&#xf053;"), //
		chevron_right("&#xf054;"), //
		plus_sign("&#xf055;"), //
		minus_sign("&#xf056;"), //
		remove_sign("&#xf057;"), //
		ok_sign("&#xf058;"), //
		question_sign("&#xf059;"), //
		info_sign("&#xf05a;"), //
		screenshot("&#xf05b;"), //
		remove_circle("&#xf05c;"), //
		ok_circle("&#xf05d;"), //
		ban_circle("&#xf05e;"), //

		arrow_left("&#xf060;"), //
		arrow_right("&#xf061;"), //
		arrow_up("&#xf062;"), //
		arrow_down("&#xf063;"), //
		share_alt("&#xf064;"), //
		resize_full("&#xf065;"), //
		resize_small("&#xf066;"), //
		plus("&#xf067;"), //
		minus("&#xf068;"), //
		asterisk("&#xf069;"), //
		exclamation_sign("&#xf06a;"), //
		gift("&#xf06b;"), //
		leaf("&#xf06c;"), //
		fire("&#xf06d;"), //
		eye_open("&#xf06e;"), //

		eye_close("&#xf070;"), //
		warning_sign("&#xf071;"), //
		plane("&#xf072;"), //
		calendar("&#xf073;"), //
		random("&#xf074;"), //
		comment("&#xf075;"), //
		magnet("&#xf076;"), //
		chevron_up("&#xf077;"), //
		chevron_down("&#xf078;"), //
		retweet("&#xf079;"), //
		shopping_cart("&#xf07a;"), //
		folder_close("&#xf07b;"), //
		folder_open("&#xf07c;"), //
		resize_vertical("&#xf07d;"), //
		resize_horizontal("&#xf07e;"), //

		bar_chart("&#xf080;"), //
		twitter_sign("&#xf081;"), //
		facebook_sign("&#xf082;"), //
		camera_retro("&#xf083;"), //
		key("&#xf084;"), //
		cogs("&#xf085;"), //
		comments("&#xf086;"), //
		thumbs_up("&#xf087;"), //
		thumbs_down("&#xf088;"), //
		star_half("&#xf089;"), //
		heart_empty("&#xf08a;"), //
		signout("&#xf08b;"), //
		linkedin_sign("&#xf08c;"), //
		pushpin("&#xf08d;"), //
		external_link("&#xf08e;"), //

		signin("&#xf090;"), //
		trophy("&#xf091;"), //
		github_sign("&#xf092;"), //
		upload_alt("&#xf093;"), //
		lemon("&#xf094;"), //
		phone("&#xf095;"), //
		check_empty("&#xf096;"), //
		bookmark_empty("&#xf097;"), //
		phone_sign("&#xf098;"), //
		twitter("&#xf099;"), //
		facebook("&#xf09a;"), //
		github("&#xf09b;"), //
		unlock("&#xf09c;"), //
		credit_card("&#xf09d;"), //
		rss("&#xf09e;"), //

		hdd("&#xf0a0;"), //
		bullhorn("&#xf0a1;"), //
		bell("&#xf0a2;"), //
		certificate("&#xf0a3;"), //
		hand_right("&#xf0a4;"), //
		hand_left("&#xf0a5;"), //
		hand_up("&#xf0a6;"), //
		hand_down("&#xf0a7;"), //
		circle_arrow_left("&#xf0a8;"), //
		circle_arrow_right("&#xf0a9;"), //
		circle_arrow_up("&#xf0aa;"), //
		circle_arrow_down("&#xf0ab;"), //
		globe("&#xf0ac;"), //
		wrench("&#xf0ad;"), //
		tasks("&#xf0ae;"), //

		filter("&#xf0b0;"), //
		briefcase("&#xf0b1;"), //
		fullscreen("&#xf0b2;"), //

		group("&#xf0c0;"), //
		link("&#xf0c1;"), //
		cloud("&#xf0c2;"), //
		beaker("&#xf0c3;"), //
		cut("&#xf0c4;"), //
		copy("&#xf0c5;"), //
		paper_clip("&#xf0c6;"), //
		save("&#xf0c7;"), //
		sign_blank("&#xf0c8;"), //
		reorder("&#xf0c9;"), //
		list_ul("&#xf0ca;"), //
		list_ol("&#xf0cb;"), //
		strikethrough("&#xf0cc;"), //
		underline("&#xf0cd;"), //
		table("&#xf0ce;"), //

		magic("&#xf0d0;"), //
		truck("&#xf0d1;"), //
		pinterest("&#xf0d2;"), //
		pinterest_sign("&#xf0d3;"), //
		google_plus_sign("&#xf0d4;"), //
		google_plus("&#xf0d5;"), //
		money("&#xf0d6;"), //
		caret_down("&#xf0d7;"), //
		caret_up("&#xf0d8;"), //
		caret_left("&#xf0d9;"), //
		caret_right("&#xf0da;"), //
		columns("&#xf0db;"), //
		sort("&#xf0dc;"), //
		sort_down("&#xf0dd;"), //
		sort_up("&#xf0de;"), //

		envelope_alt("&#xf0e0;"), //
		linkedin("&#xf0e1;"), //
		undo("&#xf0e2;"), //
		legal("&#xf0e3;"), //
		dashboard("&#xf0e4;"), //
		comment_alt("&#xf0e5;"), //
		comments_alt("&#xf0e6;"), //
		bolt("&#xf0e7;"), //
		sitemap("&#xf0e8;"), //
		umbrella("&#xf0e9;"), //
		paste("&#xf0ea;"), //
		lightbulb("&#xf0eb;"), //
		exchange("&#xf0ec;"), //
		cloud_download("&#xf0ed;"), //
		cloud_upload("&#xf0ee;"), //

		user_md("&#xf0f0;"), //
		stethoscope("&#xf0f1;"), //
		suitcase("&#xf0f2;"), //
		bell_alt("&#xf0f3;"), //
		coffee("&#xf0f4;"), //
		food("&#xf0f5;"), //
		file_alt("&#xf0f6;"), //
		building("&#xf0f7;"), //
		hospital("&#xf0f8;"), //
		ambulance("&#xf0f9;"), //
		medkit("&#xf0fa;"), //
		fighter_jet("&#xf0fb;"), //
		beer("&#xf0fc;"), //
		h_sign("&#xf0fd;"), //
		plus_sign_alt("&#xf0fe;"), //

		double_angle_left("&#xf100;"), //
		double_angle_right("&#xf101;"), //
		double_angle_up("&#xf102;"), //
		double_angle_down("&#xf103;"), //
		angle_left("&#xf104;"), //
		angle_right("&#xf105;"), //
		angle_up("&#xf106;"), //
		angle_down("&#xf107;"), //
		desktop("&#xf108;"), //
		laptop("&#xf109;"), //
		tablet("&#xf10a;"), //
		mobile_phone("&#xf10b;"), //
		circle_blank("&#xf10c;"), //
		quote_left("&#xf10d;"), //
		quote_right("&#xf10e;"), //

		spinner("&#xf110;"), //
		circle("&#xf111;"), //
		reply("&#xf112;"), //
		github_alt("&#xf113;"), //
		folder_close_alt("&#xf114;"), //
		folder_open_alt("&#xf115;");

		private final String id;

		private RawIcon(String id) {
			this.id = id;
		}

		@Override
		public String toString() {
			return variant();
		}

		/**
		 * Gets the character entity used for this {@link RawIcon}.
		 * 
		 * @return character entity
		 */
		public String id() {
			return id;
		}

		/**
		 * Gets the stylename used for this {@link RawIcon}.
		 * 
		 * @return the icon stylename
		 */
		public String stylename() {
			return "icon-" + name().replaceAll("_", "-");
		}

		/**
		 * Gets the icon HTML with the given {@link IconVariant}s added.
		 * <p>
		 * Multiple {@link IconVariant}s can be used, but all combinations do
		 * not make sense.
		 * </p>
		 * 
		 * @param variants
		 * @return
		 */
		public String variant(IconVariant... variants) {
			String stylenames = stylename();
			for (IconVariant v : variants) {
				stylenames += " " + v;
			}
			return "<i class=\"" + stylenames + "\"></i>";
		}

	}

	public enum Icon {
		LOG_IN(RawIcon.signin), MENU(RawIcon.reorder), USER(RawIcon.user), HELP(
				RawIcon.question_sign), CHANGE_ROLE(RawIcon.columns), LOG_OUT(
				RawIcon.signout), SETTINGS(RawIcon.cog), NAVIGATOR_ARROW_LEFT(
				RawIcon.chevron_left), NAVIGATOR_ARROW_RIGHT(
				RawIcon.chevron_right), EXIT(RawIcon.remove), SUBMIT(
				RawIcon.upload_alt), RESET(RawIcon.refresh), WINDOW_MINIMIZE(
				RawIcon.resize_small), WINDOW_MAXIMIZE(RawIcon.resize_full), WINDOW(
				RawIcon.external_link), COURSE(RawIcon.book), ROUND(
				RawIcon.th_list), OK(RawIcon.ok), STARTED(RawIcon.circle_blank), NOT_STARTED(
				RawIcon.circle), MINIMUM_ACHIEVED(RawIcon.circle), DEADLINE(
				RawIcon.time), CALENDAR(RawIcon.calendar), STUDY_JOURNAL(
				RawIcon.edit), MANUAL_OTHER(RawIcon.pencil), DONE(RawIcon.check), DEMONSTRATION(
				RawIcon.check), ATTENDANCE(RawIcon.time), EXAM(RawIcon.tasks), COURSE_ASSIGNMENT(
				RawIcon.copy), REGISTRATION(RawIcon.ok_circle), BOOKING_CALENDAR(
				RawIcon.calendar), AUTOMATIC_ASSIGNMENT(RawIcon.upload_alt), WARNING(
				RawIcon.exclamation_sign), NEWS(RawIcon.info_sign), CLOSE(
				RawIcon.remove_sign), SEPARATOR_CARET(
				RawIcon.double_angle_right), PROFILE(RawIcon.user), MESSAGES(
				RawIcon.envelope_alt), INBOX(RawIcon.inbox), SENT_MAIL(
				RawIcon.share), OWN_RESOURCES(RawIcon.star), PUBLIC_RESOURCES(
				RawIcon.th), EXERCISE(RawIcon.edit), MATERIALS(RawIcon.picture), TUTORIAL(
				RawIcon.file_alt), STUDENTS(RawIcon.group), STATISTICS(
				RawIcon.bar_chart), STUDENT_PERFORMANCE(RawIcon.tasks), MANUALLY_GRADED(
				RawIcon.check), PRACTICAL_WORK(RawIcon.beaker), FOLD(
				RawIcon.minus), UNFOLD(RawIcon.plus), BOOKMARK(RawIcon.bookmark), CONTACTS(
				RawIcon.tags), PASSWORD(RawIcon.lock), SAVE(RawIcon.save), DELETE(
				RawIcon.trash), REVIEW(RawIcon.check), GROUPS(RawIcon.group), EVENTS(
				RawIcon.time), TEACHER(RawIcon.user), NAVIGATOR_ARROW_FIRST(
				RawIcon.step_backward), NAVIGATOR_ARROW_LAST(
				RawIcon.step_forward), PANEL_FOLD(RawIcon.sort_down), PANEL_UNFOLD(
				RawIcon.caret_right), SEARCH(RawIcon.search), NEW_RESOURCE(
				RawIcon.file), EDIT(RawIcon.edit), FOLDER(
				RawIcon.folder_close_alt), TEST(RawIcon.play), COPY(
				RawIcon.copy), REPLY(RawIcon.reply), NEW(RawIcon.file), CANCEL(
				RawIcon.remove), MATH_CHECK(RawIcon.check), MATH_NEXT(
				RawIcon.chevron_right), MATH_PREV(RawIcon.chevron_left), INFO(
				RawIcon.info_sign), TAGS(RawIcon.tags), GENERATE(
				RawIcon.refresh), ADD_ASSIGNMENT(RawIcon.upload), ADD(
				RawIcon.plus), CHECK_VALIDITY(RawIcon.refresh), BROWSE_THUMBS(
				RawIcon.th), BROWSE_TABLE(RawIcon.table), MATH_LEVEL_EASY(
				RawIcon.star), MATH_LEVEL_NORMAL(RawIcon.star), MATH_LEVEL_HARD(
				RawIcon.star), ROUND_VISIBLE(RawIcon.eye_open), ROUND_HIDDEN(
				RawIcon.eye_close), UP(RawIcon.arrow_up), DOWN(
				RawIcon.arrow_down), PREVIEW(RawIcon.eye_open), EXERCISE_NAME(
				RawIcon.user), EXERCISE_DESCRIPTION(RawIcon.edit), NOTES_FOR_TEACHERS(
				RawIcon.envelope), HIDE(RawIcon.eye_close), MONITOR(
				RawIcon.desktop), CONDITIONAL_ROUND(RawIcon.list_ol), DOWNLOAD(
				RawIcon.download_alt), ENROLL(RawIcon.signin), UPDATE(
				RawIcon.refresh), RFID(RawIcon.sign_blank), TEMPLATE(
				RawIcon.signal), CALCULATE_TOTALS(RawIcon.plus_sign), SURVEY(

		RawIcon.paste), LIBRARY(RawIcon.list), TEXT(RawIcon.file_alt), IMAGE(
				RawIcon.picture), AUDIO(RawIcon.volume_up), MOVIE(RawIcon.film), OBJECT(
				RawIcon.suitcase), TABLE(RawIcon.table), LAYOUT_SINGLE(
				RawIcon.check_empty), LAYOUT_DOUBLE(RawIcon.columns), LAYOUT_2X2(
				RawIcon.th_large), LAYOUT_3X3(RawIcon.th), LAYOUT_HEADER(
				RawIcon.h_sign), LAYOUT_PAGE_BREAK(RawIcon.share_alt), LAYOUT_TRIPLE(
				RawIcon.columns),

		UPLOAD(RawIcon.upload), SIZE(RawIcon.resize_full), SORT_OPTIONS(
				RawIcon.tasks), STYLE_SETTINGS(RawIcon.magic), SORT(
				RawIcon.sort), FEEDBACK(RawIcon.comment_alt), SURVEY_OPTIONS_ICON(
				RawIcon.circle_blank), SURVEY_BOOLEAN_ICON(RawIcon.check), SURVEY_TEXTFIELD_ICON(
				RawIcon.minus), SURVEY_TEXTAREA_ICON(RawIcon.list_alt), SURVEY_SCALE_ICON(
				RawIcon.exchange), SURVEY_EXPLANATION_ICON(
				RawIcon.question_sign), SURVEY_UPLOAD_ICON(RawIcon.upload), SURVEY_BREAK_ICON(
				RawIcon.cut), SURVEY_OPTIONS_OPEN(RawIcon.comment), SURVEY_GRID_ICON(
				RawIcon.th), MIME_IMAGE_MEDIUM(RawIcon.picture), MIME_MOVIE_MEDIUM(
				RawIcon.facetime_video), IMAGE_TAG(RawIcon.tags), SURVEY_COMPONENTS(
				RawIcon.th_large), TEXTFIELD(RawIcon.list_alt), MCQ_PRECENTAGE_SELECT_ONE(
				RawIcon.plus_sign), MCQ_COMBINED_PERCENTAGE(
				RawIcon.plus_sign_alt), SHORT_ANSWER(RawIcon.font), MCQ(
				RawIcon.list), MCQ_MATH(RawIcon.pushpin), QUESTIONS(
				RawIcon.question_sign), OPTION_GROUP(RawIcon.circle_blank), NEXT(
				RawIcon.circle_arrow_right), PREVIOUS(RawIcon.circle_arrow_left), CODE_EDITOR(
				RawIcon.edit), TRANSLATE(RawIcon.refresh), ANIMATION_CONTROLS(
				RawIcon.play_circle), NEW_ARRAY_QUESTIONS(RawIcon.question_sign), ATTACH(
				RawIcon.plus_sign), DETACH(RawIcon.minus_sign), ANSWER(
				RawIcon.edit), EXPLANATION(RawIcon.comment), VARIABLES(
				RawIcon.cogs), EXERCISE_POOL(RawIcon.hdd), PEER_REVIEW(
				RawIcon.group), VILLE_CS(RawIcon.beaker), KEY(RawIcon.key), STACK(
				RawIcon.align_justify), SHARED_MEMORY(RawIcon.share), MATH_PERFORMANCE(
				RawIcon.dashboard), CATEGORY(RawIcon.list_ol);

		private final RawIcon rawIcon;

		private Icon(RawIcon icon) {
			rawIcon = icon;
		}

		public RawIcon getIcon() {
			return rawIcon;
		}

	}

	public enum OldIcon {

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

		// get out of the 'current-theme' and to the correct theme (even if
		// starting
		// in correct theme)
		private static final String iconsBasePath = "../ville-standardutils/icons";
		private final String iconPath;

		private OldIcon(String iconPath) {
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
		 * The file type is first checked by the MIME type provided. If no
		 * matches are found, the filename extension is checked next.<br>
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
}
