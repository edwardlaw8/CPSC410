import java.util.ArrayList;

import jdepend.xmlui.JDepend;


public class JDAnalyzer extends Analyzer {
	
	ArrayList JDependOutput;
	ArrayList output;
	JDParser parser;
	CustomJDependArray realOutput;

	public JDAnalyzer(String src) {
		super(src);
	}

	public ArrayList analyzeThis() {
		
		JDepend jd = new JDepend();
		String args = "C:\\Users\\EdNKuma\\Desktop\\jdepend-2.9.1\\build";
		
		//TODO: Need way to grab package names and classes in each package
		JDependOutput = jd.jdAnaylze(args);
		realOutput = parser.JDParser(JDependOutput);
		output.add(realOutput);
		
		return output;
		
	}

}
