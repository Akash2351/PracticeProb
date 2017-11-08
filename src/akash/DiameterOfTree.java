package akash;

/**
 * Created by akash on 08-11-2017.
 */
public class DiameterOfTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root); //returns height of tree...we dont need that.
        return max;
        //Note: finding left tree height + right tree height + links to parent
        //will not always work...sometimes right/left child only may have the longest path
    }

    //calculate height of tree...meanwhile check for max height btw left and right child.
    int getHeight(TreeNode root) {
        if (root == null)
            return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        //For every node, length of longest path which passes it
        // is  MaxDepth of its left subtree + MaxDepth of its right subtree.
        max = Math.max(max, left + right);

        return 1 + Math.max(left, right);
    }
}
