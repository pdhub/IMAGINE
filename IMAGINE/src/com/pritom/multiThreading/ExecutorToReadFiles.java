package com.pritom.multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ExecutorToReadFiles {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		Callable<List<String>> callable = new Callable<List<String>>() {

			@Override
			public List<String> call() throws Exception {
				
				List<String> lines = new ArrayList<>();
				return lines;
			}
			
		};
		
		Future<List<String>> future = executor.submit(callable);
		
		try {
			List<String> lines = future.get(5, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException e) {
			
			e.printStackTrace();
		}
		
		executor.shutdown();
	}
}
