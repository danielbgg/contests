package br.com.danielbgg.contests.uva.problem394;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Problem 394
 * 
 * Mapmaker
 * 
 * http://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=330
 */
class Problem394 {
	
	int n = 0;
	int r = 0;


	int algorithm(int value) {
		return 0;
	}

	public static void main(String args[]) {
		Problem394 myWork = new Problem394();
		//myWork.begin();
		
//		3 4
		
//		ONE       1500 2 2 0 3 1 5
//		TWO       2000 4 3 1 4 0 5 5 10
//		THREE     3000 1 1 1 9
		
//		ONE       2 4
//		THREE     7
//		TWO       2 0 6
//		TWO       3 3 9		
		
		
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
		String input;
		StringTokenizer idata;

		int line = 0;
		int n= 0;
		int r=0;
		
		while ((input = readLn(255)) != null) {
			idata = new StringTokenizer(input);
			
			if (line == 0) {
				n = Integer.parseInt(idata.nextToken());
				r = Integer.parseInt(idata.nextToken());
				line++;
			}
			
			
		}
		
		
		
		
		
	}
}
