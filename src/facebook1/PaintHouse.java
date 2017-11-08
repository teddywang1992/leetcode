package facebook1;

public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null) return 0;
        int preRed= 0, preGreen = 0, preBlue = 0;
        for (int[] cost : costs) {
            int red = cost[0] + Math.min(preGreen, preBlue);
            int green = cost[1] + Math.min(preRed, preBlue);
            int blue = cost[2] + Math.min(preRed, preGreen);
            preRed = red;
            preGreen = green;
            preBlue = blue;
        }

        return Math.min(preRed, Math.min(preGreen, preBlue));
    }
}
