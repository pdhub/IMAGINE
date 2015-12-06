package com.codeChef.practice;

import java.util.Scanner;

public class ChefAndCube {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int numTestCases = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numTestCases; i++) {
			int arr[] = { 0, 0, 0, 0, 0, 0 };
			String[] colors = in.nextLine().split(" ");
			
			boolean mayBeposs = false;
			int colorIndex = -1;
			for (int j = 2; j < colors.length; j++) {
				if(j!=colors.length-1){
					if(colors[j].equals(colors[j+1])){
						mayBeposs=true;
						colorIndex=j;
						break;
					}
				}else{
					if(colors[j].equals(colors[2])){
						mayBeposs=true;
						colorIndex=j;
						break;
					}
				}
			}
			
			if (mayBeposs && (colors[0].equals(colors[colorIndex]) | colors[1].equals(colors[colorIndex])))
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}

}
