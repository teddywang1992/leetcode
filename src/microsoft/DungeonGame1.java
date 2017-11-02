package microsoft;

public class DungeonGame1 {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return -1;
        int row = dungeon.length - 1;
        int col = dungeon[0].length - 1;
        int[][] dp = new int[row + 1][col + 1];

        dp[row][col] = Math.max(1, 1 - dungeon[row][col]);

        for (int i = row - 1; i >= 0; i--) {
            dp[i][col] = Math.max(1, dp[i + 1][col] - dungeon[i][col]);
        }

        for (int i = col - 1; i >= 0; i--) {
            dp[row][i] = Math.max(1, dp[row][i + 1] - dungeon[row][i]);
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                dp[i][j] = Math.max(1, Math.min(dp[i + 1][j] - dungeon[i][j], dp[i][j + 1] - dungeon[i][j]));
            }
        }

        return dp[0][0];
    }
}
