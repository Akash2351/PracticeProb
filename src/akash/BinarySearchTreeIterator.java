package akash;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by akash on 08-01-2018.
 */
public class BinarySearchTreeIterator {

    //Implement an iterator over a binary search tree (BST). Your iterator will
    // be initialized with the root node of a BST.
    //Calling next() will return the next smallest number in the BST.
    //Note: next() and hasNext() should run in average O(1) time and uses
    // O(h) memory, where h is the height of the tree.

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class BSTIterator {

        TreeNode rootNode;
        List<Integer> list = new ArrayList<>();
        int index = 0;

        public BSTIterator(TreeNode root) {
            rootNode = root;
            getList(root);
        }

        public void getList(TreeNode node) {
            if (node != null) {
                getList(node.left);
                list.add(node.val);
                getList(node.right);
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            if (index >= list.size()) return false;
            return true;
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            return list.get(index++);
        }
    }
}
