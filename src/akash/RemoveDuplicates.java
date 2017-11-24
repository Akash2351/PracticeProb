package akash;

/**
 * Created by akash on 23-11-2017.
 */
public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1)
            return nums.length;

        //starting from 1st index, keep adding unique
        //numbers..return this count.
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] == nums[j]) continue;

            //else add to next place...non repeated chars..
            nums[++i] = nums[j];
        }
        //return count of unique numbers
        return i + 1;
    }
}
