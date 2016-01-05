package hearth.Target.hiring.Challenge15;

import java.util.Scanner;

public class WillYouBeMyFriend {

	private static int count=0;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int puchi = Integer.parseInt(in.nextLine());
		int tests = Integer.parseInt(in.nextLine());
		for (int i = 0; i < tests; i++) {
			int num = Integer.parseInt(in.next());
			check(puchi,num);
		}
		System.out.println(count);
	
	}
	private static void check(int puchi, int num) {
		int res = GCD(puchi,num);
		if(res!=1)
			count++;
		
	}
	public static int GCD(int a, int b) {
		   if (b==0) return a;
		   return GCD(b,a%b);
		}

}
