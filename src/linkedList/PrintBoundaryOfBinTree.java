/**
 * Created by Chiru on Jan 13, 2017
 */
package linkedList;
//1. Print left boundary top down

//2. print all leaf nodes
//3. print right boundary bottom up

public class PrintBoundaryOfBinTree {

    public static void main(String[] args) {
        /*
		 * BinaryTree tree = new BinaryTree(); tree.root = new TreeNode(20);
		 * tree.root.leftNode = new TreeNode(8); tree.root.leftNode.leftNode =
		 * new TreeNode(4); tree.root.leftNode.rightNode = new TreeNode(12);
		 * tree.root.leftNode.rightNode.leftNode = new TreeNode(10);
		 * tree.root.leftNode.rightNode.rightNode = new TreeNode(14);
		 * tree.root.rightNode = new TreeNode(22); tree.root.rightNode.rightNode
		 * = new TreeNode(25); tree.printBoundary(tree.root);
		 */

        TreeNode root = new TreeNode(20);

        root.leftNode = new TreeNode(8);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.rightNode = new TreeNode(12);
        root.leftNode.rightNode.leftNode = new TreeNode(10);
        root.leftNode.rightNode.leftNode.leftNode = new TreeNode(11);
        root.leftNode.rightNode.rightNode = new TreeNode(14);
        // root.leftNode.rightNode.rightNode.leftNode = new TreeNode(13);
        root.rightNode = new TreeNode(22);
        root.rightNode.rightNode = new TreeNode(25);
        new PrintBoundaryOfBinTree().printBoundary(root);
    }

    public static class TreeNode {
        int data;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int data) {
            this.data = data;
            leftNode = rightNode = null;
        }
    }

    // public static class BinaryTree {
    // TreeNode root;

    public void printLeafNodes(TreeNode node) {
        if (node != null) {
            printLeafNodes(node.leftNode);

            if (node.leftNode == null && node.rightNode == null)
                System.out.print(node.data + " ");

            printLeafNodes(node.rightNode);
        }
    }

    public void printLeftBoundary(TreeNode node) {
        if (node != null) {
            // check if both left and right side of the tree are != null and
            // print
            // if left and right are null then it is leaf
            // so going the other way
            if (node.leftNode != null) {
                // first print the node to preserve order
                System.out.print(node.data + " ");
                printLeftBoundary(node.leftNode);

            } else if (node.rightNode != null) {
                System.out.print(node.data + " ");
                printLeftBoundary(node.rightNode);

            }
        }
    }

    public void printRightBoundary(TreeNode node) {
        if (node != null) {
            // check if both left and right side of the tree are != null and
            // print
            // if left and right are null then it is leaf
            // so going the other way
            // Make sure you print bottom up here

            if (node.rightNode != null) {
                // go to last node to preserve order & then print

                printRightBoundary(node.rightNode);
                System.out.print(node.data + " ");

            } else if (node.leftNode != null) {
                printRightBoundary(node.leftNode);
                System.out.print(node.data + " ");

            }
        }
    }

    public void printBoundary(TreeNode node) {
        if (node != null) {
            // print root first to avoid duplicates
            System.out.print(node.data + " ");

            // Print the left boundary in top-down manner
            // start with left node to avoid duplicates
            printLeftBoundary(node.leftNode);

            printLeafNodes(node);

            // Print the right boundary in bottom-up manner
            // start with right node
            printRightBoundary(node.rightNode);
        }
    }
    // }
}