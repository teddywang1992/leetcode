package LeetCodeAnswer.no581_ShortestUnsortedContinuousSubarray;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length < 2) return 0;
        int start = -1, end = -2, min = nums[nums.length - 1], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - 1 - i]);
            if (nums[i] < max) end = i;
            if (nums[nums.length - 1 - i] > min) start = nums.length - 1 - i;
        }
        return end - start + 1;
    }
}
