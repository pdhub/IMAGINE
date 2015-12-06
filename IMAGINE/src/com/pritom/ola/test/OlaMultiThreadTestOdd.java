package com.pritom.ola.test;

public class OlaMultiThreadTestOdd implements Runnable {

	private OlaSharedLock sharedObj;
	
	public OlaMultiThreadTestOdd(OlaSharedLock sharedObj) {
		this.sharedObj = sharedObj;
	}

	@Override
	public void run() {
		for (int i = 2; i < 5; i = i + 2) {

			try {

				synchronized (sharedObj) {
					while (!(sharedObj.getWhich()==0))
						sharedObj.wait();
					System.out.println(i);
					sharedObj.setWhich(1);
					System.out.println("Sending notify all..from odd");
					sharedObj.notifyAll();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
