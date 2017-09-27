package dynamicProgramming;

/*
I used a dp array of size n + 1 to save subproblem solutions. dp[0] means an empty string will have one way to decode,
dp[1] means the way to decode a string of size 1. I then check one digit and two digit combination and save the
results along the way. In the end, dp[n] will be the end result.
 */

public class DecodeWays {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = (s.charAt(0) == '0') ? 0 : 1;

        for (int i = 2; i < s.length() + 1; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            int two = Integer.valueOf(s.substring(i - 2, i));

            if (one > 0 && one < 10) {
                dp[i] += dp[i - 1];
            }
            if (two > 9 && two < 27) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[s.length()];
    }
}
