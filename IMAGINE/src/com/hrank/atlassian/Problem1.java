package com.hrank.atlassian;

public class Problem1 {

	public static void main(String[] args) {
		 System.out.println(LookAndSay("11",2));
		 System.out.println(convert(7));

	}
	
	public static String convert(long input) {

        char base7[]={'0','a','t','l','s','i','n'};
        long rem;
        String str = "";
        while(input>0)
        {
            rem=input%7; 
            str=base7[(int) Math.floor(rem)]+str; 
            input=input/7;
        }
        return str;

    }
	
	public static String LookAndSay(String start, int n) {

       if(n==0)
            return start;
        int count = 1; char prev = start.charAt(0);
        //StringBuffer res = new StringBuffer();
        String res = "";
        for(int i=1;i<start.length();i++){
        	
            char next = start.charAt(i);
            if(next!=prev){
            	res+=count+""+prev;
            	count=1;prev=next;
            }
            else{
            	count++;
            }
        }
        res+=count+""+prev;
        start = res.toString();
        return LookAndSay(start,n-1);
        //return start;

    }

}
