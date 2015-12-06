package com.pritom.ola.test;

public class OlaMultiThreadTestSpl implements Runnable{

	private OlaSharedLock sharedObj;
	private final char[] c = {'a','b'};
	
	public OlaMultiThreadTestSpl(OlaSharedLock sharedObj) {
		this.sharedObj = sharedObj;
		
	}

	@Override
	public void run() {
		for (int i = 0; i < c.length; i++) {

			try {
				
				synchronized (sharedObj) {
					while (!(sharedObj.getWhich()==-1))
						sharedObj.wait();
					System.out.println(c[i]);
					sharedObj.setWhich(0);
					System.out.println("Sending notify all..from spl");
					sharedObj.notifyAll();
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
