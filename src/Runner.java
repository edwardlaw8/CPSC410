import java.io.IOException;
import java.util.ArrayList;
import com.google.gson.JsonObject;

public class Runner {
	public static void main(String[] args){
		
		String pmd_loc = "C:\\Users\\EdNKuma\\Desktop\\pmd-bin-5.2.0\\bin\\pmd";
		String pattern = "violation";
		String src = "/Users/risanewyear-ramirez/git/CPSC410/Sponge(CPSC410CodeBase1)";
		String src2 = "/Users/risanewyear-ramirez/git/CPSC410/twoway-view(CPSC410CodeBase2)";
		String dir = System.getProperty("user.dir");
		Runtime rt = Runtime.getRuntime();
		
		
		
		System.out.println("Which Codebase Would You Like to Analyze?");
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
