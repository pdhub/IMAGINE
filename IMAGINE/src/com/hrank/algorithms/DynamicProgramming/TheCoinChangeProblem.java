package com.hrank.algorithms.DynamicProgramming;

import java.util.Scanner;

public class TheCoinChangeProblem {

	public int countNumWays(int coins[], int numCoins, int sum){
		
		if(sum==0)
			return 1;
		
		if(sum<=0)
			return 0;
		
		if(numCoins<=0 && sum>=1)
			return 0;
		
		return countNumWays(coins, numCoins-1, sum) + countNumWays(coins, numCoins, sum-coins[numCoins-1]);
	}
	
	public int countNumWaysOptimized(int coins[], int numCoins, int sum){
		
		int i=0, j=0, x=0, y=0;
		 
	    // We need n+1 rows as the table is consturcted in bottom up manner using 
	    // the base case 0 value case (n = 0)
	    int table[][] = new int[sum+1][numCoins];
	    //int table[][] = new int[numCoins][sum+1];
	    
	    
	    // Fill the enteries for 0 value case (n = 0)
	    for (i=0; i<numCoins; i++)
	        table[0][i] = 1;
	    
	    // Fill rest of the table enteries in bottom up manner  
	    for (i = 1; i < sum+1; i++)
	    {
	        for (j = 0; j < numCoins; j++)
	        {
	            // Count of solutions including S[j]
	            x = (i-coins[j] >= 0)? table[i - coins[j]][j]: 0;
	 
	            // Count of solutions excluding S[j]
	            y = (j >= 1)? table[i][j-1]: 0;
	 
	            // total count
	            table[i][j] = x + y;
	        }
	    }
	    return table[sum][numCoins-1];
	}
	
	
	public int countNumWaysOptimizedMore(int coins[], int numCoins, int sum){
		int table[] = new int[sum+1];
		 
	    for (int i = 0; i < table.length; i++) {
	    	table[i] = 0;
		}
	    // Base case (If given value is 0)
	    table[0] = 1;
	 
	    // Pick all coins one by one and update the table[] values
	    // after the index greater than or equal to the value of the
	    // picked coin
	    for(int i=0; i<numCoins; i++)
	        for(int j=coins[i]; j<=sum; j++)
	            table[j] += table[j-coins[i]];
	    return table[sum];
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int sum = in.nextInt();
		int numCoins = in.nextInt();
		in.nextLine();
		int coins[] = new int[numCoins];
		for (int i = 0; i < numCoins; i++) {
			coins[i] = in.nextInt();
		}
		in.nextLine();
		
		int numWays = new TheCoinChangeProblem().countNumWaysOptimizedMore(coins, numCoins, sum);
		
		System.out.println(numWays);
	}
}
