package LeetCodeAnswer.no173_BinarySearchTreeIterator;

import helper.TreeNode;

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
//    private Stack<TreeNode> stack = new Stack<TreeNode>();
//    private TreeNode cur;
//    public BSTIterator(TreeNode root) {
//        cur = root;
//    }
//
//    /** @return whether we have a next smallest number */
//    public boolean hasNext() {
//        return (cur != null || !stack.isEmpty());
//    }
//
//    /** @return the next smallest number */
//    public int next() {
//        while (cur != null) {
//            stack.push(cur);
//            cur = cur.left;
//        }
//        cur = stack.pop();
//        TreeNode node = cur;
//        cur = cur.right;
//        return node.val;
//
//    }
	private Stack<TreeNode> stack = new Stack<>();
	public BSTIterator(TreeNode root) {
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}
	
	public boolean hasNext() {
		return !stack.isEmpty();
	}
	
	public int next() {
		TreeNode node = stack.pop(), tmp = node.right;
		while (tmp != null) {
			stack.push(tmp);
			tmp = tmp.left;
		}
		return node.val;
	}
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
