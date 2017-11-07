package facebook1;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                min = Math.min(min, right - left);
                sum -= nums[left++];
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
