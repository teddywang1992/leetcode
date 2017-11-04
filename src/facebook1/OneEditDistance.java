package facebook1;

public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        if (s == null || t == null) return false;
        int len1 = s.length();
        int len2 = t.length();
        if (Math.abs(len1 - len2) > 1) return false;

        for (int i = 0; i < len1 && i < len2; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (len1 == len2) return s.substring(i + 1).equals(t.substring(i + 1));
                if (len1 > len2) return s.substring(i + 1).equals(t.substring(i));
                else return s.substring(i).equals(t.substring(i + 1));
            }
        }
        //All previous chars are the same, the only possibility is deleting the end char in the longer one of s and t
        return Math.abs(len1 - len2) == 1;
    }
}
