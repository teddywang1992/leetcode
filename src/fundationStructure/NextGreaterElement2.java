package fundationStructure;

//take care of the corner case that two digit are same
//so we need to store each time. so we can't use hashmap to do that.

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int[] result = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n = nums.length;
        Arrays.fill(result, -1);

        for (int i = 1; i < 2 * n; i++) {
            if (i < n + 1) {
                stack.push(i - 1);
            }

            while(!stack.isEmpty() && nums[(i % n)] > nums[stack.peek()]) {
                result[stack.pop()] = nums[i % n];
            }
        }

        return result;
    }
}
