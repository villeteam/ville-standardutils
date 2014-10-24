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
	
	public CleanTextArea() {
		super();

	}
	
	public CleanTextArea(String caption) {
		super(caption);
	}
	
	public CleanTextArea(String caption, String value) {
		super(caption);
		setValue(value);
	}
	
	private String clean(String html, Whitelist whitelist) {
		String enterEscaped = html.replaceAll("\n", "%newline%");
		
	    Document dirty = Jsoup.parseBodyFragment(enterEscaped, "");
	    Cleaner cleaner = new Cleaner(whitelist);
	    Document clean = cleaner.clean(dirty);
	    clean.outputSettings().escapeMode(EscapeMode.xhtml);
	    clean.outputSettings().charset("UTF-8");
	    String cleaned = clean.body().html().replaceAll("%newline%", "\n");
	    
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
