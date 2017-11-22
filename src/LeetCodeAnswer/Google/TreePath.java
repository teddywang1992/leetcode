package LeetCodeAnswer.Google;

import LeetCodeAnswer.helper.TreeNode;

public class TreePath {
	public static int treePath(TreeNode root) {
		if (root == null) return 0;
		if (root.left == null && root.right == null) return root.val;
		int left = treePath(root.left);
		int right = treePath(root.right);
		if (root.left != null) {
			left = Integer.parseInt(String.valueOf(root.val) + String.valueOf(left));
		}
		if (root.right != null) {
			right = Integer.parseInt(String.valueOf(root.val) + String.valueOf(right));
		}
		return left + right;
	}
	public static int f(int x, int y) {
		if (x == 0) return 0;
		if (x == 1) return y;
		return f(x-1,y) + f(x-2,y) + y;
	}
	
	public static int test(TreeNode root, int v) {
		if (root == null) return -1;
		if (v < root.val) {
			return 2 * test(root.left, v);
		} else if (v == root.val) {
			return 0;
		} else {
			return 2 * test(root.right, v) + 1;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(36);
		root.left = new TreeNode(8);
		root.right = new TreeNode(50);
		root.left.left = new TreeNode(6);
		root.left.right = new TreeNode(22);
		root.right.left = new TreeNode(45);
		root.right.right = new TreeNode(107);
		root.left.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(7);
		root.left.right.left = new TreeNode(20);
		root.left.right.right = new TreeNode(35);
		root.right.left.left = new TreeNode(40);
		root.right.left.right = new TreeNode(47);
		root.right.right.left = new TreeNode(99);
		root.right.right.right = new TreeNode(1001);
//		System.out.println(treePath(root));
		for (int i = 0; i <= 2000; i++) {
			if (test(root, i) == 7) System.out.println(i);
		}
	}
}
