package com.hearth.challenge.bookMyShow;
import java.util.Scanner;

public class ValentineShopping {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numTestCases = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numTestCases; i++) {
			String[] itemsShops = in.nextLine().split(" ");
			int items = Integer.parseInt(itemsShops[0]);
			int shops = Integer.parseInt(itemsShops[1]);
			
			for (int j = 0; j < items; j++) {
				int maxDiscount=0;
				int index=0;
				for (int k = 0; k < shops; k++) {
					
					String[] discounts = in.nextLine().split(" ");
					int discount=0;
					for (int l = 0; l < discounts.length; l++) {
						discount+=Integer.parseInt(discounts[l]);
						
					}
					if(discount>maxDiscount){
						maxDiscount=discount;
						index=k;
					}
					
				}
				System.out.print(index+1+" ");
				index=0;
			}
			System.out.println();
			
		}
	}

}
