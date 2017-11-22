package LeetCodeAnswer.Amazon;

public class RotateMatrix {
	public static int[][] rotate(int[][] matrix, int flag) {
		if (matrix == null || matrix.length == 0)
			return matrix;
		int m = matrix.length, n = matrix[0].length;
		// transpose
		int[][] res = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				res[j][i] = matrix[i][j];
		}
		
		// rotate
		if (flag == 1) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m / 2; j++) {
					int tmp = res[i][j];
					res[i][j] = res[i][m - 1 - j];
					res[i][m - 1 - j] = tmp;
				}
			}
		} else {
			for (int j = 0; j < m; j++) {
				for (int i = 0; i < n / 2; i++) {
					int tmp = res[i][j];
					res[i][j] = res[n - 1 - i][j];
					res[n - 1 - i][j] = tmp;
				}
			}
		}
		return res;
	}

	public static void printMatrix(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(matrix[i][j] + " ");
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		int[][] input = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] output1 = rotate(input, 0);
		int[][] output2 = rotate(input, 1);
		System.out.println("input");
		printMatrix(input);
		System.out.println("output1");
		printMatrix(output1);
		System.out.println("output2");
		printMatrix(output2);
	}
}
