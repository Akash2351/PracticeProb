package akash;

import java.util.Arrays;

/**
 * Created by akash on 08-11-2017.
 */
public class EqualSubsetPartition {

    public boolean canPartition(int[] nums) {

        if (nums.length == 1)
            return false;

        int sum = 0;
        for (int num : nums)
            sum += num;

        //if sum is not even, return false,it cannot be divided
        if (sum % 2 != 0)
            return false;

        sum = sum / 2;
        boolean table[] = new boolean[sum + 1];
        Arrays.fill(table, false);
        table[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j > 0; j--) {
                if (nums[i] <= j)
                    table[j] = table[j] || table[j - nums[i]];
            }
        }
        return table[sum];
    }
}
