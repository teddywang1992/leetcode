package facebook1;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        if (s == null || s.length() == 0) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j,i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }
}
