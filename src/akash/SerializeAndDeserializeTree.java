package akash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by akash on 27-02-2018.
 */
public class SerializeAndDeserializeTree {


/* Serialization is the process of converting a data structure or
object into a sequence of bits so that it can be stored in a file
or memory buffer, or transmitted across a network connection link
to be reconstructed later in the same or another computer environment.

    Design an algorithm to serialize and deserialize a binary tree.
    There is no restriction on how your serialization/deserialization
    algorithm should work. You just need to ensure that a binary tree
     can be serialized to a string and this string can be deserialized
      to the original tree structure.
    For example, you may serialize the following tree

             1
            /  \
            2   3
               /   \
               4   5
    as "[1,2,3,null,null,4,5]"..or any other format.*/


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrderSerialize(root, list);
        return list.toString();
    }

    //traverse in preorder, store all nodes, using -99 to indicate null
    public void preOrderSerialize(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            list.add(-99);
            return;
        }

        list.add(root.val);
        preOrderSerialize(root.left, list);
        preOrderSerialize(root.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        //build the list from string data.. [1,3,-1,-1...]
        data = data.substring(1, data.length() - 1);
        String[] vals = data.split(",");
        //use queue and keep removing from the beginning...
        Queue<String> queue = new LinkedList<String>(Arrays.asList(vals));
        return DeserializeTree(queue);
    }

    public TreeNode DeserializeTree(Queue<String> queue) {
        String cur = queue.remove();
        if (cur.trim().equals("-99")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(cur.trim()));
        root.left = DeserializeTree(queue);
        root.right = DeserializeTree(queue);
        return root;
    }

    public static void main(String[] args) {
        SerializeAndDeserializeTree st = new SerializeAndDeserializeTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(st.serialize(root));
        TreeNode rt = st.deserialize(st.serialize(root));
        System.out.println(rt.val);
    }
}
