package com.hearth.chipmonk;

public class VerifyRotatedPalindrome {

	public static boolean isPalinDrome(String s){
		
		char[] ins = s.toCharArray();
		for (int i = 0; i <= ins.length/2; i++) {
			if(ins[i]!=ins[ins.length-1-i]){
				return false;
			}
		}
		return true;
	}
	
	public static boolean IsRotated(String s){
		for (int i = 0; i < s.length(); i++) {
			String left = s.substring(0,i);
			String right = s.substring(i);
			
			if(isPalinDrome(left+right))
				return true;
		}
		
		return false;
	}
}
