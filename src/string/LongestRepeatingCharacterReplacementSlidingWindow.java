package string;

/*
use sliding window.
be careful about the condition "end - start + 1 - maxCount > k"

你个傻逼，不是在窗口start向右滑动的时候把之前的删除了吗，傻逼！
*/

public class LongestRepeatingCharacterReplacementSlidingWindow {
    public static void main(String[] args) {
        String s = "AABAABAABAABAABAABAABAABAABCCCCCC";
        System.out.println(characterReplacement(s, 1));
    }
    private static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int start = 0;
        int end = 0;

        for (end = 0; end < s.length(); end++) {
            int endIndex = s.charAt(end) - 'A';
            count[endIndex]++;
            maxCount = Math.max(maxCount, count[endIndex]);

            while (end - start + 1 - maxCount > k) {
                int startIndex = s.charAt(start) - 'A';
                count[startIndex]--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }

//        System.out.println("maxCount: " + maxCount);
//        System.out.println("countA: " + count['A' - 'A']);

        return maxLength;
    }
}
