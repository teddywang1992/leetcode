package facebook1;

import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubarraySumEqualsk1 {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) max = i + 1;
            else if (map.containsKey(sum - k)) max = Math.max(max, i - map.get(sum - k));
            map.putIfAbsent(sum, i);
        }

        return max;
    }
}
