import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.javatuples.Triplet;

import com.google.gson.JsonObject;

public class Runner {
	public static void main(String[] args){
		
		String pmd_loc = "E:\\UBC\\cs410\\CPSC410\\pmd\\bin\\pmd";
		String pattern = "violation";
		String src = "E:/UBC/cs410/CPSC410/Sponge(CPSC410CodeBase1)";
		String src2 = "E:/UBC/cs410/CPSC410/twoway-view(CPSC410CodeBase2)";
	//	String dir = System.getProperty("user.dir");
		Runtime rt = Runtime.getRuntime();
		Scanner s = new Scanner(System.in);
		String userinput;
	
		System.out.println("Which Codebase Would You Like to Analyze? Sponge or Twoway-view?");
		userinput = s.next();
		if (userinput.equalsIgnoreCase("Sponge")) {
			PMDAnalyzer pmdAnalyzer = new PMDAnalyzer(pmd_loc, pattern, src);
			int violations = pmdAnalyzer.analyzeThis();
			
			JDAnalyzer jdAnalyzer = new JDAnalyzer(src);
			ArrayList packageList = jdAnalyzer.analyzeThis();
			Fuser fuser = new Fuser(violations, packageList);
		}
		
		if (userinput.equalsIgnoreCase("Twoway-view")) {
			PMDAnalyzer pmdAnalyzer = new PMDAnalyzer(pmd_loc, pattern, src2);
			int violations = pmdAnalyzer.analyzeThis();
		
			JDAnalyzer jdAnalyzer = new JDAnalyzer(src2);
			ArrayList packageList = jdAnalyzer.analyzeThis();
			Fuser fuser = new Fuser(violations, packageList);
		}
		
		//Add output of Fuser (two .jsons) to Visualizer
		try {
			Process visualization = rt.exec("open index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
