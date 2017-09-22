package string;
/*
三种情况
大于1
等于1
小于1
注意有时会是空，那是就用最后的语句
 */

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s.length() < t.length()) {
            String temp = s;
            s = t;
            t = temp;
        }

        int diff = s.length() - t.length();

        if (diff > 1) {
            return false;
        }

        if (diff == 1) {
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1, s.length()).equals(t.substring(i, t.length()));
                }
            }
        }

        if (diff == 0) {
            for (int i = 0; i < t.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return s.substring(i + 1, s.length()).equals(t.substring(i + 1, t.length()));
                }
            }
        }

        return diff == 1;
    }
}
