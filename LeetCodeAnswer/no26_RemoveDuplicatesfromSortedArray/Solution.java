package no26_RemoveDuplicatesfromSortedArray;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0, count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[left]) {
                nums[left + 1] = nums[i];
                left++;
                count++;
            } else {
                continue;
            }
        }
        return count;
    }
}
