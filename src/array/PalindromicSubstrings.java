package array;

public class PalindromicSubstrings {
    private int count = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            isPalidromic(s, i, i + 1);
            isPalidromic(s, i, i);
        }

        return count;
    }

    private void isPalidromic(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }
}
