package ebay;

import tree.TreeNode;

public class FindModeInBinarySearchTree {
    private int modeCount = 0;
    private int maxCount = 0;
    private int curValue;
    private int curCount = 0;

    private int[] result;

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];

        helper(root);
        result = new int[modeCount];
        curCount = 0;
        modeCount = 0;
        helper(root);
        return result;
    }

    private void process(int val) {
        if (val != curValue) {
            curValue = val;
            curCount = 0;
        }
        curCount++;

        if (curCount > maxCount) {
            maxCount = curCount;
            modeCount = 1;
        } else if (curCount == maxCount) {
            if (result != null) {
                result[modeCount] = curValue;
            }
            modeCount++;
        }
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        process(root.val);
        helper(root.right);
    }
}
