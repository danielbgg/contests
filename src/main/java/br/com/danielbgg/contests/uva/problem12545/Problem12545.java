package br.com.danielbgg.contests.uva.problem12545;

import java.io.IOException;
import java.util.Arrays;
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

	static int EQUALS = 1;
	static int DIFFERENT = 0;
	static int MASK = 2;
	static int DIFFERENT_MOVED = 3;
	int mask = 0;

	void analiseInicial(char[] chars, char[] chart, int[] b) {
		System.out.println("----");
		System.out.println("analise inicial - marcar dados diferentes como 0, iguais como 1 e mascaras como 2");
		for (int i = 0; i < chars.length; i++) {
			char s1 = chars[i];
			char t1 = chart[i];
			if (s1 == t1) {
				b[i] = EQUALS;
			} else if (s1 == '?') {
				b[i] = MASK;
				mask++;
			} else {
				b[i] = DIFFERENT;
			}
		}
	}

	int inverterPosicoes(char[] chars, char[] chart, int[] b) {
		System.out.println("----");
		System.out.println("inverter posicoes diferentes no s");
		int count = 0;
		loop1: for (int i = 0; i < chars.length; i++) {
			if (b[i] == DIFFERENT) {

				loop2: for (int j = i + 1; j < chars.length; j++) {
					if (b[j] == EQUALS || chars[j] == '?') {
						continue loop2;
					}

					if (chars[i] != chars[j]) {
						char a = chars[i];
						chars[i] = chars[j];
						chars[j] = a;
						count++;
						if (chars[i] == chart[i] && chars[j] == chart[j]) {
							b[i] = EQUALS;
							b[j] = EQUALS;
							continue loop1;
						}
					}
				}
			}
		}
		return count;
	}

	int encontraMascara(char[] chars, int posicaoInicial) {
		for (int i = posicaoInicial; i < chars.length; i++) {
			if (chars[i] == '?') {
				return i;
			}
		}
		return -1;
	}

	int reposicionarMascara(char[] chars, char[] chart, int[] b) {
		System.out.println("----");
		System.out.println("reposicionar a mascara no s");
		int count = 0;

		loop2: for (int i = 0; i < chars.length; i++) {
			if (b[i] == DIFFERENT && mask >= 0) {
				
				System.out.println("Diferente:" + i);

				loop1:for (int j = 0; j < chars.length; j++) {
					if (chars[j] == '?' && b[j] == MASK) {

						if (chars[i] == chart[j]) {
							char a = chars[i];
							chars[i] = chars[j];
							chars[j] = a;
							count++;
							mask--;
							continue loop2;
						}

					}
				}

			}

		}
		return count;
	}

	void printDados(char[] chars, char[] chart, int[] b, int count) {
		System.out.println("----");
		System.out.println("array s: " + Arrays.toString(chars));
		System.out.println("array t: " + Arrays.toString(chart));
		System.out.println("array b: " + Arrays.toString(b));
		System.out.println("count: " + count);
	}

	int substituirMascara(char[] chars, char[] chart, int[] b) {
		System.out.println("----");
		System.out.println("substituir a mascara");
		int count = 0;
		loop3: for (int i = 0; i < chars.length; i++) {
			if (chars[i] == '?') {
				chars[i] = chart[i];
				b[i] = EQUALS;
				count++;
				continue loop3;
			}
		}
		return count;
	}

	int calculate(String s, String t) {
		char[] chars = s.toCharArray();
		char[] chart = t.toCharArray();
		int count = 0;
		mask = 0;
		int[] b = new int[s.length()];

		System.out.println("-----------------------------------------------");
		analiseInicial(chars, chart, b);
		printDados(chars, chart, b, count);
		count = count + inverterPosicoes(chars, chart, b);
		printDados(chars, chart, b, count);
		count = count + reposicionarMascara(chars, chart, b);
		printDados(chars, chart, b, count);
		count = count + substituirMascara(chars, chart, b);
		printDados(chars, chart, b, count);

		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != chart[i]) {
				count = -1;
				break;
			}
		}

		printDados(chars, chart, b, count);
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
		for (int i = 0; i < data.length; i = i + 2) {
			System.out.println("Case " + (j++) + ": " + calculate(data[i], data[i + 1]));
		}
	}
}
