package no459_RepeatedSubstringpattern;

public class Solution {
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() < 2) return false;
        String ref = "";
        for (int i = 0; i < str.length() / 2; i++) {
            ref = str.substring(0, i + 1);
            if (check(str, ref)) {
                return true;
            }
        }
        return false;
    }
    private boolean check(String str, String ref) {
        StringBuilder sb = new StringBuilder();
        if (str.length() % ref.length() != 0) return false;
        for (int i = 0; i < str.length() / ref.length(); i++) {
            sb.append(ref);
            if (!str.substring(0, (i + 1) * ref.length()).equals(sb.toString())) return false;
        }
        return true;
    }
}