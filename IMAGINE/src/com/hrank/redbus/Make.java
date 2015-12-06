package com.hrank.redbus;

import java.io.IOException;

public class Make {
	
	public static void main(String[] args) throws IOException{
        int res;
        
        int[] _a = {7,9,5,6,3,2};
        
        res = maxDifferenceAgain(_a);
        System.out.println(res);
	}
	
	public static int maxDifferenceAgain(int[] a){
		int max= -1;
		
		
		int currMax = a[a.length-1];
		
		for (int i =  a.length-2; i >= 0; i--) {
			if(a[i]<currMax){
				if(max < currMax-a[i])
					max =  currMax-a[i];
			}
			
			if(a[i]>currMax){
				currMax = a[i];
			}
		}
		return max;
	}
	
	public static int maxDifference(int[] a)
	{
		int max= -1;
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				
				if(a[i] <a[j])
				{
					if(max<a[j]-a[i])
					{
						max = a[j]-a[i];
					}
				}
			}
		}
		return max;
	}
	

}
