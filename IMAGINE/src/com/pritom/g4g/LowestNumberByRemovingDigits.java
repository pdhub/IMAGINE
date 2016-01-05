package com.pritom.g4g;

import java.util.Scanner;

public class LowestNumberByRemovingDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String number = in.nextLine();
		String maxDeltions = in.nextLine();
		constructLowestNumber(number, maxDeltions);
	}

	private static void constructLowestNumber(String number, String maxDeltions) {
		Integer maxDeletions = Integer.parseInt(maxDeltions);
		for (int i = 0, j=0; i < maxDeletions && j<number.length(); j++) {
			if (number.charAt(j)>number.charAt(j+1)) {
				
			}
		}
		
	}

}
