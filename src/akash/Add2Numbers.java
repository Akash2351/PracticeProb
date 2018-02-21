package akash;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.reverse;

/**
 * Created by akash on 21-02-2018.
 */
public class Add2Numbers {

/* You are given two non-empty linked lists representing two non-negative
 integers. The most significant digit comes first and each of their nodes
  contain a single digit. Add the two numbers and return it as a linked list.
  You may assume the two numbers do not contain any leading zero,
  except the number 0 itself.
  Follow up:
  What if you cannot modify the input lists? In other words, reversing the
  lists is not allowed.
  Example:
  Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
  Output: 7 -> 8 -> 0 -> 7 */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        //idea is to store the values in list, traverse from end,
        //add to new list...reverse the final list, make linked list
        //and return.
        while (l1 != null) {
            list1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            list2.add(l2.val);
            l2 = l2.next;
        }
        List<Integer> maxList, minList;
        if (list1.size() > list2.size()) {
            maxList = list1;
            minList = list2;
        } else {
            maxList = list2;
            minList = list1;
        }

        int carry = 0, minlen = minList.size(), maxlen = maxList.size();
        for (int i = 0; i < maxlen; i++) {
            int sum = minlen > i ? minList.get(minlen - 1 - i) + maxList.get(maxlen - 1 - i) :
                    maxList.get(maxlen - 1 - i);
            sum += carry;
            carry = sum / 10;
            sum = sum % 10;
            list.add(sum);
        }
        if (carry > 0)
            list.add(carry);

        reverse(list);
        ListNode prev = null, cur = null;
        ListNode head = new ListNode(list.get(0));
        prev = head;
        for (int i = 1; i < list.size(); i++) {
            cur = new ListNode(list.get(i));
            prev.next = cur;
            prev = cur;
        }
        return head;
    }
}
