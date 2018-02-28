package akash;

import java.util.*;

/**
 * Created by akash on 27-02-2018.
 */
public class BinaryTreeVerticalTraversal {
/*
Given a binary tree, return the vertical order traversal of
its nodes' values. (ie, from top to bottom, column by column).
If two nodes are in the same row and column,
the order should be from left to right.

  Examples:
 Given binary tree [3,9,20,null,null,15,7],

             3
            /\
           /  \
          9  20
             /\
            /  \
           15   7

            return its vertical order traversal as:
            [
            [9],
            [3,15],
            [20],
            [7]
            ]
*/


// let root be at level 0, root.left will be -1, root.right will be +1
// use this index to track the vertical ordering...
//traverse tree level by level..use BFS

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        //TreeMap, so the results are sorted based on key..i.e. col index
        Map<Integer, List<Integer>> map = new TreeMap<>();
        parseTreeBFS(root, map);
        list.addAll(map.values());
        return list;

    }

    public void parseTreeBFS(TreeNode root, Map<Integer, List<Integer>> map) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> colQueue = new LinkedList<>();
        queue.add(root);
        colQueue.add(0); //to keep track of col..map key


        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            Integer index = colQueue.remove();

            if (!map.containsKey(index)) {
                map.put(index, new ArrayList<Integer>());
            }
            map.get(index).add(node.val);

            if (node.left != null) {
                queue.add(node.left);
                colQueue.add(index - 1);
            }
            if (node.right != null) {
                queue.add(node.right);
                colQueue.add(index + 1);
            }
        }
    }
}
