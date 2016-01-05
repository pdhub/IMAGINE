package com.hearth.intalio;

import java.util.Scanner;

public class StringConstruction {

	public static void main(String[] args) {
		StringConstruction s = new StringConstruction();
		Scanner in = new Scanner(System.in);
		
		int testCases = Integer.valueOf(in.nextLine());
		
		for (int i = 0; i < testCases; i++) {
			String str = in.nextLine();
			System.out.println(s.count(str));
		}
		
		

	}
	
	public int count(String orig){
		
		int val = 0;
		String left = "";
		String right = "";
		
		left = left+orig.charAt(0)+"";
		
		String pivot = orig.charAt(0)+"";
		
		for (int i = 1; i < orig.length(); i++) {
			
			if((!right.contains(orig.charAt(i)+""))){
				//Try adding to left
				
					//left = left+orig.charAt(i)+"";
					right = right+orig.charAt(i)+"";
					val = val+right.length()+left.length();
					
			}else{
				//try adding to right
				if(!left.contains(orig.charAt(i)+"")){
					left = left+orig.charAt(i)+"";
					val = val+right.length()+left.length();
				}
				
			
				
			}
		}
		
		return val;
	}

}
