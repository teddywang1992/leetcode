package ebay;

import tree.TreeNode;

public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        TreeNode kid = (root.val < target) ? root.right : root.left;
        if (kid == null) return root.val;
        int close = closestValue(kid, target);
        return Math.abs(root.val - target) < Math.abs(close - target) ? root.val : close;
    }
}
