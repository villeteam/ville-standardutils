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
import com.vaadin.shared.ui.colorpicker.Color;

public class StandardIcon {

	public static final String path = "../ville-standardutils/font-awesome-4.4.0/css/font-awesome.min.css";

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
		 * Use fa-fw to set icons at a fixed width. Great to use when variable
		 * icon widths throw off alignment. Especially useful in things like nav
		 * lists.
		 */
		FIXED_WIDTH("fa-fw"),
		/**
		 * Use fa-ul and fa-li to easily replace default bullets in unordered
		 * lists.
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
		 * To arbitrarily rotate and flip icons, use the fa-rotate-* and
		 * fa-flip-* classes.
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
		 * To stack multiple icons, use the fa-stack class on the parent, the
		 * fa-stack-1x for the regularly sized icon, and fa-stack-2x for the
		 * larger icon. fa-inverse can be used as an alternative icon color. You
		 * can even throw larger icon classes on the parent to get further
		 * control of sizing.
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

		DARK_GRAY("color-dark-gray"),

		BLACK("color-black"),

		YELLOW("color-yellow"),

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
		no_icon(0x000),
		// Arrow icons
		angle_double_down(0xf103), angle_double_left(0xf100), angle_double_right(
				0xf101), angle_double_up(0xf102), angle_down(0xf107), angle_up(
				0xf106), arrow_circle_down(0xf0ab), arrow_circle_left(0xf0a8), arrow_circle_o_down(
				0xf01a), arrow_circle_o_left(0xf190), arrow_circle_o_right(
				0xf18e), arrow_circle_o_up(0xf01b), arrow_circle_right(0xf0a9), arrow_circle_up(
				0xf0aa), arrow_down(0xf063), arrow_left(0xf060), arrow_right(
				0xf061), arrow_up(0xf062), arrows(0xf047), arrows_h(0xf07e), arrows_v(
				0xf07d), caret_down(0xf0d7), caret_left(0xf0d9), caret_right(
				0xf0da), caret_square_o_down(0xf150), caret_square_o_left(
				0xf191), caret_square_o_right(0xf152), caret_square_o_up(0xf151), caret_up(
				0xf0d8), chevron_circle_down(0xf13a), chevron_circle_left(
				0xf137), chevron_circle_right(0xf138), chevron_circle_up(0xf139), chevron_down(
				0xf078), chevron_left(0xf053), chevron_right(0xf054), chevron_up(
				0xf077), exchange(0xf0ec), external_link(0xf08e), external_link_square(
				0xf14c), hand_o_down(0xf0a7), hand_o_left(0xf0a5), hand_o_right(
				0xf0a4), hand_o_up(0xf0a6), history(0xf1da), level_down(0xf149), level_up(
				0xf148), location_arrow(0xf124), long_arrow_down(0xf175), long_arrow_left(
				0xf177), long_arrow_right(0xf178), long_arrow_up(0xf176), random(
				0xf074), recycle(0xf1b8), retweet(0xf079), share(0xf064), share_square(
				0xf14d), share_square_o(0xf045), sign_in(0xf090), sign_out(
				0xf08b), sort(0xf0dc), sort_alpha_asc(0xf15d), sort_alpha_desc(
				0xf15e), sort_amount_asc(0xf160), sort_amount_desc(0xf161), sort_asc(
				0xf0de), sort_desc(0xf0dd), sort_down(0xf0dd), sort_numeric_asc(
				0xf162), sort_numeric_desc(0xf163), sort_up(0xf0de), toggle_down(
				0xf150), toggle_left(0xf191), toggle_right(0xf152), toggle_up(
				0xf151), unsorted(0xf0dc),

		// Travel and Location Icons
		anchor(0xf13d), automobile(0xf1b9), bed(0xf236), bicycle(0xf206), building(
				0xf1ad), building_o(0xf0f7), bus(0xf207), cab(0xf1ba), car(
				0xf1b9), compass(0xf14e), dashboard(0xf0e4), fighter_jet(0xf0fb), h_square(
				0xf0fd), home(0xf015), hotel(0xf236), map_marker(0xf041), motorcycle(
				0xf21c), plane(0xf072), road(0xf018), rocket(0xf135), ship(
				0xf21a), space_shuttle(0xf197), subway(0xf239), suitcase(0xf0f2), tachometer(
				0xf0e4), taxi(0xf1ba), train(0xf238), truck(0xf0d1), wheelchair(
				0xf193),

		// Communication Icons
		at(0xf1fa), comment(0xf075), comment_o(0xf0e5), comments(0xf086), comments_o(
				0xf0e6), envelope(0xf0e0), envelope_o(0xf003), envelope_square(
				0xf199), inbox(0xf01c), mail_forward(0xf064), mail_reply(0xf112), mail_reply_all(
				0xf122), quote_left(0xf10d), quote_right(0xf10e), reply(0xf112), reply_all(
				0xf122), send(0xf1d8), send_o(0xf1d9),

		// Star Icons
		asterisk(0xf069), star(0xf005), star_half(0xf089), star_half_empty(
				0xf123), star_half_full(0xf123), star_half_o(0xf123), star_o(
				0xf006),

		// Design Icons
		adjust(0xf042), crop(0xf125), crosshairs(0xf05b), eyedropper(0xf1fb), image(
				0xf03e), magic(0xf0d0), paint_brush(0xf1fc), pencil(0xf040), pencil_square(
				0xf14b), pencil_square_o(0xf044), photo(0xf03e), picture_o(
				0xf03e), tint(0xf043),

		// Chart Icons
		area_chart(0xf1fe), bar_chart(0xf080), bar_chart_o(0xf080), line_chart(
				0xf201), pie_chart(0xf200),

		// Control Icons
		angle_left(0xf104), angle_right(0xf105), cogs(0xf085), filter(0xf0b0), gears(
				0xf085), plug(0xf1e6), power_off(0xf011), sliders(0xf1de), toggle_off(
				0xf204), toggle_on(0xf205), wrench(0xf0ad),

		// Event Icons
		certificate(0xf0a3), futbol_o(0xf1e3), gift(0xf06b), graduation_cap(
				0xf19d), mortar_board(0xf19d), soccer_ball_o(0xf1e3), trophy(
				0xf091), university(0xf19c),

		// Help Icons
		info(0xf129), info_circle(0xf05a), question(0xf128), question_circle(
				0xf059),

		// Flag Icons
		flag(0xf024), flag_checkered(0xf11e), flag_o(0xf11d),

		// Text Editor Icons
		align_center(0xf037), align_justify(0xf039), align_left(0xf036), align_right(
				0xf038), bold(0xf032), chain(0xf0c1), chain_broken(0xf127), clipboard(
				0xf0ea), columns(0xf0db), copy(0xf0c5), cut(0xf0c4), dedent(
				0xf03b), edit(0xf044), eraser(0xf12d), files_o(0xf0c5), floppy_o(
				0xf0c7), font(0xf031), header(0xf1dc), indent(0xf03c), italic(
				0xf033), link(0xf0c1), list(0xf03a), list_alt(0xf022), list_ol(
				0xf0cb), list_ul(0xf0ca), outdent(0xf03b), paperclip(0xf0c6), paragraph(
				0xf1dd), paste(0xf0ea), repeat(0xf01e), rotate_left(0xf0e2), rotate_right(
				0xf01e), save(0xf0c7), scissors(0xf0c4), strikethrough(0xf0cc), subscript(
				0xf12c), superscript(0xf12b), table(0xf0ce), text_height(0xf034), text_width(
				0xf035), th(0xf00a), th_large(0xf009), th_list(0xf00b), underline(
				0xf0cd), undo(0xf0e2), unlink(0xf127),

		// Form Icons
		circle(0xf111), circle_o(0xf10c), dot_circle_o(0xf192), minus_square(
				0xf146), minus_square_o(0xf147), plus_square(0xf0fe), plus_square_o(
				0xf196), square(0xf0c8), square_o(0xf096),

		// Media Icons
		arrows_alt(0xf0b2), backward(0xf04a), compress(0xf066), eject(0xf052), expand(
				0xf065), fast_backward(0xf049), fast_forward(0xf050), film(
				0xf008), forward(0xf04e), headphones(0xf025), microphone(0xf130), microphone_slash(
				0xf131), music(0xf001), pause(0xf04c), play(0xf04b), play_circle(
				0xf144), play_circle_o(0xf01d), step_backward(0xf048), step_forward(
				0xf051), stop(0xf04d), ticket(0xf145), video_camera(0xf03d), volume_down(
				0xf027), volume_off(0xf026), volume_up(0xf028),

		// Maths Icons
		minus(0xf068), minus_circle(0xf056), plus(0xf067), plus_circle(0xf055),

		// Technology Icons
		calculator(0xf1ec), camera(0xf030), camera_retro(0xf083), cloud_download(
				0xf0ed), cloud_upload(0xf0ee), code(0xf121), code_fork(0xf126), database(
				0xf1c0), desktop(0xf108), download(0xf019), fax(0xf1ac), gamepad(
				0xf11b), hdd_o(0xf0a0), keyboard_o(0xf11c), laptop(0xf109), mobile(
				0xf10b), mobile_phone(0xf10b), phone(0xf095), phone_square(
				0xf098), print(0xf02f), qrcode(0xf029), rss(0xf09e), rss_square(
				0xf143), server(0xf233), signal(0xf012), tablet(0xf10a), terminal(
				0xf120), tty(0xf1e4), upload(0xf093), wifi(0xf1eb),

		// Food and Drink Icons
		beer(0xf0fc), birthday_cake(0xf1fd), coffee(0xf0f4), cutlery(0xf0f5), glass(
				0xf000), spoon(0xf1b1),

		// Nature Icons
		bug(0xf188), globe(0xf0ac), leaf(0xf06c), paw(0xf1b0), tree(0xf1bb),

		// Weather Icons
		bolt(0xf0e7), cloud(0xf0c2), flash(0xf0e7), moon_o(0xf186), sun_o(
				0xf185), umbrella(0xf0e9),

		// Emergency Icons
		ambulance(0xf0f9), bullhorn(0xf0a1), fire(0xf06d), fire_extinguisher(
				0xf134), heartbeat(0xf21e), hospital_o(0xf0f8), life_bouy(
				0xf1cd), life_buoy(0xf1cd), life_ring(0xf1cd), life_saver(
				0xf1cd), medkit(0xf0fa), stethoscope(0xf0f1), support(0xf1cd),

		// Security and Warning Icons
		ban(0xf05e), bell(0xf0f3), bell_o(0xf0a2), bell_slash(0xf1f6), bell_slash_o(
				0xf1f7), bomb(0xf1e2), exclamation(0xf12a), exclamation_circle(
				0xf06a), exclamation_triangle(0xf071), key(0xf084), lock(0xf023), shield(
				0xf132), unlock(0xf09c), unlock_alt(0xf13e), warning(0xf071),

		// Organisation Icons
		archive(0xf187), barcode(0xf02a), calendar(0xf073), calendar_o(0xf133), folder(
				0xf07b), folder_o(0xf114), folder_open(0xf07c), folder_open_o(
				0xf115), remove(0xf00d), reorder(0xf0c9), search(0xf002), search_minus(
				0xf010), search_plus(0xf00e), sitemap(0xf0e8), tag(0xf02b), tags(
				0xf02c), tasks(0xf0ae), thumb_tack(0xf08d), trash(0xf1f8), trash_o(
				0xf014),

		// 3D Icons
		book(0xf02d), cube(0xf1b2), cubes(0xf1b3), language(0xf1ab), paper_plane(
				0xf1d8), paper_plane_o(0xf1d9),

		// Payment Icons
		bank(0xf19c),

		// Currency Icons
		cny(0xf157), dollar(0xf155), eur(0xf153), euro(0xf153), gbp(0xf154), ils(
				0xf20b), inr(0xf156), jpy(0xf157), krw(0xf159), money(0xf0d6), rmb(
				0xf157), rouble(0xf158), rub(0xf158), ruble(0xf158), rupee(
				0xf156), shekel(0xf20b), sheqel(0xf20b), turkish_lira(0xf195), usd(
				0xf155), won(0xf159), yen(0xf157),

		// E_Commerce Icons
		cart_arrow_down(0xf218), cart_plus(0xf217), credit_card(0xf09d), shopping_cart(
				0xf07a),

		// Spinner Icons
		circle_o_notch(0xf1ce), cog(0xf013), gear(0xf013), refresh(0xf021), spinner(
				0xf110),

		// File Type Icons
		file(0xf15b), file_archive_o(0xf1c6), file_audio_o(0xf1c7), file_code_o(
				0xf1c9), file_excel_o(0xf1c3), file_image_o(0xf1c5), file_movie_o(
				0xf1c8), file_o(0xf016), file_pdf_o(0xf1c1), file_photo_o(
				0xf1c5), file_picture_o(0xf1c5), file_powerpoint_o(0xf1c4), file_sound_o(
				0xf1c7), file_text(0xf15c), file_text_o(0xf0f6), file_video_o(
				0xf1c8), file_word_o(0xf1c2), file_zip_o(0xf1c6),

		// People Icons
		child(0xf1ae), eye(0xf06e), eye_slash(0xf070), female(0xf182), frown_o(
				0xf119), group(0xf0c0), heart(0xf004), heart_o(0xf08a), male(
				0xf183), meh_o(0xf11a), smile_o(0xf118), street_view(0xf21d), thumbs_down(
				0xf165), thumbs_o_down(0xf088), thumbs_o_up(0xf087), thumbs_up(
				0xf164), user(0xf007), user_md(0xf0f0), user_plus(0xf234), user_secret(
				0xf21b), user_times(0xf235), users(0xf0c0),

		// Gender Icons
		genderless(0xf22d), mars(0xf222), mars_double(0xf227), mars_stroke(
				0xf229), mars_stroke_h(0xf22b), mars_stroke_v(0xf22a), mercury(
				0xf223), neuter(0xf22c), transgender(0xf224), transgender_alt(
				0xf225), venus(0xf221), venus_double(0xf226), venus_mars(0xf228),

		// Ticks and Crosses Icons
		check(0xf00c), check_circle(0xf058), check_circle_o(0xf05d), check_square(
				0xf14a), check_square_o(0xf046), close(0xf00d), times(0xf00d), times_circle(
				0xf057), times_circle_o(0xf05c),

		// Legal Icons
		briefcase(0xf0b1), cc(0xf20a), copyright(0xf1f9), gavel(0xf0e3), institution(
				0xf19c), legal(0xf0e3),

		// Miscellaneous
		amazon(0xf270), balance_scale(0xf24e), bars(0xf0c9), battery_0(0xf244), battery_1(
				0xf243), battery_2(0xf242), battery_3(0xf241), battery_4(0xf240), battery_empty(
				0xf244), battery_full(0xf240), battery_half(0xf242), battery_quarter(
				0xf243), battery_three_quarters(0xf241), binoculars(0xf1e5), black_tie(
				0xf27e), bookmark(0xf02e), bookmark_o(0xf097), bullseye(0xf140), calendar_check_o(
				0xf274), calendar_minus_o(0xf272), calendar_plus_o(0xf271), calendar_times_o(
				0xf273), cc_diners_club(0xf24c), cc_jcb(0xf24b), chrome(0xf268), circle_thin(
				0xf1db), clock_o(0xf017), clone(0xf24d), commenting(0xf27a), commenting_o(
				0xf27b), contao(0xf26d), creative_commons(0xf25e), diamond(
				0xf219), ellipsis_h(0xf141), ellipsis_v(0xf142), expeditedssl(
				0xf23e), feed(0xf09e), firefox(0xf269), flask(0xf0c3), fonticons(
				0xf280), get_pocket(0xf265), gg(0xf260), gg_circle(0xf261), hand_grab_o(
				0xf255), hand_lizard_o(0xf258), hand_paper_o(0xf256), hand_peace_o(
				0xf25b), hand_pointer_o(0xf25a), hand_rock_o(0xf255), hand_scissors_o(
				0xf257), hand_spock_o(0xf259), hand_stop_o(0xf256), hourglass(
				0xf254), hourglass_1(0xf251), hourglass_2(0xf252), hourglass_3(
				0xf253), hourglass_end(0xf253), hourglass_half(0xf252), hourglass_o(
				0xf250), hourglass_start(0xf251), houzz(0xf27c), i_cursor(
				0xf246), industry(0xf275), internet_explorer(0xf26b), intersex(
				0xf224), lightbulb_o(0xf0eb), magnet(0xf076), map(0xf279), map_o(
				0xf278), map_pin(0xf276), map_signs(0xf277), mouse_pointer(
				0xf245), navicon(0xf0c9), newspaper_o(0xf1ea), object_group(
				0xf247), object_ungroup(0xf248), odnoklassniki(0xf263), odnoklassniki_square(
				0xf264), opencart(0xf23d), opera(0xf26a), optin_monster(0xf23c), puzzle_piece(
				0xf12e), registered(0xf25d), safari(0xf267), sticky_note(0xf249), sticky_note_o(
				0xf24a), television(0xf26c), trademark(0xf25c), tripadvisor(
				0xf262), tv(0xf26c), vimeo(0xf27d), wikipedia_w(0xf266), y_combinator(
				0xf23b), y_combinator_square(0xf1d4), yc(0xf23b), yc_square(
				0xf1d4),

		// Brand Icons
		adn(0xf170), android(0xf17b), angellist(0xf209), apple(0xf179), behance(
				0xf1b4), behance_square(0xf1b5), bitbucket(0xf171), bitbucket_square(
				0xf172), bitcoin(0xf15a), btc(0xf15a), buysellads(0xf20d), cc_amex(
				0xf1f3), cc_discover(0xf1f2), cc_mastercard(0xf1f1), cc_paypal(
				0xf1f4), cc_stripe(0xf1f5), cc_visa(0xf1f0), codepen(0xf1cb), connectdevelop(
				0xf20e), css3(0xf13c), dashcube(0xf210), delicious(0xf1a5), deviantart(
				0xf1bd), digg(0xf1a6), dribbble(0xf17d), dropbox(0xf16b), drupal(
				0xf1a9), empire(0xf1d1), facebook(0xf09a), facebook_f(0xf09a), facebook_official(
				0xf230), facebook_square(0xf082), flickr(0xf16e), forumbee(
				0xf211), foursquare(0xf180), ge(0xf1d1), git(0xf1d3), git_square(
				0xf1d2), github(0xf09b), github_alt(0xf113), github_square(
				0xf092), gittip(0xf184), google(0xf1a0), google_plus(0xf0d5), google_plus_square(
				0xf0d4), google_wallet(0xf1ee), gratipay(0xf184), hacker_news(
				0xf1d4), html5(0xf13b), instagram(0xf16d), ioxhost(0xf208), joomla(
				0xf1aa), jsfiddle(0xf1cc), lastfm(0xf202), lastfm_square(0xf203), leanpub(
				0xf212), linkedin(0xf0e1), linkedin_square(0xf08c), linux(
				0xf17c), maxcdn(0xf136), meanpath(0xf20c), medium(0xf23a), openid(
				0xf19b), pagelines(0xf18c), paypal(0xf1ed), pied_piper(0xf1a7), pied_piper_alt(
				0xf1a8), pinterest(0xf0d2), pinterest_p(0xf231), pinterest_square(
				0xf0d3), qq(0xf1d6), ra(0xf1d0), rebel(0xf1d0), reddit(0xf1a1), reddit_square(
				0xf1a2), renren(0xf18b), sellsy(0xf213), share_alt(0xf1e0), share_alt_square(
				0xf1e1), shirtsinbulk(0xf214), simplybuilt(0xf215), skyatlas(
				0xf216), skype(0xf17e), slack(0xf198), slideshare(0xf1e7), soundcloud(
				0xf1be), spotify(0xf1bc), stack_exchange(0xf18d), stack_overflow(
				0xf16c), steam(0xf1b6), steam_square(0xf1b7), stumbleupon(
				0xf1a4), stumbleupon_circle(0xf1a3), tencent_weibo(0xf1d5), trello(
				0xf181), tumblr(0xf173), tumblr_square(0xf174), twitch(0xf1e8), twitter(
				0xf099), twitter_square(0xf081), viacoin(0xf237), vimeo_square(
				0xf194), vine(0xf1ca), vk(0xf189), wechat(0xf1d7), weibo(0xf18a), weixin(
				0xf1d7), whatsapp(0xf232), windows(0xf17a), wordpress(0xf19a), xing(
				0xf168), xing_square(0xf169), yahoo(0xf19e), yelp(0xf1e9), youtube(
				0xf167), youtube_play(0xf16a), youtube_square(0xf166);

		private final int id;

		private RawIcon(int id) {
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
			return "&#x" + Integer.toHexString(id) + ";";
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
			return variant(null, variants);
		}

		public String variant(String customClass, IconVariant... variants) {
			return variant(null, null, variants);
		}

		public String variant(String customClass, Color color,
				IconVariant... variants) {
			String stylenames = stylename();
			String colorString = "";
			if (customClass != null) {
				stylenames += " " + customClass;
			}
			for (IconVariant v : variants) {
				stylenames += " " + v;
			}
			if (color != null) {
				colorString = "style=\"color: " + color.getCSS() + ";\"";
			}
			return "<i " + colorString + " class=\"" + stylenames + "\"></i>";
		}

	}

	public enum Icon {
		LOG_IN(RawIcon.sign_in), PHONE(RawIcon.phone), MENU(RawIcon.reorder), USER(
				RawIcon.user), HELP(RawIcon.question), CHANGE_ROLE(
				RawIcon.columns), LOG_OUT(RawIcon.sign_out), SETTINGS(
				RawIcon.cog), NAVIGATOR_ARROW_LEFT(RawIcon.chevron_left), NAVIGATOR_ARROW_RIGHT(
				RawIcon.chevron_right), ERROR(RawIcon.times_circle_o), EXIT(
				RawIcon.arrow_circle_left), SUBMIT(RawIcon.upload), RESET(RawIcon.refresh), WINDOW_MINIMIZE(
				RawIcon.compress), WINDOW_MAXIMIZE(RawIcon.expand), WINDOW(
				RawIcon.external_link), COURSE(RawIcon.book), ROUND(
				RawIcon.th_list), OK(RawIcon.check), STARTED(RawIcon.circle_o), NOT_STARTED(
				RawIcon.circle), MINIMUM_ACHIEVED(RawIcon.circle), DEADLINE(
				RawIcon.clock_o), CALENDAR(RawIcon.calendar), STUDY_JOURNAL(
				RawIcon.edit), MANUAL_OTHER(RawIcon.pencil), DONE(RawIcon.check), DEMONSTRATION(
				RawIcon.check), ATTENDANCE(RawIcon.clock_o), EXAM(RawIcon.tasks), COURSE_ASSIGNMENT(
				RawIcon.copy), REGISTRATION(RawIcon.check_circle_o), BOOKING_CALENDAR(
				RawIcon.calendar), AUTOMATIC_ASSIGNMENT(RawIcon.upload), WARNING(
				RawIcon.exclamation), NEWS(RawIcon.info), CLOSE(RawIcon.times), SEPARATOR_CARET(
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
				RawIcon.file), EDIT(RawIcon.edit), FOLDER(RawIcon.folder_o), TEST(
				RawIcon.play), COPY(RawIcon.copy), REPLY(RawIcon.reply), NEW(
				RawIcon.file), CANCEL(RawIcon.times), MATH_CHECK(RawIcon.check), MATH_NEXT(
				RawIcon.chevron_right), MATH_PREV(RawIcon.chevron_left), INFO(
				RawIcon.info), TAGS(RawIcon.tags), GENERATE(RawIcon.refresh), ADD_ASSIGNMENT(
				RawIcon.upload), ADD(RawIcon.plus), CHECK_VALIDITY(
				RawIcon.refresh), BROWSE_THUMBS(RawIcon.th), BROWSE_TABLE(
				RawIcon.table), MATH_LEVEL_EASY(RawIcon.star), STAR(
				RawIcon.star), MATH_LEVEL_NORMAL(RawIcon.star), MATH_LEVEL_HARD(
				RawIcon.star), ROUND_VISIBLE(RawIcon.eye), ROUND_HIDDEN(
				RawIcon.eye_slash), UP(RawIcon.arrow_up), DOWN(
				RawIcon.arrow_down), PREVIEW(RawIcon.eye), EXERCISE_NAME(
				RawIcon.user), EXERCISE_DESCRIPTION(RawIcon.edit), NOTES_FOR_TEACHERS(
				RawIcon.envelope), HIDE(RawIcon.eye_slash), MONITOR(
				RawIcon.desktop), CONDITIONAL_ROUND(RawIcon.list_ol), DOWNLOAD(
				RawIcon.download), ENROLL(RawIcon.sign_in), UPDATE(
				RawIcon.refresh), RFID(RawIcon.square), TEMPLATE(RawIcon.signal), CALCULATE_TOTALS(
				RawIcon.plus_circle), SURVEY(RawIcon.paste), LIBRARY(
				RawIcon.list), TEXT(RawIcon.file_o), IMAGE(RawIcon.image), AUDIO(
				RawIcon.volume_up), MOVIE(RawIcon.film), OBJECT(
				RawIcon.suitcase), TABLE(RawIcon.table), LAYOUT_SINGLE(
				RawIcon.square_o), LAYOUT_DOUBLE(RawIcon.columns), LAYOUT_2X2(
				RawIcon.th_large), LAYOUT_3X3(RawIcon.th), LAYOUT_HEADER(
				RawIcon.h_square), LAYOUT_PAGE_BREAK(RawIcon.share_alt), LAYOUT_TRIPLE(
				RawIcon.columns), UPLOAD(RawIcon.upload), SIZE(RawIcon.expand), SORT_OPTIONS(
				RawIcon.tasks), STYLE_SETTINGS(RawIcon.magic), SORT(
				RawIcon.sort), FEEDBACK(RawIcon.comment_o), SURVEY_OPTIONS_ICON(
				RawIcon.circle_o), SURVEY_BOOLEAN_ICON(RawIcon.check), SURVEY_TEXTFIELD_ICON(
				RawIcon.minus), SURVEY_TEXTAREA_ICON(RawIcon.list_alt), SURVEY_SCALE_ICON(
				RawIcon.exchange), SURVEY_EXPLANATION_ICON(RawIcon.question), SURVEY_UPLOAD_ICON(
				RawIcon.upload), SURVEY_BREAK_ICON(RawIcon.cut), SURVEY_OPTIONS_OPEN(
				RawIcon.comment), SURVEY_GRID_ICON(RawIcon.th), MIME_IMAGE_MEDIUM(
				RawIcon.image), MIME_MOVIE_MEDIUM(RawIcon.video_camera), IMAGE_TAG(
				RawIcon.tags), SURVEY_COMPONENTS(RawIcon.th_large), TEXTFIELD(
				RawIcon.list_alt), MCQ_PRECENTAGE_SELECT_ONE(
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
				RawIcon.dashboard), CATEGORY(RawIcon.list_ol), FIGHTER_JET(
				RawIcon.fighter_jet), NUMBER_LINE_TAG(RawIcon.times), VISUALIZE(
				RawIcon.camera), NEW_EXERCISE(RawIcon.plus_square_o), NEW_MESSAGE(
				RawIcon.send_o), RESULT(RawIcon.check), TERM_RANGE(
				RawIcon.arrows_h), OPERATORS(RawIcon.square), AMOUNT(
				RawIcon.database), DECREASE(RawIcon.minus), INCREASE(
				RawIcon.plus), ACHIEVEMENTS(RawIcon.trophy), MORE(RawIcon.plus), HOME_PAGE(
				RawIcon.home), MATH(RawIcon.subscript), UNDERLINE(
				RawIcon.underline), AUTOMATIC_GRADED(RawIcon.magic), CONSTRUCT(
				RawIcon.cogs), POOL(RawIcon.database), MANUAL_GRADED(
				RawIcon.edit), FOLDER_OPEN(RawIcon.folder_open), FOLDER_FILL(
				RawIcon.folder), DEMONSTRATION_EXER(RawIcon.suitcase), STUDY_JOURNAL_EXERCISE(
				RawIcon.book), MANUAL_COURSE_ASSIGNMENT(RawIcon.copy), MANUAL_EXAM(
				RawIcon.book), VIDEO(RawIcon.film), YOUTUBE(RawIcon.youtube), GEOGEBRA(
				RawIcon.superscript), OTHER_MATERIAL(RawIcon.paperclip), LECTURE(
				RawIcon.university), POLL(RawIcon.bar_chart_o), SDEDITOR(
				RawIcon.indent), WALL(RawIcon.comment), UNDO(RawIcon.undo), REDO(
				RawIcon.repeat), OPEN_POLL(RawIcon.plus), CLOSE_POLL(
				RawIcon.minus), FORUM(RawIcon.comment_o), START(RawIcon.play), STETHOSCOPE(
				RawIcon.stethoscope), NORTH(RawIcon.arrow_up), SOUTH(
				RawIcon.arrow_down), EAST(RawIcon.arrow_right), WEST(
				RawIcon.arrow_left), TURN_NORTH(RawIcon.arrow_circle_up), TURN_SOUTH(
				RawIcon.arrow_circle_down), TURN_EAST(
				RawIcon.arrow_circle_right), TURN_WEST(
				RawIcon.arrow_circle_left), IS_ROAD(RawIcon.road), LOOP(
				RawIcon.refresh), IF(RawIcon.question_circle), IFELSE(
				RawIcon.random), INFO_CIRCLE(RawIcon.info_circle), TAKE_PHOTO(RawIcon.camera),
				PH_MEASUREMENT(RawIcon.balance_scale), INCORRECT(RawIcon.close);

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
