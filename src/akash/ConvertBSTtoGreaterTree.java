package akash;

/**
 * Created by akash on 11-11-2017.
 */
public class ConvertBSTtoGreaterTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return root;
        // reverse a inorder traversal.
        // start from right, root and left,
        // keep adding the values from right extreme end.
        convertBST(root.right);

        root.val += sum;
        sum = root.val;

        convertBST(root.left);
        return root;
    }
}
