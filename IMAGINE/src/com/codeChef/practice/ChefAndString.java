package com.codeChef.practice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ChefAndString {
	private static Map<String,Integer> map = new HashMap<String, Integer>();
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Integer numTestCases = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < numTestCases; i++) {
			String[] strLenAndNumWays= in.nextLine().split(" ");
			String s = in.nextLine();
			Integer numWays = Integer.parseInt(strLenAndNumWays[1]);
			populateMap(s);
			for (int j = 0; j < numWays; j++) {
				Integer num = Integer.parseInt(in.nextLine());
				calculateNumWays(num);
			}
			map.clear();
		}
		
	}

	private static void populateMap(String s) {
		
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < s.length(); i++) {
			
			for (int j = 1; j <= s.length()-i; j++) {
				String temp = s.substring(i, i+j);
				//System.out.println("i is :" +i+" j : "+j+"Adding : "+temp);
				if(map.get(temp)!=null)
					map.put(temp, Integer.valueOf(map.get(temp))+1);
				else
					map.put(temp, 1);
				
			}
		}
		
	}

	private static void calculateNumWays(Integer num) {
		int sum=0;
		for (Iterator iterator = map.keySet().iterator(); iterator.hasNext();) {
			String type = (String) iterator.next();
			if(map.get(type)>=num){
				sum+=getNcr(map.get(type),num);
			}
			
		}
		System.out.println(sum);
		
	}

	private static int getNcr(Integer N, Integer num) {
		BigInteger ret = BigInteger.ONE;
	    for (int k = 0; k < num; k++) {
	        ret = ret.multiply(BigInteger.valueOf(N-k))
	                 .divide(BigInteger.valueOf(k+1));
	    }
	    return ret.intValue();
	}

}
