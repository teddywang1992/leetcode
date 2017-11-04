package facebook1;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;

        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return isValid(s, start + 1, end) || isValid(s, start, end - 1);
            }
            start++;
            end--;
        }

        return true;
    }

    private boolean isValid(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }

        return true;
    }
}
