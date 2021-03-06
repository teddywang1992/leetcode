package LeetCodeAnswer.no437_PathSumIII;

import helper.TreeNode;

public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    public int findPath(TreeNode root, int sum){
        int res = 0;
        if(root == null)
            return res;
        if(sum == root.val)
            res++;
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }
}