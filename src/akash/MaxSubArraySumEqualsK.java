package akash;

import java.util.HashMap;

/**
 * Created by akash on 07-03-2018.
 */
public class MaxSubArraySumEqualsK {
    /*
    Given an array nums and a target value k, find the maximum length of a
     subarray that sums to k. If there isn't one, return 0 instead.
    Note:
    The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

    Example 1:
    Given nums = [1, -1, 5, -2, 3], k = 3,
    return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)

    Example 2:
    Given nums = [-2, -1, 2, 1], k = 1,
    return 2. (because the subarray [-1, 2] sums to 1 and is the longest)

        Follow Up:
        Can you do it in O(n) time?
        */
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int sum = 0, maxSubSum = 0;
        //use map to store index of sum till that element.
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //check if the sum = k, or
            //sum(current i) - sum(at some j) =k ...then max of (i-j) is answer
            sum += nums[i];

            if (sum == k) {
                return i + 1;
            } else if (map.containsKey(sum - k)) {
                maxSubSum = Math.max(maxSubSum, i - map.get(sum - k));
            } else {
                if (!map.containsKey(sum))
                    map.put(sum, i);
            }
        }
        return maxSubSum;
    }
}
