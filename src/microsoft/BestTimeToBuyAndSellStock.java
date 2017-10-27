package microsoft;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }

        return max;
    }
}
