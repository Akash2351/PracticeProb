/**
 * Created by Chiru on Jan 8, 2017
 */
package linkedList;

public class FindLoopInList {

    public static void main(String[] args) {

        Node list = new Node(10);
        Node temp = list;

        //List with loop
        list.next = new Node(20);
        list = list.next;
        list.next = new Node(30);
        list = list.next;
        list.next = new Node(40);
        list = list.next;
        list.next = new Node(50);
        list = list.next;
        // creating loop
        list.next = temp.next.next;

        if (hasLoop(temp))
            System.out.println("List has loop!");
        else
            System.out.println("List has no loop!");

        //List without loop
        Node list2 = new Node(10);
        Node temp2 = list2;

        list2.next = new Node(20);
        list2 = list2.next;
        list2.next = new Node(30);
        list2 = list2.next;
        list2.next = new Node(40);
        list2 = list2.next;
        list2.next = new Node(50);
        list2 = list2.next;

        if (hasLoop(temp2))
            System.out.println("List has loop!");
        else
            System.out.println("List has no loop!");
    }

    public static boolean hasLoop(Node head) {

        if (head == null || head.next == null) {
            return false;
        }
        Node slowPtr = head;
        Node fastPtr = head;
        // move slow pointer one node at a time
        // move fast pointer two nodes at a time
        while (slowPtr != null && fastPtr != null) {

            slowPtr = slowPtr.next;
            // Make sure that search doesn't hit null pointer exception if there
            // is no loop
            if (fastPtr.next != null)
                fastPtr = fastPtr.next.next;
            else
                fastPtr = fastPtr.next;

            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }
}