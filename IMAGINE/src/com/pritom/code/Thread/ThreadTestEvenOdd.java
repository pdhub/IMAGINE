package com.pritom.code.Thread;

import java.util.concurrent.Semaphore;

public class ThreadTestEvenOdd {

	public static Object obj = new Object();
	static Semaphore sem = new Semaphore(1);
	
	
	public static void main(String[] args) {
		ThreadLocal threadLocal = new ThreadLocal<>();
		
		new Thread(new ThreadA(obj,sem)).start();
		new Thread(new ThreadB(obj,sem)).start();
	}

}

class ThreadA implements Runnable {
	Object obj1;
	Semaphore sem;

	ThreadA(Object obj, Semaphore sem) {
		this.obj1 = obj; this.sem = sem;
	}

	public void run() {

		for (int i = 100; i >= 91; i--) {
			/*synchronized (obj1) {
				
				try {
					//obj1.wait();
					System.out.println("Thread 1 :" + i);
					obj1.notify();
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}*/
			try {
				sem.acquire();
				System.out.println("Thread 1 :" + i);
				
				sem.release();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}

class ThreadB implements Runnable {
	Object obj2;
	Semaphore sem;

	ThreadB(Object obj, Semaphore sem) {
		this.obj2 = obj; this.sem = sem;
	}

	public void run() {

		for (int i = 1; i <= 10; i++) {
			/*synchronized (obj2) {
				
				try {
					obj2.wait();
					System.out.println("Thread 2 :" + i);
					obj2.notify();
					
				} catch (Exception e) {
					e.printStackTrace();
				}

			}*/
			try {
				sem.acquire();
				System.out.println("Thread 2 :" + i);
				sem.release();
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		//obj2.notifyAll();

	}

}
