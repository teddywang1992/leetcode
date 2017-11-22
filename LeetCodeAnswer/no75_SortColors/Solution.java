package no75_SortColors;

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int start = 0, end = nums.length -1;
        int i = 0;
        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, start, i);
                start++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                swap(nums, end, i);
                end--;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
