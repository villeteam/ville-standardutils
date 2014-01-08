package edu.vserver.standardutils.ui;

import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;

import edu.vserver.standardutils.Localizer;
import edu.vserver.standardutils.StandardIcon;
import edu.vserver.standardutils.StandardUIConstants;
import edu.vserver.standardutils.ui.DynamicStyles.DynamicStylesEditor;
import edu.vserver.standardutils.ui.DynamicStyles.StyleSettings;

public class StylesPopup extends Button {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3047507429002710034L;
	private StyleSettings currStyles;
	private final DynamicStylesEditor stylesEditor;
	private final Localizer localizer;

	private final Button.ClickListener stylesBtnListener =

	new ClickListener() {

		/**
		 * 
		 */
		private static final long serialVersionUID = -3471780663067401363L;

		@Override
		public void buttonClick(ClickEvent event) {
			// ensure correct state of styles-editor
			stylesEditor.loadStyles(currStyles);
			final SaveDialog editDial = new SaveDialog(
					localizer.getUIText(StandardUIConstants.STYLE_SETTINGS),
					stylesEditor.getStylesEditor(), localizer);

			UI.getCurrent().addWindow(editDial);

			editDial.addCloseListener(new CloseListener() {

				/**
			 * 
			 */
				private static final long serialVersionUID = -4784039250025940129L;

				@Override
				public void windowClose(CloseEvent e) {
					if (editDial.isOk()) {
						currStyles = stylesEditor.getCurrStyles();
					}
				}

			});

		}
	};

	public StylesPopup(Localizer localizer, StyleSettings initStyles) {
		super(localizer.getUIText(StandardUIConstants.STYLE_SETTINGS));
		setIcon(StandardIcon.STYLES.getIcon());
		this.localizer = localizer;
		this.currStyles = initStyles;
		this.stylesEditor = DynamicStyles.newStylesEditor();
		this.addClickListener(stylesBtnListener);
	}

	public StyleSettings getEditedStyles() {
		return currStyles;
	}

}
