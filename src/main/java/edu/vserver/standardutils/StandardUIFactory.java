package edu.vserver.standardutils;

import com.vaadin.server.Resource;
import com.vaadin.shared.ui.AlignmentInfo.Bits;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * A collection of factory methods for fetching certain generally usable
 * components with ViLLE-styling.
 * 
 * @author Erkki Kaila
 * 
 */
public final class StandardUIFactory {

	// all methods are static factory-methods; no need to instantiate
	private StandardUIFactory() {
	}

	/**
	 * Returns a panel that can be used to display information to user in
	 * dialogs or in UI.
	 * 
	 * @param message
	 *            the message displayed
	 * @return an information panel
	 */
	public static Label getInformationPanel(String message) {
		if (!message.contains("<br>")) {
			message += "<br>&nbsp;";
		}
		final Label lb = new Label(message, ContentMode.HTML);
		lb.setStyleName("dialog_info_panel");
		return lb;
	}

	/**
	 * @return a label with horizontal-line and html-content-mode
	 */
	public static Label getHr() {
		return new Label("<hr/>", ContentMode.HTML);
	}

	/**
	 * Returns a panel that can be used to display a warning to user in dialogs
	 * or in UI.
	 * 
	 * @param message
	 *            the message displayed
	 * @return an information panel
	 */
	public static Label getWarningPanel(String message) {
		if (!message.contains("<br>")) {
			message += "<br>&nbsp;";
		}
		final Label lb = new Label(message, ContentMode.HTML);
		lb.setStyleName("dialog_warning_panel");
		return lb;
	}

	/**
	 * Returns a panel that can be used to display an error to user in dialogs
	 * or in UI.
	 * 
	 * @param message
	 *            the message displayed
	 * @return an information panel
	 */
	public static Label getErrorPanel(String message) {
		if (!message.contains("<br>")) {
			message += "<br>&nbsp;";
		}
		final Label lb = new Label(message, ContentMode.HTML);
		lb.setStyleName("dialog_error_panel");
		return lb;
	}

	/**
	 * Returns a borderless panel with light styling.
	 * 
	 * @return new panel
	 */
	public static Panel getBorderlessLightPanel() {
		Panel p = new Panel();
		p.setStyleName("borderless light");
		return p;
	}

	/**
	 * Returns a default style button to use in dialogs and such.
	 * 
	 * @param caption
	 *            the caption of the button
	 * @param icon
	 *            the icon for the button. Use null for no icon.
	 * @return new default style button
	 */
	public static Button getDefaultButton(String caption, Resource icon) {
		Button b = new Button(caption);
		b.addStyleName("default");
		if (icon != null) {
			b.setIcon(icon);
		}
		return b;
	}

	/**
	 * Returns a small button.
	 * 
	 * @param caption
	 *            the caption of the button
	 * @return small button
	 */
	public static Button getSmallButton(String caption) {
		Button b = new Button(caption);
		b.addStyleName("small default");
		return b;
	}

	/**
	 * Return a modal window with given caption without specifying the size. A
	 * VerticalLayout is set as a default content for the window.
	 * 
	 * @param caption
	 *            the caption of the window
	 * @return new modal window
	 */
	public static Window getModalWindow(String caption) {
		Window window = new Window(caption);
		window.addStyleName("opaque");
		window.setModal(true);

		VerticalLayout layout = new VerticalLayout();
		layout.setWidth("100%");
		layout.setSpacing(true);
		layout.setMargin(true);

		window.setContent(layout);

		return window;
	}

	/**
	 * Returns a modal window with given width and caption
	 * 
	 * @param width
	 *            the width in String (e.g. "400px" or "45%")
	 * @param caption
	 *            the caption of the window
	 * @return new modal window
	 */
	public static Window getModalWindow(String width, String caption) {
		Window window = new Window(caption);
		window.addStyleName("opaque");
		window.setWidth(width);
		window.setModal(true);

		final VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setMargin(true);
		window.setContent(layout);

		return window;
	}

	/**
	 * Returns a panel with given width.
	 * 
	 * @param caption
	 *            the caption of the panel.
	 * @param width
	 *            the width of the panel
	 * @return new panel
	 */
	public static Panel getFixedWidthPanel(String caption, String width) {
		Panel p = new Panel(caption);
		p.setWidth(width);
		VerticalLayout vl = new VerticalLayout();
		vl.setSpacing(true);
		vl.setMargin(true);
		p.setContent(vl);
		p.setStyleName("bubble");
		p.addStyleName("info-panel-bolded");
		return p;
	}

	/**
	 * Returns a button to be used in the toolbar of main layouts.
	 * 
	 * @param caption
	 *            the caption of the button
	 * @return main toolbar button
	 */
	public static Button getTopButton(String caption) {
		Button b = new Button(caption);
		b.setHeight("65px");
		b.addStyleName("icon-on-top");
		b.addStyleName("default");
		return b;
	}

	/**
	 * Returns a large rounded button that can be used in selectors and such.
	 * 
	 * @param caption
	 *            the main caption of the button
	 * @param description
	 *            the description, displayed under the caption
	 * @param icon
	 *            the icon displayed in the button; preferably atleast 48 x 48
	 *            pixels.
	 * @param width
	 *            the width of the icon, e.g. "500px" or "95%". Note, that using
	 *            100% as width may lead to right hand side of the icon
	 *            disappearing.
	 * @return large rounded "button"
	 */
	public static HorizontalLayout getLargePanelButton(String caption,
			String description, Resource icon, String width) {
		final HorizontalLayout button = new HorizontalLayout();
		button.setStyleName("large_panel_button");
		button.setWidth(width);

		final Embedded buttonIcon = new Embedded(null, icon);
		final Label textLabel = new Label("<span style=\"font-size:18px\">"
				+ caption + "</span><br>" + description, ContentMode.HTML);
		button.addComponent(buttonIcon);
		button.addComponent(textLabel);
		button.setComponentAlignment(buttonIcon, new Alignment(
				Bits.ALIGNMENT_VERTICAL_CENTER));
		button.setComponentAlignment(textLabel, Alignment.MIDDLE_RIGHT);
		button.setExpandRatio(textLabel, 1.0f);
		return button;
	}

	/**
	 * Returns a button panel to use in a dialog. The buttons are centered in
	 * the panel.
	 * 
	 * @param buttonsToAdd
	 *            buttons to be added into this panel.
	 * @return dialog button panel with given buttons.
	 */
	public static HorizontalLayout getDialogButtonPanel(
			Component... buttonsToAdd) {
		final HorizontalLayout panel = new HorizontalLayout();
		panel.setMargin(true);
		panel.setWidth("100%");

		final HorizontalLayout wrapper = new HorizontalLayout();
		wrapper.setSpacing(true);
		for (Component b : buttonsToAdd) {
			wrapper.addComponent(b);
		}

		panel.addComponent(wrapper);
		panel.setComponentAlignment(wrapper, new Alignment(
				Bits.ALIGNMENT_HORIZONTAL_CENTER));

		return panel;
	}

}
