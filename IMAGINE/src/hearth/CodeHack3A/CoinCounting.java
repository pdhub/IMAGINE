package hearth.CodeHack3A;

import java.util.Scanner;

public class CoinCounting {

	public static void main(String[] args) {
		
		int[] coins = { 1,3, 5 };
		Scanner in = new Scanner(System.in);
		int numTes = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numTes; i++) {
			Integer sum = Integer.parseInt(in.nextLine());
			findNumWays(sum, coins);
		}
		
	}

	private static void findNumWays(Integer sum, int[] coins) {
		Integer [] array = new Integer[sum+1];
		for (int i = 0; i < array.length; i++) {
			array[i]=0;
		}
		array[0]=1;
		
		for (int i = 0; i < coins.length; i++) {
			int j = coins[i];
			for (int k = j; k <= sum; k++) {
				
				array[k]+=array[k-j];
				
			}
		}
		
		System.out.println(array[sum]);
		
	}

}
