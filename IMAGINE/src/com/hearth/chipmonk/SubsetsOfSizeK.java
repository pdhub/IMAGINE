package com.hearth.chipmonk;

public class SubsetsOfSizeK {

	public static void printSubSetOfSizeK(int array[], boolean used[], int startIndex, int currentSize, int k){
		
		if(currentSize == k){
			for (int i = 0; i < array.length; i++) {
				if(used[i])
					System.out.print(array[i]+" ");
			}
			System.out.println();
			return;
		}
		
		if(startIndex == array.length){
			return;
		}
		
		used[startIndex] = true;
		
		printSubSetOfSizeK(array, used, startIndex+1, currentSize+1, k);
		
		used[startIndex] = false;
		
		printSubSetOfSizeK(array, used, startIndex+1, currentSize, k);
	}

	public static void main(String[] args) {
		int array[] = {1,2,3,1};
		boolean used[] = new boolean[array.length];
		int k = 2;
		printSubSetOfSizeK(array, used, 0, 0, k);
	}
}
