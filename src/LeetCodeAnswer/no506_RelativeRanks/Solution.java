package LeetCodeAnswer.no506_RelativeRanks;

import java.util.Arrays;

public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int min = nums[0], max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            } else if (nums[i] > max) {
                max = nums[i];
            }
        }
        int[] index = new int[max - min + 1];
        Arrays.fill(index, -1);
        for (int i = 0; i < nums.length; i++) {
            index[nums[i] - min] = i;
        }
        String[] res = new String[nums.length];
        int order = 1;
        for (int i = index.length - 1; i >= 0; i--) {
            if (index[i] == -1) continue;
            if (order == 1) {
                res[index[i]] = "Gold Medal";
            } else if (order == 2) {
                res[index[i]] = "Silver Medal";
            } else if (order == 3) {
                res[index[i]] = "Bronze Medal";
            } else {
                res[index[i]] = String.valueOf(order);
            }
            order++;
        }

        return res;
    }
}