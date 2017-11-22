package LeetCodeAnswer.no543_DiameterOfBinaryTree;

import helper.TreeNode;

class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);
        int throughRoot = maxDepth(root.left) + maxDepth(root.right);
        return Math.max(left, Math.max(right, throughRoot));
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    } 
}