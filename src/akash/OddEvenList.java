package akash;

/**
 * Created by akash on 15-11-2017.
 */
public class OddEvenList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //move the odd and even pointer by jumping one node.
        ListNode odd = head, even = head.next, evenHead = head.next;
        //even.next will be odd...odd should not be null,
        //coz even will be appended to odd in the end.
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
