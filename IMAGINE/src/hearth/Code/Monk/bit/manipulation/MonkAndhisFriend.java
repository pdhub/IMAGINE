package hearth.Code.Monk.bit.manipulation;

import java.util.Scanner;


public class MonkAndhisFriend {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = Integer.valueOf(in.nextLine());
		for (int i = 0; i < testCases; i++) {
			String[] inpt = in.nextLine().split(" ");
			findDiversity(inpt[0], inpt[1]);
		}
		

	}
	public static void findDiversity(String n1, String n2){
		
		String binaryN1 = stringToBin(Long.valueOf(n1));
		String binaryN2 = stringToBin(Long.valueOf(n2));
		
		int zerosToAdd = Math.abs(binaryN1.length()-binaryN2.length());
		
		String zeros = "";
		for (int i = 0; i < zerosToAdd; i++) {
			zeros+="0";
		}
		
		if(binaryN1.length()>binaryN2.length()){
			binaryN2=zeros+binaryN2;
		}else
			binaryN1=zeros+binaryN1;
		
		int diverSity=0;
		for (int i = 0; i < binaryN1.length(); i++) {
			char n1Char = binaryN1.charAt(i);
			char n2Char = binaryN2.charAt(i);
			
			if(n1Char!=n2Char)
				diverSity++;
		}
		System.out.println(diverSity);
		
		
	}
	
	public static String stringToBin(Long num){
		String retVal = "";
		while(num>0){
			long rem = (long) (num%2);
			retVal=rem+retVal;
			num=num/2;
		}
		return retVal;
	}

}
