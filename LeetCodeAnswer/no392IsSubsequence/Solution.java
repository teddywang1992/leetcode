package no392IsSubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;
        if (t == null || t.length() == 0) return false;
        int indexS = 0, indexT = 0;
        if (s.length() > t.length()) return false;
        while (indexS < s.length() && indexT < t.length()) {
            if (s.charAt(indexS) == t.charAt(indexT)) {
                indexS++;
                indexT++;
            } else {
                indexT++;
            }
        }
        return indexS == s.length();
    }
}