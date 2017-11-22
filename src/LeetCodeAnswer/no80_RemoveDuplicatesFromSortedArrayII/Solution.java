package LeetCodeAnswer.no80_RemoveDuplicatesFromSortedArrayII;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 1, left = 1, length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                if (count == 2) continue;
                count++;
            } else {
                count = 1;
            }
            nums[left++] = nums[i];
            length++;
        }
        return length;
    }
}