/**
		 * 
		 * Synchronizers are high level constructs that co-ordinate and control thread execution
		 * 
		 * Types of synchronizers are Semaphores, CyclicBarriers, CountDownLatch, Exchangers and Phasers
		 * 
		 * We will discuss only the First three
		 * 
		 * */
		
		/**
		 * Semaphore  : Maintains a set of permits, maintained by acquire() and release()
**/

package com.pritom.multiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

final class Pool{
	public static final int MAX_AVAILABLE = 10;
	private Semaphore available = new Semaphore(MAX_AVAILABLE, true);
	private String items[];
	private boolean[] used = new boolean[MAX_AVAILABLE];
	
	Pool(){
		items = new String[MAX_AVAILABLE];
		for (int i = 0; i < MAX_AVAILABLE; i++) {
			items[i] = "ITEM: "+i;
		}
	}
	
	String getItem() throws InterruptedException{
		available.acquire();
		return getNextAvailableItem();
	}
	
	void putItem(String item){
		if(markAsUnused(item)){
			available.release();
		}
	}
	
	private synchronized String getNextAvailableItem(){
		for (int i = 0; i < MAX_AVAILABLE; i++) {
			if(!used[i]){
				used[i] = true;
				return items[i];
			}
		}
		return null;
	}
	
	private synchronized boolean markAsUnused(String item){
		for (int i = 0; i < MAX_AVAILABLE; i++) {
			if(item==items[i]){
				used[i]= false;
				return true;
			}
		}
		return false;
	}
}

public class SemaphoreExample {

	
	public static void main(String[] args) {
	
		final Pool pool = new Pool();
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				String name = Thread.currentThread().getName();
				try {
					while(true){
						String item;
						item = pool.getItem();
						System.out.println("Accuired item : "+item);
						Thread.sleep((long) (Math.random()*100));
						pool.putItem(item);
						System.out.println("Released item : "+item);
					}
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
				
			}
		};
		
		ExecutorService executors[] = new ExecutorService[Pool.MAX_AVAILABLE+1];
		for (int i = 0; i < executors.length; i++) {
			executors[i] = Executors.newSingleThreadExecutor();
			executors[i].execute(r);
		}

	}

	
}
