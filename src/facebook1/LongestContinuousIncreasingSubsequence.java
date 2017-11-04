package facebook1;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int start = 0;
        int end = 0;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                end = i;
            } else {
                max = Math.max(max, end - start + 1);
                start = i;
                end = i;
            }
        }
        max = Math.max(max, end - start + 1);
        return max;
    }

    public int findLengthOfLCIS1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(max, dp[i]);
            }
            else dp[i] = 1;
        }

        return max;
    }
}
