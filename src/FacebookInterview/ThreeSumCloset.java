package FacebookInterview;

import java.util.Arrays;

public class ThreeSumCloset {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        if (nums == null || nums.length < 3) return 0;

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(diff) > Math.abs(target - sum)) {
                    diff = target - sum;
                }
                if (sum < target) {
                    left++;
                } else if (sum >= target) {
                    right--;
                }
            }
        }

        return target - diff;
    }
}
