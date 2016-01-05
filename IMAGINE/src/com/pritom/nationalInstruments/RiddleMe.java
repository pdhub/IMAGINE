package com.pritom.nationalInstruments;

public class RiddleMe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String encrypted = "lvlblb";
		String portion  = "abac";
		
		findActual(encrypted,portion);

	}

	private static void findActual(String encrypted, String portion) {
		int startpos = 0;
		int endPos = 0;
		for (int i = 0, j=0; i < portion.length()-1; i++) {
			if(
			Math.abs(portion.charAt(i) - encrypted.charAt(j)) == Math.abs(portion.charAt(i+1) - encrypted.charAt(j+1))){
				
			}
						
		}
		
	}

}
