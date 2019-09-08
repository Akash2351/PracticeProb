package season2.top_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3]
 * Output:
 * [
 * [1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]
 * ]
 */
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0)
            return list;
        else if (nums.length == 1) {
            list.add(Arrays.asList(nums[0]));
            return list;
        }

        getPermutations(nums, new ArrayList<Integer>(), list);
        return list;
    }

    void getPermutations(int[] nums, List<Integer> cur, List<List<Integer>> list) {
        if (cur.size() == nums.length) {
            list.add(new ArrayList(cur));
        } else if (cur.size() < nums.length) {
            for (int num : nums) {
                if (!cur.contains(num)) {
                    cur.add(num);
                    getPermutations(nums, cur, list);
                    cur.remove(cur.size() - 1);
                }
            }
        }
    }
}
