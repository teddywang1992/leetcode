package LeetCodeAnswer.no285_InorderSuccessorInBST;

import helper.TreeNode;

public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;
        if (root.val <= p.val) return inorderSuccessor(root.right, p);
        TreeNode left = inorderSuccessor(root.left, p);
        if (left == null) return root;
        return left;
    }
}