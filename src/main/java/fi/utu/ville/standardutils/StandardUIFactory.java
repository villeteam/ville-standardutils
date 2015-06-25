package fi.utu.ville.standardutils;

import com.vaadin.shared.ui.AlignmentInfo.Bits;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.Panel;
import com.vaadin.ui.ProgressBar;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.themes.BaseTheme;

import fi.utu.ville.standardutils.StandardIcon.Icon;
import fi.utu.ville.standardutils.StandardIcon.IconVariant;
import fi.utu.ville.standardutils.ui.AbstractEditorLayout;

/**
 * <p>
 * Class for creating all elements in ViLLE 7 UI.
 * <p>
 * Please note, that all elements in new UI should be received from this class.
 * If you need something that's not found, add it to UIFactory instead of
 * creating local elements.
 * </p>
 * 
 * @author temira,ertaka
 * 
 */
public class StandardUIFactory {

	/**
	 * <p>
	 * Enum for border styles; if used outside UIFactory, use something like
	 * <p>
	 * <tt>component.addStyleName(Border.LEFT.getValue());</tt>
	 * 
	 */
	public enum Border {
		TOP("panel-border-top"), RIGHT("panel-border-right"), BOTTOM(
				"panel-border-bottom"), LEFT("panel-border-left"), ALL(
				"panel-border-all"), NONE("panel-border-none");

		private final String value;

