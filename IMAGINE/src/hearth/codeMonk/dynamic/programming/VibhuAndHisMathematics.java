/*
 
 https://www.hackerearth.com/code-monk-dynamic-programming/algorithm/vibhu-and-his-mathematics/
 
 */

package hearth.codeMonk.dynamic.programming;

import java.util.Scanner;

public class VibhuAndHisMathematics {

	public static void main(String args[] ) {
	Scanner in= new Scanner(System.in);
	int t=in.nextInt();
	
	long[] a = new long[1000001];
	a[0]= 0;
	a[1]= 1;
	a[2]=2;
	for(int i=3;i<=1000000;i++)
		a[i]= ((a[i-1])+ ((i-1)*a[i-2])) % 1000000007;
	while(t>0)
	{
		t--;
		int n = in.nextInt();
		System.out.println(a[n] );
	}
}
}
