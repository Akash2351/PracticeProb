package akash;


/**
 * Created by akash on 07-03-2018.
 */
public class CircularLinkedList {
    Node last = null;
    int size = 0;

    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void handleFirstNode(int val) {

        last = new Node(val);
        last.next = last;
        size++;
    }

    public void addToLast(int val) {
        // if first node is added
        if (size == 0) {
            handleFirstNode(val);
            return;
        }

        Node newNode = new Node(val);
        newNode.next = last.next;
        last.next = newNode;
        last = newNode;
        size++;
    }

    public void addToFirst(int val) {
        if (size == 0) {
            handleFirstNode(val);
            return;
        }

        Node newNode = new Node(val);
        newNode.next = last.next;
        last.next = newNode;
        size++;
    }

    public void removeNode(int val) {
        Node prev = last;
        Node cur = last.next;

        while (cur != last) {
            if (cur.val == val) {
                prev.next = prev.next.next;
                size--;
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    void printNodes() {
        Node cur = last.next;
        System.out.println("Printing nodes...");
        if (size == 1) {
            System.out.println(last.val);
            return;
        }

        while (cur != last) {
            System.out.println(" " + cur.val);
            cur = cur.next;
        }
        System.out.println(last.val);
    }

    public static void main(String[] args) {
        CircularLinkedList cl = new CircularLinkedList();
        cl.addToFirst(3);
        cl.addToFirst(4);
        cl.addToLast(5);
        cl.addToLast(1);
        cl.addToLast(8);
        cl.printNodes();
        cl.removeNode(4);
        cl.printNodes();
    }
}
