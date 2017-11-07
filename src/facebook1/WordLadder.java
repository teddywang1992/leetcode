package facebook1;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue1 = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();
        queue1.offer(beginWord);
        queue2.offer(1);
        while (!queue1.isEmpty()) {
            String cur = queue1.poll();
            int cnt = queue2.poll();
            if (cur.equals(endWord)) return cnt;
            for (int i = 0; i < cur.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String newWord = cur.substring(0, i) + c + cur.substring(i + 1, beginWord.length());
                    if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                        queue1.offer(newWord);
                        queue2.offer(cnt + 1);
                        visited.add(newWord);
                    }
                }
            }
        }

        return 0;
    }
}
