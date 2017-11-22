package LeetCodeAnswer.no44_WildCardMatching;

public class Solution {
    public boolean isMatch(String s, String p) {
        int index = 0, ptr = 0, match = 0, starIndex = -1;
        while (index < s.length()) {
            if (ptr < p.length() && (p.charAt(ptr) == '?' || s.charAt(index) == p.charAt(ptr))) {
                index++;
                ptr++;
                continue;
            }
            if (ptr < p.length() && p.charAt(ptr) == '*') {
                starIndex = ptr;
                match = index;
                ptr++;
                continue;
            }
            if (starIndex != -1) {
                ptr = starIndex + 1;
                match++;
                index = match;
            } else {
                return false;
            }
        }
        
        while (ptr < p.length() && p.charAt(ptr) == '*') ptr++;
        return ptr == p.length();
    }
}
