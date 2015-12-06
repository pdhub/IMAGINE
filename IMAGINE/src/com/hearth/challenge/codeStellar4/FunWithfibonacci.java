package com.hearth.challenge.codeStellar4;

import java.math.BigInteger;
import java.util.Scanner;

public class FunWithfibonacci {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numTestCase = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numTestCase; i++) {
			generateFibonacci(Integer.valueOf(in.nextLine()));
		}
		
	}

	private static void generateFibonacci(int i) {
		BigInteger prev1=BigInteger.ZERO;
		BigInteger prev2=BigInteger.ONE;
		BigInteger finalSum=BigInteger.ZERO;
		BigInteger sum=prev1.add(prev2);
		/*while (sum<i) {
			//System.out.println(sum);
			if(sum%2==0)
				finalSum+=sum;
			sum=prev1+prev2;
			prev1=prev2;
			prev2=sum;
			
		}*/
		System.out.println(finalSum);
		
	}

}
