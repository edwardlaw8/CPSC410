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
		String dir = System.getProperty("user.dir");
		//String args = dir + this.src;
		
		//TODO: Need way to grab package names and classes in each package
		JDependOutput = JDepend.main(this.src);
		
		
		return JDependOutput;
		
	}

}
