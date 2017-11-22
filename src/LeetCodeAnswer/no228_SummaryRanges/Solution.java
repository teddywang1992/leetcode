package LeetCodeAnswer.no228_SummaryRanges;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if (nums == null || nums.length == 0) return res;
        if (nums.length == 1) {
            res.add(new String(String.valueOf(nums[0])));
            return res;
        }
        String s = String.valueOf(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                continue;
            } else {
                if (s.equals(String.valueOf(nums[i - 1]))) {
                    res.add(new String(s));
                    s = String.valueOf(nums[i]);
                } else {
                    s = s + "->" + String.valueOf(nums[i - 1]);
                    res.add(new String(s));
                    s = String.valueOf(nums[i]);
                }
            }
        }
        if (nums[nums.length - 1] != nums[nums.length - 2] + 1) {
            res.add(new String(String.valueOf(nums[nums.length - 1])));
        } else {
            if (s.equals(String.valueOf(nums[nums.length - 1]))) {
                res.add(new String(s));
                return res;
            }
            s = s + "->" + String.valueOf(nums[nums.length - 1]);
            res.add(new String(s));
        }
        return res;
    }
}
