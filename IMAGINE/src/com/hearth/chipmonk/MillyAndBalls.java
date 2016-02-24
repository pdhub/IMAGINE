package com.hearth.chipmonk;

import java.math.BigInteger;
import java.util.Scanner;

public class MillyAndBalls {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int numPersons = in.nextInt();
			int initialBalls = in.nextInt();
			System.out.println(calculateExtraBalls(numPersons, initialBalls));
		}
			

	}

	public static int calculateExtraBalls(int numPersons, int initialBalls){
		
		BigInteger numPer = new BigInteger(Integer.valueOf(numPersons).toString());
		BigInteger initialbal = new BigInteger(Integer.valueOf(initialBalls).toString());
		BigInteger totalBallsReqdForACircle = (numPer.multiply(numPer.add(BigInteger.ONE)).divide(new BigInteger("2")));
		if(totalBallsReqdForACircle.compareTo(initialbal)==1)
			return totalBallsReqdForACircle.subtract(initialbal).intValue();
		else{
			Integer extraballs = (initialbal.mod(totalBallsReqdForACircle).intValue()); 
			/*if(extraballs>totalBallsReqdForACircle){
				extraballs = extraballs%totalBallsReqdForACircle;
			}*/
			if(extraballs>0)
				return (int) (totalBallsReqdForACircle.subtract(new BigInteger(extraballs.toString())).intValue());
		}
		return 0;
	}
}
