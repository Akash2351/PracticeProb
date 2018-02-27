package akash;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by akash on 26-02-2018.
 */


public class CopyListRandomPointer {
    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

    //this works for unique node labels only..using hashmap labels as keys
    public RandomListNode copyRandomListUnique(RandomListNode head) {
        if (head == null) return null;
        if (head.next == null) {
            RandomListNode node = new RandomListNode(head.label);
            node.next = null;
            node.random = head.random;
            return node;
        }

        HashMap<Integer, RandomListNode> map = new HashMap<>();
        RandomListNode prev = null, cur = head;
        while (cur != null) {
            map.put(cur.label, new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            int label = cur.label;
            RandomListNode next = cur.next != null ? map.get(cur.next.label) : null;
            RandomListNode random = cur.random != null ? map.get(cur.random.label) : null;
            RandomListNode curNode = map.get(label);
            curNode.next = next;
            curNode.random = random;

            cur = cur.next;
        }
        return map.get(head.label);
    }


/*A linked list is given such that each node contains an additional random pointer
    which could point to any node in the list or null.
Return a deep copy of the list.*/

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;

        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();

        // loop 1. copy all the nodes
        RandomListNode node = head;
        while (node != null) {
            map.put(node, new RandomListNode(node.label));
            node = node.next;
        }

        // loop 2. assign next and random pointers
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }

        return map.get(head);
    }
}
