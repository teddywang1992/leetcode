package LeetCodeAnswer.no59_SpiralMatrixII;

public class Solution {
    public int[][] generateMatrix(int n) {
        int rowBegin = 0, colBegin = 0;
        int rowEnd = n - 1, colEnd = n - 1;
        int[][] res = new int[n][n];
        int count = 1;
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            for (int j = colBegin; j <= colEnd; j++) {
                res[rowBegin][j] = count++;
            }
            rowBegin++;
            for (int j = rowBegin; j <= rowEnd; j ++) {
                 res[j][colEnd] = count++;
            }
            colEnd--;
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j --) {
                    res[rowEnd][j] = count++;
                }
            }
            rowEnd--;
            if (colBegin <= colEnd) {
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res[j][colBegin] = count++;
                }
            }
            colBegin++;
        }
        return res;
    }
}