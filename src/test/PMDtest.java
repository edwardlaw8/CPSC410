package test;


import static org.junit.Assert.*;

import org.junit.Test;

import CPSC410.PMDAnalyzer;

public class PMDtest {
	String dir = System.getProperty("user.dir");
	String pmd_loc = dir + "/pmd/bin/pmd";
	String pattern = "violation";
	String src1 = dir + "/musicbrainz(CPSCCodeBase4)";
	String src2 = dir + "/spark-master(CPSC410CodeBase3)";
	String repoName1 = "fm";
	String repoName2 = "spark";

	@Test
	public void testGetViolationsMB_design() {
		String ruleSet = "design";
		PMDAnalyzer pmdAnalyzer = new  PMDAnalyzer(pmd_loc, pattern, src1);
		int violations = pmdAnalyzer.getviolations(ruleSet);
		System.out.println("[testGetViolationsMB_design] violations should be 6 is "+ violations);
		assertEquals(violations, 6);
	}
	
	@Test
	public void testGetViolationsSpark_design() {
		String ruleSet = "design";
		PMDAnalyzer pmdAnalyzer = new  PMDAnalyzer(pmd_loc, pattern, src2);
		int violations = pmdAnalyzer.getviolations(ruleSet);
		System.out.println("[testGetViolationsSpark_design] violations should be 215 is "+ violations);
		assertEquals(violations, 215);
	}
	
	@Test
	public void testGetViolationsSpark_basic() {
		String ruleSet = "basic";
		PMDAnalyzer pmdAnalyzer = new  PMDAnalyzer(pmd_loc, pattern, src2);
		int violations = pmdAnalyzer.getviolations(ruleSet);
		System.out.println("[testGetViolationsSpark_basic] violations should be 40 is "+ violations);
		assertEquals(violations, 40);
	}
	@Test
	public void testGetViolationsMB_basic() {
		String ruleSet = "basic";
		PMDAnalyzer pmdAnalyzer = new  PMDAnalyzer(pmd_loc, pattern, src1);
		int violations = pmdAnalyzer.getviolations(ruleSet);
		System.out.println("[testGetViolationsMB_basic] violations should be 0 is "+ violations);
		assertEquals(violations, 0);
	}
}
