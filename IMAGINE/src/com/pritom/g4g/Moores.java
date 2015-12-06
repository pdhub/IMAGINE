package com.pritom.g4g;

public class Moores {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a[]={1, 3, 3, 1, 2};
		System.out.println(findCandidate(a, a.length));
	}
	static int findCandidate(int a[], int size)
	{
	    int maj_index = 0, count = 1;
	    int i;
	    for(i = 1; i < size; i++)
	    {
	    	System.out.println("Comparing a["+maj_index+"] with a["+i+"]");
	        if(a[maj_index] == a[i])
	            count++;
	        else
	            count--;
	        if(count == 0)
	        {
	            maj_index = i;
	            count = 1;
	        }
	    }
	    return a[maj_index];
	}

}
