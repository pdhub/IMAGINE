package com.hearth.chipmonk;

public class FindOccuranceInSortedArray {

	public static int findOccurance(int arr[], int startIndex, int endIndex, int k){
		if(endIndex < startIndex)
			return 0;
		
		if(arr[startIndex] > k)
			return 0;
		if(arr[endIndex] < k)
			return 0;
		
		if(arr[startIndex]==k && arr[endIndex]==k)
			return endIndex-startIndex+1;
		
		int mid = (startIndex+endIndex)/2;
		
		if(arr[mid]==k)
			return 1+findOccurance(arr, startIndex, mid-1, k)+findOccurance(arr, mid+1, endIndex, k);
		
		else if(arr[mid]<k)
			return findOccurance(arr, startIndex, mid-1, k);
		else
			return findOccurance(arr, mid+1, endIndex, k);
	}
}
