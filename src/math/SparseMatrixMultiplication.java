package math;

public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] A, int[][] B) {
        if (A == null || A.length == 0 || A[0].length == 0) {
            return null;
        }

        int mA = A.length;
        int nA = A[0].length;
        int nB = B[0].length;
        int[][] C = new int[mA][nB];

        for (int i = 0; i < mA; i++) {
            for (int k = 0; k < nA; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < nB; j++) {
                        C[i][j] += A[i][k] * B[k][j];
                    }
                }
            }
        }

        return C;
    }
}
