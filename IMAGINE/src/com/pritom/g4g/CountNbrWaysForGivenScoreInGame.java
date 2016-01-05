package com.pritom.g4g;

public class CountNbrWaysForGivenScoreInGame {

	public static void main(String[] args) {
		int n = 20;
	   System.out.println(count(n));
	 
	}

	private static int count(int n) {
		 int table[] = new int[n+1];
		 
		    // Initialize all table values as 0
		   
		    // Base case (If given value is 0)
		    table[0] = 1;
		 
		    // One by one consider given 3 moves and update the table[]
		    // values after the index greater than or equal to the
		    // value of the picked move
		    for (int i=3; i<=n; i++)
		       table[i] += table[i-3];
		    for (int i=5; i<=n; i++)
		       table[i] += table[i-5];
		    for (int i=10; i<=n; i++)
		       table[i] += table[i-10];
		 
		    return table[n];
	}

}
