package akash;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by akash on 20-11-2017.
 */
public class Test {

    class TimeSeries implements Comparable<TimeSeries> {
        String dt;
        String str;
        int num;

        public TimeSeries(String dt, String str, int num) {
            this.dt = dt;
            this.str = str;
            this.num = num;
        }

        @Override
        public int compareTo(TimeSeries o) {
            Date dt1 = toDate(this.dt);
            Date dt0 = toDate(o.dt);
            if (dt1.compareTo(dt0) == 0) {
                return this.str.compareTo(o.str);
            }
            //for descending dates
            else if (dt1.compareTo(dt0) < 0)
                return 1;
            else return -1;
        }

        public Date toDate(String str) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM");
            Date date = null;
            try {
                date = (Date) formatter.parse(str);
            } catch (Exception e) {
                System.out.println(e);
            }
            return date;
        }
    }

    public static int solution(int[] A) {

        int count = 0;

        for (int i = 0; i < A.length; i++) {
            HashSet<Integer> curSet = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                curSet.add(A[j]);
            }
            if (curSet.containsAll(getSet(i))) {
                count++;
            }
        }
        return count;
    }

    public static HashSet<Integer> getSet(int n) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n + 1; i++) {
            set.add(i);
        }
        return set;
    }

    public static void main(String[] args) {

        // System.out.println(solution(new int[]{2, 1, 3, 5, 4, 7, 6}));
     /*   Test ts = new Test();
        TimeSeries t1 = ts.new TimeSeries("2015-05", "clicks", 23);
        TimeSeries t2 = ts.new TimeSeries("2015-05", "clicka", 23);
        TimeSeries t3 = ts.new TimeSeries("2015-07", "clicks", 23);
        ArrayList<TimeSeries> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);
        Date dt;
        Collections.sort(list);
        *//*list.sort(new Comparator<TimeSeries>() {
            @Override
            public int compare(TimeSeries o1, TimeSeries o2) {
                return 0;
            }
        });*//*
        for (TimeSeries s1 : list) {
            System.out.println(s1.dt + " :" + s1.str);
        }*/

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
