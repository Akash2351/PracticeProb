package akash;

/**
 * Created by akash on 23-02-2018.
 */
public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode h1 = new ListNode(0);
        ListNode l12 = new ListNode(1);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(5);
        h1.next = l12;
        l12.next = l13;
        l13.next = l14;

        ListNode h2 = new ListNode(2);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(6);
        ListNode l24 = new ListNode(10);
        h2.next = l22;
        l22.next = l23;
        l23.next = l24;

        ListNode h3 = new ListNode(8);
        ListNode l32 = new ListNode(9);
        ListNode l33 = new ListNode(11);
        ListNode l34 = new ListNode(15);
        h3.next = l32;
        l32.next = l33;
        l33.next = l34;

        lists[0] = h1;
        lists[1] = h2;
        lists[2] = h3;

        printNodes(mergeKLists(lists));
    }

    //Merge k sorted linked lists and return it as one sorted list.
// Analyze and describe its complexity.
//I think the complexity is k * n * logk. Because the recursion depth is logK,
// and in each level, every element will be compared. n -no of elements in each list
    public static void printNodes(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return mergeSort(lists, 0, lists.length - 1);
    }

    public static ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int mid = (start + end) / 2;
            ListNode l1 = mergeSort(lists, start, mid);
            ListNode l2 = mergeSort(lists, mid + 1, end);
            return merge(l1, l2);
        }
        return null;
    }

    public static ListNode merge(ListNode l1, ListNode l2) {
        ListNode mergedList = new ListNode(0);
        ListNode temp = mergedList;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                temp.next = l2;
                l2 = l2.next;
            } else {
                temp.next = l1;
                l1 = l1.next;
            }
            temp = temp.next;
        }

        if (l1 == null) {
            temp.next = l2;
        } else {
            temp.next = l1;
        }
        return mergedList.next;
    }
}
