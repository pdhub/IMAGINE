package hearth.pipemonk;

import java.util.Scanner;

public class TheChocolateGame {

	public int calculate(int a[]) {

		int numChocolates = 0;
		int maxChocolates = 0;
		int maxValue = a[0];
		int pos = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] > maxValue) {
				maxValue = a[i];
				pos = i;
			}

			/*
			 * if(maxChocolates<numChocolates){ maxChocolates = numChocolates;
			 * numChocolates=0; maxValue = a[i];
			 * 
			 * }
			 */
		}
		// System.out.println(pos);
		return a.length - (pos + 1);
	}

	public static void main(String[] args) {

		int x = -1; System.out.println(x>>>29); System.out.println(x>>>30); System.out.println(x>>>31);
	}

	Scanner in = new Scanner(System.in);
	int numChoco = Integer.valueOf(in.nextLine());
	int nums[] = new int[numChoco];
	/*
	 * for (int i = 0; i < nums.length; i++) { nums[i] = in.nextInt(); }
	 */
	// in.nextLine();
	// System.out.println(new TheChocolateGame().calculate(nums));

}
