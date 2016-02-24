package com.hearth.chipmonk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;

public class FunnyOperations {

	public static void main(String[] args) {

		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		
		l1.add(new Integer(1));
		l1.add(new Integer(2));
		
		l2.add(new Integer(1));
		l2.add(new Integer(2));
		
		Set<List<Integer>> set = new HashSet<List<Integer>>();
		set.add(l1);set.add(l2);
		System.out.println(set.size());
		
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int numEle = in.nextInt();
			List<Integer> list = new ArrayList<Integer>();
			for (int j = 0; j < numEle; j++) {
				list.add(in.nextInt());
			}
			
			List<List<Integer>> allSubList = powerSet(list);
			
			int pVal = 0, maxLen = 0;
			for(List<Integer> listSub: allSubList){
				printThisSubset(listSub);
				int tempVal = XORVal(listSub) | ANDVAL(listSub);
				if(tempVal > pVal){
					pVal = tempVal;
					maxLen = listSub.size();
				}
			}
			System.out.println(pVal+" "+maxLen);
		}
	}
	
	private static void printThisSubset(List<Integer> listSub) {
		System.out.print("Printing subset start : ");
		for (int i = 0; i < listSub.size(); i++) {
			System.out.print(listSub.get(i)+" ");
		}
		System.out.println();
		
	}

	private static int XORVal(List<Integer> listSub) {
		if(listSub.size()<1)
			return 0;
		int retVal = listSub.get(0);
		for (int i = 1; i < listSub.size(); i++) {
			retVal^=listSub.get(i);
		}
		return retVal;
	}
	
	private static int ANDVAL(List<Integer> listSub) {
		if(listSub.size()<1)
			return 0;
		int retVal = listSub.get(0);
		for (int i = 1; i < listSub.size(); i++) {
			retVal&=listSub.get(i);
		}
		return retVal;
	}

	public static List<List<Integer>> powerSet(List<Integer> originalSet) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new ArrayList<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        List<Integer> rest = new ArrayList<Integer>(list.subList(1, list.size()));
        for (List<Integer> set : powerSet(rest)) {
        	List<Integer> newSet = new ArrayList<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }

}
