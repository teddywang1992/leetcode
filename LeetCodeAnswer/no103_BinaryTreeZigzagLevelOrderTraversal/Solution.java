package no103_BinaryTreeZigzagLevelOrderTraversal;

import helper.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        Stack<TreeNode> currLevel = new Stack<TreeNode>();
        Stack<TreeNode> nextLevel = new Stack<TreeNode>();
        currLevel.push(root);
        boolean normalOrder = true;
        
        while (!currLevel.isEmpty()) {
            List<Integer> currLevelResult = new ArrayList<Integer>();
            while (!currLevel.isEmpty()) {
                TreeNode node = currLevel.pop();
                currLevelResult.add(node.val);
                if (normalOrder) {
                    if (node.left != null) nextLevel.push(node.left);
                    if (node.right != null) nextLevel.push(node.right);
                } else {
                    if (node.right != null) nextLevel.push(node.right);
                    if (node.left != null) nextLevel.push(node.left);
                }
            }
            res.add(currLevelResult);
            currLevel = nextLevel;
            nextLevel = new Stack<TreeNode>();
            normalOrder = !normalOrder;
        }
        return res;
    }
}