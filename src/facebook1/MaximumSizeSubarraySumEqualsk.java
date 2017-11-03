package facebook1;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk {
    public static void main(String[] args) {
        int[] nums = {1, -1, 5, -2, 3};
        System.out.println(maxSubArrayLen(nums, 3));
    }

    private static int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int max = 0;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            else if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return max;
    }
}
