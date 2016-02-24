package com.hearth.chipmonk;

public class SquareRoot {

	public static double squareRoot(int a){
		if(a<0)
			return -1;
		if(a==0 || a==1)
			return a;
		
		double precision = 0.0001;
		double start = 0;
		double end = a;
		
		if(a<1)
			end = 1;
		
		while(end-start<precision){
			double mid = (end+start)/2;
			double midsqr = mid*mid;
			if(midsqr==a)
				return mid;
			else if(mid<a){
				start = mid;
			}else
				end = mid;
		}
				
		return (start+end)/2;
	}
	
	public static void main(String[] args) {
		int a = 65;
		System.out.println(squareRoot(a));
	}
}
