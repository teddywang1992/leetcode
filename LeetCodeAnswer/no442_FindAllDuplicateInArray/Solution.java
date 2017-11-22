package no442_FindAllDuplicateInArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return result;
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0) {
                result.add(Math.abs(index+1));
            } else {
                nums[index] = -nums[index];
            }
        }
        return result;
    }
}