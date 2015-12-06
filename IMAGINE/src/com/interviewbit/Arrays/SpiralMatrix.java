package com.interviewbit.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		
		//args = NULL;
		int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		List a = Arrays.asList(arr[0]);
		List b = Arrays.asList(arr[1]);
		List c = Arrays.asList(arr[2]);

		List<List<Integer>> finalList = new ArrayList();
		finalList.add(a);
		finalList.add(b);
		finalList.add(c);

		printSpiral(finalList);

		int top = 0, left = 0;
		int bottom = arr.length - 1, right = arr.length - 1;

		int dir = 0;
		while (top < bottom || left < right) {
			switch (dir) {
			case 0:
				for (int i = top; i <= right; i++) {
					System.out.println(arr[top][i] + ":" + dir);
				}
				top++;
				break;

			case 1:
				for (int i = top; i <= bottom; i++) {
					System.out.println(arr[i][bottom] + ":" + dir);
				}
				right--;
				break;

			case 2:
				for (int i = right; i >= left; i--) {
					System.out.println(arr[bottom][i] + ":" + dir);
				}
				bottom--;
				break;

			case 3:
				for (int i = bottom; i >= top; i--) {
					System.out.println(arr[bottom][i] + ":" + dir);
				}
				left++;
				break;

			}

			dir = (dir + 1) % 4;
			// System.out.println("B:"+bottom+":T:"+top+"L:"+left+":R:"+right+":D:"+dir);

		}
	}

	private static void printSpiral(List<List<Integer>> finalList) {
		int top = 0, left = 0;
		int bottom = finalList.size() - 1, right = finalList.size() - 1;
		System.out.println("flist : "+finalList.get(top).get(top));
		int dir = 0;
		while (top < bottom || left < right) {
			switch (dir) {
			case 0:
				for (int i = top; i <= right; i++) {
					System.out.println(finalList.get(top).get(i) + ":" + dir);
				}
				top++;
				break;

			case 1:
				for (int i = top; i <= bottom; i++) {
					System.out
							.println(finalList.get(i).get(bottom) + ":" + dir);
				}
				right--;
				break;

			case 2:
				for (int i = right; i >= left; i--) {
					System.out
							.println(finalList.get(bottom).get(i) + ":" + dir);
				}
				bottom--;
				break;

			case 3:
				for (int i = bottom; i >= top; i--) {
					System.out
							.println(finalList.get(bottom).get(i) + ":" + dir);
				}
				left++;
				break;

			}

			dir = (dir + 1) % 4;
			// System.out.println("B:"+bottom+":T:"+top+"L:"+left+":R:"+right+":D:"+dir);

		}

	}

}
