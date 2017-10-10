package ebay;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (r * c != m * n) return nums;

        int[][] result = new int[r][c];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                result[count / c][count % c] = nums[i][j];
                count++;
            }
        }

        return result;
    }
}
