package LeetCodeAnswer.no124_BinaryTreeMaximumPathSum;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

class Result {
	int root2Any;
	int any2Any;

	public Result(int root2Any, int any2Any) {
		this.root2Any = root2Any;
		this.any2Any = any2Any;
	}
}

public class Solution {
	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		return helper(root).any2Any;
	}

	private Result helper(TreeNode root) {
		if (root == null)
			return new Result(0, Integer.MIN_VALUE);
		Result left = helper(root.left);
		Result right = helper(root.right);

		int root2Any = Math.max(0, Math.max(left.root2Any, right.root2Any))
				+ root.val;
		int any2Any = Math.max(0, left.root2Any) + Math.max(0, right.root2Any)
				+ root.val;
		any2Any = Math.max(any2Any, Math.max(left.any2Any, right.any2Any));
		any2Any = Math.max(any2Any, root2Any);
		return new Result(root2Any, any2Any);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		TreeNode root = new TreeNode(-3);
		System.out.println(solution.maxPathSum(root));

	}

}
