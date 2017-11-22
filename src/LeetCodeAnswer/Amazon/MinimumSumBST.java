package LeetCodeAnswer.Amazon;

import LeetCodeAnswer.helper.TreeNode;

public class MinimumSumBST {
    public int helper(TreeNode root) {
        if (root == null)   return 0;
        if (root.left != null && root.right == null)
            return helper(root.left) + root.val;
        if (root.left == null && root.right != null)
            return helper(root.right) + root.val;
        return Math.min(helper(root.left), helper(root.right)) + root.val;
    }
}
