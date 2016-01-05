package com.pritom.stringManipulation;

public class FindPermutations {

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++) {
				/*
				 * System.out.println("--------"+i+"------------------------------"
				 * ); System.out.println("Prefix is : " + prefix);
				 * System.out.println("str.charAt(i) is: " + str.charAt(i));
				 * System.out.println("str.substring(0, i) is :" +
				 * str.substring(0, i));
				 * System.out.println("str.substring(i+1, n) is : " +
				 * str.substring(i + 1, n));
				 */
				permutation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));

			}
		}
	}

	public static void main(String[] args) {
		permutation("abc");
	}

}
