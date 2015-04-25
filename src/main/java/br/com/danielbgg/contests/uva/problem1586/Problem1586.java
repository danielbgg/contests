package br.com.danielbgg.contests.uva.problem1586;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Problem 1586
 * 
 * Molar mass
 * 
 * http://uva.onlinejudge.org/external/15/1586.html
 */
class Problem1586 {

	static double C = 12.01;
	static double H = 1.008;
	static double O = 16.00;
	static double N = 14.01;

	double evaluate(char c) {
		if (c == 'C') {
			return C;
		}
		if (c == 'H') {
			return H;
		}
		if (c == 'O') {
			return O;
		}
		if (c == 'N') {
			return N;
		}
		return -1.0;
	}

	double calculate(String s) {
		double sum = 0.0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				int j = 0;
				boolean next = true;
				while (next) {
					j++;
					next = ((i + j) < s.length()) && Character.isDigit(s.charAt(i + j));
				}
				char letter = s.charAt(i);
				String number = s.substring(i + 1, i + j);
				int n = number == null || number.length() == 0 ? 1 : Integer.parseInt(number);
				sum = sum + (evaluate(letter) * n);
			}
		}
		return sum;
	}

	public static void main(String args[]) {
		Problem1586 myWork = new Problem1586();
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
			System.out.printf("%.3f\n", calculate(data[i]));			
		}
	}
	

}
