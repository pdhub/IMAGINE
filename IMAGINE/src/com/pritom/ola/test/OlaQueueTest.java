package com.pritom.ola.test;

public class OlaQueueTest {

	public static void main(String[] args) throws InterruptedException {
		
		OlaQueue olaQueue = new OlaQueue();
		
		olaQueue.push(1);
		olaQueue.push(2);
		olaQueue.push(new Character('3'));
		
		System.out.println(olaQueue.peek());
		
		olaQueue.pop();
		
		OlaQueueThreadInteger intQueueThread = new OlaQueueThreadInteger(olaQueue);
		
		OlaQueueThreadString intQueueString = new OlaQueueThreadString(olaQueue);
		
		new Thread(intQueueThread).start();
		
		new Thread(intQueueString).start();
		
		Thread.sleep(6000);
		
		olaQueue.pop();
		olaQueue.pop();
		olaQueue.pop();
		
		olaQueue.listOlaQueueElements();
		

	}

}
