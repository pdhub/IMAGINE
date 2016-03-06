package hearth.techMojo;

import java.math.BigInteger;
import java.util.Scanner;

public class MillySRank {

	public static String findPossibleRank(BigInteger total, BigInteger better, BigInteger worse){
		BigInteger res = BigInteger.ZERO;
		res = total.subtract(better).add(worse).subtract(new BigInteger("2"));
		return res.toString();
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		while(testCases-- !=0){
			BigInteger total = new BigInteger(in.next());
			BigInteger better = new BigInteger(in.next());
			BigInteger worse = new BigInteger(in.next());
			
			System.out.println(findPossibleRank(total, better, worse));
			
		}
		in.close();
	}
}
