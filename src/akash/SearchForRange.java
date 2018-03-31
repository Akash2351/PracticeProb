package akash;

/**
 * Created by akash on 08-03-2018.
 */
public class SearchForRange {

/* Given an array of integers sorted in ascending order,
find the starting and ending position of a given target value.
    Your algorithm's runtime complexity must be in the order of O(log n).

    If the target is not found in the array, return [-1, -1].
    For example,
    Given [5, 7, 7, 8, 8, 10] and target value 8,
            return [3, 4].  */

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;

        int low = 0, high = nums.length - 1;
        int index = -1;

        //do binary search...find the element..
        //if not found, return -1,-1..
        // if found, expand around its index for range...
        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (index == -1) {
            return res;
        }

        int left = 0, right = 0;
        int idx = index;
        while (idx - 1 >= 0 && nums[idx] == nums[idx - 1]) {
            left++;
            idx--;
        }
        idx = index;
        while (idx + 1 <= nums.length - 1 && nums[idx] == nums[idx + 1]) {
            right++;
            idx++;
        }

        res[0] = index - left;
        res[1] = index + right;
        return res;
    }
}
