package microsoft;

public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) return 0;

        int m = dungeon.length - 1;
        int n = dungeon[0].length - 1;
        int[][] dp = new int[dungeon.length][dungeon[0].length];
        dp[m][n] = Math.max(1, 1 - dungeon[m][n]);

        for (int i = m; i >= 1; i--) {
            dp[i - 1][n] = Math.max(1, dp[i][n] - dungeon[i - 1][n]);
        }

        for (int i = n; i >= 1; i--) {
            dp[m][i - 1] = Math.max(1, dp[m][i] - dungeon[m][i - 1]);
        }

        for (int i = m; i >= 1; i--) {
            for (int j = n; j >= 1; j--) {
                dp[i - 1][j - 1] = Math.max(1, Math.min(dp[i][j - 1] - dungeon[i - 1][j - 1], dp[i - 1][j] - dungeon[i - 1][j - 1]));
            }
        }

        return dp[0][0];
    }
}
