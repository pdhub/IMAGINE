package com.hearth.challenge.Xseed;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class TheCompetitiveClass {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numStudents = Integer.valueOf(in.nextLine());
		String[] marks = in.nextLine().split(" ");
				
		int marksPos[] = new int[1001];
		for (int i = 0; i < marksPos.length; i++) {
			marksPos[i]=0;
		}
		
		for (int i = 0; i < marks.length; i++) {
			int pos = Integer.valueOf(marks[i]);
			marksPos[pos]++;
		}
		
		int count = 0;
		for (int i = 0; i < marks.length; i++) {
			for (int j =  marksPos.length-1; j >0; j--) {
				if(Integer.valueOf(marks[i])==j){
					System.out.print(count+1);
					System.out.print(" ");
					count=0;
					break;
				}else{
					count+=marksPos[j];
				}
			}
		}

	}

}
