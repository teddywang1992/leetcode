package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharactersReturnString {
    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstringReturnString(s));

    }
    public static String lengthOfLongestSubstringReturnString(String s) {
        int left = 0;
        int right = 0;
        String result = "";
        int length = 0;
        Set<Character> set = new HashSet<>();

        while (left < s.length() && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
                if (length < right - left) {
                    result = s.substring(left, right);
                    length = right - left;
                }
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return result;
    }
}
