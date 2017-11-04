package akash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by akash on 03-11-2017.
 */
public class Permutations {

    public static void main(String[] args) {
        Permutations per = new Permutations();
        System.out.println(per.permute(new int[]{1, 2, 3}));
    }


    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null)
            return list;
        else if (nums.length == 1) {
            list.add(Arrays.asList(nums[0]));
            return list;
        }

        getPermutations(nums, nums.length, new ArrayList<Integer>(), list);
        return list;
    }

    void getPermutations(int[] nums, int curLen, List<Integer> cur, List<List<Integer>> list) {
        if (curLen == 0) {
            list.add(new ArrayList(cur));
        } else if (curLen > 0) {
            for (int num : nums) {
                if (!cur.contains(num)) {
                    cur.add(num);
                    getPermutations(nums, curLen - 1, cur, list);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
