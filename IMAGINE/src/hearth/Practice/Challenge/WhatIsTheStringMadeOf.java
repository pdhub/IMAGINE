package hearth.Practice.Challenge;

import java.util.Scanner;

public class WhatIsTheStringMadeOf {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(madeOf(in.nextLine()));

	}
	
	public static int madeOf(String s){
		
		int res = 0;
		int arr[] = {6,2,5,5,4,5,6,3,7,6};
		for (int i = 0; i < s.length(); i++) {
			int x = Integer.valueOf(s.charAt(i)+"");
			res+=arr[x];
			
		}
		return res;
	}
	
	public static int anotherWay(String s){
		int p = 0;
		for(int j=0;j<s.length();j++){
	    	  char c =s.charAt(j);
	    	  if(c == '1')
	    	   p=p+2;
	    	  else if(c == '2'  || c == '3' || c == '5')
	    	   p=p+5;
	    	  else if(c == '4' )
	       	   p=p+4;
	    	  else if(c == '6' ||c=='9' || c == '0')
	    	   p=p+6;
	    	  else if(c == '7')
	           p=p+3;
	    	  else
	      	   p=p+7;
	    	  
	      }
	      return p;
	}

}
