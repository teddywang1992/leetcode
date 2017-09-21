package array;

import java.util.HashSet;
import java.util.Set;

public class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        int distance = Integer.MAX_VALUE;

        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) set1.add(i);
            if (word2.equals(words[i])) set2.add(i);
        }

        for (Integer key1 : set1) {
            for (Integer key2 : set2) {
                distance = Math.min(distance, Math.abs(key1 - key2));
            }
        }

        return distance;
    }
}
