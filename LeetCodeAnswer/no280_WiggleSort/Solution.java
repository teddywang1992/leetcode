package no280_WiggleSort;

import java.util.Arrays;

public class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        if (nums.length < 3) return;
        for (int i = 1; i < nums.length - 1; i++) {
            swap(nums, i, i+ 1);
            i++;
        }
        return;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
