package akash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 28-02-2018.
 */
public class BinaryTreeRightView {

/* Given a binary tree, imagine yourself standing on the right
 side of it, return the values of the nodes you can see
 ordered from top to bottom.

    For example:
    Given the following binary tree,
               1            <---
            /   \
           2     3         <---
            \     \
            5     4       <---
    You should return [1, 3, 4].  */


    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        rightView(root, list, 0);
        return list;
    }

    public void rightView(TreeNode root, List<Integer> list, int depth) {
        if (root != null) {

            //add only 1 node for each level...if right is null, add left...
            if (list.size() == depth) {
                list.add(root.val);
            }
            //keep traversing the right side of the tree...
            //either ways only 1 node per level will be added...
            //this priority will be given to right side node first.
            rightView(root.right, list, depth + 1);
            rightView(root.left, list, depth + 1);
        }
    }
}
