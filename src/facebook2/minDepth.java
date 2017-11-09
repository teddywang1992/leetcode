package facebook2;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class minDepth {
    //    min depth of BT
    // recursive method
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return traverse(root, 0);
    }
    private int traverse(TreeNode root, int depth) {
        depth++;
        if (root.left == null && root.right == null) {
            return depth;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null) {
            left = traverse(root.left, depth);
        }
        if (root.right != null) {
            right = traverse(root.right, depth);
        }
        return Math.min(left, right);
    }

    // iterative method
    private int findMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        int level = 0;
        int result = 0;
        nodes.offer(root);
        while (result == 0) {
            level++;
            int size = nodes.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                if (node.left == null && node.right == null) {
                    result = level;
                }
                if (node.left != null) {
                    nodes.offer(node.left);
                }
                if (node.right != null) {
                    nodes.offer(node.right);
                }
            }
        }
        return result;
    }
}
