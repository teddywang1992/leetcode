package LeetCodeAnswer.no70_ClimbingStairs;

public class Solution {
    public int climbStairs(int n) {
        // if (n == 1) return 1;
        // if (n == 2) return 2;
        // int[] dp = new int[n + 1];
        // dp[0] = 0;
        // dp[1] = 1;
        // dp[2] = 2;
        // for (int i = 3; i <= n; i++) {
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];
        
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        
        int one = 2;
        int two = 1;
        int res = 0;
        
        for(int i=2; i<n; i++){
        	res = one + two;
        	two = one;
            one = res;
        }
        return res;
    }
}