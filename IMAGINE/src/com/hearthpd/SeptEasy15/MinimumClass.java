package com.hearthpd.SeptEasy15;

import java.util.Scanner;

public class MinimumClass {

	
	public static int getMinimumClasses(Integer reqd){
		if(reqd<=2)
			return reqd;
		//System.out.println("ene");
		//reqd =reqd-2;
		int count =2;
		int classVal = 1;
		int totalClassTaken = 0;
		
		while(totalClassTaken<=reqd/2){
			totalClassTaken+= classVal++;	
			//System.out.println("Add : "+classVal);
			count++;
		}
		System.out.println("Total : "+totalClassTaken+" count : "+count);
		if(count%2==0)
			count--;
		return count;
		
	}
	public static void main(String[] args) {
		System.out.println(getMinimumClasses(6));
		System.out.println(getMinimumClasses(1));
		System.out.println(getMinimumClasses(9));
		/*Scanner in = new Scanner(System.in);
		int numTst = Integer.valueOf(in.nextLine());
		for (int i = 0; i < numTst; i++) {
			Integer num = Integer.valueOf(in.nextLine());
			System.out.println(getMinimumClasses(num));
		}*/
	}

}
