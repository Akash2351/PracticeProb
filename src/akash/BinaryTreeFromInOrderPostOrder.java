package akash;

import java.util.HashMap;

/**
 * Created by akash on 04-03-2018.
 */
public class BinaryTreeFromInOrderPostOrder {
/*
 Given inorder and postorder traversal of a tree,
  construct the binary tree.
            Note:
  You may assume that duplicates do not exist in the tree.
            For example, given

    inorder = [9,3,15,20,7]
    postorder = [9,15,7,20,3]
    Return the following binary tree:

            3
            / \
            9  20
              /  \
              15   7*/

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> imap = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            imap.put(inorder[i], i);
        }

        return buildTree(0, inorder.length - 1, inorder, postorder.length - 1, 0, postorder, imap);
    }

    public TreeNode buildTree(int inStart, int inEnd, int[] inorder,
                              int postStart, int postEnd, int[] postorder,
                              HashMap<Integer, Integer> imap) {

        if (inStart > inEnd || postEnd > postStart) return null;

        TreeNode root = new TreeNode(postorder[postStart]);
        int inRoot = imap.get(postorder[postStart]);
        int rightTreeSize = inEnd - inRoot;

        root.left = buildTree(inStart, inRoot - 1, inorder, postStart - rightTreeSize - 1, 0, postorder, imap);
        root.right = buildTree(inRoot + 1, inEnd, inorder, postStart - 1, postStart - rightTreeSize, postorder, imap);
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeFromInOrderPostOrder bt = new BinaryTreeFromInOrderPostOrder();
        TreeNode node = bt.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}
