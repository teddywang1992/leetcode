package facebook2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
    public static void main(String[] args) {
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        String s = "catsanddog";
        System.out.println(wordBreak(s, wordDict));
    }
    private static Map<String, List<String>> cache = new HashMap<>();
    private static List<String> wordBreak(String s, List<String> wordDict) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> result = new ArrayList<>();
        if (s == null) return result;
        if (s.equals("")) {
            result.add(s);
            return result;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = wordBreak(s.substring(word.length()), wordDict);
                for (String sub : list) {
                    String newString = word + " " + sub;
                    result.add(newString.trim());
                }
            }
        }
        cache.put(s, result);
        return result;
    }
}
