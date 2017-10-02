package ebay;
import tree.TreeNode;

public class arrayNumsToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode current = new TreeNode(nums[mid]);

        TreeNode left = helper(nums, start, mid - 1);
        TreeNode right = helper(nums, mid + 1, end);

        return current;
    }
}
