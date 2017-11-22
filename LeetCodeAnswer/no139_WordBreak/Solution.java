package no139_WordBreak;

import java.util.List;

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        if (wordDict == null || wordDict.size() == 0) return false;
        int maxLength = getMaxLength(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int last = 1; last <= i && last <= maxLength; last++) {
                if (!dp[i - last]) continue;
                if (wordDict.contains(s.substring(i - last, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
    
    private int getMaxLength(List<String> wordDict) {
        int res = 0;
        for (String str : wordDict) {
            res = Math.max(res, str.length());
        }
        return res;
    }
}