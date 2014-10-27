import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public abstract class Analyzer {
	
	protected String src;
	
	public Analyzer(String src){
		this.src = src;
	}
	
	
}
