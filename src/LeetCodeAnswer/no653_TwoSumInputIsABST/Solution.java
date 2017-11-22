package LeetCodeAnswer.no653_TwoSumInputIsABST;

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
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> leftStack = new Stack<TreeNode>(), rightStack = new Stack<TreeNode>();
        stackAdd(leftStack, root, true);
        stackAdd(rightStack, root, false);
        while (leftStack.peek() != rightStack.peek()) {
            int sum = leftStack.peek().val + rightStack.peek().val;
            if (sum == k) return true;
            if (sum > k) {
                stackNext(rightStack, false);
            } else {
                stackNext(leftStack, true);
            }
        }
        return false;
    }
    
    private void stackAdd(Stack<TreeNode> stack, TreeNode root, boolean isLeft) {
        while (root != null) {
            if (isLeft) {
                stack.push(root);
                root = root.left;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
    }
    
    private void stackNext(Stack<TreeNode> stack, boolean isLeft) {
        TreeNode node = stack.pop();
        if (isLeft) {
            stackAdd(stack, node.right, true);
        } else {
            stackAdd(stack, node.left, false);
        }
    }
}