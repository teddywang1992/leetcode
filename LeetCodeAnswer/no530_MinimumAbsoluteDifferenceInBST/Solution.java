package no530_MinimumAbsoluteDifferenceInBST;

import java.util.Stack;

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
    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>(); 
        TreeNode cur = root, pre = null; 
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop(); 
                if (pre != null) 
                    min = Math.min(min, cur.val - pre.val); 
                pre = cur; 
                cur = cur.right; 
            }
        }
        return min; 
    }
}