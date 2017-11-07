package facebook1;

public class PalindromicSubstrings {
    private int count = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        for (int i = 0; i < s.length(); i++) {
            isValid(s, i, i);
            isValid(s, i, i + 1);
        }

        return count;
    }

    private void isValid(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++)) {//注意是while不是if
            count++;
        }
    }
}