		Border(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * Style for panels; SMALL has less padding and smaller font size.
	 * 
	 */
	public enum PanelStyle {
		SMALL, DEFAULT, NONE;
	}

	/**
	 * Align for text in components; if used outside UIFactory, use something
	 * like
	 * <p>
	 * <tt>component.addStyleName(TextAlign.LEFT.getValue());</tt>
	 * 
	 */
	public enum TextAlign {
		LEFT("text-align-left"), CENTER("text-align-center"), RIGHT(
				"text-align-right");

		private final String value;

		TextAlign(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}
	}

	/**
	 * Return a small icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getBlackIconSmall(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.BLACK),
				ContentMode.HTML);
	}

	/**
	 * Return a default sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getBlueIcon(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.BLUE,
				IconVariant.SIZE_LARGE), ContentMode.HTML);
	}

	/**
	 * Return a double sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getBlueIcon2X(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.BLUE,
				IconVariant.SIZE_2X), ContentMode.HTML);
	}

	/**
	 * Return a medium (3x) sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getBlueIconMedium(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.BLUE,
				IconVariant.SIZE_3X), ContentMode.HTML);
	}

	/**
	 * Return a small icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getBlueIconSmall(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.BLUE),
				ContentMode.HTML);
	}

	public static VerticalLayout getBubbleWihtCaption(String caption,
			Icon icon, Component component) {
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setWidth("100%");

		Label label = getFormTitleLabel(caption, icon);
		layout.addComponent(label);
		layout.setExpandRatio(label, 0f);

		CssLayout bubble = new CssLayout();
		bubble.addComponent(component);
		bubble.addStyleName("bubble-layout-gray");

		// component.setWidth("100%");
		layout.addStyleName("margin-bottom-15");
		layout.addComponent(bubble);
		layout.setExpandRatio(bubble, 1f);

		return layout;
	}

	/**
	 * Get default button with a blue icon
	 * 
	 * @param caption
	 *            button caption
	 * @param icon
	 *            icon shown in button; @see {@link IconFactory}
	 * @return new button
	 */
	public static Button getButton(String caption, Icon icon) {
		return getButton(caption, icon, IconVariant.BLUE);
	}

	/**
	 * Get default button with specified IconVariant
	 * 
	 * @param caption
	 *            button caption
	 * @param icon
	 *            icon shown in button; @see {@link IconFactory}
	 * @param iconVariant
	 *            IconVariant used for icon.
	 * @return new button
	 */
	public static Button getButton(String caption, Icon icon,
			IconVariant iconVariant) {

		if (icon == null) {
			final Button button = new Button(caption);
			button.setHtmlContentAllowed(false);
			return button;
		}

		final Button button = new Button(icon.getIcon().variant(iconVariant,
				IconVariant.SIZE_LARGE)
				+ "&nbsp;&nbsp;&nbsp;" + caption);
		button.setHtmlContentAllowed(true);
		return button;
	}

	/**
	 * Get button caption only for situations when the button already exists.
	 * 
	 * @param caption
	 *            button caption
	 * @param icon
	 *            icon shown in button; @see {@link IconFactory}
	 * @return button caption
	 */
	public static String getButtonCaption(String caption, Icon icon) {
		return icon.getIcon().variant(IconVariant.BLUE, IconVariant.SIZE_LARGE)
				+ "&nbsp;&nbsp;&nbsp;" + caption;
	}

	/**
	 * Returns a panel for UI buttons
	 * 
	 * @param buttons
	 *            buttons to be inserted into panel
	 * @return panel for buttons
	 */
	public static HorizontalLayout getButtonPanel(Alignment alignment,
			Component... buttons) {
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setStyleName("button-container-gray");
		buttonLayout.setWidth("100%");

		HorizontalLayout layout = new HorizontalLayout();
		layout.setSpacing(true);
		for (Component button : buttons) {
			layout.addComponent(button);
		}
		buttonLayout.addComponent(layout);
		buttonLayout.setComponentAlignment(layout, alignment);
		return buttonLayout;
	}

	/**
	 * Returns a panel for UI buttons
	 * 
	 * @param buttons
	 *            buttons to be inserted into panel
	 * @return panel for buttons
	 */
	public static HorizontalLayout getButtonPanel(Component... buttons) {
		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.setStyleName("button-container-gray");
		buttonLayout.setWidth("100%");

		HorizontalLayout layout = new HorizontalLayout();
		layout.setSpacing(true);
		for (Component button : buttons) {
			layout.addComponent(button);
		}
		buttonLayout.addComponent(layout);
		return buttonLayout;
	}

	/**
	 * Returns a panel for selecting level in exercise editor
	 * 
	 * @param buttons
	 *            buttons to be inserted into panel
	 * @return Math level selection bar
	 */
	public static HorizontalLayout getButtonPanelForLevels(Component... buttons) {

		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.addStyleName("button-container-gray");
		buttonLayout.addStyleName("math-levels-bar");
		buttonLayout.setWidth("100%");

		HorizontalLayout layout = new HorizontalLayout();
		layout.setSpacing(true);
		// layout.setWidth("100%");
		for (Component button : buttons) {
			layout.addComponent(button);
			layout.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
		}

		buttonLayout.addComponent(layout);
		buttonLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		return buttonLayout;

	}

	/**
	 * Returns a panel for MathLayout to show Check-button, Next-button and
	 * progressbar
	 * 
	 * @param buttons
	 *            buttons to be inserted into panel
	 * @return Math navigation bar
	 */
	public static HorizontalLayout getButtonPanelForMathControls(
			Component... buttons) {

		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.addStyleName("button-container-gray");
		buttonLayout.addStyleName("math-nav-bar");
		buttonLayout.setWidth("100%");

		HorizontalLayout layout = new HorizontalLayout();
		layout.setSpacing(true);
		// layout.setWidth("100%");
		for (Component button : buttons) {
			layout.addComponent(button);
			layout.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
		}

		layout.getComponent(2).addStyleName("math-progress-margin");

		// Component c = layout.getComponent(layout.getComponentCount() - 1);
		// layout.setComponentAlignment(c, Alignment.MIDDLE_RIGHT);
		buttonLayout.addComponent(layout);
		buttonLayout.setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
		return buttonLayout;

	}

	/**
	 * Returns default cancel button
	 * 
	 * @param localizer
	 *            for localizing caption
	 * @return cancel button
	 */
	public static Button getCancelButton(Localizer localizer) {
		return getButton(localizer.getUIText(StandardUIConstants.CANCEL),
				Icon.CANCEL);
	}

	/**
	 * Returns a caption with icon left
	 * 
	 * @param caption
	 *            visible text
	 * @param icon
	 *            icon displayed on the left side of the icon
	 * @return caption with icon
	 */
	public static String getCaptionIconLeft(String caption, Icon icon) {
		return icon.getIcon().variant(IconVariant.BLUE, IconVariant.SIZE_LARGE)
				+ "&nbsp;&nbsp;&nbsp;" + caption;
	}

	/**
	 * Returns a caption with icon right
	 * 
	 * @param caption
	 *            visible text
	 * @param icon
	 *            icon displayed on the right side of the icon
	 * @return caption with icon
	 */
	public static String getCaptionIconRight(String caption, Icon icon) {
		return caption
				+ "&nbsp;&nbsp;&nbsp;"
				+ icon.getIcon().variant(IconVariant.BLUE,
						IconVariant.SIZE_LARGE);
	}

	/**
	 * Returns default close button
	 * 
	 * @param localizer
	 *            for localizing caption
	 * @return close button
	 */
	public static Button getCloseButton(Localizer localizer) {
		return getButton(localizer.getUIText(StandardUIConstants.CLOSE),
				Icon.CLOSE);
	}

	public static Label getComponentTitle(String title) {
		return new Label("<strong>" + title + "</strong>", ContentMode.HTML);
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
		panel.setWidth("100%");

		final HorizontalLayout wrapper = new HorizontalLayout();
		wrapper.setSpacing(true);
		for (Component b : buttonsToAdd) {
			wrapper.addComponent(b);
		}

		panel.addComponent(wrapper);
		panel.setComponentAlignment(wrapper,
				new Alignment(Bits.ALIGNMENT_RIGHT));

		return panel;
	}

	public static Panel getExpandablePanel() {
		Panel p = new Panel();
		VerticalLayout vl = new VerticalLayout();
		p.setContent(vl);
		vl.setSpacing(true);
		vl.setMargin(true);
		p.addStyleName("panel-nostyle");
		return p;
	}

	public static Panel getExpandablePanelNoContent() {
		Panel p = new Panel();
		VerticalLayout vl = new VerticalLayout();
		p.setContent(vl);
		vl.setSpacing(true);
		vl.setMargin(true);
		p.addStyleName("panel-nostyle");
		return p;
	}

	/**
	 * Returns a panel with given width. A VerticalLayout is added as default
	 * content.
	 * 
	 * @param width
	 *            the width of the panel
	 * @return new panel
	 */
	public static Panel getFixedWidthPanel(String width) {
		Panel p = new Panel();
		p.setWidth(width);

		VerticalLayout vl = new VerticalLayout();
		p.setContent(vl);

		vl.setSpacing(true);
		vl.setMargin(true);

		return p;
	}

	/**
	 * Returns a panel for form components
	 * 
	 * @param caption
	 *            the caption of the form
	 * @param icon
	 *            icon for the form
	 * @param titleWidth
	 *            the width of the component captions; this should be long
	 *            enough to fit all components in this form in all languagesa.
	 * @param components
	 *            all form components
	 * @return a form panel
	 */
	public static VerticalLayout getFormPanel(String caption, Icon icon,
			String titleWidth, Component... components) {

		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setWidth("100%");

		if (caption != null) {
			Label label = getFormTitleLabel(caption, icon);
			layout.addComponent(label);
		}
		VerticalLayout content = getVerticalGrayContentLayout(PanelStyle.DEFAULT);
		content.setSpacing(true);
		layout.addComponent(content);

		for (Component component : components) {
			HorizontalLayout rowLayout = new HorizontalLayout();
			rowLayout.setSpacing(true);
			rowLayout.setWidth("100%");
			Label titleLabel = new Label(component.getCaption());
			titleLabel.setSizeUndefined();
			HorizontalLayout titleLayout = new HorizontalLayout();
			titleLayout.setWidth(titleWidth);
			titleLayout.addComponent(titleLabel);
			titleLayout.setComponentAlignment(titleLabel,
					Alignment.MIDDLE_RIGHT);
			component.setCaption(null);
			rowLayout.addComponent(titleLayout);
			rowLayout.addComponent(component);
			rowLayout.setComponentAlignment(titleLayout, Alignment.TOP_RIGHT);
			rowLayout.setComponentAlignment(component, Alignment.MIDDLE_LEFT);
			rowLayout.setExpandRatio(component, 1);

			content.addComponent(rowLayout);
		}

		return layout;
	}

	/**
	 * Returns a label used as a form title / header
	 * 
	 * @param caption
	 *            form title
	 * @param icon
	 *            icon displayed besides the title
	 * @return form title
	 */
	public static Label getFormTitleLabel(String caption, Icon icon) {
		Label label = new Label(icon.getIcon().variant(IconVariant.GREEN)
				+ "&nbsp;&nbsp;&nbsp;" + caption, ContentMode.HTML);
		label.addStyleName("panel-title");
		return label;
	}

	/**
	 * Get default button with a green icon
	 * 
	 * @param caption
	 *            button caption
	 * @param icon
	 *            icon shown in button; @see {@link IconFactory}
	 * @return new button
	 */
	public static Button getGreenButton(String caption, Icon icon) {
		return getButton(caption, icon, IconVariant.GREEN);
	}

	/**
	 * Return a default sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getGreenIcon(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.GREEN,
				IconVariant.SIZE_LARGE), ContentMode.HTML);
	}

	/**
	 * Return a double sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getGreenIcon2X(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.GREEN,
				IconVariant.SIZE_2X), ContentMode.HTML);
	}

	/**
	 * Return a medium (3x) sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getGreenIconMedium(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.GREEN,
				IconVariant.SIZE_3X), ContentMode.HTML);
	}

	/**
	 * Return a small icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getGreenIconSmall(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.GREEN),
				ContentMode.HTML);
	}

	/**
	 * Return a black header bar, used as a caption for some panels
	 * 
	 * @return black header bar
	 */
	public static HorizontalLayout getHeaderBarBlack() {
		HorizontalLayout bar = new HorizontalLayout();
		bar.setSpacing(true);
		bar.setStyleName("sub-header-black");
		bar.setHeight("40px");
		bar.setWidth("100%");
		return bar;
	}

	/**
	 * Returns a blue "sub" header bar
	 * 
	 * @return sub header bar
	 */
	public static HorizontalLayout getHeaderBarBlue() {
		HorizontalLayout bar = new HorizontalLayout();
		bar.setSpacing(true);
		bar.setStyleName("sub-header-blue");
		bar.setHeight("30px");
		bar.setWidth("100%");
		return bar;
	}

	/**
	 * Returns a green "main" header bar
	 * 
	 * @return main header bar
	 */
	public static HorizontalLayout getHeaderBarGreen() {
		HorizontalLayout bar = new HorizontalLayout();
		bar.setSpacing(true);
		bar.setStyleName("sub-header-green");
		bar.setHeight("40px");
		bar.setWidth("100%");
		return bar;
	}

	public static VerticalLayout getIconCaptionPanel(String caption, Icon icon,
			Component... components) {
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setWidth("100%");

		Label label = getFormTitleLabel(caption, icon);
		layout.addComponent(label);

		VerticalLayout content = getVerticalGrayContentLayout(PanelStyle.DEFAULT);
		content.setSpacing(true);
		content.setSizeFull();
		layout.addComponent(content);
		layout.setExpandRatio(content, 1);

		for (Component component : components) {
			content.addComponent(component);
		}

		return layout;
	}

	/**
	 * Return a button that contains only an icon
	 * 
	 * @param icon
	 *            icon for button
	 * @return button without caption
	 */
	public static Button getIconOnlyButton(Icon icon) {
		final Button button = new Button(icon.getIcon().variant(
				IconVariant.BLUE, IconVariant.SIZE_LARGE));
		button.addStyleName("only-icon");
		button.setHtmlContentAllowed(true);
		return button;
	}

	/**
	 * Returns an info panel for laying out components without borders or such;
	 * 
	 * @return an info panel
	 */
	public static VerticalLayout getInfoPanel() {
		VerticalLayout layout = new VerticalLayout();
		layout.setWidth("100%");
		layout.setSpacing(true);
		layout.setStyleName("info-container");
		return layout;
	}

	/**
	 * Returns a panel that can be used to display an information message to
	 * user in dialogs or in UI.
	 * 
	 * @param message
	 *            the message displayed
	 * @return an information panel
	 */
	public static HorizontalLayout getInformationPanel(String message) {
		if (!message.contains("<br>")) {
			message += "<br>&nbsp;";
		}
		HorizontalLayout layout = new HorizontalLayout();
		layout.setWidth("100%");
		layout.setStyleName("information-panel");

		Label iconLabel = StandardUIFactory.getWhiteIconMedium(Icon.INFO);
		iconLabel.setWidth("40px");
		layout.addComponent(iconLabel);

		Label content = StandardUIFactory.getPanelTitle(message);

		layout.addComponent(content);
		layout.setExpandRatio(content, 1);
		return layout;
	}

	/**
	 * Return a large panel button
	 * 
	 * @param title
	 *            button caption
	 * @param description
	 *            button description, displayed below the title
	 * @param icon
	 *            icon displayed in button
	 * @return a large panel button
	 */
	public static HorizontalLayout getLargePanelButton(String title,
			String description, Icon icon) {
		HorizontalLayout layout = new HorizontalLayout();
		layout.setWidth("250px");
		layout.setStyleName("large-panel-button");

		Label iconLabel = StandardUIFactory.getBlueIcon2X(icon);
		iconLabel.setWidth("40px");
		layout.addComponent(iconLabel);

		VerticalLayout titleLayout = new VerticalLayout();
		titleLayout.addComponent(StandardUIFactory.getPanelTitle(title));
		titleLayout
				.addComponent(StandardUIFactory.getPanelContent(description));

		layout.addComponent(titleLayout);
		layout.setExpandRatio(titleLayout, 1);
		return layout;
	}

	public static Button getLinkButton(String caption, Icon icon) {
		final Button button = new Button(icon.getIcon().variant(
				IconVariant.BLUE)
				+ "&nbsp;" + caption);
		button.setStyleName(BaseTheme.BUTTON_LINK);
		button.setHtmlContentAllowed(true);
		return button;
	}

	public static Window getModalWindow(String width, String caption) {
		final Window window = new Window(caption);
		window.setModal(true);
		window.setWidth(width);
		return window;
	}

	/**
	 * Retruns progressbar used in coding exercises.
	 * 
	 * @param initValue
	 *            progress
	 * @return progressbar
	 */
	// progressbar does not poll by default anymore
	public static ProgressBar getNonPollingProgressIndicator(float initValue) {
		ProgressBar res = new ProgressBar(initValue);
		return res;
	}

	/**
	 * Returns default save button
	 * 
	 * @param localizer
	 *            for localizing caption
	 * @return save button
	 */
	public static Button getOKButton(Localizer localizer) {
		return getButton(localizer.getUIText(StandardUIConstants.OK), Icon.OK);
	}

	/**
	 * Return a default sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getOrangeIcon(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.ORANGE,
				IconVariant.SIZE_LARGE), ContentMode.HTML);
	}

	/**
	 * Return a double sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getOrangeIcon2X(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.ORANGE,
				IconVariant.SIZE_2X), ContentMode.HTML);
	}

	/**
	 * Return a medium (3x) sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getOrangeIconMedium(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.ORANGE,
				IconVariant.SIZE_3X), ContentMode.HTML);
	}

	/**
	 * Return a small icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getOrangeIconSmall(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.ORANGE),
				ContentMode.HTML);
	}

	/**
	 * Returns a label to be used as a panel content
	 * 
	 * @param content
	 *            content as HTML string
	 * @return panel content label
	 */
	public static Label getPanelContent(String content) {
		Label label = new Label(content, ContentMode.HTML);
		label.setStyleName("panel-content");
		return label;
	}

	/**
	 * Returns a title component to be used inside panels
	 * 
	 * @param title
	 *            title caption
	 * @return panel title
	 */
	public static Label getPanelTitle(String title) {
		Label label = new Label(title, ContentMode.HTML);
		label.setStyleName("panel-title");
		return label;
	}

	/**
	 * Returns a blue title component to be used inside panels
	 * 
	 * @param title
	 *            title caption
	 * @return panel title
	 */
	public static Label getPanelTitleBlue(String title) {
		Label label = new Label(title, ContentMode.HTML);
		label.setStyleName("panel-title");
		label.addStyleName("color-blue");
		return label;
	}

	/**
	 * Retruns default preview/test button used in exercise editors.
	 * 
	 * @param localizer
	 *            for localizing caption
	 * @return Preview/test button
	 */
	public static Button getPreviewButton(Localizer localizer) {
		return getButton(localizer.getUIText(StandardUIConstants.PREVIEW),
				Icon.PREVIEW);
	}

	/**
	 * Return a default sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getRedIcon(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.RED,
				IconVariant.SIZE_LARGE), ContentMode.HTML);
	}

	/**
	 * Return a double sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getRedIcon2X(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.RED,
				IconVariant.SIZE_2X), ContentMode.HTML);
	}

	/**
	 * Return a medium (3x) sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getRedIconMedium(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.RED,
				IconVariant.SIZE_3X), ContentMode.HTML);
	}

	/**
	 * Return a small icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getRedIconSmall(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.RED),
				ContentMode.HTML);
	}

	/**
	 * Returns default save button
	 * 
	 * @param localizer
	 *            for localizing caption
	 * @return save button
	 */
	public static Button getSaveButton(Localizer localizer) {
		return getButton(localizer.getUIText(StandardUIConstants.SAVE),
				Icon.SAVE);
	}

	/**
	 * Returns a new select element
	 * 
	 * @param caption
	 *            caption for select element
	 * @param items
	 *            items; same string is used for item id and caption
	 * @return new select element
	 */
	public static NativeSelect getSelect(String caption, String[] items) {
		NativeSelect box = new NativeSelect(caption);
		box.setNullSelectionAllowed(false);
		for (String item : items) {
			box.addItem(item);
		}

		if (items.length > 0) {
			box.select(items[0]);
		}

		return box;
	}

	/**
	 * Return a select element from a localizable enum with all items localized.
	 * 
	 * @param caption
	 *            caption for element. Will be run through the localizer.
	 * @param localizer
	 * @param enumeration
	 *            The values() of a localizable enum
	 * @return a select element. Item id is the enum itself and its caption is the localized string it gives.
	 */
	public static NativeSelect getSelect(String caption,
			Localizer localizer, LocalizableEnum... enumeration) {
		NativeSelect select = new NativeSelect(localizer.getUIText(caption));
		
		if(enumeration == null || enumeration.length == 0)
			return select;
		
		select.setNullSelectionAllowed(false);
		for (LocalizableEnum kv : enumeration) {
			if(kv.getLocalizerString().equals(LocalizableEnum.HIDDEN))
				continue;
						
			select.addItem(kv);
			
			if(kv.getLocalizerString().equals(LocalizableEnum.UNLOCALIZED))
				continue;
			
			select.setItemCaption(kv, localizer.getUIText(kv.getLocalizerString()));
		}

		return select;
	}
	
	/**
	 * Returns a label to be used as a separator between components in panels
	 * and such
	 * 
	 * @return content separator
	 */
	public static Label getSeparator() {
		return new Label("<hr>", ContentMode.HTML);
	}

	public static Button getSmallButton(String caption) {
		final Button button = new Button(caption);
		button.setStyleName("only-icon");
		button.setHtmlContentAllowed(true);
		return button;
	}

	/**
	 * Returns smaller button with icon only
	 * 
	 * @param icon
	 *            icon for button
	 * @return button without caption
	 */
	public static Button getSmallIconOnlyButton(Icon icon) {
		final Button button = new Button(icon.getIcon().variant(
				IconVariant.BLUE));
		button.setStyleName("only-icon");
		button.setHtmlContentAllowed(true);
		return button;
	}

	/**
	 * Returns smaller button with icon only
	 * 
	 * @param icon
	 *            icon for button
	 * @return button without caption
	 */
	public static Button getSmallIconOnlyButton(Icon icon,
			IconVariant... variants) {
		final Button button = new Button(icon.getIcon().variant(variants));
		button.setStyleName("only-icon");
		button.setHtmlContentAllowed(true);
		return button;
	}

	public static VerticalLayout getStylishCaptionContainer(String caption,
			Icon icon, Component component) {
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(true);
		layout.setWidth("100%");

		Label label = getFormTitleLabel(caption, icon);
		layout.addComponent(label);

		// component.setCaption(null);
		component.setWidth("100%");
		component.setSizeFull();
		component.addStyleName("margin-bottom-15");
		layout.addComponent(component);
		layout.setExpandRatio(component, 1.0f);

		return layout;
	}

	public static VerticalLayout getStylishCaptionContainerNoMargin(
			String caption, Icon icon, Component component) {
		VerticalLayout layout = new VerticalLayout();
		layout.setSpacing(false);
		layout.setWidth("100%");

		Label label = getFormTitleLabel(caption, icon);
		layout.addComponent(label);

		// component.setCaption(null);
		component.setWidth("100%");
		layout.addComponent(component);
		layout.setExpandRatio(component, 1.0f);

		return layout;
	}

	/**
	 * Returns a table with given caption
	 * 
	 * @param caption
	 *            the caption of the table
	 * @return new table
	 */
	public static Table getTable(String caption) {
		Table table = new Table(caption);
		table.addStyleName("striped");
		table.addStyleName("normal-table");
		return table;
	}

	/**
	 * Returns default test button
	 * 
	 * @param localizer
	 *            for localizing caption
	 * @return test button
	 */
	public static Button getTestButton(Localizer localizer) {
		return getButton(localizer.getUIText(StandardUIConstants.TEST),
				Icon.TEST);
	}

	/**
	 * Returns a larger view title.
	 * 
	 * @param title
	 *            title caption
	 * @return title
	 */
	public static Label getTitle(String title) {
		Label label = new Label(title, ContentMode.HTML);
		label.setStyleName("title");
		return label;
	}

	/**
	 * Returns a label that contains a title and a value
	 * 
	 * @param title
	 *            title
	 * @param value
	 *            value
	 * @return label with title and value
	 */
	public static Label getTitleValueLabel(String title, String value) {
		Label label = new Label("<strong>" + title + ": "
				+ "<span class=\"color-blue\">" + value + "</span></strong>",
				ContentMode.HTML);
		return label;
	}

	/**
	 * Returns a two column view used in editors. Left hand side is narrower.
	 * 
	 * @return AbstractEditorLayout
	 */
	public static AbstractEditorLayout getTwoColumnView() {
		return new AbstractEditorLayout();
	}

	/**
	 * Returns a gray content layout for laying out component vertically
	 * 
	 * @param borders
	 *            panel borders
	 * @return grady content layout
	 */
	public static VerticalLayout getVerticalGrayContentLayout(PanelStyle style,
			Border... borders) {
		VerticalLayout layout = new VerticalLayout();

		if (style == PanelStyle.SMALL) {
			layout.setStyleName("container-gray-small");
		} else if (style == PanelStyle.NONE) {
			layout.setStyleName("container-gray-none");
		} else {
			layout.setStyleName("container-gray");
		}

		layout.setWidth("100%");
		for (Border border : borders) {
			layout.addStyleName(border.getValue());
		}
		return layout;
	}

	/**
	 * Returns a panel that can be used to display a warning to user in dialogs
	 * or in UI.
	 * 
	 * @param message
	 *            the message displayed
	 * @return an information panel
	 */
	public static HorizontalLayout getWarningPanel(String message) {
		if (!message.contains("<br>")) {
			message += "<br>&nbsp;";
		}
		HorizontalLayout layout = new HorizontalLayout();
		layout.setWidth("100%");
		layout.setStyleName("warning-panel");

		Label iconLabel = StandardUIFactory.getWhiteIconMedium(Icon.WARNING);
		iconLabel.setWidth("40px");
		layout.addComponent(iconLabel);

		Label content = StandardUIFactory.getPanelTitle(message);

		layout.addComponent(content);
		layout.setExpandRatio(content, 1);
		return layout;
	}

	/**
	 * Return a default sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getWhiteIcon(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.WHITE,
				IconVariant.SIZE_LARGE), ContentMode.HTML);
	}

	/**
	 * Return a double sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getWhiteIcon2X(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.WHITE,
				IconVariant.SIZE_2X), ContentMode.HTML);
	}

	/**
	 * Return a medium (3x) sized icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getWhiteIconMedium(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.WHITE,
				IconVariant.SIZE_3X), ContentMode.HTML);
	}

	/**
	 * Return a small icon
	 * 
	 * @param icon
	 *            icon type, see {@link IconFactory}
	 * @return a small icon
	 */
	public static Label getWhiteIconSmall(Icon icon) {
		return new Label(icon.getIcon().variant(IconVariant.WHITE),
				ContentMode.HTML);
	}

	/**
	 * Returns a button used for window headers and other header bars
	 * 
	 * @param icon
	 *            icon displayed in button
	 * @return button for header controls
	 */
	public static Button getWindowControlButton(Icon icon) {
		final Button button = new Button(icon.getIcon().variant(
				IconVariant.WHITE));
		button.setStyleName("window-control");
		button.setHtmlContentAllowed(true);
		return button;
	}
}
