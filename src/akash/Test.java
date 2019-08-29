package akash;

import java.util.*;

/**
 * Created by akash on 20-11-2017.
 */
public class Test {

    public static List<String> retrieveWords(String literatureText, List<String> wordsToExclude) {

        String[] words = literatureText.split(" ");
        Map<String, Integer> countMap = new HashMap<>();
        for (String str : words) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        //use a bucket, with count as index...and store the nos...
        List[] bucket = new List[words.length + 1];
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {

            if (bucket[entry.getValue()] == null)
                bucket[entry.getValue()] = new ArrayList<>();

            bucket[entry.getValue()].add(entry.getKey());
        }

        List<String> res = new ArrayList<String>();
        for (int i = words.length; i > 0; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
                res.removeAll(wordsToExclude);
                if (res.size() != 0) break;
            }
        }
        return res;
    }

    public static List<String> reorderLines(int logfileSize, List<String> logfile) {
        int logFileSize = 5;
        List<String> finalList = new ArrayList<>();
        List<String> logFile = new ArrayList<>();
        HashMap<String, Integer> indexValue = new HashMap<>();
        logFile.add("a1 9 2 3 1");
        logFile.add("g1 Act car");
        logFile.add("zo4 4 7");
        logFile.add("ab1 off KEY dog");
        logFile.add("a8 act zoo");

        String[] secondWords = new String[logFileSize];
        String[] fullWords = new String[logFileSize];
        ArrayList<String> fullWordss = new ArrayList<>(fullWords.length);

        for (int i = 0; i < logFileSize; i++) {
            int startIndex = logFile.get(i).indexOf(' ', 0);
            int endIndex = 0;
            if (startIndex != -1) {
                endIndex = logFile.get(i).indexOf(' ', startIndex + 1);
            }

            if (startIndex != -1 && endIndex != -1) {
                secondWords[i] = logFile.get(i).substring(startIndex, endIndex);
                fullWords[i] = logFile.get(i).substring(startIndex);
            }

        }

        String[] temp = Arrays.copyOf(secondWords, secondWords.length);

        for (int i = 0; i < temp.length; i++) {
            indexValue.put(temp[i], i);
        }

        System.out.println(Arrays.asList(temp));

        //Arrays.sort(secondWords);
        List<String> secWords = Arrays.asList(secondWords);
        Collections.sort(secWords, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        secondWords = (String[]) secWords.toArray();
        //Arrays.sort(fullWords);
        System.out.println(Arrays.asList(secondWords));

        for (String s : secondWords) {
            try {
                // checking valid integer using parseInt() method
                Integer.parseInt(s.trim());

                //      System.out.println(input2 + " is a valid integer number");
            } catch (NumberFormatException e) {
                finalList.add(logFile.get(indexValue.get(s)));

            }
        }

        for (String t : logFile) {
            if (!finalList.contains(t)) {
                finalList.add(t.trim());
            }
        }

        System.out.println(finalList);
        return finalList;
    }



    public static void main(String[] args) {
        //System.out.println(reorderLines(0,null));

        //System.out.println(retrieveWords("romeo romeo wherefore art thou romeo",Arrays.asList("art,thou")));
        //System.out.println(retrieveWords("rose is a flower rose is pond a flower rose flower in garden garden garden pond pond rose is a rose is a rose is a rose is a",Arrays.asList("rose","is","a")));

        // System.out.println(solution(new int[]{2, 1, 3, 5, 4, 7, 6}));
        //int[] arr = {3, 1, 5, 4, 2};
        // System.out.println(getBloomingNo(arr, 1));

        // System.out.println(numberNeeded("hello", "ell"));

        HashMap<Character, Integer> map = new HashMap<>();

        /*map.put('A',3);
        map.put('B',2);
        map.put('Z',5);
        TreeMap<Character,Integer> treeMap = new TreeMap<>((e1,e2) -> {return map.get(e1).compareTo(map.get(e2));});
        treeMap.putAll(map);
        treeMap.entrySet().stream().forEach(e->System.out.println(e.getKey()+"-"+e.getValue()));
        StringBuilder sb = new StringBuilder();
        int div = 1;
        sb.append(Character.toString((char)('A' - (div-1))));*/

        /*int[] visited = new int[5];
        visited[2] = 1;
        visited[3] = 1;
        long cnt = Arrays.stream(visited).filter(t -> t == 1 ? true : false).count();
        System.out.println(cnt);*/

        /*String x = "encoded password";
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        for(int i = 0;i<x.length();i++){
            char c = x.charAt(i);
            stringBuilder.append(c += c+i);
        }

        String temp = stringBuilder.toString();

        for(int i = 0;i<temp.length();i++){
            char c = temp.charAt(i);
            c=(char)((c-i)/2);
            stringBuilder2.append(c);
        }

        System.out.println(stringBuilder2.toString());*/

        /*aggregatePools(new int[]{12000,300,500,600,700});
        aggregatePools(new int[]{100,100,100,200,200,200,300});
        aggregatePools(new int[]{200,200,600,300, 600,700});*/
        Test tes = new Test();

        Solution sol = tes.new Solution();
        ListNode head = tes.new ListNode(1);
        head.setNext(tes.new ListNode(2, tes.new ListNode(
                3, tes.new ListNode(3, tes.new ListNode(
                4, tes.new ListNode(4, tes.new ListNode(5)))))));
        sol.candyCrush(head);
        sol.printhead(head);

        ListNode head2 = tes.new ListNode(1);
        head2.setNext(tes.new ListNode(1, tes.new ListNode(
                3, tes.new ListNode(3, tes.new ListNode(
                3, tes.new ListNode(5, tes.new ListNode(6)))))));
        sol.candyCrush(head2);
        sol.printhead(head2);

    }

    class ListNode {
        public int value;
        public ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

    }

    class Solution {
        public ListNode candyCrush(ListNode head) {
            boolean canCrush = true, isListChanged = false;

            ListNode start = null, end = null;
            ListNode prev, cur;
            prev = null;
            cur = head;
            do {
                do {
                    if (prev != null && cur != null && prev.getValue() == cur.getValue()) {
                        if (start == null) start = prev;
                        isListChanged = true;
                    } else if (start != null) {
                        end = cur;
                        break;
                    }
                    prev = cur;
                    cur = cur != null && cur.getNext() != null ? cur.getNext() : null;
                    if (cur == null && !isListChanged) {
                        canCrush = false;
                    }
                    isListChanged = false;
                } while (canCrush);

                if (start != null) {
                    ListNode temp = head;
                    if (temp == start) {
                        head = end;
                        start = null;
                        end = null;
                        prev = null;
                        cur = head;
                    } else {
                        while (temp.getNext() != null && temp.getNext() != start)
                            temp = temp.getNext();

                        if (temp != null) {
                            temp.setNext(end);
                            start = null;
                            end = null;
                        }
                    }
                }
            } while (canCrush);
            return head;
        }

        public void printhead(ListNode head) {
            ListNode temp = head;

            while (temp != null) {
                System.out.print(temp.getValue() + " -> ");
                temp = temp.getNext();
            }

        }
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

    static int[][] aggregatePools(int[] poolList) {
        List<List<Integer>> list;
        list = combinationSum(poolList, 0);
        System.out.println(list);
        return null;
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int sum) {

        //for storing the list..
        List<List<Integer>> list = new ArrayList<>();
        if (candidates == null || candidates.length == 0)
            return list;
        //for storing the temp list
        List<Integer> curList = new ArrayList<>();
        printRecursive(candidates, 0, sum, curList, list);
        return list;
    }

    public static void printRecursive(int[] candidates, int index, int sum,
                                      List<Integer> curList, List<List<Integer>> list) {
        //base case..
        if (sum >= 1000 && sum % 1000 == 0 && curList.size() <= 3) {
            //just adding curList, it will be empty in the end...so making a new copy
            list.add(new ArrayList<>(curList));
        } else if (sum > 1000 && sum % 1000 != 0) {
            return;
        } else {
            // if starting from i =0, it will give all combinations...
            // if input is [2, 3, 6, 7], we get [2, 2, 3],[2, 3, 2], [3,2,2] with i=0
            // else, it gives only [2, 2, 3]
            for (int i = index; i < candidates.length; i++) {
                if (!curList.contains(candidates[i])) {
                    curList.add(candidates[i]);
                    printRecursive(candidates, i, sum + candidates[i], curList, list);
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }


}
