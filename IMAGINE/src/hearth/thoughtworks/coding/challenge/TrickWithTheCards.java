package hearth.thoughtworks.coding.challenge;

import java.math.BigInteger;
import java.util.Scanner;

public class TrickWithTheCards {

	public static BigInteger three = new BigInteger("3");
	public static BigInteger num = null;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = Integer.parseInt(in.nextLine());
		for (int i = 0; i < size; i++) {
			num = new BigInteger(in.nextLine());
			findMin(num);
		}
		
	}

	private static void findMin(BigInteger num) {
		
		if(num.compareTo(three)==0){
			System.out.println(1);
			return;
		}
		BigInteger res[] =num.divideAndRemainder(three);
		if(res[1]==BigInteger.ZERO)
			System.out.println(res[0]);
		else
			System.out.println(num);
		
	}

}
