package microsoft;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "ababd";
        System.out.println(s.substring(0, 2));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            result = helper(s, i, i).length() > result.length() ? helper(s, i, i) : result;
            result = i != s.length() - 1 && helper(s, i, i + 1).length() > result.length() ? helper(s, i, i + 1) : result;
        }

        return result;
    }

    private static String helper(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }
}
