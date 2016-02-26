package fi.utu.ville.standardutils.ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Vector;

import com.vaadin.server.FileResource;
import com.vaadin.ui.Audio;
import com.vaadin.ui.CssLayout;

import fi.utu.ville.standardutils.MathHelper;

public class VilleVoice extends CssLayout {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5705426427370304125L;
	private int repeats;
	private final String lang;
	private final String calculation;
	private File file;
	
	public VilleVoice(String lang, String calculation) {
		this.calculation = calculation;
		this.lang = lang;
		repeats = 0;
		setSizeUndefined();
		this.setWidth("0px");
		this.setHeight("0px");
		
		makeFile();
	}
	
	public VilleVoice(String calculation) {
		this.calculation = calculation;
		repeats = 0;
		lang = "";
		
		setSizeUndefined();
		this.setWidth("0px");
		this.setHeight("0px");
		
		makeFile();
	}
	
	public String getLang() {
		return lang;
	}
	
	private void growRepeats() {
		repeats++;
	}
	
	public int getAmountOfRepeats() {
		return repeats;
	}
	
	public void playPlaylist() {
		removeAllComponents();
		Audio player = createAudio();
		addComponent(player);
		
		growRepeats();
		FileResource audio = new FileResource(file);
		player.setSource(audio);
		player.play();
	}
	
	public VilleVoiceView getVilleVoiceView() {
		return new VilleVoiceView(this);
	}
	
	private void makeFile() {
		
		Vector<String> v = MathHelper.split(calculation);
		// Paths server
		String soxPath = "/usr/local/bin/";
		String filePath = "/home/stubtest/ogg/";
		String outPath = "/home/stubtest/ogg/out/";
		String ext = ".mp3";
		
		// Paths - local stuff osx.
		// String soxPath = "/usr/local/bin/";
		// String filePath =
		// "/Users/chgt/dumps/ville7/maskumatixresources/ogg/";
		// String outPath =
		// "/Users/chgt/dumps/ville7/maskumatixresources/ogg/out/";
		// String ext = ".ogg";
		
		// Paths - villetest stuff.
		// String soxPath = "/usr/bin/";
		// String filePath = "/home/villeresources/ogg/";
		// String outPath = "/home/villeresources/ogg/out/";
		// String ext = ".ogg";
		
		// Paths - maskumatix
		// String soxPath = "/usr/bin/";
		// String filePath = "/home/maskumatixresources/ogg/";
		// String outPath = "/home/maskumatixresources/ogg/out/";
		// String ext = ".ogg";
		
		// Filename
		StringBuilder fname = new StringBuilder();
		for (int i = 0; i < v.size(); i++) {
			if (!(v.get(i).equals("+") || v.get(i).equals("-")
					|| v.get(i).equals("*") || v.get(i).equals("/"))) {
				fname.append(v.get(i));
			} else if (v.get(i).equals("+")) {
				fname.append("plus");
			} else if (v.get(i).equals("-")) {
				fname.append("minus");
			} else if (v.get(i).equals("*")) {
				fname.append("mult");
			} else if (v.get(i).equals("/")) {
				fname.append("div");
			}
		}
		
		fname.append(UUID.randomUUID().toString());
		
		ArrayList<String> cmd = new ArrayList<String>();
		cmd.add(soxPath + "sox");
		
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i).equals("+")) {
				cmd.add(filePath + "plus" + lang + ext);
			} else if (v.get(i).equals("-")) {
				cmd.add(filePath + "minus" + lang + ext);
			} else if (v.get(i).equals("*")) {
				cmd.add(filePath + "mult" + lang + ext);
			} else if (v.get(i).equals("/")) {
				cmd.add(filePath + "div" + lang + ext);
			} else {
				cmd.add(filePath + v.get(i) + lang + ext);
			}
		}
		
		cmd.add(outPath + fname.toString() + lang + ext);
		
		executeCommand(cmd);
		
		file = new File(outPath + fname.toString() + lang + ext);
		
	}
	
	private void executeCommand(ArrayList<String> command) {
		
		ProcessBuilder pb = new ProcessBuilder(command);
		
		Process p = null;
		try {
			p = pb.start();
			try {
				
				int val = p.waitFor();
				System.out.println(val);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			//			VilleErrorReporter.reportByMail("", e);
			e.printStackTrace();
		} finally {
			if (p != null) {
				BufferedReader error = new BufferedReader(
						new InputStreamReader(p.getErrorStream()));
						
				String line = "";
				
				try {
					while ((line = error.readLine()) != null) {
						System.out.println(line);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private Audio createAudio() {
		Audio audio = new Audio();
		audio.setShowControls(false);
		audio.setHtmlContentAllowed(true);
		audio.setWidth("0px");
		audio.setHeight("0px");
		
		return audio;
	}
	
	public void deleteFile() {
		file.delete();
	}
}
