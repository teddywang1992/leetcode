package array;

public class DimondMining {
    public static int collect_max(int[][] mat){
        if (mat == null || mat.length == 0 ||
                mat[0].length == 0){
            return 0;
        }

        int n = mat.length;
        int m = mat[0].length;
        int p = m + n - 2;

        int[][][] dp = new int[m+n][n][n];
        dp[0][0][0] = mat[0][0];

        for (int k = 1; k <= p; k++){
            for (int i = 0; i < n; i++){
                for (int j = i; j < n; j++){
                    dp[k][i][j] = -1;
                }
            }
        }

        for (int k = 1; k <= p; k++){
            for (int i = 0; i < n; i++){
                for (int j = i; j < n; j++){
                    if (!isValid(k, i, j, mat) || dp[k][i][j] < 0){
                        continue;
                    }

                    if (isValid(k + 1, i + 1, j + 1, mat)) {
                        dp[k + 1][i + 1][j + 1] = Math.max(dp[k + 1][i + 1][j + 1], dp[k][i][j] + mat[i + 1][k - i] + (i == j ? 0 : mat[j + 1][k - j]));
                    }

                    if (isValid(k + 1, i, j + 1, mat)) {
                        dp[k + 1][i][j + 1] = Math.max(dp[k + 1][i][j + 1], dp[k][i][j] + mat[i][k + 1 - i] + (i == j + 1 ? 0 : mat[j + 1][k - j]));
                    }

                    if (isValid(k + 1, i + 1, j, mat)) {
                        dp[k + 1][i + 1][j] = Math.max(dp[k + 1][i + 1][j], dp[k][i][j] + mat[i + 1][k - i] + (i + 1 == j ? 0 : mat[j][k + 1 - j]));
                    }

                    if (isValid(k + 1, i, j, mat)) {
                        dp[k + 1][i][j] = Math.max(dp[k + 1][i][j], dp[k][i][j] + mat[i][k + 1 - i] + (i == j ? 0 : mat[j][k + 1 - j]));
                    }
                }
            }
        }
        return dp[p][m-1][m-1] < 0 ? 0 : dp[p][m-1][m-1];
    }

    public static boolean isValid(int step, int rowi, int rowj, int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int coli = step - rowi;
        int colj =  step - rowj;

        boolean res = (rowi >= 0) && (rowi < n) && (rowj >= 0) && (rowj < n) &&
                (coli >= 0) && (coli < m) && (colj >= 0) && (colj < m) &&
                (mat[rowi][coli] != -1) && (mat[rowj][colj] != -1);

        return res;
    }
}
