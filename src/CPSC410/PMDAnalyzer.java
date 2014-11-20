package CPSC410;
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
		super(src, "");
		this.pmd_loc = pmd_loc;
		this.pattern = pattern;
	}
	
	public int analyzeThis() {
		int violations = 0;
		violations = violations +  getviolations("basic");
		violations = violations +  getviolations("design");
		return violations;
	}
	
	public int getviolations(String ruleset) {
		int violations = 0;
		try {
			Process p;
			if (System.getProperty("os.name").equalsIgnoreCase("Mac OS X")){
				String run = pmd_loc + "/run.sh";
				p = Runtime.getRuntime().exec("bash" + " -f "+"."+ run + " pmd" + " -d " + src + " -f" +  " xml" +  " -R" + " rulesets/java/" + ruleset +".xml" + " -version" +  " 1.7" +  " -language" +  " java");

			}else{
				p = Runtime.getRuntime().exec("cmd /c " + pmd_loc +  " -d " + src + " -f xml -R rulesets/java/" + ruleset +".xml");
			}
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();
			Document doc = (Document) fac.newDocumentBuilder().parse(p.getInputStream());
			NodeList nodeList = doc.getElementsByTagName(pattern);
			violations = nodeList.getLength();
			System.out.println("\nNumber of " + pattern + " : " + nodeList.getLength());
			
			/*for(int i = 0; i < nodeList.getLength(); i++){
				System.out.println(nodeList.item(i).getTextContent());
			}*/
		} catch (SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		return violations;
	}

	public void getAllPackageLoc(){
	
	}
}
