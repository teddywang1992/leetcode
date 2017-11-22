package no230_KthSmallestElementInBST;

import helper.TreeNode;

import java.util.ArrayList;

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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> nums = new ArrayList<Integer>();
        helper(nums, root);
        return nums.get(k - 1);
    }
    private void helper(ArrayList<Integer> nums, TreeNode root) {
        if (root.left == null) {
            nums.add(root.val);
        } else {
            helper(nums, root.left);
            nums.add(root.val);
        }
        if (root.right != null) {
            helper(nums, root.right);
        }
    }
}
