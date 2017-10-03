package ebay;

import tree.TreeNode;
import tree.constantTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeBT {
    public static void main(String[] args) {
        TreeNode root = constantTree.returnRoot();

    }

    private static String serialize(TreeNode root) {
        if (root == null) return "null";

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            sb.append(cur.val).append(",");
            if (cur.right != null) stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }

        return sb.toString();
    }

    private static TreeNode deserialize(String data) {
        if (data.equals("null")) return null;

        String[] strings = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(strings[0]));
        queue.offer(root);

        for (int i = 1; i < strings.length; i++) {
            TreeNode cur = queue.poll();

            if (!strings[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.valueOf(strings[i]));
                queue.offer(left);
                cur.left = left;
            }

            if (!strings[++i].equals("null")) {
                TreeNode right = new TreeNode(Integer.valueOf(strings[i]));
                queue.offer(right);
                cur.right = right;
            }
        }
        return root;
    }
}
