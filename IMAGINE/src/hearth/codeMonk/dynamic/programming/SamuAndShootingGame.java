/*
 
 https://www.hackerearth.com/code-monk-dynamic-programming/algorithm/samu-and-shooting-game/
 
 */


package hearth.codeMonk.dynamic.programming;

import java.util.Scanner;

public class SamuAndShootingGame {
	 public static void main(String args[] ) throws Exception {
		 Scanner in = new Scanner(System.in);
		 int T = in.nextInt();
		 while(T-- > 0) {
			 int X = in.nextInt(), Y = in.nextInt(), N = in.nextInt(), W = in.nextInt();
			 double P1 = in.nextInt() / 100.0, P2 = in.nextInt() / 100.0;
			 int i, j;
			 double dp[][] = new double[N + 1][W + 1];
			 for(i=0;i<=N;i++) {
				 dp[i][0] = 1;
			 }
			 for(i=1;i<=N;i++) {
				 for(j=1;j<=W;j++) {
					 dp[i][j] = Math.max(P1 * dp[i - 1][Math.max(j - X, 0)] + 
							 (1 - P1) * dp[i - 1][j],
							 P2 * dp[i - 1][Math.max(j - Y, 0)] + 
							 (1 - P2) * dp[i - 1][j]);
				 }
			 }
			 double ans = dp[N][W] * 100;

			 System.out.printf("%.6f\n", ans);        	
		 }
	 }
}
