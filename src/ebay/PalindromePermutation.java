package ebay;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {
    public boolean canPermutePalindrome(String s) {
        int flag = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (char c : map.keySet()) {
            if (map.get(c) % 2 == 1) flag++;
        }

        return flag <= 1;
    }
}
