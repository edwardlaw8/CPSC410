import java.io.IOException;
import java.util.ArrayList;

public class Runner {
	public static void main(String[] args){
		
		String pmd_loc = "C:\\Users\\EdNKuma\\Desktop\\pmd-bin-5.2.0\\bin\\pmd";
		String pattern = "violation";
		String src = "C:\\Users\\EdNKuma\\Documents\\GitHub\\Sponge\\src";
		
		PMDAnalyzer pmdAnalyzer = new PMDAnalyzer(pmd_loc, pattern, src);
		int violations = pmdAnalyzer.analyzeThis();
		
		JDAnalyzer jdAnalyzer = new JDAnalyzer(src);
		ArrayList packageList = jdAnalyzer.analyzeThis();

	}
	
	
}
