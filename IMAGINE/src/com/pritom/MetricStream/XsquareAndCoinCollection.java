/*
 2
8 1
3 2 2 3 1 1 1 3
8 2
3 2 2 3 1 1 1 3
 
 
2
8 1
3 1 2 3 1 1 1 3
8 2
3 2 2 3 2 2 2 3
 
 */

package com.pritom.MetricStream;

import java.util.Scanner;

public class XsquareAndCoinCollection {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numTestCases = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numTestCases; i++) {
			String[] stackLenAndKSize = in.nextLine().split(" ");
			Integer stackLen = Integer.parseInt(stackLenAndKSize[0]);
			Integer kSize = Integer.parseInt(stackLenAndKSize[1]);
			String[] stackVals = in.nextLine().split(" ");
			Integer[] stackValsInt = new Integer[stackVals.length];
			for (int j = 0; j < stackValsInt.length; j++) {
				stackValsInt[j]=Integer.parseInt(stackVals[j]);
			}
			findMaximumSum(stackValsInt,kSize);
		}
	}

	private static void findMaximumSum(Integer[] stackValsInt, Integer kSize) {
		Integer tempSum =0;
		Integer sum = 0;
		for (int i = 0; i < stackValsInt.length; i++) {
			if(stackValsInt[i]==kSize){
				tempSum+=stackValsInt[i];
				sum=tempSum;
			}
			if(stackValsInt[i]!=kSize){
				tempSum=0;
			}
		}
		System.out.println(sum.toString().trim());
	}
}
