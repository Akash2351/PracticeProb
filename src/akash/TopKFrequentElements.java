package akash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by akash on 08-11-2017.
 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        System.out.println(topKFrequent(new int[]{1, 1, 1, 1, 2, 2, 2, 3}, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {

        //get the frequency count...
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //use a bucket, with count as index...and store the nos...
        List[] bucket = new List[nums.length + 1];
        for (Integer no : map.keySet()) {
            Integer count = map.get(no);
            if (bucket[count] == null)
                bucket[count] = new ArrayList<>();

            bucket[count].add(no);
        }

        //keep adding results from the max count bucket until k elements are added..
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = nums.length; i > 0 && res.size() < k; i--) {
            if (bucket[i] != null) {
                res.addAll(bucket[i]);
            }
        }
        return res;
    }
}
