package com.pritom.multiThreading;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		BlockingDeque queue = (BlockingDeque) new LinkedBlockingQueue<>();
		queue.put(new Object());
		queue.take();
	}
}
