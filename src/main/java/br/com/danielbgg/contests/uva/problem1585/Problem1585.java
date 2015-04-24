package br.com.danielbgg.contests.uva.problem1585;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Problem 1585
 * 
 * Score
 * 
 * http://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category
 * =24&page=show_problem&problem=4460
 */
class Problem1585 {

	int calculate(String s) {
		char[] chars = s.toCharArray();
		int sum = 0;
		int offset = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (c == 'O') {
				sum = sum + offset + 1;
				offset++;
			} else {
				offset = 0;
			}
		}
		return sum;
	}

	public static void main(String args[]) {
		Problem1585 myWork = new Problem1585();
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
		int line = Integer.parseInt(idata.nextToken());
		String[] data = new String[line];

		for (int i = 0; i < line; i++) {
			input = readLn(255);
			idata = new StringTokenizer(input);
			data[i] = idata.nextToken();
		}

		for (int i = 0; i < data.length; i++) {
			System.out.println(calculate(data[i]));
		}
	}
}
