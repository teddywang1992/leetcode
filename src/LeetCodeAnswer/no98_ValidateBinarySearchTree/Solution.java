package LeetCodeAnswer.no98_ValidateBinarySearchTree;

import helper.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Result {
    boolean isBST;
    int max;
    int min;
    Result(boolean isBST, int max, int min) {
        this.isBST = isBST;
        this.max = max;
        this.min = min;
    }
}
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root).isBST;
    }
    private Result helper(TreeNode root) {
        if (root == null) return new Result(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        Result left = helper(root.left);
        Result right = helper(root.right);
        if (!left.isBST || !right.isBST) return new Result(false, 0, 0);
        if (root.left != null && left.max >= root.val || root.right != null && right.min <= root.val) return new Result(false, 0, 0);
        return new Result(true, Math.max(root.val, right.max), Math.min(root.val, left.min));
    }
}
