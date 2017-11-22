package no311_SparseMatrixMultiplication;

public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int col = A[0].length;
        int m = A.length, n = B[0].length;
        int[][] res = new int[m][n];
        // i: A row
        // j: A col, B row
        // k: B col
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < col; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < n; k++) {
                        if (B[j][k] != 0) res[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }
        return res;
        
    }
}
