package CPSC410;
import jdepend.textui.JDepend;
import org.json.JSONArray;


public class JDAnalyzer extends Analyzer {
	
	JSONArray JDependOutput;

	public JDAnalyzer(String src, String repoName) {
		super(src, repoName);
	}

	public JSONArray analyzeThis() {
		
	//	JDepend jd = new JDepend();
		String dir = System.getProperty("user.dir");
		//String args = dir + this.src;
		
		//TODO: Need way to grab package names and classes in each package
		JDependOutput = JDepend.main(this.src, this.repoName);
		
		
		return JDependOutput;
		
	}

}
