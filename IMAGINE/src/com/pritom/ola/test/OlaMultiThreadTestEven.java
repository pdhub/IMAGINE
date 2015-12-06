package com.pritom.ola.test;

public class OlaMultiThreadTestEven implements Runnable{

	private OlaSharedLock sharedObj;
		
	public OlaMultiThreadTestEven(OlaSharedLock sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		for (int i = 1; i < 5; i = i + 2) {

			try {

				synchronized (sharedObj) {
					while (!(sharedObj.getWhich() == 1))
						sharedObj.wait();
					System.out.println(i);
					sharedObj.setWhich(-1);
					System.out.println("Sending notify all..from even");
					sharedObj.notifyAll();
				}
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
		
	}
	
	
}
