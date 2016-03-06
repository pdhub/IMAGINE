package com.hearth.algorithms.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OnceuponatimeinTimeLand {
	public static void main(String args[] ) throws IOException {
        /*
         * Read input from stdin and provide input before running*/
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            String s[] = in.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            s = in.readLine().split(" ");
            long a[] = new long[n+1];
            a[1] = Math.max(Integer.parseInt(s[0]), 0);
            a[2] = Math.max(Integer.parseInt(s[1]), a[1]);
            for(int j = 2; j <=n; j++){
            	int l = Integer.parseInt(s[j-1]);
            	if(l<0 || (l>=0 && j-k-1<=0))
            		a[j] = Math.max(a[j-1], l);
            	else if(l>=0 && j-k-1>0)
            		a[j] = Math.max(a[j-1], l+a[j-k-1]);
            }
            System.out.println(a[n]);
        }
 
     }
}
