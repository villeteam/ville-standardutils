package edu.vserver.standardutils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * This class provides certain static-methods that are useful when implementing
 * XML-based {@link PersistenceHandler}.
 * 
 * @author Riku Haavisto
 * 
 */
public final class XMLHelper {

	private XMLHelper() {
		// no instance is needed; all methods are static
	}

	/**
	 * <p>
	 * Converts a {@link Document} to a {@link InputStream} that can be returned
	 * from {@link PersistenceHandler #save(ExerciseData) save()} [ eg. return
	 * XMLHelper.xmlToInputStream(document-containing-exer-data); ]
	 * </p>
	 * 
	 * @param doc
	 *            {@link Document} to be converted to a stream
	 * @return {@link InputStream} generated from the {@link Document}
	 * @throws TransformerConfigurationException
	 * @throws TransformerException
	 * @throws TransformerFactoryConfigurationError
	 */
	public static byte[] xmlToBytes(Document doc)
			throws TransformerConfigurationException, TransformerException,
			TransformerFactoryConfigurationError {

		DOMSource source = new DOMSource(doc);

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		Result res = new StreamResult(outputStream);

		TransformerFactory.newInstance().newTransformer()
				.transform(source, res);

		return outputStream.toByteArray();

	}

	/**
	 * Creates and returns a newly created {@link Document}-object. This is
	 * quite usual start {@link PersistenceHandler #save(ExerciseData) save()}
	 * -method of an {@link PersistenceHandler}-implementor.
	 * 
	 * @return newly created empty {@link Document}-object
	 * @throws ParserConfigurationException
	 */
	public static Document createEmptyDocument()
			throws ParserConfigurationException {
		DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document doc = dBuilder.newDocument();

		return doc;
	}

	/**
	 * Parses a {@link Document} from an {@link InputStream} containing one.
	 * This is quite usual start {@link PersistenceHandler #load(InputStream)
	 * load()}-method of an {@link PersistenceHandler}-implementor.
	 * 
	 * @param inStream
	 *            {@link InputStream} from which to parse
	 * @return {@link Document} parsed from the input-stream
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	public static Document parseFromBytes(byte[] dataPres)
			throws ParserConfigurationException, SAXException, IOException {
		DocumentBuilder dBuilder = null;
		Document doc = null;
		dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

		// no external resources are tied with ByteArray-streams;
		// no need to worry about closing
		doc = dBuilder.parse(new ByteArrayInputStream(dataPres));

		doc.getDocumentElement().normalize();
		return doc;
	}
}
