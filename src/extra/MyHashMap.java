/**
 * Created by csd on Jan 29, 2017
 */
package extra;

/**
 * @author csd Custom HashMap implementation Shows how HashMap works internally
 */
public class MyHashMap<K, V> {
    // Main data structure for HashMap
    static class Entry<K, V> {
        K key;
        V Value;
        Entry<K, V> next;

        // constructor for Entry class
        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.Value = value;
            this.next = next;
        }
    }

    private Entry<K, V>[] table;
    private int capacity = 16;

    // constructor for MyHashMap class
    public MyHashMap() {
        table = new Entry[capacity];
    }

    // method to get hashed index for table
    private int hashIndex(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    // method to put value to HashMap
    public void put(K key, V value) {

        // No null elements are allowed
        if (key == null) {
            return;
        }

        int index = hashIndex(key);

        Entry<K, V> newEntry = new Entry<K, V>(key, value, null);

        if (table[index] == null) {
            table[index] = newEntry;
        }

        Entry<K, V> previous = null;
        Entry<K, V> current = newEntry;

        // Search if it is already present in the list and replace
        while (current != null) {

            if (current.key.equals(key)) {

                if (previous == null) {
                    // found at the beginning of the list
                    newEntry.next = current.next;
                    table[index] = newEntry;
                    return;
                }

                newEntry.next = current.next;
                previous.next = newEntry;
            }
            previous = current;
            current = current.next;
        }
        // add at the end of list
        previous.next = newEntry;
    }

    // get method for MyHashMap
    public V get(K key) {
        int index = hashIndex(key);

        if (table[index] == null)
            return null;
        Entry<K, V> entry = table[index];

        while (entry != null) {
            if (entry.key.equals(key))
                return entry.Value;
            entry = entry.next;
        }
        return null;
    }

    // method to remove entry from HashMap
    boolean remove(K key) {
        int index = hashIndex(key);
        if (key == null) {
            return false;
        }

        if (table[index] == null)
            return false;

        Entry<K, V> previous = null;
        Entry<K, V> current = table[index];

        // Search in list and remove
        while (current != null) {

            if (current.key.equals(key)) {

                if (previous == null) {
                    // found at the beginning of the list
                    table[index] = current.next;
                    return true;
                }
                previous.next = current.next;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void display() {

        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {

                Entry<K, V> entry = table[i];

                while (entry != null) {

                    System.out.println("Key = " + entry.key + " Value = " + entry.Value);
                    entry = entry.next;
                }
            }
        }
    }

}