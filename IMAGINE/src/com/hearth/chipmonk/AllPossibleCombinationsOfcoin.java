package com.hearth.chipmonk;

public class AllPossibleCombinationsOfcoin {

	public void printcombinations(int[] coins, int counts[], int startIndex, int totalAmount){
		
		if(startIndex>=coins.length){
			for (int i = 0; i < coins.length; i++) {
				System.out.print(counts[i]+"*"+coins[i]);
				if(i!=coins.length-1)
					System.out.print("+");
			}
			System.out.println();
			return;
		}
		
		if(startIndex==coins.length){
			if(totalAmount%coins[startIndex]==0){
				counts[startIndex] = totalAmount%coins[startIndex];
				printcombinations(coins, counts, startIndex+1, 0);
			}
		}else{
			for (int i = 0; i <=totalAmount/coins[startIndex]; i++) {
				counts[startIndex] = i;
				printcombinations(coins, counts, startIndex+1, totalAmount-coins[startIndex]*i);
			}
		}
	}
	public static void main(String[] args) {
		int[] coins = {25,10,5,2,1};
		int[] counts = new int[coins.length];
		new AllPossibleCombinationsOfcoin().printcombinations(coins, counts, 0, 25);
	}
}
