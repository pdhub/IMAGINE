package com.pritom.ola.test;

public class OlaQueueThreadInteger implements Runnable {

	private OlaQueue olaQueue;
	
	public OlaQueueThreadInteger(){
		
	}
	
	public OlaQueueThreadInteger(OlaQueue olaQueue){
		this.olaQueue= olaQueue;
	}
	
	@Override
	public void run() {
		System.out.println("So lets add 3 Integers into the queue");
		
		for (int i = 0; i < 30; i++) {
			System.out.println("Pushing Integer : "+i);
			olaQueue.push(i);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
