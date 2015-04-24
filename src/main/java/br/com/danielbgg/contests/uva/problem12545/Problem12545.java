package br.com.danielbgg.contests.uva.problem12545;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Problem 12545
 * 
 * Bits Equalizer
 * 
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category
 * =24&page=show_problem&problem=3990
 */
class Problem12545 {

	int calculate(String s, String t) {
		char[] chars = s.toCharArray();
		char[] chart = t.toCharArray();
		int count = 0;
		boolean[] b = new boolean[s.length()];

		for (int i = 0; i < chars.length; i++) {
			char s1 = chars[i];
			char t1 = chart[i];
			if (s1 == t1) {
				b[i] = true;
			}
		}

		loop1: for (int i = 0; i < chars.length; i++) {
			if (b[i] == false) {

				if (chars[i] == '?') {
					chars[i] = chart[i];
					b[i] = true;
					count++;
					continue loop1;
				}

				loop2: for (int j = 0; j < chars.length; j++) {
					if (b[j] || chars[j] == '?') {
						continue loop2;
					}

					if (chars[i] != chars[j]) {
						char a = chars[i];
						chars[i] = chars[j];
						chars[j] = a;
						b[i] = true;
						b[j] = true;
						count++;
						continue loop1;
					}
				}

			}
		}

		for (int i = 0; i < chars.length; i++) {
			if (b[i] == false) {
				count = -1;
				break;
			}
		}

		return count;
	}

	public static void main(String args[]) {
		Problem12545 myWork = new Problem12545();
		myWork.begin();
	}

	static String readLn(int maxLg) {
		byte lin[] = new byte[maxLg];
		int lg = 0, car = -1;
		try {
			while (lg < maxLg) {
				car = System.in.read();
				if ((car < 0) || (car == '\n'))
					break;
				lin[lg++] += car;
			}
		} catch (IOException e) {
			return (null);
		}
		if ((car < 0) && (lg == 0))
			return (null);
		return (new String(lin, 0, lg));
	}

	void begin() {
		String input = readLn(255);
		StringTokenizer idata = new StringTokenizer(input);
		int line = Integer.parseInt(idata.nextToken()) * 2;
		String[] data = new String[line];

		for (int i = 0; i < line; i++) {
			input = readLn(255);
			idata = new StringTokenizer(input);
			data[i] = idata.nextToken();
		}

		int j = 1;
		for (int i = 0; i < data.length; i = i+2) {
			System.out.println("Case " + (j++) + ": " + calculate(data[i], data[i + 1]));
		}
	}
}
