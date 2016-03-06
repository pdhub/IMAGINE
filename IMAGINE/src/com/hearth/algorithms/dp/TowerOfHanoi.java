package com.hearth.algorithms.dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TowerOfHanoi {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int t = 0; t < N; t++) {
			int disksCount = Integer.parseInt(br.readLine());
			List<Disk> l = new ArrayList<Disk>();
			
			//Reading Input
			for (int j = 0; j < disksCount; j++) {
				String[] input = br.readLine().split(" ");
				Disk d = new Disk();
				d.radius = Integer.parseInt(input[0]);
				d.height = Integer.parseInt(input[1]);
				l.add(d);
			}
			
			//Sorting input
			Collections.sort(l, new Comparator<Disk>() {
				public int compare(Disk d1, Disk d2) {
					if (d1.radius <= d2.radius)
						return 1;
					else
						return -1;
				}
			});
			long[] dp = new long[disksCount];
			
			//Initial Dp is the height of the disk at that index
			for (int j = 0; j < disksCount; j++) {
				dp[j] = l.get(j).height;
			}
			
			for (int j = 1; j < disksCount; j++) {
				for (int i = 0; i < j; i++) {
					if (l.get(i).height > l.get(j).height && l.get(i).radius > l.get(j).radius) {
						dp[j] = Math.max(dp[j], (dp[i] + l.get(j).height));
					}
				}
			}
			long output = 0;
			for (int j = 0; j < disksCount; j++) {
				output = Math.max(output, dp[j]);
			}
			System.out.println(output);
		}
	}

	static class Disk {
		public int height;
		public int radius;
	}
}
