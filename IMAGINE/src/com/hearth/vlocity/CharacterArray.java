package com.hearth.vlocity;

import java.util.Scanner;

public class CharacterArray {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		String input = in.nextLine();
		char sentence[] = new char[input.length()];
		
		for (int i = 0; i < input.length(); i++) {
			sentence[i]= input.charAt(i);
		}
		
		/*for (int i = 0; i < sentence.length; i++) {
			char c = sentence[i];
			System.out.print(c);
			System.out.print("-");
			
		}
		System.out.println();
		System.out.println("--------------");*/
		removeWhiteSpace(sentence);
	}

	private static void removeWhiteSpace(char[] sentence) {
		for (int i = 0; i < sentence.length; i++) {
			if(sentence[i]==' '){
				for (int j = i; j < sentence.length-1; j++) {
					sentence[j] = sentence[j+1];
				}
				sentence[sentence.length-1] = ' ';
			}
		}
		
		/*for (int i = 0; i < sentence.length; i++) {
			char c = sentence[i];
			System.out.print(c);
			System.out.print("-");
		}*/
		
	}

}
