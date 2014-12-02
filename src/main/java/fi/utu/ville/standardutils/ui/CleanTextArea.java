package fi.utu.ville.standardutils.ui;

import org.apache.commons.lang3.StringEscapeUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Entities.EscapeMode;
import org.jsoup.safety.Cleaner;
import org.jsoup.safety.Whitelist;

import com.vaadin.ui.TextArea;

public class CleanTextArea extends TextArea {

	private static final long serialVersionUID = 6169981980216103506L;

	private static final Whitelist whitelist;
	
	private static final int MAX_LENGTH = 32000;
	
	public CleanTextArea() {
		super();
		setMaxLength(MAX_LENGTH);
		extendAutoSave();
	}
	
	public CleanTextArea(String caption) {
		super(caption);
		setMaxLength(MAX_LENGTH);
		extendAutoSave();
	}
	
	public CleanTextArea(String caption, String value) {
		super(caption);
		setMaxLength(MAX_LENGTH);
		setValue(value);
		extendAutoSave();
	}
	
	private void extendAutoSave() {
		setImmediate(true);
		PeriodicValueChangeExtension.extend(this);
	}
	
	private String clean(String html, Whitelist whitelist) {
		String enterEscaped = html.replaceAll("\n", "%newline%");
		
	    Document dirty = Jsoup.parseBodyFragment(enterEscaped, "");
	    Cleaner cleaner = new Cleaner(whitelist);
	    Document clean = cleaner.clean(dirty);
	    clean.outputSettings().escapeMode(EscapeMode.xhtml);
	    clean.outputSettings().charset("UTF-8");
	    
	    // Remove all created newlines and restore all the pre-existing ones. 
	    String cleaned = clean.body().html().replaceAll("\n", "").replaceAll("%newline%", "\n");
	    
	    return StringEscapeUtils.unescapeXml(cleaned);
	}

	@Override
	public String getValue() {
		String value = super.getValue();
		if (value == null) return(null);
		return clean(value, whitelist);
	}
	
	@Override
	public void setValue(String value) {
		if ((value == "") || (value == null)) {
			super.setValue(value);
			return;
		} else super.setValue(clean(value, whitelist));
	}
	
	static {
		whitelist = Whitelist.relaxed();
		whitelist.addTags("font").addAttributes("font", "size", "color", "face");
		whitelist.addTags("hr").addAttributes("hr", "align", "noshade", "size", "width");
		whitelist.addAttributes("div", "align");
		whitelist.addEnforcedAttribute("a", "rel", "nofollow");
	}
}
