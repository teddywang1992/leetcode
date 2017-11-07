package facebook1;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int count = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            count = (nums[i] == 0) ? count + 1 : count - 1;
            if (!map.containsKey(count)) map.put(count, i);
            max = Math.max(max, i - map.get(count));
        }

        return max;
    }
}
