package LeetCodeAnswer.no163_MissingRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();
        int next = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < next) continue;
            if (nums[i] == next) {
              next++;
              continue;
            }
            res.add(getRange(next, nums[i] - 1));
            next = nums[i] + 1;
        }
        if (next == Integer.MIN_VALUE) return res;
        if (next <= upper) res.add(getRange(next, upper));
        return res;
    }
    private String getRange(int n1, int n2) {
        return (n1 == n2) ? String.valueOf(n1) : String.format("%d->%d", n1, n2);
    }
}