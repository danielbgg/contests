package br.com.danielbgg.contests.uva.problem1585;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Problem1585Test extends TestCase {

	public Problem1585Test(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(Problem1585Test.class);
	}

	public void testApp() {
		Problem1585 myWork = new Problem1585();
		assertEquals(myWork.calculate("OOXXOXXOOO"), 10);
		assertEquals(myWork.calculate("OOXXOOXXOO"), 9);
		assertEquals(myWork.calculate("OXOXOXOXOXOXOX"), 7);
		assertEquals(myWork.calculate("OOOOOOOOOO"), 55);
		assertEquals(myWork.calculate("OOOOXOOOOXOOOOX"), 30);
	}
}
