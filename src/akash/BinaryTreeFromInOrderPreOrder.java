package akash;

import java.util.HashMap;

/**
 * Created by akash on 04-03-2018.
 */
public class BinaryTreeFromInOrderPreOrder {

/*
   Given preorder and inorder traversal of a tree,
    construct the binary tree.

            Note:
    You may assume that duplicates do not exist in the tree.

   For example, given
    preorder = [3,9,20,15,7]
    inorder = [9,3,15,20,7]
    Return the following binary tree:

             3
            / \
           9  20
             /  \
            15   7    */

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        //using a hashmap to get locations for inorder...
        HashMap<Integer, Integer> imap = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++)
            imap.put(inorder[i], i);

        return buildTree(0, preorder.length - 1, preorder,
                0, inorder.length - 1, inorder, imap);

    }

    public TreeNode buildTree(int preStart, int preEnd, int[] preorder,
                              int inStart, int inEnd, int[] inorder, HashMap<Integer, Integer> imap) {


        if (preStart > preEnd || inEnd > inEnd) return null;  //out of range

        TreeNode root = new TreeNode(preorder[preStart]);
        int inRoot = imap.get(preorder[preStart]);
        int leftLength = inRoot - inStart;

        root.left = buildTree(preStart + 1, preStart + leftLength, preorder,
                inStart, inRoot - 1, inorder, imap);
        root.right = buildTree(preStart + leftLength + 1, preEnd, preorder,
                inRoot + 1, inEnd, inorder, imap);
        return root;
    }
}
