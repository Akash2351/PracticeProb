package akash;

/**
 * Created by akash on 07-11-2017.
 */
public class PathSum3 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;

        //call recursively and find for other child nodes...
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

        //if checking from only root node, then
        //return findPath(root, sum);
    }

    //returns the number of paths to a given sum, starting from node root...
    int findPath(TreeNode root, int sum) {
        if (root == null)
            return 0;

        int count = 0;
        sum = sum - root.val;
        if (sum == 0)
            count++;
        count += findPath(root.left, sum);
        count += findPath(root.right, sum);

        return count;
    }
}
