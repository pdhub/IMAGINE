package hearth.capillary;

import java.util.HashSet;
import java.util.Scanner;

public class KthSequence {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();

		while (testCases-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			System.out.println(findKthsubSequence(n,k));
		}
	}

	private static String findKthsubSequence(int n, int k) {
		String retVal = ""; String orig= "";
		for (int i = 0; i < n; i++) {
			orig+="O";
		}
		HashSet<String> set = new HashSet<String>();
		generateSequence(n,k,set,orig);
		return retVal;
	}

	private static void generateSequence(int n, int k, HashSet<String> s, String orig) {
		s.add(orig);
		for (int i = 0; i < orig.length()-1; i++) {
			if(orig.charAt(i)!=orig.charAt(i+1)){
				
			}
		}
	}
}
