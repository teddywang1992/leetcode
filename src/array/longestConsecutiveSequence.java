package array;

import java.util.HashSet;
import java.util.Set;
// use two pointer to point every digit's pre and post number.
// use hashset to store them.
public class longestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> hashset = new HashSet<>();
        int answer = 0;

        for (Integer num : nums) {
            hashset.add(num);
        }

        for (Integer num : nums) {
            int pre = num - 1;
            int post = num + 1;
            while (hashset.contains(pre)) {
                hashset.remove(pre);
                pre--;
            }

            while (hashset.contains(post)) {
                hashset.remove(post);
                post++;
            }

            answer = Math.max(answer, post - pre - 1);
        }

        return answer;
    }
}
