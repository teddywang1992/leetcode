package array;

import java.util.Stack;

public class maximalRectangle {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0' ,'0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};
        System.out.println(maximalRectangle(matrix));

    }

    private static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] heights = new int[m][n + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    heights[i][j] = 0;
                } else if (i == 0) {
                    heights[i][j] = 1;
                } else {
                    heights[i][j] = heights[i - 1][j] + 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            max = Math.max(max, largestArea(heights[i]));
        }

        return max;
    }

    private static int largestArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int max = Integer.MIN_VALUE;

        for (int i = 0; i <= heights.length; i++) {
            int current = i == heights.length ? Integer.MIN_VALUE : heights[i];
            while (!stack.isEmpty() && current <= heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
            stack.push(i);
        }

        return max;
    }
}
