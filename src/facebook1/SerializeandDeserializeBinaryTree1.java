package facebook1;

import tree.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree1 {
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(nodes));
        return buildTree(queue);
    }

    private TreeNode buildTree(Queue<String> queue) {
        String cur = queue.poll();
        if (cur.equals("null")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(cur));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
