package LeetCodeAnswer.no340LongestSubstringwithAtMostKDistinctCharacters;

class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        int start = 0, end = 0, counter = k, res = 0;
        int[] map = new int[128];
        while (end < s.length()) {
            char c1 = s.charAt(end++);
            if (++map[c1] == 1) counter--;
            while (counter < 0) {
                char c2 = s.charAt(start++);
                if (--map[c2] == 0) counter++;
            }
            if (counter >= 0) res = Math.max(res, end - start);
        }
        return res;
    }
}