package akash;

/**
 * Created by akash on 27-02-2018.
 */
public class MaximumBinaryTree {

/* Given an integer array with no duplicates. A maximum tree
 building on this array is defined as follow:

    The root is the maximum number in the array.
    > The left subtree is the maximum tree constructed from
    left part subarray divided by the maximum number.
    > The right subtree is the maximum tree constructed from
    right part subarray divided by the maximum number.
   > Construct the maximum tree by the given array and
    output the root node of this tree.

            Example 1:
    Input: [3,2,1,6,0,5]
    Output: return the tree root node representing the following tree:

              6
            /   \
           3     5
            \    /
             2  0
              \
               1 */

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        return buildTree(nums, 0, nums.length - 1);
    }

    public TreeNode buildTree(int[] nums, int start, int end) {
        //same like binary search.. instead of mid,
        //find the mid to be max value..
        //recursively call left and right of array
        if (start <= end) {
            int max = Integer.MIN_VALUE, mid = -1;
            for (int i = start; i <= end; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    mid = i;
                }
            }

            TreeNode root = new TreeNode(max);
            root.left = buildTree(nums, start, mid - 1);
            root.right = buildTree(nums, mid + 1, end);
            return root;
        } else
            return null; //outside range..return null
    }
}
