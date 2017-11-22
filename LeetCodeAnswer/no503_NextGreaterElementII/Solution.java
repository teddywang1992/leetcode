package no503_NextGreaterElementII;

import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        // naive O(n * n)
        // int n = nums.length;
        // int[] result = new int[n];
        // for (int i = 0; i < n; i++) {
        //     result[i] = -1;
        //     int j = 0;
        //     for (j = i + 1; j < n; j++) {
        //         if (nums[j] > nums[i]) {
        //             result[i] = nums[j];
        //             break;
        //         }
        //     }
        //     if (j == n) {
        //         for (j = 0; j < i; j++) {
        //             if (nums[j] > nums[i]) {
        //                 result[i] = nums[j];
        //                 break;
        //             }
        //         }
        //     }
        // }
        // return result;
        
        // O(n) Using a stack
        int n = nums.length;
        int[] result = new int[n];
        
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = n - 1; i >= 0; i--) {
            stack.push(i);
        }
        
        for (int i = n - 1; i >= 0; i--) {
            result[i] = -1;
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()){
                result[i] = nums[stack.peek()];
            }
            stack.add(i);
        }
        
        return result;
    }
}
