package no639_DecodeWaysII;

class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        dp[1] = ways(s.charAt(0));
        for (int i = 2; i <= s.length(); i++) {
            dp[i] = (dp[i - 1] * ways(s.charAt(i - 1)) + dp[i - 2] * ways(s.charAt(i - 2), s.charAt(i - 1))) % 1000000007;
        }
        return (int)dp[s.length()];
    }
    
    private int ways(char c) {
        if (c == '*') return 9;
        if (c == '0') return 0;
        return 1;
    }
    
    private int ways(char c1, char c2) {
        if (c1 != '*' && c2 != '*') {
            int twoDigits = 10 * (c1 - '0') + c2 - '0';
            if (twoDigits >= 10 && twoDigits <= 26) {
                return 1;
            } else {
                return 0;
            }
        }
        
        if (c1 == '*' && c2 == '*') {
            return 15;
        }
        
        if (c1 == '*') {
            if (c2 - '0' <= 6) {
                return 2;
            } else {
                return 1;
            }
        }
        
        if (c1 == '1') return 9;
        if (c1 == '2') return 6;
        return 0;
    }
}