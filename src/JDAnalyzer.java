import java.util.ArrayList;

import jdepend.xmlui.JDepend;


public class JDAnalyzer extends Analyzer {

	public JDAnalyzer(String src) {
		super(src);
	}

	public ArrayList analyzeThis() {
		
		JDepend jd = new JDepend();
		String args = "C:\\Users\\EdNKuma\\Desktop\\jdepend-2.9.1\\build";
		
		return jd.jdAnaylze(args);
		
	}

}
