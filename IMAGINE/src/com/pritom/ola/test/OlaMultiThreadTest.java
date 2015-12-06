package com.pritom.ola.test;

public class OlaMultiThreadTest {

	private static OlaSharedLock sharedObj = new OlaSharedLock(0);
		
	public static void main(String[] args) {
		
		OlaMultiThreadTestOdd odd = new OlaMultiThreadTestOdd(sharedObj);
		
		OlaMultiThreadTestEven even = new OlaMultiThreadTestEven(sharedObj);
		
		OlaMultiThreadTestSpl spl = new OlaMultiThreadTestSpl(sharedObj);
		
		new Thread(odd).start();
		new Thread(even).start();
		new Thread(spl).start();
		
		
	}
}
