package facebook1;

public class PaintHouseII {
    // So I have three variable to record: prevMin, prevMinColor, prevSecondMin. and the above formula will be translated into:
    //dp[currentHouse][currentColor] = (currentColor == prevMinColor? prevSecondMin: prevMin) + costs[currentHouse][currentColor].
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;
        int preMin1 = 0, preMin2 = preMin1, preColor = -1;
        int k = costs[0].length;
        for (int[] cost : costs) {
            int min1 = Integer.MAX_VALUE, min2 = min1, color = -1;
            for (int i = 0; i < k; i++) {
                int val = ((i == preColor) ? preMin2 : preMin1) + cost[i];
                if (val < min1) {
                    min2 = min1;
                    min1 = val;
                    color = i;
                } else if (val < min2) {
                    min2 = val;
                }
            }
            preMin1 = min1;
            preMin2 = min2;
            preColor = color;
        }

        return preMin1;
    }
}
