package facebook1;

public class SparseMatrixMultiplication1 {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colA = A[0].length;
        int rowB = B.length;
        int colB = B[0].length;
        if (colA != rowB) return null;

        int[][] C = new int[rowA][colB];

        for (int i = 0; i < rowA; i++) {
            for(int j = 0; j < colA; j++) {
                if (A[i][j] != 0) {
                    for (int k = 0; k < colB; k++) {
                        C[i][k] += A[i][j] * B[j][k];
                    }
                }
            }
        }

        return C;
    }
}
