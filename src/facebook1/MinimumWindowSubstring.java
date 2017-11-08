package facebook1;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null) return "";
        int sl = s.length(), tl = t.length();
        if (sl < tl) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tl; i++) {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int start = -1;
        for (int left = 0, right = 0, count = 0; right < sl; right++) {
            char c1 = s.charAt(right);
            if (map.containsKey(c1)) {
                int cnt1 = map.get(c1) - 1;
                map.put(c1, cnt1);
                if (cnt1 >= 0) {
                    count++;
                }
            }

            while (count == tl) {
                int len = right - left + 1;
                if (minLen > len) {
                    minLen = len;
                    start = left;
                }

                char c2 = s.charAt(left++);
                if (map.containsKey(c2)) {
                    int cnt2 = map.get(c2) + 1;
                    map.put(c2, cnt2);
                    if (cnt2 > 0) {
                        count--;
                    }
                }
            }
        }

        return start >= 0 ? s.substring(start, start + minLen) : "";
    }
}
