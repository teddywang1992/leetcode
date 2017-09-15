package graph_BFS_DFS;

import java.util.*;

public class MeAlienDictionary {
    //两个表一个队列
    //一个表存的是入度， 一个表存是的字母后面的顺序， 队列存的是入度为零的字母，代表该字母目前是最大的
    // when we init the ordermap, we need to add each letter's indegree
    // when pop from ordermap we need to reduce letter's indegree

    public String alienOrder(String[] words) {
        StringBuilder result = new StringBuilder();
        Map<Character, Set<Character>> ordermap = new HashMap<>();
        Map<Character, Integer> indegreemap = new HashMap<>();
        Queue<Character> queue = new LinkedList<>();

        if (words == null || words.length == 0) {
            return "";
        }

        for (String word : words) {
            for (char c : word.toCharArray()) {
                indegreemap.put(c, 0);
            }
        }

        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];
            int len = Math.min(word1.length(), word2.length());
            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if (c1 != c2) {
                    ordermap.putIfAbsent(c1, new HashSet<>());
                    if (!ordermap.get(c1).contains(c2)) {// this line is because make sure we don't add a element twice
                        ordermap.get(c1).add(c2);
                        indegreemap.put(c2, indegreemap.getOrDefault(c2, 0) + 1);
                    }

                    break;
                }
            }
        }

        for (Character c : indegreemap.keySet()) {
            if (indegreemap.get(c) == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char c1 = queue.poll();
            result.append(c1);
            if (ordermap.containsKey(c1)) { // this line is important . because ordermap may not have every letter like 'f'
                for (Character c2 : ordermap.get(c1)) {
                    indegreemap.put(c2, indegreemap.get(c2) - 1);
                    if (indegreemap.get(c2) == 0) {
                        queue.offer(c2);
                    }
                }
            }
        }
        //be carefully when the size is not same we need to return the wrong situation
        return result.length() == indegreemap.size() ? result.toString() : "";
    }
}
