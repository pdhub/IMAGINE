package com.pritom.hearth.CodeMania2E;

import java.util.Scanner;

public class MathematicianFight {

	
	public void calc(int n){
		int div = (int) Math.floor((double)n/2);
		int rem = (int) Math.floor((double)n/10);
		int num = div+(rem+1);
		System.out.println(num);
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.valueOf(in.nextLine());
		for (int i = 0; i < testCases; ++i) {
			int ele = Integer.valueOf(in.nextLine());
			
			new MathematicianFight().calc(ele);
			
		}

	}

}
