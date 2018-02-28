package akash;

import java.util.Arrays;

/**
 * Created by akash on 27-02-2018.
 */
public class KthLargestInArray {

    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        if (len == 0) return 0;

        Arrays.sort(nums);
        int lastMax = Integer.MAX_VALUE;
        for (int i = len - 1; i >= 0; i--) {
            if (lastMax == nums[i]) continue;
            lastMax = nums[i] < lastMax ? nums[i] : lastMax;
            if (k == 1) {
                return lastMax;
            }
            k--;
        }
        return lastMax;
    }

    public static void main(String[] args) {
        KthLargestInArray klar = new KthLargestInArray();
        System.out.println(klar.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }
}
