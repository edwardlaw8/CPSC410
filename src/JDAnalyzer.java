import java.util.ArrayList;

import org.javatuples.Triplet;

import jdepend.textui.JDepend;


public class JDAnalyzer extends Analyzer {
	
	ArrayList JDependOutput;

	public JDAnalyzer(String src) {
		super(src);
	}

	public ArrayList analyzeThis() {
		
	//	JDepend jd = new JDepend();
		String args = "/Users/risanewyear-ramirez/git/CPSC410/build/jdepend";
		
		//TODO: Need way to grab package names and classes in each package
		JDependOutput = JDepend.main(args);
		
		
		return JDependOutput;
		
	}

}
