package com.pritom.hearth.thinkAThon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpecialPairs {

	private static int[] nums;
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		int test = Integer.valueOf(in.nextLine());
		int size = Integer.valueOf(in.nextLine());
		nums = new int[size];
		
		for (int i = 0; i < size; i++) {
			nums[i]=Integer.valueOf(in.nextInt());
		}
		
		calculate();

	}
	private static void calculate() {
	
		List posList = new ArrayList();;
		for (int i = 0; i < nums.length; i++) {
			int t1 = nums[i];
			for (int j = 0; j < nums.length; j++) {
				if((t1&nums[j])==0){
					
					//pos+=(i+1)+" "+(j+1)+" ";
					posList.add(i+1);
					posList.add(j+1);
				}
			}
		}
		
		System.out.println(posList.size()/2);
		
	}

}
