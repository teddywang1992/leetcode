package no290_WordPattern;

import java.util.HashMap;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        char[] patternChar = pattern.toCharArray();
        String[] strs = str.trim().split("\\s+");
        if (patternChar.length != strs.length) return false;
        HashMap<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < patternChar.length; i++) {
            if (!map.containsKey(patternChar[i])) {
                if (map.containsValue(strs[i])) return false;
                map.put(patternChar[i], strs[i]);
            } else {
                if (!strs[i].equals(map.get(patternChar[i]))) return false;
            }
        }
        return true;
    }
}
