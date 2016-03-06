package hearth.techMojo;

import java.util.Scanner;

public class LovelyCouple {

	public static int findPossibleRank(int total, int better, int worse){
		int res = 0;
		return res;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		while(testCases-- !=0){
			int total = in.nextInt();
			int better = in.nextInt();
			int worse = in.nextInt();
			
			System.out.println(findPossibleRank(total, better, worse));
		}
	}
}
