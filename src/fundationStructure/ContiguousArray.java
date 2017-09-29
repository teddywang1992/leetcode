package fundationStructure;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {
    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int count = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            count = (nums[i] == 0) ? count - 1 : count + 1;
            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLength;
    }
}
