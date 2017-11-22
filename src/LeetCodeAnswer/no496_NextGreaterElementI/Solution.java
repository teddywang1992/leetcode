package LeetCodeAnswer.no496_NextGreaterElementI;

import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        // Naive solution, O(m * n)
        Map<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            valToIndex.put(nums[i], i);
        }
        
        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            result[i] = -1;
            int start = valToIndex.get(findNums[i]);
            
            for (int j = start + 1; j < nums.length; j++) {
                if (nums[j] > findNums[i]) {
                    result[i] = nums[j];
                    break;
                }
            }
        }
        
        return result;
        // O(n) from right to the left
        // Map<Integer, Integer> map = new HashMap<>();
        // Stack<Integer> stack = new Stack<>();
        // for(int i = nums.length-1; i >= 0; i--){
        //     while(!stack.empty() && nums[i]>stack.peek()) stack.pop();
        //     map.put(nums[i], (stack.empty())? -1 : stack.peek());
        //     stack.push(nums[i]);
        // }
        // for(int i = 0; i<findNums.length; i++){
        //     findNums[i] = map.get(findNums[i]);
        // }
        // return findNums;   
    }
}