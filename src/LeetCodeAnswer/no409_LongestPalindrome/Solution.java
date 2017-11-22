package LeetCodeAnswer.no409_LongestPalindrome;

import java.util.HashSet;

public class Solution {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<Character>();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(i));
                count++;
            } else {
                set.add(s.charAt(i));
            }
        }
        if (!set.isEmpty()) {
            return 2 * count + 1;
        } else {
            return 2 * count;
        }
    }
}