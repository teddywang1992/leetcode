package binarySearch;

public class searchA2DMatrix {
    public static void main(String[] args) {
        int[][] test = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        searchA2DMatrix obj = new searchA2DMatrix();
        System.out.println(obj.searchMatrix(test, 5));

    }

    private boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int start = 0;
        int end = m * n - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] == target) {
                return true;
            }
            if (matrix[row][col] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        return (matrix[start / n][start % n] == target) || (matrix[end / n][end % n] == target);
    }
}
