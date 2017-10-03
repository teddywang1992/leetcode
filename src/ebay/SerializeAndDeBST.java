package ebay;

//449. Serialize and Deserialize BST

import tree.TreeNode;
import tree.constantTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SerializeAndDeBST {
    public static void main(String[] args) {
        TreeNode root = constantTree.returnRoot();
        System.out.println(serialize(root));
    }

    private static String serialize(TreeNode root) {
        if (root == null) return "null";

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

    private static TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }

        String[] strings = data.split(",");
        Queue<Integer> queue = new LinkedList<>();

        for (String string : strings) {
            queue.offer(Integer.valueOf(string));
        }

        return getNode(queue);
    }

    private static TreeNode getNode(Queue<Integer> queue) {
        if (queue.isEmpty()) return null;

        Queue<Integer> smallQueue = new LinkedList<>();
        TreeNode root = new TreeNode(queue.poll());

        while (!queue.isEmpty() && queue.peek() < root.val) {
            smallQueue.offer(queue.poll());
        }

        root.left = getNode(smallQueue);
        root.right = getNode(queue);

        return root;
    }
}
