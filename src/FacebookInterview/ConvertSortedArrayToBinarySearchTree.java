package FacebookInterview;

import tree.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode current = new TreeNode(nums[mid]);

        current.left = helper(nums, start, mid - 1);
        current.right = helper(nums, mid + 1, end);

        return current;
    }
}
