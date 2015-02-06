package util.XMLUtils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;


public class XMLParser {
	  public static void main(String argv[]) {
		  parseRSS("soen487/XMLResources/rssNews.xml", "item");
		  parseXML("soen487/XMLResources/marfSample1.xml", "item");
		  
	  }
	  
	  public static void parseRSS(String fileName, String tagName){
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
			 
					if (node.getNodeType() == Node.ELEMENT_NODE) {
			 
						Element element = (Element) node;
			 
						System.out.println("Title : " + element.getElementsByTagName("title").item(0).getTextContent());
			 
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
}
