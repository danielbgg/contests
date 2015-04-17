package br.com.danielbgg.contests.uva.problem100;

import java.util.LinkedList;
import java.util.List;

/**
 * The 3n + 1 problem
 */
public class Problem100 {

	public void algorithm(int min, int max) {
		int maxCycleLenght = 0;
		for (int i = min; i <= max; i++) {
			List l = new LinkedList();
			algorithm2(l, i);
			if (l.size() > maxCycleLenght) {
				maxCycleLenght = l.size();
			}
		}
		System.out.println(min + " " + max + " " + maxCycleLenght);
	}

	private void algorithm2(List l, int value) {
		l.add(value);
		if (value == 1) {
			return;
		}
		if (value % 2 == 0) {
			value = value / 2;
		} else {
			value = (3 * value) + 1;
		}
		algorithm2(l, value);
	}

	public static void main(String[] args) {
		Problem100 p100 = new Problem100();
		p100.algorithm(1, 10);
		p100.algorithm(100, 200);
		p100.algorithm(201, 210);
		p100.algorithm(900, 1000);
		p100.algorithm(1, 110000);
	}
	

}
