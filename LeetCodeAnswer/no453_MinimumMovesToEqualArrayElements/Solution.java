package no453_MinimumMovesToEqualArrayElements;

public class Solution {
    public int minMoves(int[] nums) {
        if (nums.length <= 1) return 0;
        int min = Integer.MAX_VALUE;
        for(int i : nums){
            min = Math.min(i, min);
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]-min;
        }
        return sum;
    }
}
