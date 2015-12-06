package com.hearth.intalio;

public class MyThread extends Thread {

	public String text;
	
	@Override
	public void run() {
		System.out.println(text);
	}
}
