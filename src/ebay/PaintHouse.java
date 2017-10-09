package ebay;

public class PaintHouse {
    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) return 0;

        int preRed = 0;
        int preBlue = 0;
        int preGreen = 0;
        for (int[] color : costs) {
            int red = color[0] + Math.min(preBlue, preGreen);
            int blue = color[1] + Math.min(preRed, preGreen);
            int green = color[2] + Math.min(preRed, preBlue);
            preRed = red;
            preBlue = blue;
            preGreen = green;
        }

        return Math.min(preRed, Math.min(preBlue, preGreen));
    }
}
