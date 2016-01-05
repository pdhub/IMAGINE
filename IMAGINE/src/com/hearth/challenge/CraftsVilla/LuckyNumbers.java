package com.hearth.challenge.CraftsVilla;

import java.util.BitSet;
import java.util.Scanner;

public class LuckyNumbers {

	
	public void sum(int n){
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int num = Integer.bitCount(i);
			if(num==2){
				sum+=i;
			}
		}
		
		int res = sum%10000007;
		System.out.println(res);
	}
	
	private boolean contains2SetBits(int num) {
		int count = 0;
		while (num > 0) {
	        num = num&(num-1);
	       	count++;
	        if(count>2)
	        	return false;
	    }
		if(count==2)
			return true;
		return false;
	}
	
	public boolean checkBinaryAgain(int n){
		
		Integer num = Integer.valueOf(n);
		String numStr = num.toBinaryString(num);
		//System.out.println(numStr);
		int count = 0;
		for (int i = 0; i <numStr.length(); i++) {
			if(numStr.charAt(i)=='1')
				count++;
			if(count>2)
				return false;
		}
		if(count==2)
			return true;
		else
			return false;
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int numTests = Integer.valueOf(in.nextLine());
		for (int i = 0; i < numTests; i++) {
			Integer num = Integer.valueOf(in.nextLine());
			new LuckyNumbers().sum(num);
			
		}
				

	}

}
