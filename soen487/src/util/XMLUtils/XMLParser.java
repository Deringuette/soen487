package util.XMLUtils;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import java.io.File;


public class XMLParser {
	  public static void main(String argv[]) {
		  parseRSS("soen487/XMLResources/rssNews.xml", "item");
		  //parseXML("soen487/XMLResources/marfSample1.xml", "item");
		  //parse("soen487/XMLResources/rssNews.xml");
		  
	  }
	  
	  public static void parseRSS(String fileName, String tagName){
		  try {
				 
				File fXmlFile = new File(fileName);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
			 
				XMLParserHelper xmlHelper = new XMLParserHelper();
				
				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				//doc.getDocumentElement().normalize();
			 
				//System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			 
				NodeList nodeList = doc.getElementsByTagName(tagName);
			 
				//System.out.println("----------------------------");
			 
				for (int i = 0; i < nodeList.getLength(); i++) {
			 
					Node node = nodeList.item(i);
			 
					//System.out.println("\nCurrent Element :" + node.getNodeName());
			 
					if (node.getNodeType() == Node.ELEMENT_NODE) {
			 
						//Element element = (Element) node;
			 
						System.out.println("Title : " +  xmlHelper.getNodeValue("title", node.getChildNodes()));//element.getElementsByTagName("title").item(0).getTextContent());
			 
					}
				}
		    } 
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
	  }
	  
	  public static void parseXML(String fileName, String tagName){
		  try {
				 
				File fXmlFile = new File(fileName);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
			 
				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				doc.getDocumentElement().normalize();
			 
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
			 
				NodeList nodeList = doc.getElementsByTagName(tagName);
			 
				System.out.println("----------------------------");
			 
				for (int i = 0; i < nodeList.getLength(); i++) {
			 
					Node node = nodeList.item(i);
			 
					System.out.println("\nCurrent Element :" + node.getNodeName());
					
					NodeList innerNodes = node.getChildNodes();
					for (int j = 0; j < innerNodes.getLength(); j++) {
						 
						Node indderNode = innerNodes.item(j);
						if (indderNode.getNodeType() == Node.ELEMENT_NODE) {
							 
							Element element = (Element) indderNode;
				 
							System.out.println(element.getTagName() + ":" + element.getNodeValue());
				 
						}
					}
			 
					
				}
		    } 
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
	  }
	  
	  public static void parse(String fileName){
		  try {
	            SAXParserFactory factory = SAXParserFactory.newInstance();
	            SAXParser saxParser = factory.newSAXParser();

	            DefaultHandler handler = new DefaultHandler() {

	                StringBuilder value;

	                public void startElement(String uri, String localName, String qName,Attributes attribtues) throws SAXException {
	                    value = new StringBuilder();
	                }

	                public void endElement(String uri, String localName, String qName) throws SAXException {
	                    if ("fileContent".equalsIgnoreCase(qName)) {
	                        String decodedValue = new String(DatatypeConverter.parseBase64Binary(value.toString()));
	                        System.out.println(qName + " = " + decodedValue);
	                    } else {
	                        System.out.println(qName + " = " + value);
	                    }
	                    value = new StringBuilder();
	                }

	                public void characters(char ch[], int start, int length) throws SAXException {
	                    value.append(new String(ch, start, length));
	                }

	            };

	            saxParser.parse(new File(fileName), handler);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }  
	  }
}
