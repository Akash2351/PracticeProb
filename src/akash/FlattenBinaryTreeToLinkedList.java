package akash;

/**
 * Created by akash on 09-03-2018.
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        TreeNode head = new TreeNode(0);
        TreeNode cur = buildList(root, head);
        root = head.right;
    }

    TreeNode buildList(TreeNode root, TreeNode cur) {
        if (root == null) return cur;

        cur.right = new TreeNode(root.val);
        cur = cur.right;
        cur = buildList(root.left, cur);
        cur = buildList(root.right, cur);
        return cur;
    }

    public static void main(String[] args) {
        FlattenBinaryTreeToLinkedList fl = new FlattenBinaryTreeToLinkedList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        fl.flatten(root);
        System.out.println(root);
    }
}
