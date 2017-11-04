package facebook1;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
    public int romanToInt(String s) {
        if (s == null || s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum += map.get(s.charAt(i));
            if (i != 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1))) sum -= map.get(s.charAt(i - 1)) * 2;
        }

        return sum;
    }
}
