import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonObject;

public class Runner {
	public static void main(String[] args){
		
		String pmd_loc = "C:\\Users\\EdNKuma\\Desktop\\pmd-bin-5.2.0\\bin\\pmd";
		String pattern = "violation";
		String src = "C:\\Users\\EdNKuma\\Documents\\GitHub\\Sponge\\src";
		Runtime rt = Runtime.getRuntime();
		
		PMDAnalyzer pmdAnalyzer = new PMDAnalyzer(pmd_loc, pattern, src);
		int violations = pmdAnalyzer.analyzeThis();
		
		JDAnalyzer jdAnalyzer = new JDAnalyzer(src);
		ArrayList packageList = jdAnalyzer.analyzeThis();
		Fuser fuser = new Fuser(violations, packageList);
		JsonObject PACData = fuser.JSONPackagesAndClasses;
		JsonObject VAPData = fuser.JSONViolationsAndPackages;
		
		//Add output of Fuser to Visualizer
		try {
			Process visualization = rt.exec("open index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
