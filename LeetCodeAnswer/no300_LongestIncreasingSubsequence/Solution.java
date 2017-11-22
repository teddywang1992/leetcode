package no300_LongestIncreasingSubsequence;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] f = new int[nums.length];
        for (int i = 0; i < nums.length; i++) f[i] = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
        }
        
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
