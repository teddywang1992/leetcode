package no270_ClosestBinarySearchTreeValue;

import helper.TreeNode;


public class Solution {
    public int closestValue(TreeNode root, double target) {
        double min = Math.abs(target - root.val);
        int minVal = root.val;
        while (root != null) {
            if (root.val < target) {
                root = root.right;
                if (root ==null) break;
                double cur = Math.abs(target - root.val);
                if (cur < min) {
                    min = cur;
                    minVal = root.val;
                }
            } else {
                root = root.left;
                if (root ==null) break;
                double cur = Math.abs(target - root.val);
                if (cur < min) {
                    min = cur;
                    minVal = root.val;
                }
            }
        }
        return minVal;
    }
}