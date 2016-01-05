package com.pritom.multiThreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExample {
	
		
	/**
	 * Executor just executes stuff you give it, ExecutorService adds startup, 
	 * shutdown, and the ability to wait for and look at the status of jobs you've 
	 * submitted for execution on top of executor (which it extends).
	 * */
	
	static Executor pool = Executors.newFixedThreadPool(5);
	
	/**Fixed thread pool creates unbounded queue*/
	
	public static void main(String[] args) {
		
		
		try {
			ServerSocket socket = new ServerSocket(9000);
			
			while(true){
				final Socket s = socket.accept();
				Runnable r = new Runnable() {
					
					@Override
					public void run() {
						doWork(s);
						
					}
				};
				
				new Thread(r).start(); /**This will create a new thread for each request*/
				
				/* We can use the executor Framework in this case as*/
				
				//Create a pool of Executor as in the above and then do
				pool.execute(r);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	static void doWork(Socket s){
		
	}

}
