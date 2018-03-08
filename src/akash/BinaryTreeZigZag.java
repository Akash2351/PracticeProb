package akash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by akash on 04-03-2018.
 */
public class BinaryTreeZigZag {

/* Given a binary tree, return the zigzag level order
traversal of its nodes' values. (ie, from left to right,
 then right to left for the next level and alternate between).

    For example:
    Given binary tree [3,9,20,null,null,15,7],
            3
            / \
            9  20
            /  \
            15   7
   return its zigzag level order traversal as:
            [
            [3],
            [20,9],
            [15,7]
            ]  */

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);

        List<Integer> subList;
        boolean order = true; //true for normal

        while (!q.isEmpty()) {
            int levelSize = q.size();
            subList = new ArrayList<>();
            while (levelSize > 0) {
                TreeNode node = q.poll();
                if (order) {
                    subList.add(node.val);
                } else {
                    subList.add(0, node.val);
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
                levelSize--;
            }
            list.add(subList);
            order = !order; //flip direction for each level
        }
        return list;
    }
}
