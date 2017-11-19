package facebook3;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        int[] counter = new int[256];
        for (char c : t.toCharArray()) {
            counter[c]++;
        }
        int start = -1;
        int remain = t.length();
        int low = 0, high = 0;
        int minLen = Integer.MAX_VALUE;
        while (high < s.length()) {
            if (counter[s.charAt(high++)]-- > 0) remain--;
            while (remain == 0) {
                if (minLen > high - low) {
                    minLen = high - low;
                    start = low;
                }
                if (++counter[s.charAt(low++)] > 0) remain++;
            }
        }

        return start == -1 ? "" : s.substring(start, start + minLen);
    }
}
