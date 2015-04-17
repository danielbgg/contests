package br.com.danielbgg.contests.uva.problem100;

import java.io.IOException;
import java.util.StringTokenizer;

class Problem100 {

	int calculateCycleLength(int a, int b) {
		int max, min;
		if (a >= b) {
			max = a;
			min = b;
		} else {
			max = b;
			min = a;
		}
		int maxCycleLenght = 0;
		for (int i = min; i <= max; i++) {
			int maxIntermediateResult = algorithm(i);
			if (maxIntermediateResult > maxCycleLenght) {
				maxCycleLenght = maxIntermediateResult;
			}
		}
		System.out.println(a + " " + b + " " + maxCycleLenght);
		return maxCycleLenght;
	}

	int algorithm(int value) {
		int length = 0;
		int newValue = value;
		while (newValue > 1) {
			length++;
			if (newValue % 2 == 0) {
				newValue = newValue / 2;
			} else {
				newValue = (3 * newValue) + 1;
			}
		}
		return ++length;
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

	public static void main(String args[]) {
		Problem100 myWork = new Problem100();
		myWork.begin();
	}

	void begin() {
		String input;
		StringTokenizer idata;
		while ((input = Problem100.readLn(255)) != null) {
			idata = new StringTokenizer(input);
			int a = Integer.parseInt(idata.nextToken());
			int b = Integer.parseInt(idata.nextToken());
			calculateCycleLength(a, b);
		}
	}
}
