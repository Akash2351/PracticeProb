package akash;

import java.util.Arrays;

/**
 * Created by akash on 10-11-2017.
 */
public class ShortestUnsortedContiguousSubarray {

    public int findUnsortedSubarray(int[] nums) {

        //sort the list and comparing the difference elements index
        //from both ends...
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int left = 0;
        while (left < nums.length && nums[left] == sorted[left]) left++;

        int right = nums.length - 1;
        while (right > left && nums[right] == sorted[right]) right--;

        return right - left + 1;
    }
}
