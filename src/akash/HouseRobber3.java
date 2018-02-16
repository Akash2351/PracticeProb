package akash;

/**
 * Created by akash on 15-02-2018.
 */
public class HouseRobber3 {

/*The thief has found himself a new place for his thievery again.
    There is only one entrance to this area, called the "root." Besides
    the root, each house has one and only one parent house. After a tour,
    the smart thief realized that "all houses in this place forms a binary tree".
    It will automatically contact the police if two directly-linked houses were
    broken into on the same night.

Determine the maximum amount of money the thief can rob tonight
    without alerting the police.

                  3
                 / \
                4   5
               / \   \
              1   3   1
 Maximum amount of money the thief can rob = 4 + 5 = 9.*/

    public int rob(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null)
            return root.val;

        //consider the rob case...
        //rob = root + left child's grandchildren + right child's grandchildren
        int rob = root.val;
        int grandChildLeft = 0, grandChildRight = 0;
        if (root.left != null)
            grandChildLeft = rob(root.left.left) + rob(root.left.right);
        if (root.right != null)
            grandChildRight = rob(root.right.left) + rob(root.right.right);

        rob += grandChildLeft + grandChildRight;

        //consider not rob case...
        //not rob = left child + right child called recursively
        int notRob = rob(root.left) + rob(root.right);

        return Math.max(rob, notRob);
    }
}
