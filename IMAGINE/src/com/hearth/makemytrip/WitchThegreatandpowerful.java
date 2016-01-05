package com.hearth.makemytrip;

import java.util.Scanner;

public class WitchThegreatandpowerful {
	
	
	public int checkMaxMoves(int h[]){
		int moves = 0;
		
		while(h[2]-h[0]>2){
			if(h[2]-h[1]>h[1]-h[0]){
				
				h[0] = h[2]-1;
				int temp = h[0];
				h[0]=h[1];
				h[1]=temp;
				moves++;
				
			}else{
				
				h[2] = h[1]-1;
				int temp = h[2];
				h[2]=h[1];
				h[1]=temp;
				moves++;
				
			}
		}
		System.out.println(moves);
						
		return moves;
	}

	public static void main(String[] args) {
		//int h[] = {1,2,4};
		int h[] = new int[3];
		Scanner in = new Scanner(System.in);
		int testCases = Integer.valueOf(in.nextLine());
		for (int i = 0; i < testCases; i++) {
			String s[] = in.nextLine().split(" ");
			h[0] = Integer.valueOf(s[0]);
			h[1] = Integer.valueOf(s[1]);
			h[2] = Integer.valueOf(s[2]);
			//new WitchThegreatandpowerful().checkMaxMoves(h);
			new WitchThegreatandpowerful().checkRandom(h);
		}
		

	}
	
	public void checkRandom(int h[]){
		int max = 0;
		int diff1  = h[2]-h[1];
		int diff2 = h[1]-h[0];
		int sum = diff1+diff2;
		max = sum/2;
		System.out.println(sum);
		
	}

}
