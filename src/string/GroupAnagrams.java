package string;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        if (strs == null || strs.length == 0) {
            return result;
        }

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String string = new String(chars);
            map.putIfAbsent(string, new ArrayList<>());
            map.get(string).add(str);
        }

        result.addAll(map.values());
        return result;
    }
}
