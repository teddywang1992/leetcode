package FacebookInterview;

import tree.TreeNode;

public class MaximumBinaryTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length- 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int maxIndex = start;
        for (int i = start; i <= end; i++) {
            if (nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = helper(nums, start, maxIndex - 1);
        root.right = helper(nums, maxIndex + 1, end);
        return root;
    }
}
