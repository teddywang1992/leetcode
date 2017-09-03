package dataStructure;

import java.util.Stack;

public class largestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }
    private static int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) {
            return 0;
        }

        int max = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <= heights.length; i++) {
            int current = (i == heights.length) ? Integer.MIN_VALUE : heights[i];
            while(!stack.isEmpty() && current < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = (stack.isEmpty()) ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }

        return max;
    }
}
