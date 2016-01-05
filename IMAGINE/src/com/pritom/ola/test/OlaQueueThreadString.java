package com.pritom.ola.test;

public class OlaQueueThreadString implements Runnable {

	private OlaQueue olaQueue;
	
	public OlaQueueThreadString(){
		
	}
	
	public OlaQueueThreadString(OlaQueue olaQueue){
		this.olaQueue= olaQueue;
	}
	
	@Override
	public void run() {
		System.out.println("So lets add 3 Strings into the queue");
		
		for (int i = 0; i < 3; i++) {
			
			System.out.println("Pushing String : "+i);
			olaQueue.push(new String(":"+i+":"));
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
