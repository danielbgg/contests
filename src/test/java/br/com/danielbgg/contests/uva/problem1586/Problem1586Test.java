package br.com.danielbgg.contests.uva.problem1586;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Problem1586Test extends TestCase {

	public Problem1586Test(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(Problem1586Test.class);
	}

	public void testApp() {
		Problem1586 myWork = new Problem1586();
		assertEquals(myWork.calculate("C"), 12.010);
		assertEquals(myWork.calculate("C6H5OH"), 94.108);
		assertEquals(myWork.calculate("NH2CH2COOH"), 75.070);
		assertEquals(myWork.calculate("C12H22O11"), 342.296);
	}
}
