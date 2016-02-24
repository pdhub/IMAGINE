package com.hearth.algorithms.dp;

import java.math.BigInteger;
import java.util.Scanner;

public class FibonacciModified {

	public static int fibonacciMod(int a, int b, int n){
		BigInteger t[]= new BigInteger[n+2];
		t[0]=a;
		t[1]=b;
		
		for (int i = 0; i < t.length-2; i++) {
			t[i+2]= (t[i+1]*t[i+1])+t[i];
		}
		
		return t[n-1];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int n = in.nextInt();
		
		
		
		System.out.println(fibonacciMod( a,  b,  n));
	}
}
