package com.hrank.crossover;

import java.util.ArrayList;
import java.util.List;

public class IsPalindrome {

	public static void main(String[] args) {
		String s = "abaac";
		System.out.println(is_Palindrome(s));
		
		
		new IsPalindrome().seeList();
		

	}
	
	private void seeList() {
		List list = new ArrayList();
		seeListAgin(list);
		System.out.println(list.size());
	}
	
	private void seeListAgin(List list) {
		list.add("1");
		
	}

	static String is_Palindrome(String s) {

		char chars[] = new char[256];
		
		for (int i = 0; i < chars.length; i++) {
			chars[i]=0;
		}
		
		for (int i = 0; i < s.length(); i++) {
			chars[s.charAt(i)]++;
		}
		
		if(s.length()%2 == 0){
			//Check if all elements have count divisible by 2
			for (int i = 0; i < chars.length; i++) {
				if(chars[i]%2 !=0)
					return "NO";
			}
			
		}else{
			int oddCount = 0;
			for (int i = 0; i < chars.length; i++) {
				if(chars[i]%2 !=0){
					oddCount++;
				}
			}
			
			if(oddCount > 1)
				return "NO";
			
			
		}
		
		return "YES";
			

    }
	
	
	

}
