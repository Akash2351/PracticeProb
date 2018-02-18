package akash;

/**
 * Created by akash on 17-02-2018.
 */
public class LinkedListCycle2 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //Given a linked list, return the node where the cycle begins.
    // If there is no cycle, return null.
// Note: Do not modify the linked list.
    public ListNode detectCycle(ListNode head) {

        if (head == null)
            return null;

        ListNode slow = head, fast = head;
        ListNode cycle = null;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                //cycle detected...
                cycle = head;
                //move head and slow one node at a time
                //when they are the same, its the entry of the cycle.
                while (cycle != slow) {
                    slow = slow.next;
                    cycle = cycle.next;
                }
                return cycle;
            }
        }
        return cycle;
    }
}
