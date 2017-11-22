package no27_RemoveElement;

public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int pos = 0, length = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[pos] = nums[i];
                pos++;
                length++;
            } else {
                
            }
        }
        return length;
    }
}