package no294_FlipGameII;

import java.util.HashMap;

public class Solution {
    public boolean canWin(String s) {
        if (s == null || s.length() < 2) return false;
        HashMap<String, Boolean> map = new HashMap<String, Boolean>();
        return helper(s, map);
    }
    private boolean helper(String s, HashMap<String, Boolean> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.startsWith("++", i)) {
                String t = s.substring(0, i) + "--" + s.substring(i + 2);
                if (!helper(t, map)) {
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
