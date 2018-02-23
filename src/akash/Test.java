package akash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by akash on 20-11-2017.
 */
public class Test {



    public static void main(String[] args) {

        // System.out.println(solution(new int[]{2, 1, 3, 5, 4, 7, 6}));
        //int[] arr = {3, 1, 5, 4, 2};
        // System.out.println(getBloomingNo(arr, 1));

        // System.out.println(numberNeeded("hello", "ell"));

       /* HashMap<Character, Integer> map = new HashMap<>();
        map.put('A',3);
        map.put('B',2);
        map.put('Z',5);
        TreeMap<Character,Integer> treeMap = new TreeMap<>((e1,e2) -> {return map.get(e1).compareTo(map.get(e2));});
        treeMap.putAll(map);
        treeMap.entrySet().stream().forEach(e->System.out.println(e.getKey()+"-"+e.getValue()));
        StringBuilder sb = new StringBuilder();
        int div = 1;
        sb.append(Character.toString((char)('A' - (div-1))));*/

    }


    public static int numberNeeded(String first, String second) {
        char[] firstc = first.replaceAll("\\s", "").toCharArray();
        char[] secondc = second.replaceAll("\\s", "").toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : firstc) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : secondc) {
            map.put(c, map.getOrDefault(c, 0) - 1);
        }

        int count = 0;
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            Character c = (Character) it.next();
            int val = map.get(c);
            // System.out.println("key:"+c+" val:"+val);
            if (0 != val)
                count += Math.abs(val);
        }
        return count;

    }


    public static int FlowerNbloom(int[] arr, int k) {
        TreeSet<Integer> ds = new TreeSet();
        for (int i = 0; i < arr.length; i++) {
            ds.add(arr[i]);
            Integer lower = ds.lower(arr[i]);
            Integer higher = ds.higher(arr[i]);
            System.out.println("High:" + higher + "Low:" + lower);
            if (lower == null) {
                if (arr[i] - 1 == k) {
                    return i + 1;
                }
            } else if (arr[i] - lower - 1 == k) {
                return i + 1;
            }

            if (higher == null) {
                if (arr.length - arr[i] == k) {
                    return i + 1;
                }
            } else if (higher - arr[i] - 1 == k) {
                return i + 1;
            }

        }
        return -1;
    }

    static int getBloomingNo(int[] P, int k) {
        TreeSet<Integer> data = new TreeSet();
        for (int i = 0; i < P.length; i++) {
            data.add(P[i]);
            Integer lowerNo = data.lower(P[i]);
            Integer higherNo = data.higher(P[i]);

            if (lowerNo == null) {
                if (P[i] - 1 == k)
                    return i + 1;
            } else if (P[i] - lowerNo - 1 == k) {
                return i + 1;
            }

            if (higherNo == null) {
                if (P.length - P[i] == k)
                    return i + 1;
            } else if (higherNo - P[i] - 1 == k) {
                return i + 1;
            }
        }
        return -1;
    }


}
