/**
 * Created by Chiru on Jan 1, 2017
 */
package byteByByte;

import linkedList.Node;

//Finding a node that is n steps away from the last node
//Use two pointers to find it in a single pass of loop
public class NthToLastNode {

    public static void nthToLastNode(Node head, int n) {

        Node current = head;
        Node follower = head;

        int i = 0;
        while (current != null) {

            if (i > n) {
                follower = follower.next;
            }
            i++;
            current = current.next;
        }
        if (i < n)
            System.out.println("Size of list is small");
        else
            System.out.println("Node found: " + follower.value);
    }

    public static void main(String[] args) {

        Node list = new Node(10);
        Node temp = list;
        list.next = new Node(20);
        list = list.next;
        list.next = new Node(30);
        list = list.next;
        list.next = new Node(40);
        list = list.next;
        list.next = new Node(50);
        list = list.next;

        nthToLastNode(temp, 2);

        int dummy = printNthLast(temp, 2);

    }

    // Recursive method to print the Nth node from last node

    public static int printNthLast(Node head, int n) {

        if (head == null)
            return -1;

        int index = printNthLast(head.next, n) + 1;

        if (index == n)
            System.out.println(n + "th node from last is " + head.value);

        return index;
    }

}