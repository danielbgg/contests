package br.com.danielbgg.contests.uva.template;

import java.io.IOException;
import java.util.StringTokenizer;

class Main {

	int execute(int min, int max) {
		return 0;
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
		Main myWork = new Main();
		myWork.begin();
	}

	void begin() {
		String input;
		StringTokenizer idata;
		while ((input = Main.readLn(255)) != null) {
			idata = new StringTokenizer(input);
			int a = Integer.parseInt(idata.nextToken());
			int b = Integer.parseInt(idata.nextToken());
			execute(a, b);
		}
	}
}
