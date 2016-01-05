package com.hrank.redbus;

import java.util.Scanner;

public class PascalTree {
	public static void main(String[] args) {

		double d = 10.0/-0;
		System.out.println(d == Double.POSITIVE_INFINITY );
		String a= new String("asdasd");
		String b= new String("asdasdasd");
		String c= a+b;
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		sc.close();
		PascalTree ptObj = new PascalTree();
		ptObj.printPascalTree(k);
		
	}

	private static void pass(int[] a) {
		// TODO Auto-generated method stub
		a[0]++;
	}

	private static void printPascalTree(int k) {

		for (int i = 0; i < k; i++) {

			int number = 1;

		//	System.out.print((k - i) * 2 + " ");

			for (int j = 0; j <= i; j++) {
				System.out.print(number + " ");
				number = number * (i - j) / (j + 1);
			}

			System.out.println();
		}
	}

	private int getFactorial(int num) {
		if (num == 1 || num == 0)
			return 1;
		return num * getFactorial(num - 1);
	}

	private void pt2(int k) {
		for (int i = 0; i < k; i++) {

			int number = 1;

		//	System.out.print((k - i) * 2 + " ");

			for (int j = 0; j <= i; j++) {
				System.out.print(number + " ");
				number = number * (i - j) / (j + 1);
			}

			System.out.println();
		}
	}

}
