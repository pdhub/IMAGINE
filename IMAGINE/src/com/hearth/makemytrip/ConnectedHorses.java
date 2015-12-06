package com.hearth.makemytrip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectedHorses {

	
	public boolean canSwap(Horse h1, Horse h2){
		boolean retVal = false;
		
		if(Math.abs(h1.x - h2.x)==2 && Math.abs(h1.y-h2.y)==1){
			retVal = true;
		}
		
		return retVal;
	}
	public static void main(String[] args) {
		
		
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.valueOf(in.nextLine());
		for (int i = 0; i < testCases; i++) {
			String s[] = in.nextLine().split(" ");
			
			int numhorses = Integer.valueOf(s[2]);
			
			Horse horses[] = new Horse[numhorses+1];
			for (int j = 1; j <= numhorses; j++) {
				
				String coOrd[] = in.nextLine().split(" ");
				horses[j] = new Horse(j,Integer.valueOf(coOrd[0]), Integer.valueOf(coOrd[1]));
				
			}
			
			new ConnectedHorses().checkArrangeMent(horses);
		}
		
		
		
		
	}
	private void checkArrangeMent(Horse[] horses) {
		int arrangement = 1;
		List list = new ArrayList();
		for (int i = 1; i <= horses.length-1; i++) {
			for (int j = 1; j <= horses.length-1; j++) {
				if(horses[i].equals(horses[j])){
					continue;
				}else{
					if(canSwap(horses[i],(horses[j]))){
						checkSwapPair(list,horses[i],(horses[j]));
					}
				}
			}
		}
		System.out.println(list.size());
		
		
	}
	private void checkSwapPair(List list, Horse horse, Horse horse2) {
		if(!list.contains(horse.id+""+horse2.id) && !list.contains(horse2.id+""+horse2.id)){
			list.add(horse.id+""+horse2.id);
		}
		
	}
}
class Horse{
	int id;
	int x;
	int y;
	Horse(int id,int x, int y){
		this.id = id;
		this.x= x;
		this.y=y;
	}
	
	@Override
	public boolean equals(Object obj) {
		Horse temp = (Horse) obj;
		return (this.x==temp.x && this.y==temp.y);
	}
}
