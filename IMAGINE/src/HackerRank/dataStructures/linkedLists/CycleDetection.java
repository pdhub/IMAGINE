package HackerRank.dataStructures.linkedLists;

/**
 * Created by PDeb on 10/15/2017.
 */
public class CycleDetection {
    /*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as:
*/
    class Node {
        int data;
        Node next;
    }


    boolean hasCycle(Node head) {
        if(head==null || head.next==null)
            return false;

        Node fast = head;
        Node slow = head;
        fast = fast.next!=null?fast.next.next:fast.next;

        while(fast!=null && fast.next!=null)
        {
            if(fast==slow)
                return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}
