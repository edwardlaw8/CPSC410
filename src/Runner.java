import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.javatuples.Triplet;

import com.google.gson.JsonObject;

public class Runner {
	public static void main(String[] args){
		
		
		String dir = System.getProperty("user.dir");
		String pmd_loc = dir + "/pmd/bin/pmd";
		System.out.println("pmd loc in runner: " + pmd_loc);
		String pattern = "violation";
		String src1 = dir + "/Sponge(CPSC410CodeBase1)";
		String src2 = dir + "/twoway-view(CPSC410CodeBase2)";
		String src3 = dir + "/spark(CPSC410CodeBase3)";
		
		String repoName1 = "Sponge";
		String repoName2 = "twoway-view";
		String repoName3 = "spark";
       
		Runtime rt = Runtime.getRuntime();
		Scanner s = new Scanner(System.in);
		String userinputStr;
	
		System.out.println("Which Codebase Would You Like to Analyze? \nEnter (1) for Sponge \nEnter (2) Twoway-view?");
		int userinput = -1;
		do{
			System.out.print("Please enter a valid response: ");
			userinputStr = s.next();
			userinput = Integer.parseInt(userinputStr);
			System.out.println("You entered: " + userinput );
		}while(userinput!= 1 && userinput!= 2 );
		if (userinput == 1) {
			PMDAnalyzer pmdAnalyzer = new PMDAnalyzer(pmd_loc, pattern, src1);
			int violations = pmdAnalyzer.analyzeThis();
			
			JDAnalyzer jdAnalyzer = new JDAnalyzer(src1, repoName3);
			ArrayList packageList = jdAnalyzer.analyzeThis();
			System.out.print("[Runner]: packageList size " + packageList.size());
			Fuser fuser = new Fuser(violations, packageList);
		}
		
		if (userinput == 2) {
			PMDAnalyzer pmdAnalyzer = new PMDAnalyzer(pmd_loc, pattern, src2);
			int violations = pmdAnalyzer.analyzeThis();
		
			JDAnalyzer jdAnalyzer = new JDAnalyzer(src2, repoName2);
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
