package FacebookInterview;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        if(nums == null){
            return 0;
        }
        int n = nums.length, res = 0;
        int[] dp = new int[n]; //dp[i]表示前i+1个数字中以第i+1个数nums[i]结尾的LIS的长度
        Arrays.fill(dp, 1);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
