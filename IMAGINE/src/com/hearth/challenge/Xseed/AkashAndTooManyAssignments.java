package com.hearth.challenge.Xseed;

import java.util.Iterator;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class AkashAndTooManyAssignments {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().split(" ");
		int strlen = Integer.valueOf(input[0]);
		int numOpr = Integer.valueOf(input[1]);
				
		String s = in.nextLine();
		for (int i = 0; i < numOpr; i++) {
			String inputOpr = in.nextLine();
			String opr[] = inputOpr.split(" ");
			switch(opr[0]){
			case "0":
				s= replaceAndReturn(s,Integer.valueOf(opr[1]),opr[2]);
				break;
			case "1":
				findlexicographicallySmallest(s,Integer.valueOf(opr[1]),Integer.valueOf(opr[2]),Integer.valueOf(opr[3]));
				break;
			}
		}
				
	}
	
	private static String replaceAndReturn(String s, int pos, String charToReplace) {
		char[] c = s.toCharArray();
		char[] repl = charToReplace.toCharArray();
		c[pos-1]=repl[0];
		String newString = "";
		for (int i = 0; i < c.length; i++) {
			newString+=c[i];
		}
		
		return newString;
		
	}

	private static void findlexicographicallySmallest(String s, int fromPos,
			int toPos, int k) {
		//System.out.println("frompos : "+fromPos+" topos : "+toPos);
		if(fromPos<0 || toPos>s.length())
			System.out.println("Out of Range");
		else{
			
			String substring = s.substring(fromPos-1, toPos);
			//System.out.println("Substring is : "+substring);
			SortedSet set = new TreeSet();
			for (int i = 0; i < substring.length(); i++) {
				//System.out.println("Adding "+substring.charAt(i));
				boolean added = set.add(substring.charAt(i)+"");
				if(!added)
					k--;
			}
			//System.out.println(set.size());
			Iterator it = set.iterator();
			while(it.hasNext()){
				if(k==1){
					System.out.println(it.next());
					break;
				}
				else{
					it.next();
					k--;
				}
			}
			
		}
		
	}
	
	
}
