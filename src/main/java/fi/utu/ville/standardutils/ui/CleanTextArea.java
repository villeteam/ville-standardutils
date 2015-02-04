package fi.utu.ville.standardutils.ui;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	private static final int MAX_LENGTH = 65000;
	private static final int MAX_LINK_COUNT = 100;
	
	private static final String linkCheckerString = "(http|https|ftp)\\://([a-zA-Z0-9\\.\\-]+(\\:[a-zA-Z0-9\\.&amp;%\\$\\-]+)*@)?((25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])|([a-zA-Z0-9\\-]+\\.)*[a-zA-Z0-9\\-]+\\.[a-zA-Z]{2,4})(\\:[0-9]+)?(/[^/][a-zA-Z0-9\\.\\,\\?\\'\\\\/\\+&amp;%\\$#\\=~_\\-@]*)*";
	private static final Pattern linkChecker = Pattern.compile(linkCheckerString);
	
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
		
		// Handle all Internet addresses separately.
		ArrayList<String> arr = new ArrayList<>();
		String temp = html + "";
		Matcher m = linkChecker.matcher(temp);
		int index = 0;
		while (m.find() && index < MAX_LINK_COUNT) {
			String s = m.group(0);
			arr.add(s);
			temp = temp.replaceFirst(linkCheckerString, "%internetAddress_" + (index++) + "%");
			m = linkChecker.matcher(temp);
		}
		
		// Cap the output if necessary. This should not be reachable due to MAX_LENGTH.
		if (index == MAX_LINK_COUNT) return "";
		
		String enterEscaped = StringEscapeUtils.unescapeXml(temp.replaceAll("\n", "%newline%"));
		
	    Document dirty = Jsoup.parseBodyFragment(enterEscaped, "");
	    Cleaner cleaner = new Cleaner(whitelist);
	    Document clean = cleaner.clean(dirty);
	    clean.outputSettings().escapeMode(EscapeMode.xhtml);
	    clean.outputSettings().charset("UTF-8");
	    clean.outputSettings().indentAmount(0);
	    clean.outputSettings().prettyPrint(false);
	    
	    // Remove all created newlines and restore all the pre-existing ones. 
	    String cleaned = clean.body().html().replaceAll("\n", "").replaceAll("%newline%", "\n");
	    
	    // Return all links to their original places.
	    for (int i = 0; i < arr.size(); ++i) {
	    	cleaned = cleaned.replaceAll("%internetAddress_" + i + "%", arr.get(i));
		}
		
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
