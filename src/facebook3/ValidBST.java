package facebook3;

import tree.TreeNode;

import java.util.Stack;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long. MAX_VALUE);
    }

    private boolean helper(TreeNode root, long minValue, long maxValue) {
        if (root == null) return true;
        if (root.val > minValue && root.val < maxValue) {
            return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);
        }

        return false;
    }

    public boolean isValidBST1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        pushNode(root, stack);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (pre != null && node.val <= pre.val) return false;
            pre = node;
            pushNode(node.right, stack);
        }
        return true;
    }

    private void pushNode(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}
