package com.pritom.ola.test;

import java.util.concurrent.Semaphore;


public class OlaQueue {
	
	Node head = null;
	
	Semaphore semaphore = new Semaphore(1);
	
	public void push(Object o){
		
		if(!typeCheckSuccesful(o)){
			
			System.out.println("Eww !! you are trying to feed me something I cant eat !! ");
			return;
		}
		
		try {
			semaphore.acquire();
			olaQueuePush(o);
			semaphore.release();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
	}
	
	private boolean typeCheckSuccesful(Object o) {
		boolean retval  = false;
		
		if(o instanceof Integer || o instanceof Long || o instanceof Double || o instanceof String)
			retval = true;
		
		return retval;
	}

	public void olaQueuePush(Object o){
		if(head==null){
			head = new Node(o);
		}else{
			
			Node temp = head;
			while(temp.next != null){
				temp = temp.next;
			}
			temp.next = new Node(o);
		}
	}
	
	public Object pop(){
		
		try {
			semaphore.acquire();
			Object poppedObj =  olaQueuePop();
			System.out.println(poppedObj+" got Popped :-( ");
			return poppedObj;
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}finally{
			semaphore.release();
		}
		System.out.println("Could not perform pop :-( ");
		return null;
		
	}
	
	public Object olaQueuePop(){
		if(head==null)
			return head;
		
		Node poppedData = head;
		head = head.next;
		return poppedData.data;
	}
	
	public Object peek(){
		if(head==null)
			return head;
		return head.data;
	}
	
	public void listOlaQueueElements(){
		System.out.println("Queue elements are ..");
		Node temp = head;
		while(temp!=null){
			System.out.print(temp.data);
			System.out.print("->");
			temp= temp.next;
		}
		System.out.println("null");
	}
	
}

class Node{
	Object data;
	Node next;
	
	Node(Object data){
		this.data = data;
		this.next= null;
	}
}
