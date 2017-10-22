package microsoft;

import tree.TreeNode;

public class LargestBSTSubtree {
    int max = 0;
    public int largestBSTSubtree(TreeNode root) {
        if (root == null) return 0;
        traverse(root);
        return max;
    }

    private Result traverse(TreeNode root) {
        if (root == null) return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        Result left = traverse(root.left);
        Result right = traverse(root.right);
        if (left.size == -1 || right.size == -1 || root.val <= left.upper || root.val >= right.lower) return new Result(-1, Integer.MAX_VALUE, Integer.MIN_VALUE);

        int size = 1 + left.size + right.size;
        max = Math.max(size, max);
        return new Result(size, Math.min(root.val, left.lower), Math.max(root.val, right.upper));
    }

    class Result {
        public int upper;
        public int lower;
        public int size;
        public Result(int size, int lower, int upper) {
            this.size = size;
            this.lower = lower;
            this.upper = upper;
        }
    }
}
