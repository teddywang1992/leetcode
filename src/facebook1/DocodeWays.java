package facebook1;

public class DocodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            if (isValid(s, i - 1, i)) {
                dp[i] += dp[i - 1];
            }

            if (isValid(s, i - 2, i)) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }

    private boolean isValid(String s, int i, int j) {
        return s.charAt(i) != '0' && Integer.valueOf(s.substring(i, j)) <= 26;
    }
}
