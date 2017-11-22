package LeetCodeAnswer.no242_ValidAnagram;

public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] alpha = new int[26];
        for (char c: s.toCharArray()) alpha[c - 'a']++;
        for (char c: t.toCharArray()) alpha[c - 'a']--;
        for (int i: alpha) {
            if (i != 0) return false;
        }
        return true;
    }
}
