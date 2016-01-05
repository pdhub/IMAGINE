package com.hearth.challenge.bookMyShow;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MarutAndGirls {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numQualities = Integer.parseInt(in.nextLine());
		String[] marutReqQlty = in.nextLine().split(" ");
		
		int numGirls = Integer.parseInt(in.nextLine());
		int eligibleGirls = 0;
		for (int i = 0; i < numGirls; i++) {
			String[] girlQlity = in.nextLine().split(" ");
			List<String> girlQlityList = Arrays.asList(girlQlity);
			/*for (int j = 0; j < girlQlity.length; j++) {
				girlQlityList+=girlQlity[j]+":";
			}*/
			//System.out.println(girlQlityList);
			int countQuality = 0;
			for (int j = 0; j < marutReqQlty.length; j++) {
				String quality = marutReqQlty[j];
				if(girlQlityList.contains(quality))
					countQuality++;
			}
			if(countQuality>=marutReqQlty.length)
				eligibleGirls++;
		}
		System.out.println(eligibleGirls);
	}

}
