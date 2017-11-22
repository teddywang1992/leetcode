package no74_SearchA2DMatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] > target) {
                end = mid;
            } else if (matrix[row][col] < target) {
                start = mid;
            } else {
                return true;
            }
        }
        if (matrix[start / n][start % n] == target) return true;
        if (matrix[end / n][end % n] == target) return true;
        return false;
    }
}
