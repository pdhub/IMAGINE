package com.pritom.g4g;

import java.util.Scanner;

public class TowersOfHanoi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input the Disk : ");
		int numDisks = Integer.parseInt(in.nextLine());
		String source = "A", aux="B", dest = "C";
		solveRecursive(numDisks, source, aux, dest);
		

	}

	private static void solveRecursive(int numDisks, String source, String aux,
			String dest) {
		if(numDisks==1)
			System.out.println(source +"->"+dest);
		else{
			solveRecursive(numDisks-1, source, dest, aux);
			System.out.println(source+"->"+dest);
			solveRecursive(numDisks-1, aux, source, dest);
		}
	}

}
