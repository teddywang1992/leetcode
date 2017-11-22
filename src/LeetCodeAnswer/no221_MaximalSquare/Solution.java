package LeetCodeAnswer.no221_MaximalSquare;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int ans = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = (int)(matrix[i][0] - '0');
            ans = Math.max(ans, dp[i][0]);
            for (int j = 1; j < m; j++) {
                if (i > 0) {
                    if (matrix[i][j] == '1') {
                        dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                    }
                } else {
                    dp[i][j] = (int)(matrix[i][j] - '0');
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }
}
