package com.hearth.chipmonk;

public class FirstIndexInSortedArray {

	public static int firstIndex(int start, int end, int num, int arr[]){
		if(end<start)
			return -1;
		if(arr[start]>num)
			return -1;
		if(arr[end]<num)
			return -1;
		
		if(arr[start]==num)
			return start;
		
		int mid = (start+end)/2;
		
		if(arr[mid]==num){
			int leftIndex = firstIndex(start, mid-1, num, arr);
			return (leftIndex==-1?mid:leftIndex);
		}else if(arr[mid]>num){
			return firstIndex(start, mid-1, num, arr);
		}else
			return firstIndex(mid+1, end, num, arr);
	}
}
