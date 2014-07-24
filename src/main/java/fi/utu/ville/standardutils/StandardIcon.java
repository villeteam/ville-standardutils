package fi.utu.ville.standardutils;

/**
 * Factory methods for fetching certain "standard"-ViLLE icons.
 * 
 * 
 * @author Erkki Kaila, Riku Haavisto
 * 
 */
import com.porotype.iconfont.FontAwesome;
import com.vaadin.server.Page;
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;

public class StandardIcon {

	// public static final String CDN =
	// "//netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css";

	public static final String path = "font-awesome/css/font-awesome.min.css";

	public static void load() {
		load(new ThemeResource(path));
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
		SIZE_LARGE("fa-lg"),
		        /**
		* 2x sized icon
		*/
		SIZE_2X("fa-2x"),
		        /**
		* 3x sized icon
		*/
		SIZE_3X("fa-3x"),
		        /**
		* 4x sized icon
		*/
		SIZE_4X("fa-4x"),
		        /**
		* 5x sized icon
		*/
		SIZE_5X("fa-5x"),
		        /**
		* Use fa-fw to set icons at a fixed width.
		* Great to use when variable icon widths throw off alignment.
		* Especially useful in things like nav lists.
		*/
		FIXED_WIDTH("fa-fw"),
		        /**
		* Use fa-ul and fa-li to easily replace default bullets in unordered lists.
		*/
		LIST("fa-li"),
		        /**
		* Spinning (animated) icon. Most useful with icons such as
		* {@link Icon#spinner}.
		*/
		SPIN("fa-spin"),
		        /**
		* Adds a border around the icon
		*/
		BORDER("fa-border"),
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
		        /**
		* To arbitrarily rotate and flip icons, use the fa-rotate-* and fa-flip-* classes.
		*/
		ROTATE_90("fa-rotate-90"),
		        /**
		*
		*/
		ROTATE_180("fa-rotate-180"),
		        /**
		*
		*/
		ROTATE_270("fa-rotate-270"),
		        /**
		*
		*/
		FLIP_HORIZONTAL("fa-flip-horizontal"),
		        /**
		*
		*/
		FLIP_VERTICAL("fa-flip-vertical"),
		        /**
		* To stack multiple icons, use the fa-stack class on the parent,
		* the fa-stack-1x for the regularly sized icon, and fa-stack-2x for the larger icon.
		* fa-inverse can be used as an alternative icon color.
		* You can even throw larger icon classes on the parent to get further control of sizing.
		*/
		STACK("fa-stack"),
		        /**
		* a-stack-1x for the regularly sized icon
		*/
		STACK_1X("fa-stack-1x"),
		        /**
		* fa-stack-2x for the larger icon
		*/
		STACK_2X("fa-stack-2x"),
		        /**
		* fa-inverse can be used as an alternative icon color
		*/
		INVERSE("fa-inverse"),

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
	     envelope_o("&#xf003;"), //
	     heart("&#xf004;"), //
	     star("&#xf005;"), //
	     star_o("&#xf006;"), //
	     user("&#xf007;"), //
	     film("&#xf008;"), //
	     th_large("&#xf009;"), //
	     th("&#xf00a;"), //
	     th_list("&#xf00b;"), //
	     check("&#xf00c;"), //
	     times("&#xf00d;"), //
	     search_plus("&#xf00e;"), //
	     search_minus("&#xf010;"), //
	     power_off("&#xf011;"), //
	     signal("&#xf012;"), //
	     gear("&#xf013;"),
	     cog("&#xf013;"), //
	     trash_o("&#xf014;"), //
	     home("&#xf015;"), //
	     file_o("&#xf016;"), //
	     clock_o("&#xf017;"), //
	     road("&#xf018;"), //
	     download("&#xf019;"), //
	     arrow_circle_o_down("&#xf01a;"), //
	     arrow_circle_o_up("&#xf01b;"), //
	     inbox("&#xf01c;"), //
	     play_circle_o("&#xf01d;"), //
	     rotate_right("&#xf01e;"),
	     repeat("&#xf01e;"), //
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
	     dedent("&#xf03b;"),
	     outdent("&#xf03b;"), //
	     indent("&#xf03c;"), //
	     video_camera("&#xf03d;"), //
	     photo("&#xf03e;"),
	     image("&#xf03e;"),
	     picture_o("&#xf03e;"), //
	     pencil("&#xf040;"), //
	     map_marker("&#xf041;"), //
	     adjust("&#xf042;"), //
	     tint("&#xf043;"), //
	     edit("&#xf044;"),
	     pencil_square_o("&#xf044;"), //
	     share_square_o("&#xf045;"), //
	     check_square_o("&#xf046;"), //
	     arrows("&#xf047;"), //
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
	     plus_circle("&#xf055;"), //
	     minus_circle("&#xf056;"), //
	     times_circle("&#xf057;"), //
	     check_circle("&#xf058;"), //
	     question_circle("&#xf059;"), //
	     info_circle("&#xf05a;"), //
	     crosshairs("&#xf05b;"), //
	     times_circle_o("&#xf05c;"), //
	     check_circle_o("&#xf05d;"), //
	     ban("&#xf05e;"), //
	     arrow_left("&#xf060;"), //
	     arrow_right("&#xf061;"), //
	     arrow_up("&#xf062;"), //
	     arrow_down("&#xf063;"), //
	     mail_forward("&#xf064;"),
	     share("&#xf064;"), //
	     expand("&#xf065;"), //
	     compress("&#xf066;"), //
	     plus("&#xf067;"), //
	     minus("&#xf068;"), //
	     asterisk("&#xf069;"), //
	     exclamation_circle("&#xf06a;"), //
	     gift("&#xf06b;"), //
	     leaf("&#xf06c;"), //
	     fire("&#xf06d;"), //
	     eye("&#xf06e;"), //
	     eye_slash("&#xf070;"), //
	     warning("&#xf071;"),
	     exclamation_triangle("&#xf071;"), //
	     plane("&#xf072;"), //
	     calendar("&#xf073;"), //
	     random("&#xf074;"), //
	     comment("&#xf075;"), //
	     magnet("&#xf076;"), //
	     chevron_up("&#xf077;"), //
	     chevron_down("&#xf078;"), //
	     retweet("&#xf079;"), //
	     shopping_cart("&#xf07a;"), //
	     folder("&#xf07b;"), //
	     folder_open("&#xf07c;"), //
	     arrows_v("&#xf07d;"), //
	     arrows_h("&#xf07e;"), //
	     bar_chart_o("&#xf080;"), //
	     twitter_square("&#xf081;"), //
	     facebook_square("&#xf082;"), //
	     camera_retro("&#xf083;"), //
	     key("&#xf084;"), //
	     gears("&#xf085;"),
	     cogs("&#xf085;"), //
	     comments("&#xf086;"), //
	     thumbs_o_up("&#xf087;"), //
	     thumbs_o_down("&#xf088;"), //
	     star_half("&#xf089;"), //
	     heart_o("&#xf08a;"), //
	     sign_out("&#xf08b;"), //
	     linkedin_square("&#xf08c;"), //
	     thumb_tack("&#xf08d;"), //
	     external_link("&#xf08e;"), //
	     sign_in("&#xf090;"), //
	     trophy("&#xf091;"), //
	     github_square("&#xf092;"), //
	     upload("&#xf093;"), //
	     lemon_o("&#xf094;"), //
	     phone("&#xf095;"), //
	     square_o("&#xf096;"), //
	     bookmark_o("&#xf097;"), //
	     phone_square("&#xf098;"), //
	     twitter("&#xf099;"), //
	     facebook("&#xf09a;"), //
	     github("&#xf09b;"), //
	     unlock("&#xf09c;"), //
	     credit_card("&#xf09d;"), //
	     rss("&#xf09e;"), //
	     hdd_o("&#xf0a0;"), //
	     bullhorn("&#xf0a1;"), //
	     bell("&#xf0f3;"), //
	     certificate("&#xf0a3;"), //
	     hand_o_right("&#xf0a4;"), //
	     hand_o_left("&#xf0a5;"), //
	     hand_o_up("&#xf0a6;"), //
	     hand_o_down("&#xf0a7;"), //
	     arrow_circle_left("&#xf0a8;"), //
	     arrow_circle_right("&#xf0a9;"), //
	     arrow_circle_up("&#xf0aa;"), //
	     arrow_circle_down("&#xf0ab;"), //
	     globe("&#xf0ac;"), //
	     wrench("&#xf0ad;"), //
	     tasks("&#xf0ae;"), //
	     filter("&#xf0b0;"), //
	     briefcase("&#xf0b1;"), //
	     arrows_alt("&#xf0b2;"), //
	     group("&#xf0c0;"),
	     users("&#xf0c0;"), //
	     chain("&#xf0c1;"),
	     link("&#xf0c1;"), //
	     cloud("&#xf0c2;"), //
	     flask("&#xf0c3;"), //
	     cut("&#xf0c4;"),
	     scissors("&#xf0c4;"), //
	     copy("&#xf0c5;"),
	     files_o("&#xf0c5;"), //
	     paperclip("&#xf0c6;"), //
	     save("&#xf0c7;"),
	     floppy_o("&#xf0c7;"), //
	     square("&#xf0c8;"), //
	     navicon("&#xf0c9;"),
	     reorder("&#xf0c9;"),
	     bars("&#xf0c9;"), //
	     list_ul("&#xf0ca;"), //
	     list_ol("&#xf0cb;"), //
	     strikethrough("&#xf0cc;"), //
	     underline("&#xf0cd;"), //
	     table("&#xf0ce;"), //
	     magic("&#xf0d0;"), //
	     truck("&#xf0d1;"), //
	     pinterest("&#xf0d2;"), //
	     pinterest_square("&#xf0d3;"), //
	     google_plus_square("&#xf0d4;"), //
	     google_plus("&#xf0d5;"), //
	     money("&#xf0d6;"), //
	     caret_down("&#xf0d7;"), //
	     caret_up("&#xf0d8;"), //
	     caret_left("&#xf0d9;"), //
	     caret_right("&#xf0da;"), //
	     columns("&#xf0db;"), //
	     unsorted("&#xf0dc;"),
	     sort("&#xf0dc;"), //
	     sort_down("&#xf0dd;"),
	     sort_desc("&#xf0dd;"), //
	     sort_up("&#xf0de;"),
	     sort_asc("&#xf0de;"), //
	     envelope("&#xf0e0;"), //
	     linkedin("&#xf0e1;"), //
	     rotate_left("&#xf0e2;"),
	     undo("&#xf0e2;"), //
	     legal("&#xf0e3;"),
	     gavel("&#xf0e3;"), //
	     dashboard("&#xf0e4;"),
	     tachometer("&#xf0e4;"), //
	     comment_o("&#xf0e5;"), //
	     comments_o("&#xf0e6;"), //
	     flash("&#xf0e7;"),
	     bolt("&#xf0e7;"), //
	     sitemap("&#xf0e8;"), //
	     umbrella("&#xf0e9;"), //
	     paste("&#xf0ea;"),
	     clipboard("&#xf0ea;"), //
	     lightbulb_o("&#xf0eb;"), //
	     exchange("&#xf0ec;"), //
	     cloud_download("&#xf0ed;"), //
	     cloud_upload("&#xf0ee;"), //
	     user_md("&#xf0f0;"), //
	     stethoscope("&#xf0f1;"), //
	     suitcase("&#xf0f2;"), //
	     bell_o("&#xf0a2;"), //
	     coffee("&#xf0f4;"), //
	     cutlery("&#xf0f5;"), //
	     file_text_o("&#xf0f6;"), //
	     building_o("&#xf0f7;"), //
	     hospital_o("&#xf0f8;"), //
	     ambulance("&#xf0f9;"), //
	     medkit("&#xf0fa;"), //
	     fighter_jet("&#xf0fb;"), //
	     beer("&#xf0fc;"), //
	     h_square("&#xf0fd;"), //
	     plus_square("&#xf0fe;"), //
	     angle_double_left("&#xf100;"), //
	     angle_double_right("&#xf101;"), //
	     angle_double_up("&#xf102;"), //
	     angle_double_down("&#xf103;"), //
	     angle_left("&#xf104;"), //
	     angle_right("&#xf105;"), //
	     angle_up("&#xf106;"), //
	     angle_down("&#xf107;"), //
	     desktop("&#xf108;"), //
	     laptop("&#xf109;"), //
	     tablet("&#xf10a;"), //
	     mobile_phone("&#xf10b;"),
	     mobile("&#xf10b;"), //
	     circle_o("&#xf10c;"), //
	     quote_left("&#xf10d;"), //
	     quote_right("&#xf10e;"), //
	     spinner("&#xf110;"), //
	     circle("&#xf111;"), //
	     mail_reply("&#xf112;"),
	     reply("&#xf112;"), //
	     github_alt("&#xf113;"), //
	     folder_o("&#xf114;"), //
	     folder_open_o("&#xf115;"), //
	     smile_o("&#xf118;"), //
	     frown_o("&#xf119;"), //
	     meh_o("&#xf11a;"), //
	     gamepad("&#xf11b;"), //
	     keyboard_o("&#xf11c;"), //
	     flag_o("&#xf11d;"), //
	     flag_checkered("&#xf11e;"), //
	     terminal("&#xf120;"), //
	     code("&#xf121;"), //
	     mail_reply_all("&#xf122;"),
	     reply_all("&#xf122;"), //
	     star_half_empty("&#xf123;"),
	     star_half_full("&#xf123;"),
	     star_half_o("&#xf123;"), //
	     location_arrow("&#xf124;"), //
	     crop("&#xf125;"), //
	     code_fork("&#xf126;"), //
	     unlink("&#xf127;"),
	     chain_broken("&#xf127;"), //
	     question("&#xf128;"), //
	     info("&#xf129;"), //
	     exclamation("&#xf12a;"), //
	     superscript("&#xf12b;"), //
	     subscript("&#xf12c;"), //
	     eraser("&#xf12d;"), //
	     puzzle_piece("&#xf12e;"), //
	     microphone("&#xf130;"), //
	     microphone_slash("&#xf131;"), //
	     shield("&#xf132;"), //
	     calendar_o("&#xf133;"), //
	     fire_extinguisher("&#xf134;"), //
	     rocket("&#xf135;"), //
	     maxcdn("&#xf136;"), //
	     chevron_circle_left("&#xf137;"), //
	     chevron_circle_right("&#xf138;"), //
	     chevron_circle_up("&#xf139;"), //
	     chevron_circle_down("&#xf13a;"), //
	     html5("&#xf13b;"), //
	     css3("&#xf13c;"), //
	     anchor("&#xf13d;"), //
	     unlock_alt("&#xf13e;"), //
	     bullseye("&#xf140;"), //
	     ellipsis_h("&#xf141;"), //
	     ellipsis_v("&#xf142;"), //
	     rss_square("&#xf143;"), //
	     play_circle("&#xf144;"), //
	     ticket("&#xf145;"), //
	     minus_square("&#xf146;"), //
	     minus_square_o("&#xf147;"), //
	     level_up("&#xf148;"), //
	     level_down("&#xf149;"), //
	     check_square("&#xf14a;"), //
	     pencil_square("&#xf14b;"), //
	     external_link_square("&#xf14c;"), //
	     share_square("&#xf14d;"), //
	     compass("&#xf14e;"), //
	     toggle_down("&#xf150;"),
	     caret_square_o_down("&#xf150;"), //
	     toggle_up("&#xf151;"),
	     caret_square_o_up("&#xf151;"), //
	     toggle_right("&#xf152;"),
	     caret_square_o_right("&#xf152;"), //
	     euro("&#xf153;"),
	     eur("&#xf153;"), //
	     gbp("&#xf154;"), //
	     dollar("&#xf155;"),
	     usd("&#xf155;"), //
	     rupee("&#xf156;"),
	     inr("&#xf156;"), //
	     cny("&#xf157;"),
	     rmb("&#xf157;"),
	     yen("&#xf157;"),
	     jpy("&#xf157;"), //
	     ruble("&#xf158;"),
	     rouble("&#xf158;"),
	     rub("&#xf158;"), //
	     won("&#xf159;"),
	     krw("&#xf159;"), //
	     bitcoin("&#xf15a;"),
	     btc("&#xf15a;"), //
	     file("&#xf15b;"), //
	     file_text("&#xf15c;"), //
	     sort_alpha_asc("&#xf15d;"), //
	     sort_alpha_desc("&#xf15e;"), //
	     sort_amount_asc("&#xf160;"), //
	     sort_amount_desc("&#xf161;"), //
	     sort_numeric_asc("&#xf162;"), //
	     sort_numeric_desc("&#xf163;"), //
	     thumbs_up("&#xf164;"), //
	     thumbs_down("&#xf165;"), //
	     youtube_square("&#xf166;"), //
	     youtube("&#xf167;"), //
	     xing("&#xf168;"), //
	     xing_square("&#xf169;"), //
	     youtube_play("&#xf16a;"), //
	     dropbox("&#xf16b;"), //
	     stack_overflow("&#xf16c;"), //
	     instagram("&#xf16d;"), //
	     flickr("&#xf16e;"), //
	     adn("&#xf170;"), //
	     bitbucket("&#xf171;"), //
	     bitbucket_square("&#xf172;"), //
	     tumblr("&#xf173;"), //
	     tumblr_square("&#xf174;"), //
	     long_arrow_down("&#xf175;"), //
	     long_arrow_up("&#xf176;"), //
	     long_arrow_left("&#xf177;"), //
	     long_arrow_right("&#xf178;"), //
	     apple("&#xf179;"), //
	     windows("&#xf17a;"), //
	     android("&#xf17b;"), //
	     linux("&#xf17c;"), //
	     dribbble("&#xf17d;"), //
	     skype("&#xf17e;"), //
	     foursquare("&#xf180;"), //
	     trello("&#xf181;"), //
	     female("&#xf182;"), //
	     male("&#xf183;"), //
	     gittip("&#xf184;"), //
	     sun_o("&#xf185;"), //
	     moon_o("&#xf186;"), //
	     archive("&#xf187;"), //
	     bug("&#xf188;"), //
	     vk("&#xf189;"), //
	     weibo("&#xf18a;"), //
	     renren("&#xf18b;"), //
	     pagelines("&#xf18c;"), //
	     stack_exchange("&#xf18d;"), //
	     arrow_circle_o_right("&#xf18e;"), //
	     arrow_circle_o_left("&#xf190;"), //
	     toggle_left("&#xf191;"),
	     caret_square_o_left("&#xf191;"), //
	     dot_circle_o("&#xf192;"), //
	     wheelchair("&#xf193;"), //
	     vimeo_square("&#xf194;"), //
	     turkish_lira("&#xf195;"),
	     try_FI("&#xf195;"), //
	     plus_square_o("&#xf196;"), //
	     space_shuttle("&#xf197;"), //
	     slack("&#xf198;"), //
	     envelope_square("&#xf199;"), //
	     wordpress("&#xf19a;"), //
	     openid("&#xf19b;"), //
	     institution("&#xf19c;"),
	     bank("&#xf19c;"),
	     university("&#xf19c;"), //
	     mortar_board("&#xf19d;"),
	     graduation_cap("&#xf19d;"), //
	     yahoo("&#xf19e;"), //
	     google("&#xf1a0;"), //
	     reddit("&#xf1a1;"), //
	     reddit_square("&#xf1a2;"), //
	     stumbleupon_circle("&#xf1a3;"), //
	     stumbleupon("&#xf1a4;"), //
	     delicious("&#xf1a5;"), //
	     digg("&#xf1a6;"), //
	     pied_piper_square("&#xf1a7;"),
	     pied_piper("&#xf1a7;"), //
	     pied_piper_alt("&#xf1a8;"), //
	     drupal("&#xf1a9;"), //
	     joomla("&#xf1aa;"), //
	     language("&#xf1ab;"), //
	     fax("&#xf1ac;"), //
	     building("&#xf1ad;"), //
	     child("&#xf1ae;"), //
	     paw("&#xf1b0;"), //
	     spoon("&#xf1b1;"), //
	     cube("&#xf1b2;"), //
	     cubes("&#xf1b3;"), //
	     behance("&#xf1b4;"), //
	     behance_square("&#xf1b5;"), //
	     steam("&#xf1b6;"), //
	     steam_square("&#xf1b7;"), //
	     recycle("&#xf1b8;"), //
	     automobile("&#xf1b9;"),
	     car("&#xf1b9;"), //
	     cab("&#xf1ba;"),
	     taxi("&#xf1ba;"), //
	     tree("&#xf1bb;"), //
	     spotify("&#xf1bc;"), //
	     deviantart("&#xf1bd;"), //
	     soundcloud("&#xf1be;"), //
	     database("&#xf1c0;"), //
	     file_pdf_o("&#xf1c1;"), //
	     file_word_o("&#xf1c2;"), //
	     file_excel_o("&#xf1c3;"), //
	     file_powerpoint_o("&#xf1c4;"), //
	     file_photo_o("&#xf1c5;"),
	     file_picture_o("&#xf1c5;"),
	     file_image_o("&#xf1c5;"), //
	     file_zip_o("&#xf1c6;"),
	     file_archive_o("&#xf1c6;"), //
	     file_sound_o("&#xf1c7;"),
	     file_audio_o("&#xf1c7;"), //
	     file_movie_o("&#xf1c8;"),
	     file_video_o("&#xf1c8;"), //
	     file_code_o("&#xf1c9;"), //
	     vine("&#xf1ca;"), //
	     codepen("&#xf1cb;"), //
	     jsfiddle("&#xf1cc;"), //
	     life_bouy("&#xf1cd;"),
	     life_saver("&#xf1cd;"),
	     support("&#xf1cd;"),
	     life_ring("&#xf1cd;"), //
	     circle_o_notch("&#xf1ce;"), //
	     ra("&#xf1d0;"),
	     rebel("&#xf1d0;"), //
	     ge("&#xf1d1;"),
	     empire("&#xf1d1;"), //
	     git_square("&#xf1d2;"), //
	     git("&#xf1d3;"), //
	     hacker_news("&#xf1d4;"), //
	     tencent_weibo("&#xf1d5;"), //
	     qq("&#xf1d6;"), //
	     wechat("&#xf1d7;"),
	     weixin("&#xf1d7;"), //
	     send("&#xf1d8;"),
	     paper_plane("&#xf1d8;"), //
	     send_o("&#xf1d9;"),
	     paper_plane_o("&#xf1d9;"), //
	     history("&#xf1da;"), //
	     circle_thin("&#xf1db;"), //
	     header("&#xf1dc;"), //
	     paragraph("&#xf1dd;"), //
	     sliders("&#xf1de;"), //
	     share_alt("&#xf1e0;"), //
	     share_alt_square("&#xf1e1;"), //
	     bomb("&#xf1e2;"); //

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
			return "fa fa-" + name().replaceAll("_FI", "").replaceAll("_", "-");
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
		LOG_IN(RawIcon.sign_in), MENU(RawIcon.reorder), USER(RawIcon.user), HELP(
				RawIcon.question), CHANGE_ROLE(RawIcon.columns), LOG_OUT(
				RawIcon.sign_out), SETTINGS(RawIcon.cog), NAVIGATOR_ARROW_LEFT(
				RawIcon.chevron_left), NAVIGATOR_ARROW_RIGHT(
				RawIcon.chevron_right), EXIT(RawIcon.times), SUBMIT(
				RawIcon.upload), RESET(RawIcon.refresh), WINDOW_MINIMIZE(
				RawIcon.compress), WINDOW_MAXIMIZE(RawIcon.expand), WINDOW(
				RawIcon.external_link), COURSE(RawIcon.book), ROUND(
				RawIcon.th_list), OK(RawIcon.check), STARTED(RawIcon.circle_o), NOT_STARTED(
				RawIcon.circle), MINIMUM_ACHIEVED(RawIcon.circle), DEADLINE(
				RawIcon.clock_o), CALENDAR(RawIcon.calendar), STUDY_JOURNAL(
				RawIcon.edit), MANUAL_OTHER(RawIcon.pencil), DONE(RawIcon.check), DEMONSTRATION(
				RawIcon.check), ATTENDANCE(RawIcon.clock_o), EXAM(RawIcon.tasks), COURSE_ASSIGNMENT(
				RawIcon.copy), REGISTRATION(RawIcon.check_circle_o), BOOKING_CALENDAR(
				RawIcon.calendar), AUTOMATIC_ASSIGNMENT(RawIcon.upload), WARNING(
				RawIcon.exclamation), NEWS(RawIcon.info), CLOSE(
				RawIcon.times), SEPARATOR_CARET(
				RawIcon.angle_double_right), PROFILE(RawIcon.user), MESSAGES(
				RawIcon.envelope_o), INBOX(RawIcon.inbox), SENT_MAIL(
				RawIcon.share), OWN_RESOURCES(RawIcon.star), PUBLIC_RESOURCES(
				RawIcon.th), EXERCISE(RawIcon.edit), MATERIALS(RawIcon.image), TUTORIAL(
				RawIcon.file_o), STUDENTS(RawIcon.group), STATISTICS(
				RawIcon.bar_chart_o), STUDENT_PERFORMANCE(RawIcon.tasks), MANUALLY_GRADED(
				RawIcon.check), PRACTICAL_WORK(RawIcon.flask), FOLD(
				RawIcon.minus), UNFOLD(RawIcon.plus), BOOKMARK(RawIcon.bookmark), CONTACTS(
				RawIcon.tags), PASSWORD(RawIcon.lock), SAVE(RawIcon.save), DELETE(
				RawIcon.trash_o), REVIEW(RawIcon.check), GROUPS(RawIcon.group), EVENTS(
				RawIcon.clock_o), TEACHER(RawIcon.user), NAVIGATOR_ARROW_FIRST(
				RawIcon.step_backward), NAVIGATOR_ARROW_LAST(
				RawIcon.step_forward), PANEL_FOLD(RawIcon.sort_down), PANEL_UNFOLD(
				RawIcon.caret_right), SEARCH(RawIcon.search), NEW_RESOURCE(
				RawIcon.file), EDIT(RawIcon.edit), FOLDER(
				RawIcon.folder_o), TEST(RawIcon.play), COPY(
				RawIcon.copy), REPLY(RawIcon.reply), NEW(RawIcon.file), CANCEL(
				RawIcon.times), MATH_CHECK(RawIcon.check), MATH_NEXT(
				RawIcon.chevron_right), MATH_PREV(RawIcon.chevron_left), INFO(
				RawIcon.info), TAGS(RawIcon.tags), GENERATE(
				RawIcon.refresh), ADD_ASSIGNMENT(RawIcon.upload), ADD(
				RawIcon.plus), CHECK_VALIDITY(RawIcon.refresh), BROWSE_THUMBS(
				RawIcon.th), BROWSE_TABLE(RawIcon.table), MATH_LEVEL_EASY(
				RawIcon.star), MATH_LEVEL_NORMAL(RawIcon.star), MATH_LEVEL_HARD(
				RawIcon.star), ROUND_VISIBLE(RawIcon.eye), ROUND_HIDDEN(
				RawIcon.eye_slash), UP(RawIcon.arrow_up), DOWN(
				RawIcon.arrow_down), PREVIEW(RawIcon.eye), EXERCISE_NAME(
				RawIcon.user), EXERCISE_DESCRIPTION(RawIcon.edit), NOTES_FOR_TEACHERS(
				RawIcon.envelope), HIDE(RawIcon.eye_slash), MONITOR(
				RawIcon.desktop), CONDITIONAL_ROUND(RawIcon.list_ol), DOWNLOAD(
				RawIcon.download), ENROLL(RawIcon.sign_in), UPDATE(
				RawIcon.refresh), RFID(RawIcon.square), TEMPLATE(
				RawIcon.signal), CALCULATE_TOTALS(RawIcon.plus_circle), SURVEY(

		RawIcon.paste), LIBRARY(RawIcon.list), TEXT(RawIcon.file_o), IMAGE(
				RawIcon.image), AUDIO(RawIcon.volume_up), MOVIE(RawIcon.film), OBJECT(
				RawIcon.suitcase), TABLE(RawIcon.table), LAYOUT_SINGLE(
				RawIcon.square_o), LAYOUT_DOUBLE(RawIcon.columns), LAYOUT_2X2(
				RawIcon.th_large), LAYOUT_3X3(RawIcon.th), LAYOUT_HEADER(
				RawIcon.h_square), LAYOUT_PAGE_BREAK(RawIcon.share_alt), LAYOUT_TRIPLE(
				RawIcon.columns),

		UPLOAD(RawIcon.upload), SIZE(RawIcon.expand), SORT_OPTIONS(
				RawIcon.tasks), STYLE_SETTINGS(RawIcon.magic), SORT(
				RawIcon.sort), FEEDBACK(RawIcon.comment_o), SURVEY_OPTIONS_ICON(
				RawIcon.circle_o), SURVEY_BOOLEAN_ICON(RawIcon.check), SURVEY_TEXTFIELD_ICON(
				RawIcon.minus), SURVEY_TEXTAREA_ICON(RawIcon.list_alt), SURVEY_SCALE_ICON(
				RawIcon.exchange), SURVEY_EXPLANATION_ICON(
				RawIcon.question), SURVEY_UPLOAD_ICON(RawIcon.upload), SURVEY_BREAK_ICON(
				RawIcon.cut), SURVEY_OPTIONS_OPEN(RawIcon.comment), SURVEY_GRID_ICON(
				RawIcon.th), MIME_IMAGE_MEDIUM(RawIcon.image), MIME_MOVIE_MEDIUM(
				RawIcon.video_camera), IMAGE_TAG(RawIcon.tags), SURVEY_COMPONENTS(
				RawIcon.th_large), TEXTFIELD(RawIcon.list_alt), MCQ_PRECENTAGE_SELECT_ONE(
				RawIcon.plus_circle), MCQ_COMBINED_PERCENTAGE(
				RawIcon.plus_square), SHORT_ANSWER(RawIcon.font), MCQ(
				RawIcon.list), MCQ_MATH(RawIcon.thumb_tack), QUESTIONS(
				RawIcon.question), OPTION_GROUP(RawIcon.circle_o), NEXT(
				RawIcon.arrow_circle_right), PREVIOUS(RawIcon.arrow_circle_left), CODE_EDITOR(
				RawIcon.edit), TRANSLATE(RawIcon.refresh), ANIMATION_CONTROLS(
				RawIcon.play_circle), NEW_ARRAY_QUESTIONS(RawIcon.question), ATTACH(
				RawIcon.plus_circle), DETACH(RawIcon.minus_circle), ANSWER(
				RawIcon.edit), EXPLANATION(RawIcon.comment), VARIABLES(
				RawIcon.cogs), EXERCISE_POOL(RawIcon.hdd_o), PEER_REVIEW(
				RawIcon.group), VILLE_CS(RawIcon.flask), KEY(RawIcon.key), STACK(
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
