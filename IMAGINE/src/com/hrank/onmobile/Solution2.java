package com.hrank.onmobile;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		Food f = new Food();
		f.getClass().getName();
		
		//System.out.println(calDegreePd("1010"));
		while(in.hasNext()){
			int x = in.nextInt();
			int y = in.nextInt();
			if(x<0 || y<0)
				System.out.println("java.lang.Exception: n and p should be non-negative");
			else
				System.out.println("sending "+x+" : "+y);
		}*/
		
		try {
			System.out.println(computeSum(12));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int x = 0; int y = 0;
		for (int z = 0; z < 5; z++) {
			if(++x>2 || (++y>2)){
				x++;
			}
		}
		
		try{
			int x1 = 4/0;
		}catch(Exception e){
			System.out.println("p");
		}finally {
			System.out.println("ee");
		}
		System.out.println(x +":"+y);
		new Solution2().s();

	}
	public void s(){
		String s = "h";
		System.out.println(s2(s));
	}
	
	private String s2(String s) {
		s = s+"l";
		System.out.println(s);
		return s;
	}
	public static int computeSum(int i) throws Exception{
		if(i<1 || i>50000){
			System.out.println("Invalid input: "+i);
			throw new RuntimeException();
		}
		
		int factorials[] = new int[i+1];
		factorials[0] = 1;
		return findFactorial(i,factorials);
	}
	
	
	private static int findFactorial(int i, int factorials[]) {
		int result =0;
		for (int j = 1; j <=i; j++) {
			int facdnum = getFactorial(j-1, factorials);
			int facnum = getFactorial(j, factorials);;
			result += facnum/facdnum;
		}
		return result;
	}



	private static int getFactorial(int j, int[] factorials) {
		if(j==0){
			return 1;
		}else{
			factorials[j] = j*(factorials[j-1]);
		}
		return factorials[j];
	}

	public static String calDegreePd(String time){
		
		String retVal = "";
		double hrDegree = 0;
		double minDegree = 0;
		double min = Double.valueOf(time.substring(0, 2));
		double hr = Double.valueOf(time.substring(2, 4));
		
		if(hr>12 || min>60)
			retVal = "Invalid Input :"+time;
		
		if(min==0){
			minDegree = 0;
		}else{
			minDegree = min*(360/60);
		}
		
		if(hr==12 || hr==0){
			hrDegree = 0;
		}else{
			hrDegree = (int) ((hr*(360/12))+((((minDegree))/(float)360)*30));
		}
		
		retVal = ((int)hrDegree + ":"+(int)minDegree);
		return retVal;
	}
	
	public static String calDegree(double h, double m){
		if (h <0 || m < 0 || h >12 || m > 60)
	        return "";
	 
	    if (h == 12) h = 0;
	    if (m == 60) m = 0;
	 
	    // Calculate the angles moved by hour and minute hands
	    // with reference to 12:00
	    int hour_angle = (int) (0.5 * (h*60 + m));
	    int minute_angle = (int) (6*m);
	 
	    // Find the difference between two angles
	    int angle = Math.abs(hour_angle - minute_angle);
	 
	    // Return the smaller angle of two possible angles
	    angle = Math.min(360-angle, angle);
	 
	    return String.valueOf(angle);
	}

}

class Food{
	Food(){
		System.out.println("Food");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Food";
	}
}
