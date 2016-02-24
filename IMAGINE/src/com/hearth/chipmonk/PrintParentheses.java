package com.hearth.chipmonk;

public class PrintParentheses {

	public static void printParentheses(int leftRemain, int rightRemain, String currentString){
		
		if(rightRemain ==0 ){
			System.out.println(currentString);
			return;
		}
		if(leftRemain>0){
			printParentheses(leftRemain-1, rightRemain, currentString+"(");
			
			if(leftRemain<rightRemain)
				printParentheses(leftRemain, rightRemain-1, currentString+")");
		}
		else
			printParentheses(leftRemain, rightRemain-1, currentString+")");
	}
	
	public static void main(String[] args) {
		printParentheses(3, 3, "");
	}
}
