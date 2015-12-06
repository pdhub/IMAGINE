package com.pritom.g4g;

import java.util.Scanner;

public class FindOptimalA {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer keyStrokes = Integer.parseInt(in.nextLine());
		//Integer numOfA = findOptimal(keyStrokes);
		Integer numOfA = findOptimalByStoringResults(keyStrokes);
		System.out.println(numOfA);
	}

	private static Integer findOptimalByStoringResults(Integer keyStrokes) {
		if(keyStrokes<=6)
			return keyStrokes;
		int results[] = new int[keyStrokes];
		for (int i = 1; i <= 6; i++) {
			results[i-1]=i;
		}
		// Solve all subproblems in bottom manner
		for (int i = 7; i <= keyStrokes; i++) {
			results[i-1]=0;
			// For any keystroke n, we need to loop from n-3 keystrokes
	        // back to 1 keystroke to find a breakpoint 'b' after which we
	        // will have ctrl-a, ctrl-c and then only ctrl-v all the way.
			for (int b = keyStrokes-3; b >=1; b--) {
				int curr = (i-b-1)*results[b-1];
				if(curr>results[i-1])
					results[i-1]=curr;
			}
		}
		return results[keyStrokes-1];
	}

	private static int findOptimal(Integer keyStrokes) {
		if(keyStrokes<=6)
			return keyStrokes;
		int max = 0;
		for (int b = keyStrokes-3; b >=1; b--) {
			int curr = (keyStrokes-b-1)*findOptimal(b);//Why did we do a multiplication here? And why -1
			if(curr>max)
				max=curr;
		}
		return max;
	}
	

}
