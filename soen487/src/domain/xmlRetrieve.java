package domain;

import util.XMLUtils.XMLRetriever;

public class xmlRetrieve {
	public static void main (String[] args){
		//XMLRetriever.requestXML("http://www.ledevoir.com/rss/ledevoir.xml", "soen487/XMLResources/rssNews.xml");
		XMLRetriever.requestXML("http://marf.cvs.sf.net/viewvc/marf/apps/TestNN/samples/test1.xml?revision=1.1", "XMLResources/marfSample1.xml");
	}
}
