package LeetCodeAnswer.no325_MaximumSizeSubarraySumEqualsK;

import java.util.HashMap;

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int res = 0;
        if (nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) res = i + 1;
            if (map.containsKey(sum - k)) {
                res = Math.max(res, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) map.put(sum, i);
        }
        return res;
    }
}