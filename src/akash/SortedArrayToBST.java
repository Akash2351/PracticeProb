package akash;

/**
 * Created by akash on 21-02-2018.
 */
public class SortedArrayToBST {

/*Given an array where elements are sorted in ascending order
    convert it to a height balanced BST.
For this problem, a height-balanced binary tree is defined
    as a binary tree in which the depth of the two subtrees of
    every node never differ by more than 1.*/

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;
        return getBST(nums, 0, nums.length - 1);
    }

    public TreeNode getBST(int[] nums, int start, int end) {
        if (start <= end) {   //note <= ...not <
            int mid = (start + end) / 2;
            TreeNode node = new TreeNode(nums[mid]);
            node.left = getBST(nums, start, mid - 1);
            node.right = getBST(nums, mid + 1, end);
            return node;
        }
        return null;

    }
}
