package test;

import org.json.JSONArray;

import CPSC410.JDAnalyzer;

public class JDAnalyzerTest {
	private static final String dir = System.getProperty("user.dir");
	private static final String src = dir + "/musicbrainz(CPSCCodeBase4)";
	private static final String repoName = "fm";
	static JDAnalyzer jd = new JDAnalyzer(src, repoName);
	static JSONArray JDOutput = jd.analyzeThis();

	//Test for if empty
	public static boolean isOutputEmpty() {
		if (JDOutput.getClass() != null ) {
			return false;
		}
		else {
			return true;
		}
	}
	
	//Test if output is even a JSONArray
	public static boolean isOutputJSON() {
		if(JDOutput instanceof JSONArray ) {
			return true;
		}
		return false;
	}

}
