package dynamicProgramming;

/*
if the previous status is cooldown. the result doesn't change so we define two new variables for them.
the one is preBuy. The other one is presell.
*/

public class BestTimeToBuyAndSellStock5 {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int preSell = 0;
        int buy = Integer.MIN_VALUE;
        int preBuy = 0;

        for (int price : prices) {
            preBuy = buy;
            buy = Math.max(preBuy, preSell - price);

            preSell = sell;
            sell = Math.max(preSell, preBuy + price);
        }

        return sell;
    }
}
