package facebook1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {
    Map<String, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        List<String> result = new ArrayList<>();
        if (s.length() == 0) {
            result.add("");
            return result;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> list = wordBreak(s.substring(word.length()), wordDict);
                for (String sub : list) {
                    sub = word + " " + sub;
                    result.add(sub.trim());
                }
            }
        }

        cache.put(s, result);
        return result;
    }
}
