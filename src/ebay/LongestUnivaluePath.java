package ebay;
//687. Longest Univalue Path
import tree.TreeNode;

public class LongestUnivaluePath {
    public int longestUnivaluePath(TreeNode root) {
        int[] max = new int[1];
        max[0] = 0;
        if (root == null) return 0;
        dfs(root, max);
        return max[0];
    }

    private int dfs(TreeNode root, int[] max) {
        int left = (root.left != null) ? dfs(root.left, max) : 0;
        int right = (root.right != null) ? dfs(root.right, max) : 0;
        int leftValue = (root.left != null && root.val == root.left.val) ? left + 1 : 0;
        int rightValue = (root.right != null && root.val == root.right.val) ? right + 1 : 0;
        max[0] = Math.max(max[0], leftValue + rightValue);

        return Math.max(leftValue, rightValue);
    }
}
