package fi.utu.ville.standardutils.ui;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import fi.utu.ville.standardutils.Localizer;
import fi.utu.ville.standardutils.StandardUIFactory;
import fi.utu.ville.standardutils.StandardUIFactory.Border;
import fi.utu.ville.standardutils.StandardUIFactory.PanelStyle;

public class AbstractEditorLayout extends VerticalLayout {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String GENERAL_PANEL_WIDTH = "400px";

	private VerticalLayout buttonPanel;

	private Label titleLabel;

	public Localizer localizer;

	protected HorizontalLayout contentLayout;
	private VerticalLayout settingsLayout; // for each exercise their own
	private VerticalLayout generalSettingsLayout; // name, descr etc.

	public AbstractEditorLayout() {
		this.setSpacing(false);
		this.setMargin(false);
		this.setHeight("100%");
		this.setWidth("100%");
		this.setSizeFull();

		contentLayout = new HorizontalLayout();
		contentLayout.setSizeFull();
		contentLayout.setMargin(false);
		contentLayout.setSpacing(false);

		buttonPanel = new VerticalLayout();
		buttonPanel.setMargin(false);
		buttonPanel.setSpacing(false);
		buttonPanel.setWidth("100%");

		drawEditor();
	}

	public void drawEditor() {
		contentLayout.removeAllComponents();

		// Green header bar

		titleLabel = new Label("Set header here");
		HorizontalLayout headerBar = StandardUIFactory.getHeaderBarGreen();
		headerBar.addComponent(titleLabel);
		headerBar.setComponentAlignment(titleLabel, Alignment.MIDDLE_LEFT);

		this.addComponent(headerBar);

		this.addComponent(buttonPanel);

		// Add content area
		this.addComponent(contentLayout);
		this.setExpandRatio(contentLayout, 1);

		// ---- Generate content into different layouts
		// name, description
		drawGeneralSettingsPanel();
		// settings for exercise
		drawSettingsPanel();
	}

	protected void drawGeneralSettingsPanel() {
		generalSettingsLayout = StandardUIFactory
				.getVerticalGrayContentLayout(PanelStyle.DEFAULT);
		generalSettingsLayout.setSpacing(true);
		generalSettingsLayout.setHeight("100%");
		generalSettingsLayout.setMargin(false);
		
		VerticalLayout wrapper = new VerticalLayout();
		wrapper.setMargin(false);
		wrapper.setWidth(GENERAL_PANEL_WIDTH);
		wrapper.setHeight("100%");
		wrapper.addStyleName("background-color-gray");
		wrapper.addStyleName(Border.RIGHT.getValue());
		wrapper.addComponent(generalSettingsLayout);

		contentLayout.addComponent(wrapper);
	}

	public void addToLeft(Component c) {
		generalSettingsLayout.addComponent(c);
//		c.setHeight("100%");
	}

	public void addToRight(Component c) {
		settingsLayout.addComponent(c);
	}

	public void addToTop(Component c) {
		buttonPanel.addComponent(c);
	}

	public void setTitle(String s) {
		titleLabel.setValue(s);
	}

	protected void drawSettingsPanel() {
		settingsLayout = new VerticalLayout();
		settingsLayout.setWidth("100%");
		settingsLayout.setSpacing(true);
		settingsLayout.setMargin(true);

		contentLayout.addComponent(settingsLayout);
		contentLayout.setExpandRatio(settingsLayout, 1);
	}
}
