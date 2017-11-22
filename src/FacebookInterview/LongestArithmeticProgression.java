package FacebookInterview;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticProgression {
    public static void main(String[] args) {
        int[] nums = new int[] {2,4,6,20,22,7,9,8,10};
        System.out.println(longestAP(nums));
    }

    private static int longestAP(int[] nums) {
        Map<Integer, Map<Integer, Integer>> startToDiff = new HashMap<>();
        int len = nums.length;
        int maxLen = 2;
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                int diff = nums[j] - nums[i];
                if (!startToDiff.containsKey(nums[i])) {
                    startToDiff.put(nums[i], new HashMap<>());
                }
                Map<Integer, Integer> dToLen = startToDiff.get(nums[i]);
                if (startToDiff.containsKey(nums[j]) && startToDiff.get(nums[j]).containsKey(diff)) {
                    dToLen.put(diff, startToDiff.get(nums[j]).get(diff) + 1);
                    maxLen = Math.max(maxLen, dToLen.get(diff));
                }
                else {
                    dToLen.put(diff, 2);
                }
            }
        }
        return maxLen;
    }
}
