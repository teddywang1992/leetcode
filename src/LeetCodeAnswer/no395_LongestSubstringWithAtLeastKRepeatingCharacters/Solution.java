package LeetCodeAnswer.no395_LongestSubstringWithAtLeastKRepeatingCharacters;

public class Solution {
    public int longestSubstring(String s, int k) {
        char[] chars = s.toCharArray();
        return helper(chars, 0, s.length(), k);
    }
    
    private int helper(char[] chars, int start, int end, int k) {
        if (end <= start || k > end - start) return 0;
        int[] count = new int[26];
        for(int i = start; i < end; i++) count[chars[i] - 'a']++;
        for(int i = 0; i < 26; i++) {
            if(count[i] == 0) continue;
            if(count[i] < k) {
                for(int j = start; j < end; j++) {
                    if(chars[j] == i+'a') {
                        return Math.max(helper(chars, start, j, k), helper(chars, j + 1, end, k));
                    }
                }
            }
        }
        return end-start;
    }
}