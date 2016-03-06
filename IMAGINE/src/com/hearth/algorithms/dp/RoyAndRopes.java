package com.hearth.algorithms.dp;

import java.util.Scanner;

public class RoyAndRopes {

	public static void findMaxtime(int upper[], int lower[], int len) {
		int total = len;

		for (int i = 0; i < upper.length; i++) {

			int upperRemain = upper[i];

			int lowerRemain = lower[i];

			int totalRemain = Math.max(upperRemain, lowerRemain);

			if (totalRemain > (total - (i + 1))) {
				total += totalRemain - (total - (i + 1));
			}

		}
		System.out.println(total);
	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		while (testCases-- > 0) {
			int size = in.nextInt();
			int upper[] = new int[size-1];
			int lower[] = new int[size-1];

			for (int i = 0; i < lower.length; i++) {

				upper[i] = in.nextInt();
			}

			for (int i = 0; i < lower.length; i++) {
				lower[i] = in.nextInt();
			}

			findMaxtime(upper, lower,size);
			
		}

	}
}
