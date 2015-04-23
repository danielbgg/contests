package br.com.danielbgg.contests.uva.problem100;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Problem100Test extends TestCase {

	public Problem100Test(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(Problem100Test.class);
	}

	public void testApp() {
		Problem100 p100 = new Problem100();
		assertEquals(p100.calculateCycleLength(1, 22), 21);
		assertEquals(p100.calculateCycleLength(1, 10), 20);
		assertEquals(p100.calculateCycleLength(100, 200), 125);
		assertEquals(p100.calculateCycleLength(201, 210), 89);
		assertEquals(p100.calculateCycleLength(900, 1000), 174);
		assertEquals(p100.calculateCycleLength(1, 1000000), 476);
		assertEquals(p100.calculateCycleLength(1, 1), 1);
		assertEquals(p100.calculateCycleLength(10, 1), 20);
		assertEquals(p100.calculateCycleLength(210, 201), 89);
		assertEquals(p100.calculateCycleLength(113383, 113383), 121);
		assertEquals(p100.calculateCycleLength(999999, 1), 476);
	}
}
