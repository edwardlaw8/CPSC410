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
		String src3 = dir + "/spark-master(CPSC410CodeBase3)";
		String src2 = dir + "/twoway-view(CPSC410CodeBase2)";
       
        //System.out.println("user.dir is : " + dir);
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
			PMDAnalyzer pmdAnalyzer = new PMDAnalyzer(pmd_loc, pattern, src3);
			int violations = pmdAnalyzer.analyzeThis();
			
			JDAnalyzer jdAnalyzer = new JDAnalyzer(src);
			ArrayList packageList = jdAnalyzer.analyzeThis();
			Fuser fuser = new Fuser(violations, packageList);
		}
		
		if (userinput == 2) {
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
