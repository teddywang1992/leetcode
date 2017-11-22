package LeetCodeAnswer.no269_AlienDictionary;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution {
    public String alienOrder(String[] words) {
        List<Set<Integer>> adj = new ArrayList<Set<Integer>>();
        if (words == null || words.length == 0) return "";
        for (int i = 0; i < 26; i++) adj.add(new HashSet<Integer>());
        int[] degree = new int[26];
        Arrays.fill(degree, -1);
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (degree[c - 'a'] < 0) degree[c - 'a'] = 0;
            }
            if (i == 0) continue;
            String w1 = words[i - 1], w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                int c1 = w1.charAt(j) - 'a', c2 = w2.charAt(j) - 'a';
                if (c1 != c2) {
                    if (!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        degree[c2]++;
                    }
                    break;
                }
                if (j == w2.length() - 1 && w1.length() > w2.length()) return "";
            }
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < 26; i++) {
            if (degree[i] == 0) queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            int c = queue.poll();
            sb.append((char)(c + 'a'));
            for (int j : adj.get(c)) {
                degree[j]--;
                if (degree[j] == 0) queue.offer(j);
            }
        }
        for (int d : degree) {
            if (d > 0) return "";
        }
        return sb.toString();
    }
}
