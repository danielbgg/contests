package br.com.danielbgg.contests.uva.problem12545;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Problem12545Test extends TestCase {

	public Problem12545Test(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(Problem12545Test.class);
	}

	public void testApp() {
		Problem12545 myWork = new Problem12545();
		assertEquals(myWork.calculate("01", "10"), 1);
		assertEquals(myWork.calculate("110001", "000000"), -1);
		assertEquals(myWork.calculate("010110", "100101"), 2);
		assertEquals(myWork.calculate("01011", "10010"), -1);
		assertEquals(myWork.calculate("01??00", "001010"), 3);
		assertEquals(myWork.calculate("01??001", "0010100"), -1);
	}
}
