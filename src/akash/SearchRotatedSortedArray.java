package akash;

/**
 * Created by akash on 13-02-2018.
 */
public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;

        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == nums[mid]) return mid;

            if (nums[low] <= nums[mid]) {
                if (target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            if (nums[mid] <= nums[high]) {
                if (target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }
}
