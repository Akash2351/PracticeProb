package akash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by akash on 18-02-2018.
 */
public class Subsets {

/*Given a set of distinct integers, nums, return all possible subsets (the power set).
Note: The solution set must not contain duplicate subsets.
For example,
 If nums = [1,2,3], a solution is:
            [
            [3],
            [1],
            [2],
            [1,2,3],
            [1,3],
            [2,3],
            [1,2],
            []
            ] */


    //same like permutation, phone no problem...
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length == 0) return list;

        generateRecursive(nums.length, 0, nums, new ArrayList<Integer>(), list);
        list.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return list;
    }

    public void generateRecursive(int len, int index, int[] nums, List<Integer> cur, List<List<Integer>> list) {
        if (len <= 0) return;
        //keep adding all combinations...
        list.add(new ArrayList<Integer>(cur));

        for (int i = index; i < nums.length; i++) {
            if (!cur.contains(nums[i])) {
                cur.add(nums[i]);
                generateRecursive(len - 1, i + 1, nums, cur, list);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
