package hearth.Target.hiring.Challenge15;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class MaruAndQueries {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int size = Integer.parseInt(in.nextLine());
		int arr[] = new int[size];
		
		for (int i = 0; i < arr.length; i++) {
			String ele = in.next();
			arr[i]=Integer.parseInt(ele);
		}
		//Arrays.sort(arr);
		in.nextLine();
		int queries = Integer.parseInt(in.nextLine());
		for (int i = 0; i <queries; i++) {
			String[] inpt = in.nextLine().split(" ");
			findMax(Integer.parseInt(inpt[0]),Integer.parseInt(inpt[1]),arr);
			findMaxWithBubble(Integer.parseInt(inpt[0]),Integer.parseInt(inpt[1]),arr);
		}
	
		

	}

	private static void findMaxWithBubble(int parseInt, int parseInt2, int[] arr) {
		
		int[] tempArr = arr;
		for (int i = 0; i < parseInt; i++) {
			for (int j = i; j < arr.length; j++) {
				if(tempArr[i]>tempArr[j]){
					int temp = arr[i];
					tempArr[i] = tempArr[j];
					tempArr[j] = temp;
				}
			}
		}
		
		int pos1 = tempArr[parseInt-1];
		
		tempArr = arr;
		for (int i = 0; i < parseInt2; i++) {
			for (int j = i; j < arr.length; j++) {
				if(tempArr[i]>tempArr[j]){
					int temp = arr[i];
					tempArr[i] = tempArr[j];
					tempArr[j] = temp;
				}
			}
		}
		
		int pos2 = tempArr[parseInt2-1];
		System.out.println(pos2 +" : "+pos1);
		System.out.println(pos2-1-pos1);
		
	}

	private static void findMaxWithMap(Integer parseInt, Integer parseInt2,
			Map<Integer, Integer> map) {
		Set<Integer> s = map.keySet();
		Iterator<Integer> itr = s.iterator();
		int count=1;
		Integer a=null;
		while(parseInt2!=count ){
			a =map.get(itr.next());
			count++;
		}
		
		count =1;
		Integer b=null;
		while(parseInt!=count){
			b = map.get(itr.next());
			count++;
		}
		
		System.out.println("A : "+a+" B "+b);
		System.out.println(b-a);
		
	}

	private static void findMax(int i, int j, int[] arr) {
		/*for (int k = 0; k < arr.length; k++) {
			System.out.print(arr[k]+" ");
		}
		System.out.println();*/
		System.out.println("Arr  : "+i+"th is "+arr[i-1]);
		System.out.println("Arr  : "+j+"th is "+arr[j-1]);
		
		int count = 0;
		for (int k = j-1; arr[k] != arr[i-1]; k--) {
			count++;
		}
		System.out.println(count);
	}

}
