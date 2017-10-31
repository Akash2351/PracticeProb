/**
 * Created by Chiru on Jan 14, 2017
 */
package linkedList;

import cci.MyStack;

//Use running pointer and stack to check if it is palindrome
public class ListPalindrome {

    public static void main(String[] args) {

        Node list = new Node(1);
        list.next = new Node(2);
        list.next.next = new Node(1);
        // list.next.next.next = new Node(10);

        System.out.println(isPalindrome(list));
    }

    public static boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        MyStack<Integer> stack = new MyStack<>();
        while (fast != null && fast.next != null) {
            stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }

        // If there are odd number of nodes
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            if (stack.pop() != slow.value)
                return false;
            slow = slow.next;
        }
        return true;
    }
}