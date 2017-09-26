package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeserializeBST {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            sb.append(current.val).append(",");
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("null")) {
            return null;
        }

        String[] strings = data.split(",");
        Queue<Integer> queue = new LinkedList<>();

        for (String string : strings) {
            queue.offer(Integer.parseInt(string));
        }

        return getNode(queue);
    }

    public TreeNode getNode(Queue<Integer> queue) {
        if (queue.isEmpty())  return null;
        TreeNode root = new TreeNode(queue.poll());
        Queue<Integer> smallQueue = new LinkedList<>();

        while (!queue.isEmpty() && queue.peek() < root.val) {
            smallQueue.offer(queue.poll());
        }

        root.left = getNode(smallQueue);
        root.right = getNode(queue);

        return root;
    }
}
