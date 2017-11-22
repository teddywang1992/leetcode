package no73_SetMatrixZeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix == null) return;
        int M = matrix.length, N = matrix[0].length;
        boolean topZero = false, leftZero = false;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) topZero = true;
                    if (j == 0) leftZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < M; i++) {
            if (matrix[i][0] == 0) {
                for (int q = 1; q < N; q++) matrix[i][q] = 0;
            }
        }
        for (int i = 1; i < N; i++) {
            if (matrix[0][i] == 0) {
                for (int q = 1; q < M; q++) matrix[q][i] = 0;
            }
        }
        if (topZero) {
            for (int q = 0; q < N; q++) matrix[0][q] = 0;
        }
        if (leftZero) {
            for (int q = 0; q < M; q++) matrix[q][0] = 0;
        }
    }
}
