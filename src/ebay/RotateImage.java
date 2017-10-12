package ebay;

public class RotateImage {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        int m = matrix.length;
        int[][] temp = new int[m][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                temp[i][j] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = temp[m - j - 1][i];
            }
        }
    }
}
