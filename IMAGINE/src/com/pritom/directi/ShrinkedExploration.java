package com.pritom.directi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShrinkedExploration {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String text = "ab2c3";//in.nextLine();
		int k = 14;//Integer.parseInt(in.nextLine());
		System.out.println(new ShrinkedExploration().findKthChar(text,k));
		
		//System.out.println(new ShrinkedExploration().findKthCharOptimized(text,k));

	}

	
	private char findKthChar(String shrinkedMessage, int k) {
		String sbuf = "";
		
		for (int i = 0; i < shrinkedMessage.length() && sbuf.length()<=k ; i++) {
			if(Character.isDigit(shrinkedMessage.charAt(i))){
				
				String digit = shrinkedMessage.charAt(i)+"";
				for (int j = i+1; j < shrinkedMessage.length(); j++) {
					if(Character.isDigit(shrinkedMessage.charAt(j))){
						digit+=shrinkedMessage.charAt(j);
					}else
						break;
				}
				Integer finaldigit = Integer.valueOf(digit);			
				
				String tempString = sbuf.toString();
				
				for (int j = 0; j < finaldigit-1; j++) {
					sbuf+=(tempString);
				}
			}else
				sbuf+=(shrinkedMessage.charAt(i)+"");
		}
		//System.out.println(sbuf.toString());
		
		return sbuf.charAt(k-1);
		
	}

}
