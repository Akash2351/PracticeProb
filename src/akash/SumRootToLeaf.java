package akash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 25-02-2018.
 */
public class SumRootToLeaf {

/*  Given a binary tree containing digits from 0-9 only,
 each root-to-leaf path could represent a number.
    An example is the root-to-leaf path 1->2->3 which represents
    the number 123.
    Find the total sum of all root-to-leaf numbers.
    For example,
             1
            / \
           2   3
    The root-to-leaf path 1->2 represents the number 12.
    The root-to-leaf path 1->3 represents the number 13.
    Return the sum = 12 + 13 = 25.*/

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        List<String> list = new ArrayList<>();
        recursiveToLeaf("", root, list);
        int sum = 0;
        for (String str : list) {
            sum += Integer.valueOf(str);
        }
        return sum;
    }

    public void recursiveToLeaf(String cur, TreeNode node, List<String> list) {
        //check if leaf node only..then add it
        if (node.left == null && node.right == null) {
            //note, we havent added the current node value..so add it
            cur += node.val;
            list.add(cur);
            return;
        }
        //recursive call only non null nodes...
        if (node.left != null) recursiveToLeaf(cur + node.val, node.left, list);
        if (node.right != null) recursiveToLeaf(cur + node.val, node.right, list);
    }

    public static void main(String[] args) {
        SumRootToLeaf sm = new SumRootToLeaf();
    }
}
