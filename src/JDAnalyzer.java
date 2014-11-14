import java.util.ArrayList;

import jdepend.xmlui.JDepend;


public class JDAnalyzer extends Analyzer {
	
	ArrayList JDependOutput;

	public JDAnalyzer(String src) {
		super(src);
	}

	public ArrayList analyzeThis() {
		
		JDepend jd = new JDepend();
		String args = "C:\\Users\\EdNKuma\\Desktop\\jdepend-2.9.1\\build";
		
		//TODO: Need way to grab package names and classes in each package
		JDependOutput = jd.jdAnaylze(args);
		
		return JDependOutput;
		
	}
	
	public ArrayList getClasses() {
		//Get classes associated with each package
		return JDependOutput;
		
	}
	
	public String getPackageName (ArrayList JDependOutput) {
		//Get package Name
		return src;
		
	}

}
