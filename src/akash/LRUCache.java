package akash;

import java.util.HashMap;

/**
 * Created by akash on 26-02-2018.
 */
public class LRUCache {
/*    HashMap<Integer,Integer> valueMap;
    HashMap<Integer,Integer> indexMap;
    int capacity = 0;
    int lastUsedIndex = 0;
    int elementsFilled = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        valueMap = new HashMap<>(capacity);
        indexMap = new HashMap<>(capacity);
    }

    public int get(int key) {
        int val=  valueMap.get(key)!=null? valueMap.get(key): -1;
        if(val!=-1)
            indexMap.put(key,lastUsedIndex++);
        return val;
    }

    public void put(int key, int value) {
        if(elementsFilled < capacity){
            valueMap.put(key,value);
            indexMap.put(key,lastUsedIndex++);
            elementsFilled++;
        } else if(valueMap.containsKey(key)){
            //already exists...update lastUsedIndex;
            valueMap.put(key,value);
            indexMap.put(key,lastUsedIndex++);
        } else {
            //not present and map is full
            int minIndex = Integer.MAX_VALUE, minKey = Integer.MAX_VALUE;
             for(Map.Entry<Integer,Integer> entry : indexMap.entrySet()){
                 if(entry.getValue() <minIndex){
                     minIndex = entry.getValue();
                     minKey = entry.getKey();
                 }
             }

             valueMap.remove(minKey);
            valueMap.put(key,value);
            indexMap.remove(minKey);
            indexMap.put(key,lastUsedIndex++);
        }
    }*/


/*Design and implement a data structure for Least Recently Used (LRU) cache.
 It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the
key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present.
 When the cache reached its capacity, it should invalidate the least
 recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?
Example:
    LRUCache cache = new LRUCache( 2 *//* capacity *//* );

    cache.put(1, 1);
    cache.put(2, 2);
    cache.get(1);       // returns 1
    cache.put(3, 3);    // evicts key 2
    cache.get(2);       // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    cache.get(1);       // returns -1 (not found)
    cache.get(3);       // returns 3
    cache.get(4);       // returns 4*/

    //Doubly linked list to store nodes..O(1) insertion
    // and deletion..insert next to head, remove next to tail.
    class DLinkedList {
        int val;
        int key;
        DLinkedList prev, next;

        public DLinkedList(int val) {
            this.val = val;
        }
    }

    //map to store the key, node value pair.
    HashMap<Integer, DLinkedList> map = new HashMap<>();
    int capacity;
    int count = 0;
    DLinkedList head, tail;

    //head and tail will be the boundary nodes
    //new nodes, updated nodes, get nodes are moved next to head
    //nodes next to tail are outdated (LRU)..delete them
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new DLinkedList(0);
        tail = new DLinkedList(0);

        head.prev = null;
        head.next = tail;
        tail.prev = head;
        tail.next = null;
    }


    public void addNext(DLinkedList node) {
        DLinkedList nxt = head.next;
        head.next = node;
        node.prev = head;
        node.next = nxt;
        nxt.prev = node;
    }

    public void removeNode(DLinkedList node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void moveNextToHead(DLinkedList node) {
        this.removeNode(node);
        this.addNext(node);
    }

    public DLinkedList popupTail() {
        DLinkedList pop = tail.prev;
        removeNode(pop);
        return pop;
    }

    public int get(int key) {
        DLinkedList node = map.get(key);
        if (node == null)
            return -1;

        moveNextToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedList node = map.get(key);
        if (node == null) {
            node = new DLinkedList(value);
            node.key = key;
            map.put(key, node);
            addNext(node);
            ++count;

            if (count > capacity) {
                DLinkedList pop = popupTail();
                map.remove(pop.key);
                count--;
            }
        } else {
            node.val = value;
            moveNextToHead(node);
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));
    }
}
