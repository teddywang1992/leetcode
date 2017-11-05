package facebook1;

import java.util.*;

public class GroupAnagrams {
    private int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;
        Map<Integer, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int value = hash(str);
            map.putIfAbsent(value, new ArrayList<>());
            map.get(value).add(str);
        }

        result.addAll(map.values());
        return result;
    }

    private int hash(String str) {
        int value = 1;
        char[] chars = str.toCharArray();
        for (char c : chars) {
            value *= prime[c - 'a'];
        }

        return value;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) return result;
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String newString = new String(chars);
            map.putIfAbsent(newString, new ArrayList<>());
            map.get(newString).add(str);
        }

        result.addAll(map.values());
        return result;
    }
}
