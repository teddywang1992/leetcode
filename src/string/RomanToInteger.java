package string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        if (s == null) {
            return 0;
        }

        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length(); i++) {
            result += map.get(s.charAt(i));
            if (i != 0 && map.get(s.charAt(i - 1)) < map.get(s.charAt(i))) {
                result = result - map.get(s.charAt(i - 1)) * 2;
            }
        }

        return result > 3999 ? 3999 : result;
    }
}
