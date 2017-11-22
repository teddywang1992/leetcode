package LeetCodeAnswer.no121_BestTimeToBuyAndSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int buy = prices[0], ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
                continue;
            }
            if (prices[i] - buy > ans) {
                ans = prices[i] - buy;
            }
        }
        return ans;
    }
}
