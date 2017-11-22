package LeetCodeAnswer.no410_SplitArrayLargestSum;

public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for (int num: nums) {
            max = Math.max(max, num);
            sum += num;
        }
        return (int)binary(nums, m, sum, max);
    }
    private long binary(int[] nums, int m, long end, long start) {
        long mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (valid(nums, m, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (valid(nums, m, start)) {
            return start;
        } else {
            return end;
        }
    }
    private boolean valid(int[] nums, int m, long max) {
        int cur = 0;
        int count = 1;
        for (int num: nums) {
            cur += num;
            if (cur > max) {
                cur = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }
}