package com.pritom.accolite;


public class AccoLiteLinkedList {

	public static void main(String[] args) {
		
		Node h1 = new Node(1);
		h1.next = new Node(2);
		h1.next.next = new Node(3);
		

		Node h2 = new Node(11);
		h2.next = new Node(12);
		h2.next.next = new Node(13);
		

		Node h3 = new Node(21);
		h3.next = new Node(22);
		h3.next.next = new Node(23);
		
		System.out.println("Original List");
		printLists(h1, h2, h3);
		System.out.println();
		
		Node h11=h1.next,h22=h2.next,h33=h3.next;
		
		System.out.println("New Lists are : ");
		
		while(h1!=null){
					
			Node newNodeCreated = convertVerticalList(h1, h2, h3,h11,h22,h33);
			printList(newNodeCreated);
			h1=h11;
			h2=h22;
			h3=h33;
			
			h11=h11!=null?h11.next:null;
			h22=h22!=null?h22.next:null;
			h33=h33!=null?h33.next:null;
								
		}
		
		//printLists(h1, h2, h3);

	}

	

	private static Node convertVerticalList(Node h1, Node h2, Node h3,Node h11, Node h22, Node h33) {
		
					
		h1.next = h2;
		h2.next=h3;
		h3.next=null;
				
		return h1;
				
		
	}
	
	private static void printList(Node h1) {
		Node temp = h1;
		while(temp!=null){
			System.out.print(temp.data);
			temp=temp.next;
			if(temp!=null)
				System.out.print("->");
		}
		System.out.println();
		
	}

	private static void printLists(Node h1, Node h2, Node h3) {
		while(h1!=null){
			System.out.print(h1.data);
			if(h1.next!=null)
				System.out.print("->");
			h1=h1.next;
		}
		System.out.println();
		
		while(h2!=null){
			System.out.print(h2.data);
			if(h2.next!=null)
				System.out.print("->");
			h2=h2.next;
		}
		System.out.println();
		
		while(h3!=null){
			System.out.print(h3.data);
			if(h3.next!=null)
				System.out.print("->");
			h3=h3.next;
		}
		
	}

}

class Node {
	
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
	}
}