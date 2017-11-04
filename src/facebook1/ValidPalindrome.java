package facebook1;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        char[] chars = s.toLowerCase().toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            while (start < chars.length && !Character.isLetterOrDigit(chars[start])) start++;
            while (end >= 0 && !Character.isLetterOrDigit(chars[end])) end--;
            if (start < end && chars[start++] != chars[end--]) return false;
        }

        return true;
    }
}
