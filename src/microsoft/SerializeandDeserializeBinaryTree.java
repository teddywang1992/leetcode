package microsoft;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeandDeserializeBinaryTree {
    public String serialize(TreeNode root) {
        if (root == null) return "null";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            //System.out.println("sss");
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("null,");
                continue;
            }
            sb.append(cur.val).append(",");
            queue.offer(cur.left);
            queue.offer(cur.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0 || data.equals("null")) return null;
        String[] strings = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for (int i = 1; i < strings.length; i++) {
            TreeNode cur = queue.poll();

            if (!strings[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(strings[i]));
                cur.left = left;
                queue.offer(left);
            }

            if (!strings[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(strings[i]));
                cur.right = right;
                queue.offer(right);
            }
        }

        return root;
    }
}
