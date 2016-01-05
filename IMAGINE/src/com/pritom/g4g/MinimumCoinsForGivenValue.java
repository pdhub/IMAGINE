package com.pritom.g4g;

public class MinimumCoinsForGivenValue {

	
	public static void main(String[] args) {
		int[] coinTypes = {9,6,5,1};
		int total = 13;
		System.out.println(findMinimumNaiveRecursive(coinTypes,total));
		
		System.out.println(findMinimumUsingDynamic(coinTypes,total));
	}

	private static int findMinimumUsingDynamic(int[] coinTypes, int total) {
		//This is the result saving part
		int table[] = new int[total+1];
		
		table[0] = 0;
		
		for (int i = 1; i <= total; i++) {
			table[i] = Integer.MAX_VALUE;
		}
		
		//Here is the calculation part as done in the previous method
		for (int i = 1; i <= total; i++) {
			for (int j = 0; j < coinTypes.length; j++) {
				if(coinTypes[j]<=i){
					System.out.println(" coinTypes[j]: "+coinTypes[j] +" is <= than i : "+i);
					int tempRes = table[i-coinTypes[j]];
					System.out.println("TempRes : "+tempRes);
					if(tempRes !=Integer.MAX_VALUE && tempRes+1<table[i]){
						table[i]=tempRes+1;
						System.out.println("table[i] : "+table[i]);
					}
					
				}
			}
		}
		return table[total];
	}

	//This is a naive solution, where we check for each coin that is less than the total
	
	private static int findMinimumNaiveRecursive(int[] coinTypes, int total) {
		if(total==0)
			return 0;
		int res = Integer.MAX_VALUE;
		for (int i = 0; i < coinTypes.length; i++) {
			if(coinTypes[i]<=total){
				int tempRes = findMinimumNaiveRecursive(coinTypes, total-coinTypes[i]);
				if(tempRes!=Integer.MAX_VALUE && tempRes+1<res)
					res = tempRes+1;
			}
		}
		return res;
	}

}
