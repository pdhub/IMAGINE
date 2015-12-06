package com.pritom.multiThreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierExample {

	public static void main(String[] args) {
		Runnable action = new Runnable() {
			
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				System.out.println(" Running : "+name);
				
			}
		};
		
		final CyclicBarrier barrier = new CyclicBarrier(3, action);
		
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				try {
					barrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		};
		
		ExecutorService[] executors = new ExecutorService[]{
				Executors.newSingleThreadExecutor(),Executors.newSingleThreadExecutor(),Executors.newSingleThreadExecutor()
		};
		
		for (ExecutorService executorService : executors) {
			executorService.execute(task);
		}
	}

}
