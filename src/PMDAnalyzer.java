import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class PMDAnalyzer extends Analyzer {
	
	private String pattern;
	private String pmd_loc;
	
	public PMDAnalyzer(String pmd_loc, String pattern, String src) {
		super(src);
		this.pmd_loc = pmd_loc;
		this.pattern = pattern;
	}
	
	public int analyzeThis() {
		int violations = 0;
		getAllPackageLoc();
		try{	
			if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")) {
				Process p = Runtime.getRuntime().exec("." + pmd_loc + "/run.sh" + " pmd" + " -d " + src + " -f xml -R rulesets/java/basic.xml -version 1.7 -language java");
				DocumentBuilderFactory fac1 = DocumentBuilderFactory.newInstance();
				Document doc1 = (Document) fac1.newDocumentBuilder().parse(p.getInputStream());
				
				NodeList nodeList = doc1.getElementsByTagName(pattern);
				
				violations = nodeList.getLength();
				
				System.out.println("\nNumber of " + pattern + " : " + nodeList.getLength());
				
				for(int i = 0; i < nodeList.getLength(); i++){
					System.out.println(nodeList.item(i).getTextContent());
				}
				
			} else {
			Process f = Runtime.getRuntime().exec("cmd /c " + pmd_loc +  " -d " + src + " -f xml -R rulesets/java/basic.xml");
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			Document doc = (Document) fac.newDocumentBuilder().parse(f.getInputStream());
			
			NodeList nodeList = doc.getElementsByTagName(pattern);
			
			violations = nodeList.getLength();
			
			System.out.println("\nNumber of " + pattern + " : " + nodeList.getLength());
			
			for(int i = 0; i < nodeList.getLength(); i++){
				System.out.println(nodeList.item(i).getTextContent());
			}
			}
			
		} catch (IOException e){
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}	
		
		return violations;
	}
	
	public void getAllPackageLoc(){
	
	}
}
