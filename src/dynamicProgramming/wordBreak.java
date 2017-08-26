package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class wordBreak {
    public static void main(String[] args) {
        wordBreak obj = new wordBreak();
        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");
        String test = "leetcode";
        System.out.println(obj.wordBreakGood(test, dict));
    }

    private boolean wordBreakNotGood(String s, List<String> wordDict) {
        if(s == null || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        //state
        int n = s.length();
        boolean[] f = new boolean[n + 1];

        //init
        f[0] = true;

        //top down
        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < i; j++) {
                String word = s.substring(j, i);
                f[i] = f[i] || (f[j] && wordDict.contains(word));
            }
        }
        return f[n];
    }

    /*
    two improvement
    1. Finding the max length of the word in wordDict. Make the time complexity decreased to n^2
    2. In the second for loop. if f[i] is false, just skip it.
     */
    public boolean wordBreakGood(String s, List<String> wordDict) {
        if (s == null || wordDict == null || wordDict.size() == 0) {
            return false;
        }

        int maxLength = 0;
        for (String i : wordDict) {
            maxLength = Math.max(maxLength, i.length());
        }

        //state
        int n = s.length();
        boolean[] f = new boolean[n + 1];

        //init
        f[0] = true;

        //top down
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i && j <= maxLength; j++) {
                f[i] = false;
                if (!f[i - j]) {
                    continue;
                }
                String word = s.substring(i - j, i);
                if (wordDict.contains(word)) {
                    f[i] = true;
                    break;
                }
            }
        }
        return f[n];
    }
}
