package no337_HouseRobberIII;

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
public class Solution {
    public int rob(TreeNode root) {
        if (root == null) return 0;
        return Math.max(dfs(root, false), root.val + dfs(root, true));
    }
    private int dfs(TreeNode root, boolean visited) {
        if (root == null) return 0;
        int left = 0, right = 0;
        if (visited) {
            left = dfs(root.left, false);
            right = dfs(root.right, false);
        } else {
            if (root.left != null) left = Math.max(dfs(root.left, false), root.left.val + dfs(root.left, true));
            if (root.right != null) right = Math.max(dfs(root.right, false), root.right.val + dfs(root.right, true));
        }
        return left + right;
    }
}
