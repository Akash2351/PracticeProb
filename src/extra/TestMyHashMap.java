/**
 * Created by csd on Jan 29, 2017
 */
package extra;

/**
 * @author csd Custom HashMap test stub
 */

public class TestMyHashMap {

    public static void main(String[] args) {

        MyHashMap<Integer, String> map = new MyHashMap<>();

        map.put(1, "Chiranjeevi");
        map.put(2, "Akash");
        map.put(3, "Rakshith");
        map.put(4, "Sujay");
        map.put(5, "XYZ");
        map.put(6, "Radhika");

        map.display();

        map.remove(5);

        System.out.println("\nMap contents after removing XYZ\n");

        map.display();

    }

}
