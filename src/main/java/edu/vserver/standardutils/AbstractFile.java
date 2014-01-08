package edu.vserver.standardutils;

import java.io.InputStream;

import com.vaadin.server.Resource;

public interface AbstractFile {

	String getName();

	byte[] getRawData();

	Resource getAsResource();

	InputStream getAsStream();

}
