package util.XMLUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLRetriever {

	public static void requestXML(String url, String outputFile){
		try {
			requestXML(new URL(url), outputFile);
		} catch (MalformedURLException e) {
			System.out.println("MalformedURLException has been caught.");
			e.printStackTrace();
		}
	}
	
	public static void requestXML(URL rssURL, String outputFile){
	try {
		
		HttpURLConnection connection = (HttpURLConnection) rssURL.openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/xml");

		InputStream rssXml = connection.getInputStream();

		DocumentBuilderFactory myBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder myDocumentBuilder = myBuilderFactory.newDocumentBuilder();
		Document myDocument = myDocumentBuilder.parse(rssXml);
		
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		
		DOMSource source = new DOMSource(myDocument);
		
		StreamResult streamResult =  new StreamResult(new File(outputFile));
		transformer.transform(source, streamResult);
		
	} catch (ProtocolException e) {
		System.out.println("ProtocolException has been caught.");
		e.printStackTrace();
	} catch (IOException e){
		System.out.println("IOException has been caught.");
		e.printStackTrace();
	} catch (SAXException e) {
		System.out.println("SAXException has been caught.");
		e.printStackTrace();
	} catch (ParserConfigurationException e) {
		System.out.println("ParserConfigurationException has been caught.");
		e.printStackTrace();
	} catch (TransformerException e) {
		System.out.println("TransformerException has been caught.");
		e.printStackTrace();
	}
}
}
