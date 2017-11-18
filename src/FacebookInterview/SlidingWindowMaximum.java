package FacebookInterview;

import java.util.ArrayDeque;
import java.util.Deque;
/*
1. If an element in the deque and it is out of i-(k-1), we discard them. We just need to poll from the head,
as we are using a deque and elements are ordered as the sequence in the array

2. Now only those elements within [i-(k-1),i] are in the deque. We then discard elements smaller than a[i] from
the tail. This is because if a[x] <a[i] and x<i, then a[x] has no chance to be the "max" in [i-(k-1),i], or any
other subsequent window: a[i] would always be a better candidate.

3. As a result elements in the deque are ordered in both sequence in array and their value. At each step the head
of the deque is the max element in [i-(k-1),i]
 */

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        int length = nums.length;
        int[] result = new int[length - k + 1];
        int resIndex = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k - 1) {
                result[resIndex++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
