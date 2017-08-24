package dynamicProgramming;

public class uniquePaths {
    public static void main(String[] args) {
        uniquePaths obj = new uniquePaths();
        System.out.println(obj.uniquePaths(3, 7));
    }
    private int uniquePaths(int m, int n) {
        //state
        int[][] f = new int[m][n];

        //init
        for(int i = 0; i < m; i++) {
            f[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            f[0][i] = 1;
        }

        //top down
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }

        //answer
        return f[m - 1][n - 1];
    }
}
