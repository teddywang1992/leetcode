package no494_TargetSum;

//public class Solution {
//    public int findTargetSumWays(int[] nums, int s) {
//        int sum = 0; 
//        for(int i: nums) sum += i;
//        if(s > sum || s < -sum) return 0;
//        int[] dp = new int[2 * sum + 1];
//        dp[sum] = 1;
//        for(int i = 0; i < nums.length; i++){
//            int[] next = new int[2 * sum + 1];
//            for(int k = 0; k < 2 * sum + 1; k++){
//                if(dp[k] != 0){
//                    next[k + nums[i]] += dp[k];
//                    next[k - nums[i]] += dp[k];
//                }
//            }
//            dp = next;
//        }
//        return dp[sum+s];
//    }
//}

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum < S || S < -sum) return 0;
        // So start with a two dimensional array dp[i][j] 
        // which means the number of ways for first i-th element to reach a sum j
        // dp[i][j] = dp[i-1][j+nums[i]] + dp[i-1][j-nums[i]
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][sum] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i - 1] <= 2 * sum) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum + S];
    }
}