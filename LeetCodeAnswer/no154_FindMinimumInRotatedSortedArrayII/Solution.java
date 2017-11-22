package no154_FindMinimumInRotatedSortedArrayII;

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            res = Math.min(res, nums[i]);
        }
        return res;
    }
}
