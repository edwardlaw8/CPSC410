import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.JSONArray;

public class Runner {
	public static void main(String[] args){
		
		String dir = System.getProperty("user.dir");
		String pmd_loc = dir + "/pmd/bin/pmd";
		System.out.println("pmd loc in runner: " + pmd_loc);
		String pattern = "violation";
		String src1 = dir + "/Sponge(CPSC410CodeBase1)";
		String src2 = dir + "/spark(CPSC410CodeBase3)";
		String repoName1 = "Sponge";
		String repoName2 = "spark";
		
		String src =  "" , repoName = "";
       
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
			src = src1;
			repoName = repoName1;
		} else if (userinput == 2) {
			src = src2;
			repoName = repoName2;
		}
		
		PMDAnalyzer pmdAnalyzer = new PMDAnalyzer(pmd_loc, pattern, src);
		int violations = pmdAnalyzer.analyzeThis();
		JDAnalyzer jdAnalyzer = new JDAnalyzer(src, repoName);
		JSONArray packageList = jdAnalyzer.analyzeThis();

		File jd_output_file;
		FileWriter fw = null;
		try {
			jd_output_file = new File(dir + "/visualization/jd_output.json");
			fw = new FileWriter(jd_output_file);
			fw.write(packageList.toString());
			fw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Fuser fuser = new Fuser();
		System.out.println("violations: " + violations);
		fuser.PMD_JD_fuse(violations, packageList);
		
		//Add output of Fuser (two .jsons) to Visualizer
		/*try {
			Process visualization = rt.exec("open index.html");
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}
	
	
}
