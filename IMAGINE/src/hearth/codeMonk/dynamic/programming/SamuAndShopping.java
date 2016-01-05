
/**
 
 https://www.hackerearth.com/code-monk-dynamic-programming/algorithm/samu-and-shopping/
 
 */
package hearth.codeMonk.dynamic.programming;

import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

class SamuShopping{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);

		int tc = sc.nextInt();

		while(tc != 0){

			int shops = sc.nextInt();
			int[][] prices = new int[shops][3];
			int[][] memoization = new int[shops][3];
			int minimum = 0;

			for(int i = 0; i < shops; i++){
				for(int j = 0; j < 3; j++) prices[i][j] = sc.nextInt();
			}

			for(int i = 0; i < 3; i++) memoization[0][i] = prices[0][i];

			for(int i = 1; i < shops; i++){
				memoization[i][0] = ((memoization[i-1][1] < memoization[i-1][2]) ? memoization[i-1][1] : memoization[i-1][2]) + prices[i][0];
				memoization[i][1] = ((memoization[i-1][0] < memoization[i-1][2]) ? memoization[i-1][0] : memoization[i-1][2]) + prices[i][1];
				memoization[i][2] = ((memoization[i-1][0] < memoization[i-1][1]) ? memoization[i-1][0] : memoization[i-1][1]) + prices[i][2];
			}

			minimum = (memoization[shops-1][0] < memoization[shops-1][1]) ? memoization[shops-1][0] : memoization[shops-1][1];
			if(minimum > memoization[shops-1][2]) minimum = memoization[shops-1][2];

			out.println(minimum);

			tc--;
		}
	}
}