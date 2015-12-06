package hearth.CodeHack3A;

import java.util.Scanner;

public class EggsAndBuilding {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = Integer.parseInt(in.nextLine());
		for (int i = 0; i < num; i++) {
			String[] data = in.nextLine().split(" ");
			int res = eggDrop(Integer.valueOf(data[1]),Integer.valueOf(data[0]));
			System.out.println(res);
		}
		
	}

	public static int eggDrop(int n, int k) {
		// If there are no floors, then no trials needed. OR if there is
		// one floor, one trial needed.
		//System.out.println(" N : "+n+" K : "+k);
		if (k == 1 || k == 0)
			return k;

		// We need k trials for one egg and k floors
		if (n == 1)
			return k;

		int min = k;//, x, res;

		// Consider all droppings from 1st floor to kth floor and
		// return the minimum of these values plus 1.
		for (int x = 1; x <= k; x++) {
			int res = max(eggDrop(n - 1, x - 1), eggDrop(n, k - x));
			if (res <= min)
				min = res;
		}

		return min + 1;
	}

	private static int max(int eggDrop, int eggDrop2) {
		if (eggDrop >= eggDrop2)
			return eggDrop;
		else
			return eggDrop2;
	}
}
