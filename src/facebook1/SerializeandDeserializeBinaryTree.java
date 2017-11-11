package facebook1;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null").append(",");
            }
            else {
                sb.append(cur.val).append(",");
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);
        for (int i = 1; i < nodes.length; i += 2) {
            TreeNode cur = queue.poll();
            if (!nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                cur.left = left;
                queue.offer(left);
            }
            if (!nodes[i+1].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i+1]));
                cur.right = right;
                queue.offer(right);
            }
        }
        return root;
    }
}
