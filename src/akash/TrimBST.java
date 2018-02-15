package akash;

/**
 * Created by akash on 14-02-2018.
 */


//Given a binary search tree and the lowest and highest boundaries
// as L and R, trim the tree so that all its elements lies in [L, R] (R >= L).
// You might need to change the root of the tree, so the result should
// return the new root of the trimmed binary search tree.

/*Input:
           3
         /  \
        0   4
         \
          2
        /
      1
        L = 1
        R = 3
        Output:
            3
           /
          2
        /
       1 */

public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null)
            return root;

        if (root.val >= L && root.val <= R) {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        } else if (root.val < L) {
            return trimBST(root.right, L, R);
        } else {
            return trimBST(root.left, L, R);
        }
    }
}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
