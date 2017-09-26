package tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBT {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (current == null) {
                sb.append("null,");
                continue;
            }

            sb.append(current.val).append(",");
            queue.offer(current.left);
            queue.offer(current.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        String[] strings = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        queue.offer(root);

        for (int i = 1; i < strings.length; i++) {
            TreeNode parent = queue.poll();

            if (!strings[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(strings[i]));
                parent.left = left;
                queue.offer(left);
            }

            if (!strings[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(strings[i]));
                parent.right = right;
                queue.offer(right);
            }
        }

        return root;
    }
}
