package akash;

/**
 * Created by akash on 07-11-2017.
 */
public class LinkedListMergeSort {

    //sort a linked list in o(nlogn) with constant space
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        //split the list in 2 halves...fast moves twice the speed.
        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // break first list at prev..second list starts from slow.
        prev.next = null;

        //sort the lists recursively
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);

        return merge(l1, l2);
    }

    ListNode merge(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), p = head;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 == null)
            p.next = l2;
        if (l2 == null)
            p.next = l1;

        return head.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
