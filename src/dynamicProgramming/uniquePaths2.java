package dynamicProgramming;

public class uniquePaths2 {
    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return -1;
        }
        //state
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] path = new int[m][n];

        //init
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0) {
                path[i][0] = 1;
            } else {
                break;
            }
        }
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0) {
                path[0][i] = 1;
            } else {
                break;
            }
        }

        //top down
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    path[i][j] = 0;
                } else {
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }

        //answer
        return path[m - 1][n - 1];
    }
}

