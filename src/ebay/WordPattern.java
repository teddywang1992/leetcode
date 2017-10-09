package ebay;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] strs = str.split(" ");
        if (strs.length != pattern.length()) return false;
        Map<Character, String> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).trim().equals(strs[i].trim())) {
                    return false;
                }
            } else if (map.containsValue(strs[i])) {
                return false;
            }
            map.put(pattern.charAt(i), strs[i]);
        }

        return true;
    }
}
