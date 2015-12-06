package com.hearth.vlocity;



class ListNode {
 
    public int data;
    public ListNode next;
 
    ListNode(int data){
        this.data = data;
    }
}
public class NthFromLast {
	 
    //n - depicts the nth node required from last
    public static void printNthFromLast(ListNode nodeHead, int n){
        int count = 0; // to store number of node in list 
        ListNode temp = nodeHead;
 
        if(nodeHead == null){
            return;
        }
 
        while(temp != null){
            // incrementing counter
            count++; 
            // moving to next node in list
            temp = temp.next; 
        }
        //nth node from end CANNOT be greater than length of list
        if(n > count){
            System.out.println("Not Possible");
        }else{
            count = count - n +1;
            int i=1;
                while(i < count){
                    i++;
                    nodeHead = nodeHead.next;
                }
 
            //now the headNode is pointing to the nth node from end
            System.out.println("Requested Element is "+ nodeHead.data);
        } 
    }
 
    public static void main(String [] args){
 
        // Creating a Linked List of five nodes
        // HEAD-->1-->2-->3-->4-->5-->null
 
        // creating 5 independent nodes
        ListNode nodeOne = new ListNode(1);
        ListNode nodeTwo = new ListNode(2);
        ListNode nodeThree = new ListNode(3);
        ListNode nodeFour = new ListNode(4);
        ListNode nodeFive = new ListNode(5);
 
        //Head node pointing to first node of linked list
        ListNode nodeHead = nodeOne;
 
        // creating a dependency in nodes by linking node to one another
        nodeOne.next = nodeTwo;
        nodeTwo.next = nodeThree;
        nodeThree.next = nodeFour;
        nodeFour.next = nodeFive;
 
        //we need second element from last
        printNthFromLast(nodeHead,2);
     }

}
