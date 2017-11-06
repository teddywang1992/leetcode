package facebook1;

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int length = s.length();
        int[] dp = new int[length + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= length; i++) {
            if (isValid(s, i - 1, i)) {
                dp[i] += dp[i - 1];
            }

            if (isValid(s, i - 2, i)) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[length];
    }

    private boolean isValid(String s, int start, int end) {
        if (start >= 0 && s.charAt(start) != '0' && Integer.parseInt(s.substring(start, end)) <= 26) return true;
        return false;
    }
}
