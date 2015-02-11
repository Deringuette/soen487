package util.XMLUtils;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;

import java.io.File;


public class XMLParser {
	  public static void main(String argv[]) {
		  //parseRSS("soen487/XMLResources/rssNews.xml", "item");
		  //parse("soen487/XMLResources/rssNews.xml");
		  //parseNeural("soen487/XMLResources/marfSample1.xml", "neuron");
		  //parse("soen487/XMLResources/marfcat-in.xml");
		  //parse("soen487/XMLResources/marfcat-out.xml");
		  parse("soen487/XMLResources/faultSample.wsdl");
		  
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
	  
	  //legacy code
	  /*public static void parseNeural(String fileName, String tagName){
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
	  }*/
	  
	  public static void parse(String fileName){
		  try {
			    DOMParser parser = new DOMParser();
			    parser.parse(fileName);
			    Document doc = parser.getDocument();
			    // Get the document's root XML node
			    NodeList root = doc.getChildNodes();
			    parseNodeList(root);
			}
			catch ( Exception e ) {
			    e.printStackTrace();
			} 
	  }
	  
	  public static void parse(String fileName, String rootNode){
		  try {
			    DOMParser parser = new DOMParser();
			    parser.parse(fileName);
			    Document doc = parser.getDocument();
			    // Get the document's root XML node
			    NodeList root = doc.getElementsByTagName(rootNode);
			    parseNodeList(root);
			}
			catch ( Exception e ) {
			    e.printStackTrace();
			} 
	  }
	  
	  private static void parseNodeList(NodeList root){
		  for (int i = 0; i < root.getLength(); i++) {
				Node node = root.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE){
					/*if(node.getNodeValue() != null){*/
						System.out.println(node.getNodeName() + ":" + XMLParserHelper.getNodeValue(node));
					/*}
					else{
						System.out.println(node.getNodeName() + ":");
					}*/
					if(node.hasAttributes()){
						NamedNodeMap attributes = node.getAttributes();
						for (int j = 0; j < attributes.getLength(); j++) {
							Node attribute = attributes.item(j);
							System.out.println(attribute.getNodeName() + ":" + attribute.getNodeValue());
						}
					}
					if(node.hasChildNodes()){
						parseNodeList(node.getChildNodes());
					}
				}
				
				//System.out.print(node.getNodeValue() + "\n");
		  }
		  
	  }
}
