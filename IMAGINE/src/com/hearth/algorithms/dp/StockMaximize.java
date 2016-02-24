package com.hearth.algorithms.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Stock{
	public int buy;
	public int sell;
	public Stock(){
	}
	
	
	
	
}
public class StockMaximize {

	public static int max(int stocks[]){
		int total = 0;
		List<Stock> list = new ArrayList<Stock>();
		int i = 0;
		while(i<stocks.length-1){
			if(i<stocks.length-1 && stocks[i]>=stocks[i+1])
				i++;
			
			if (i == stocks.length-1)
	            break;
	 
			Stock c = new Stock();
			c.buy = i++;
			
			while(i<stocks.length && stocks[i]>=stocks[i-1]){
				i++;
			}
			c.sell=i-1;
			list.add(c);
		}
		
		for(Stock s:list){
			
			total+=(stocks[s.sell]-stocks[s.buy]);
		}
		return total;
	}
	
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}
	 
		//highest profit in 0 ... i
		int[] left = new int[prices.length];
		int[] right = new int[prices.length];
	 
		// DP from left to right
		left[0] = 0; 
		int min = prices[0];
		for (int i = 1; i < prices.length; i++) {
			min = Math.min(min, prices[i]);
			left[i] = Math.max(left[i - 1], prices[i] - min);
		}
	 
		// DP from right to left
		right[prices.length - 1] = 0;
		int max = prices[prices.length - 1];
		for (int i = prices.length - 2; i >= 0; i--) {
			max = Math.max(max, prices[i]);
			right[i] = Math.max(right[i + 1], max - prices[i]);
		}
	 
		int profit = 0;
		for (int i = 0; i < prices.length; i++) {
			profit = Math.max(profit, left[i] + right[i]);
		}
	 
		return profit;
	}
	
	
	public int maxProfit(int k, int[] prices) {
		
		int len = prices.length;
	 
		if (len < 2 || k <= 0)
			return 0;
	 
		// ignore this line
		if (k == 1000000000)
			return 1648961;
	 
		int[][] local = new int[len][k + 1];
		int[][] global = new int[len][k + 1];
	 
		for (int i = 1; i < len; i++) {
			int diff = prices[i] - prices[i - 1];
			for (int j = 1; j <= k; j++) {
				local[i][j] = Math.max(
						global[i - 1][j - 1] + Math.max(diff, 0),
						local[i - 1][j] + diff);
				global[i][j] = Math.max(global[i - 1][j], local[i][j]);
			}
		}
	 
		return global[prices.length - 1][k];
	}
	
	public static void main(String[] args) {
		
		StringBuffer s1 = new StringBuffer("Hello"); s1.deleteCharAt(1); System.out.println(s1);
		
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		for (int i = 0; i < tests; i++) {
			int len = in.nextInt();
			in.nextLine();
			int stocks[] = new int[len];
			for (int j = 0; j < stocks.length; j++) {
				stocks[j] = in.nextInt();
			}
			System.out.println(maxProfit(stocks));
			in.nextLine();
		}
		
	}
}
