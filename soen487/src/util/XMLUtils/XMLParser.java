package util.XMLUtils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import java.io.File;


public class XMLParser {
	  public static void main(String argv[]) {
		  //parseRSS("soen487/XMLResources/rssNews.xml", "item");
		  parseNeural("soen487/XMLResources/marfSample1.xml", "neuron");
		  
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
			 
				NodeList nodeList = doc.getElementsByTagName(tagName);
			 
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node node = nodeList.item(i);
			 
					if (node.getNodeType() == Node.ELEMENT_NODE) {
						System.out.println("Title:" +  xmlHelper.getNodeValue("title", node.getChildNodes()));
					}
				}
		    } 
		    catch (Exception e) {
		    	e.printStackTrace();
		    }
	  }
	  
	  public static void parseNeural(String fileName, String tagName){
		  try {
				 
				File fXmlFile = new File(fileName);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(fXmlFile);
			 
				XMLParserHelper xmlHelper = new XMLParserHelper();
				
				//optional, but recommended
				//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
				//doc.getDocumentElement().normalize();
			 
				NodeList nodeList = doc.getElementsByTagName(tagName);
			 
				for (int i = 0; i < nodeList.getLength(); i++) {
					Node neuronNode = nodeList.item(i);
			 
					NodeList innerNodes = neuronNode.getChildNodes();
					for (int j = 0; j < innerNodes.getLength(); j++) {
						Node node = innerNodes.item(j);
						
						if (node.getNodeType() == Node.ELEMENT_NODE) {
							if(node.getNodeName() == "output"){
								System.out.println("ref:" +  xmlHelper.getNodeAttr("ref", node));
							}
							else if(node.getNodeName() == "input"){
								System.out.println("ref:" +  xmlHelper.getNodeAttr("ref", node));
								System.out.println("weight:" +  xmlHelper.getNodeAttr("weight", node));
							}
						}
					}
				}
		  }
		  catch (Exception e) {
			  e.printStackTrace();
		  }
	  }
}
