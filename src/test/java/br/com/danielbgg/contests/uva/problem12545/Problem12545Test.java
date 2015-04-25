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

		assertEquals(myWork.calculate("0?1?001001000??0?????1", "0011110111001111101010"), 15);
		
		assertEquals(myWork.calculate("01", "10"), 1);
		assertEquals(myWork.calculate("110001", "000000"), -1);
		assertEquals(myWork.calculate("010110", "100101"), 2);
		assertEquals(myWork.calculate("01011", "10010"), -1);
		assertEquals(myWork.calculate("01??00", "001010"), 3);

		assertEquals(myWork.calculate("?1????00?00??1?1??0?", "11001101110010101101"), 14);
		assertEquals(myWork.calculate("00??0", "00000"), 2);
		assertEquals(myWork.calculate("01????1?100?", "111001100110"), 9);
		assertEquals(myWork.calculate("?11?0", "00101"), 3);
		assertEquals(myWork.calculate("?111?1", "110111"), 3);
		assertEquals(myWork.calculate("?", "1"), 1);
		assertEquals(myWork.calculate("10010", "01010"), 1);
		assertEquals(myWork.calculate("?0?1?1??10?001?0?", "01100010000100111"), 12);
		assertEquals(myWork.calculate("??11101", "1101111"), 3);
		assertEquals(myWork.calculate("011010?11?1000100??", "0100010100111110001"), 8);
		assertEquals(myWork.calculate("?00011???11?0?", "01001100011111"), 8);
		assertEquals(myWork.calculate("??101??011?1", "100001010110"), 9);
		assertEquals(myWork.calculate("?????0?0?0??0???", "0010011110011000"), 15);
		assertEquals(myWork.calculate("110011??1", "010110100"), -1);
		assertEquals(myWork.calculate("10", "00"), -1);
		assertEquals(myWork.calculate("?100111?0??0?0?0", "0111010001111010"), 9);
		assertEquals(myWork.calculate("?100", "0000"), -1);
		assertEquals(myWork.calculate("000?0?0?", "00001010"), 5);
		assertEquals(myWork.calculate("?11101?0?11", "00100101010"), -1);
		assertEquals(myWork.calculate("0100?1001010101?0?", "000101100101011100"), 8);
		assertEquals(myWork.calculate("0011?1", "101010"), 3);
		assertEquals(myWork.calculate("??1", "110"), 3);
		assertEquals(myWork.calculate("0001?00?00?1?????", "11000001011111100"), 11);
		assertEquals(myWork.calculate("11?0", "0101"), 2);
		assertEquals(myWork.calculate("1?1?0?0", "0011101"), 5);
		assertEquals(myWork.calculate("??11????001?010101?", "1010001111011010101"), 13);
		assertEquals(myWork.calculate("???1", "1011"), 3);
		assertEquals(myWork.calculate("?0?1110100?1?0?0", "1001111011100011"), 9);
		assertEquals(myWork.calculate("???001110?111?", "10111001010000"), 10);
		assertEquals(myWork.calculate("00010111??", "0100010001"), -1);
		assertEquals(myWork.calculate("1", "1"), 0);
		assertEquals(myWork.calculate("001??111???011", "01101111011001"), 6);
		assertEquals(myWork.calculate("?1??00?1111101?1010?", "00010101100011101111"), 11);
		assertEquals(myWork.calculate("?011111???10?01", "110010101100011"), 9);
		assertEquals(myWork.calculate("1?10?11???0?00", "10101010000011"), 8);
		assertEquals(myWork.calculate("0??101?0???1?00?0110", "01101110000001111001"), 13);
		assertEquals(myWork.calculate("100?100?", "10011001"), 2);

		assertEquals(myWork.calculate("1111111111111111111111111111111111111111111111111110000000000000000000000000000000000000000000000000",
		        "0000000000000000000000000000000000000000000000000001111111111111111111111111111111111111111111111111"), -1);
		assertEquals(myWork.calculate("1111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000",
		        "0000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111"), 50);

		assertEquals(myWork.calculate("11111111111111111111111111111111111111111111111111??????????????????????????????????????????????????",
		        "0000000000000000000000000000000000000000000000000011111111111111111111111111111111111111111111111111"), 100);

		assertEquals(myWork.calculate("101010011010?????111010101010???11010101010????1010101010?????10101010???1010101001???101010?1101001",
		        "1110010101010100100000010101010010101010100101010111111111000001011010100101000001010100101010100000"), 45);

	}
}
