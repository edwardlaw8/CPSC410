import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public abstract class Analyzer {
	
	protected String src;
	protected String repoName;
	public Analyzer(String src, String repoName){
		this.src = src;
		this.repoName = repoName;
	}
	
	
}
