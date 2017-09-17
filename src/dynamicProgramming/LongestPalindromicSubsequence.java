package dynamicProgramming;

/*
f[][] is used for record the count.
if two letters are same. Count + 2.

 */

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[][] f = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            f[i][i] = 1;
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i + 1][j - 1] + 2;
                } else {
                    f[i][j] = Math.max(f[i + 1][j], f[i][j - 1]);
                }
            }
        }

        return f[0][s.length() - 1];
    }
}
