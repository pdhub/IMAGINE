package com.pritom.multiThreading;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

	final static int N = 3;
	public static void main(String[] args) throws InterruptedException {
		
		CountDownLatch startSignal = new CountDownLatch(1);
		CountDownLatch doneSignal = new CountDownLatch(N); // Iniitialized to the number of threads
		
		for (int i = 0; i < N; i++) {
			new Thread(new Worker(startSignal,doneSignal)).start();
		}
		
		startSignal.countDown();//All the threads initiated in the for loop will wait till this line
		
		doneSignal.await();//Waiting for all threads to finish
	}

}

class Worker implements Runnable{

	private final static int N= 5;
	private final CountDownLatch startSignal;
	private final CountDownLatch doneSignal;
	
	Worker(CountDownLatch startSignal, CountDownLatch doneSignal){
		this.startSignal = startSignal;
		this.doneSignal = doneSignal;
	}
	
	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		try {
			startSignal.await();
			
			System.out.println("Worker Completing..");
			
			doneSignal.countDown();
			
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
}