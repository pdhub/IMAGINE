package com.hearth.chipmonk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.List;

class TestClass {
    public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for (int i = 0; i < testCases; i++) {
			int numEle = in.nextInt();
			Set<Integer> list = new HashSet<Integer>();
			for (int j = 0; j < numEle; j++) {
				list.add(in.nextInt());
			}
			
			Set<Set<Integer>> allSubList = powerSet(list);
			
			int pVal = 0, maxLen = 0;
			for(Set<Integer> listSub: allSubList){
				int tempVal = XORVal(listSub) | ANDVAL(listSub);
				if(tempVal > pVal){
					pVal = tempVal;
					maxLen = listSub.size();
				}
			}
			System.out.println(pVal+" "+maxLen);
		}
	}
	
	private static int XORVal(Set<Integer> listSub) {
		if(listSub.size()<1)
			return 0;
		Iterator<Integer> itr = listSub.iterator();
		int retVal = itr.next();
		while(itr.hasNext()){
			retVal^= itr.next();
		}
		return retVal;
	}
	
	private static int ANDVAL(Set<Integer> listSub) {
		if(listSub.size()<1)
			return 0;
		Iterator<Integer> itr = listSub.iterator();
		int retVal = itr.next();
		while(itr.hasNext()){
			retVal&= itr.next();
		}
		return retVal;
	}

	public static Set<Set<Integer>> powerSet(Set<Integer> originalSet) {
        Set<Set<Integer>> sets = new HashSet<Set<Integer>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Integer>());
            return sets;
        }
        List<Integer> list = new ArrayList<Integer>(originalSet);
        Integer head = list.get(0);
        Set<Integer> rest = new HashSet<Integer>(list.subList(1, list.size()));
        for (Set<Integer> set : powerSet(rest)) {
            Set<Integer> newSet = new HashSet<Integer>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
	
}

	
	


