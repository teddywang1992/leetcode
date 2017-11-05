package facebook1;

public class MaximalSquare {
    // Top, Left, and Top Left decides the size of the square. If all of them are same, then the size of square increases by 1.
    // If they're not same, they can increase by 1 to the minimal square. If you take an example and work it out,
    //     it'll be much easier to understand when it comes to dynamic programing. :)
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        int max = 0;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (matrix[i- 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max * max;
    }
}
