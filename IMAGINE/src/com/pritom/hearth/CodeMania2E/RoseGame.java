package com.pritom.hearth.CodeMania2E;

import java.util.Scanner;

public class RoseGame {

	
	public void checkGame(int a[]){
		int copy[] = new int[a.length];
		copy[0]=0;
		boolean win = false;
		int i = 0;
		while(a[i]!=-1 && copy[i]!=1){
			int next = a[i];
			if(a[next]==-1){
				win = true;
				break;
			}else{
				copy[i] = 1;
				i = next;
			}
		}
		if(win)
			System.out.println("Win");
		else
			System.out.println("Lose");
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.valueOf(in.nextLine());
		for (int i = 0; i < testCases; ++i) {
			int numele = Integer.valueOf(in.nextLine());
			int[] ele = new int[numele];
			for (int j = 0; j < numele; j++) {
				ele[j] = in.nextInt();
			}
			new RoseGame().checkGame(ele);
			if(i!=testCases-1)
				in.nextLine();
		}
	}

}
