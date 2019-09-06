package season2.top_100;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * 10
 * /  \
 * 5   -3
 * / \    \
 * 3   2   11
 * / \   \
 * 3  -2   1
 * <p>
 * Return 3. The paths that sum to 8 are:
 * <p>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * USE DFS...
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
