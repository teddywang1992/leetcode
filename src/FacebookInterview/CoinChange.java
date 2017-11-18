package FacebookInterview;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.sort(coins);
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) continue;
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    min = Math.min(min, dp[i-coin] + 1);
                }
            }
            dp[i] = min;
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
