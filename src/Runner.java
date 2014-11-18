import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.javatuples.Triplet;

import com.google.gson.JsonObject;

public class Runner {
	public static void main(String[] args){
		
		
		String dir = System.getProperty("user.dir");
		String pmd_loc = dir + "/pmd/bin/pmd";
		String pattern = "violation";
		String src = dir + "/Sponge(CPSC410CodeBase1)";
		String src2 = dir + "/twoway-view(CPSC410CodeBase2)";
       
        System.out.println("user.dir is : " + dir);
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
