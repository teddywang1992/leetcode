package facebook1;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int len = 0;
        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int pre = num - 1;
            int post = num + 1;
            while (set.contains(pre)) {
                set.remove(pre);
                pre--;
            }
            while (set.contains(post)) {
                set.remove(post);
                post++;
            }
            len = Math.max(len, post - pre - 1);
        }
        return len;
    }
}
