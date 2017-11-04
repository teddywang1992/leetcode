package facebook1;

import tree.TreeNode;

public class ValidateBinarySearchTree {
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
}
