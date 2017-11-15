package facebook3;

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

    public int numDecodings1(String s) {
        if (s == null || s.length() == 0) return 0;
        long[] dp = new long[s.length() + 1];

        dp[0] = 1;
        dp[1] = helper(s, 0);
        for (int i = 2; i <= s.length(); i++) {
            dp[i] = (dp[i - 1] * helper(s, i - 1) + dp[i - 2] * helper(s, i - 2, i)) % 1000000007;
        }

        return (int)dp[s.length()];
    }

    private int helper(String s, int i) {
        char c = s.charAt(i);
        if (c == '*') {
            return 9;
        }
        return c == '0' ? 0 : 1;
    }

    private int helper(String s, int i, int j) {
        char c1 = s.charAt(i);
        char c2 = s.charAt(j - 1);
        if (c1 == '*' && c2 == '*') {
            return 15;
        }
        else if (c1 == '*') {
            return Integer.parseInt(c2 + "") <= 6 ? 2 : 1;
        }
        else if (c2 == '*') {
            switch (c1) {
                case '1' : return 9;
                case '2' : return 6;
                default : return 0;
            }
        }
        else {
            if (c1 != '0' && Integer.parseInt(c1 + "" + c2) <= 26) return 1;
            return 0;
        }
    }
}
