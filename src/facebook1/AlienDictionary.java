package facebook1;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> orderMap = new HashMap<>();
        Map<Character, Integer> degreeMap = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        if (words == null || words.length == 0) return "";

        for (String word : words) {
            for (char c : word.toCharArray()) {
                degreeMap.put(c, 0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String s1 = words[i - 1];
            String s2 = words[i];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    orderMap.putIfAbsent(c1, new HashSet<>());
                    if (!orderMap.get(c1).contains(c2)) {
                        orderMap.get(c1).add(c2);
                        degreeMap.put(c2, degreeMap.get(c2) + 1);
                    }
                    break;
                }
            }
        }

        for (char c : degreeMap.keySet()) {
            if (degreeMap.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char c1 = queue.poll();
            sb.append(c1);
            if (orderMap.containsKey(c1)) {
                for (char c : orderMap.get(c1)) {
                    degreeMap.put(c, degreeMap.get(c) - 1);
                    if (degreeMap.get(c) == 0) {
                        queue.offer(c);
                    }
                }
            }
        }

        return sb.length() == degreeMap.size() ? sb.toString() : "";
    }
}
