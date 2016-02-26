package fi.utu.ville.standardutils.ui;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.themes.BaseTheme;

public class VilleVoiceView extends CssLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6160935443506515726L;
	private final VilleVoice voice;
	private Button play;
	
	public VilleVoiceView(VilleVoice voice) {
		this.voice = voice;
		
		initUI();
	}
	
	private void initUI() {
		play = new Button();
		play.setStyleName(BaseTheme.BUTTON_LINK);
		play.addStyleName("playButton");
		
		play.setIcon(new ThemeResource("../vexer-math/icons/play64.png"));
		play.addClickListener(e -> voice.playPlaylist());
		
		addComponent(play);
		addComponent(voice);
	}
	
	public void addClickListener(ClickListener l) {
		play.addClickListener(l);
	}
}
