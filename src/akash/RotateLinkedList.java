package akash;

/**
 * Created by akash on 18-02-2018.
 */


public class RotateLinkedList {


    /*Given a list, rotate the list to the right by k places, where k is non-negative.
    Example:
    Given 1->2->3->4->5->NULL and k = 2,
    return 4->5->1->2->3->NULL.*/
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) return head;
        //if there is only 1 node, any k will return same list...
        if (k == 0 || head.next == null) return head;

        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode first = temp, second = temp;

        //calculate the len of list...coz k might be greater than len..use %
        ListNode dummy = head;
        int len = 0;
        while (dummy != null) {
            dummy = dummy.next;
            len++;
        }

        k = k % len;
        if (k == 0)
            return head;

        //move first pointer k nodes from head...
        //later move first and second till first reached end...
        //now break n join ends....
        while (k > 0) {
            first = first.next;
            k--;
        }

        //if first reaches end, full list is rotated..so return head.
        if (first.next == null)
            return head;

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        //eg [1,2,3,4,5] , k=2 : first-5, second-3.
        // start list from 4..i.e second.next...break list s.next = null.
        ListNode newHead = second.next;
        second.next = null;
        first.next = head;
        return newHead;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
