package hearth.MagnaSoft;

import java.util.Scanner;

public class Naviandhisfriend {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		int totalDays = Integer.parseInt(in.nextLine());
		
		for (int i = 0; i < totalDays; i++) {
			int numItems = Integer.parseInt(in.nextLine());;
			int price[] = new int[numItems];
			int weight[] = new int[numItems];
			
			for (int j = 0; j < numItems; j++) {
				String[] inputs = in.nextLine().split(" ");
				price[j]=Integer.valueOf(inputs[0]);
				weight[j]=Integer.valueOf(inputs[1]);	
			}
			String[] maxWgtAndCount = in.nextLine().split(" ");
			int maxWeight = Integer.valueOf(maxWgtAndCount[0]);
			int maxCount= Integer.valueOf(maxWgtAndCount[1]);
			System.out.println("For Day #"+(i+1)+":");
			System.out.println(totalCount(price, weight, maxWeight, maxCount));
			System.out.println();
		}

	}
	public static int totalCount(int price[], int weight[], int maxWeight, int maxCount){
		int res = 0;
		int len = price.length;
		
		int totalWeight [] = new int[len];
		int totalCount[] = new int[len];
		int totalPrice[] = new int[len];
		
			
		for (int i = 0; i < len; i++) {
			
			for (int j = 0; j < i; j++) {
				if((weight[i]+totalWeight[j] <= maxWeight) &&(totalCount[j])&& (totalCount[i]+1<=maxCount)){
					totalWeight[i]=totalWeight[j]+weight[i];
					totalPrice[i]=totalPrice[j]+price[j];
					totalCount[i]=totalCount[j]+1;
				}
			}
		}
		
		int resPrice = 0;
		for (int i = 0; i < totalCount.length; i++) {
			if(res<=totalCount[i]){
				res = totalCount[i];
				resPrice = totalPrice[i];
			}
		}
		
		return resPrice;
	}

}
