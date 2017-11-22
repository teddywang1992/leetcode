package LeetCodeAnswer.no153_FindMinimumInRotatedSortedArray;

public class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        // if (nums[0] < nums[nums.length - 1]) return nums[0];
        int target = nums[nums.length - 1];
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (nums[start] < target) {
            return nums[start];
        }
        if (nums[end] < target) {
            return nums[end];
        }
        return nums[nums.length - 1];
    }
}