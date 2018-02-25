package akash;

/**
 * Created by akash on 24-02-2018.
 */
public class MinHeightOfTree {

/*Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest
    path from the root node down to the nearest leaf node.*/

    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return 1 + (Math.min(left, right) > 0 ? Math.min(left, right) : Math.max(left, right));
    }
}
