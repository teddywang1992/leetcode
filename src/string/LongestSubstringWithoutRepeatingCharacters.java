package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "pwwkew";
        lengthOfLongestSubstring(s);
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int answer = 0;
        Set<Character> set = new HashSet<>();

        while (left < s.length() && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                answer = Math.max(right - left, answer);
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return answer;
    }
}
