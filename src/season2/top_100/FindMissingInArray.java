package season2.top_100;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 */
public class FindMissingInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] > 0)
                nums[num - 1] = -nums[num - 1];
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0)
                list.add(i + 1);
        }

        return list;
    }
}
