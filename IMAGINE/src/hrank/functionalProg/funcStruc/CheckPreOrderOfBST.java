package hrank.functionalProg.funcStruc;

import java.util.Scanner;
import java.util.Stack;

public class CheckPreOrderOfBST {

	public String checkPreOrderBST(int input[]){
		
		
		Stack<Integer> stack = new Stack<Integer>();
		
		int lower = -1;
		
		for (int i = 0; i < input.length; i++) {
			
			if(lower>-1 && input[i]<lower)
				return "NO";
			
			if(!stack.isEmpty() && stack.peek()<input[i])
				lower = stack.pop();
			
			stack.push(input[i]);
		}
		
		return "YES";
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.valueOf(in.nextLine());
		for (int i = 0; i < testCases; i++) {
			int numEle = Integer.valueOf(in.nextLine());
			int input[] = new int[numEle];
			for (int j = 0; j < numEle; j++) {
				input[j] = in.nextInt();
						
			}
			System.out.println(new CheckPreOrderOfBST().checkPreOrderBST(input));
		}

	}

}
