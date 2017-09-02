package array;

public class bestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] test = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(test));
    }
    private static int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0) {
            return Integer.MAX_VALUE;
        }

        int profit = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }

        return profit;
    }
}
