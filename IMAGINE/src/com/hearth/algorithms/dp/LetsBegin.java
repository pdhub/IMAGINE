package com.hearth.algorithms.dp;

import java.util.Scanner;

public class LetsBegin {
	static int arr[] = { 7, 5, 3, 2 };

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();

		while (testCases-- > 0) {
			int num = in.nextInt();
			System.out.println(findMinimumPrimesReq(num));
		}
	}
	
	static long memory[]=new long[1000001];
	static int num;
	
	static long sum(int x)
	{
		if(x<0) return 1000001;
		if(x-7==0) return 1;
		if(x-5==0) return 1;
		if(x-3==0) return 1;
		if(x-2==0) return 1;
		if(memory[x]!=-1) return memory[x];
		
		memory[x]=Math.min(1+sum(x-7),Math.min(1+sum(x-5),Math.min(1+sum(x-3),1+sum(x-2))));
		return (memory[x]);
		
	}

	private static int findMinimumPrimesReq(int n) {
		int ret = -1;
		if(n<8){
			if (n== 2 || n== 3 || n== 5 ||n== 7)
				ret=1;
			else 
				ret=-1;
		}
		else if (n%7==0)
			ret=n/7;
		else if ( n%7 == 2 || n%7== 3 || n%7== 5 || n%7==1 ) 
			ret=n/7+1;
		else if (n%7==4 || n%7==6)
			ret=n/7+2;
		
		return ret;

	}

}
