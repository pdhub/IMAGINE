package hearth.Code.Monk.Disjoint.Set.Union;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CityAndFlood {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numdis = Integer.parseInt(in.nextLine());
		int arr[] = new int[numdis];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=i;
		}
		int numInv = Integer.parseInt(in.nextLine());
		for (int i = 0; i < numInv; i++) {
			String[] inv = in.nextLine().split(" ");
			int invader = Integer.valueOf(inv[0]);
			int invaded = Integer.valueOf(inv[1]);
			for (int j = 0; j < arr.length; j++) {
				if(arr[j]==invaded-1)
					arr[j]=invader-1;
			}
			
		}
		/*for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+":");
		}*/
		
		Set mySet = new HashSet();
		//System.out.println("mm");
		for (int i = 0; i < arr.length; i++) {
			mySet.add(arr[i]);
		}
		System.out.println(mySet.size());

	}

}
