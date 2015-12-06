package com.pritom.g4g;

public class CountFrequenciesOfElements {

	
	//This works if the max element in the array is less than the array lenght
	public static void main(String[] args) {
		int elements []  = {2, 3, 3, 2, 5};
		countFreq(elements);
	}

	private static void countFreq(int[] elements) {
		int i = 0;
		
		while(i<elements.length){
			if(elements[i]<=0){
				i++;
				continue;
			}
			
			//Find index of the element to process
			int index = elements[i]-1;
			
			if(elements[index]>0){
				//Element at i is not processed
				
				elements[i] = elements[index];
				elements[index]=-1;
			}else{
				elements[index]--;
				elements[i]=0;
				i++;
			}
		}
		
		for (int j = 0; j < elements.length; j++) {
			System.out.println((j+1)+" : "+Math.abs(elements[j]) );
		}
		
	}

}
