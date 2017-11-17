package facebook3;

import java.util.*;

public class WordLadderII {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        while (!queue.isEmpty()) {
            level++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] chars = cur.toCharArray();
                for (int j = 0; j < cur.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newString = new String(chars);
                        if (wordSet.remove(newString)) {
                            if (newString.equals(endWord)) {
                                return level;
                            }
                            queue.offer(newString);
                        }
                    }
                    chars[j] = cur.charAt(j);
                }
            }
        }
        return 0;
    }

    public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Set<String> startSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        startSet.add(beginWord);
        endSet.add(endWord);
        int level = 1;
        while (!startSet.isEmpty()) {
            level++;
            if (startSet.size() > endSet.size()) {
                Set<String> temp = startSet;
                startSet = endSet;
                endSet = temp;
            }
            Set<String> temp = new HashSet<>();
            for (String word : startSet) {
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        String newWord = new String(chars);
                        if (endSet.contains(newWord)) {
                            return level;
                        }
                        if (wordSet.remove(newWord)) {
                            temp.add(newWord);
                        }
                    }
                    chars[i] = word.charAt(i);
                }
            }
            startSet = temp;
        }
        return 0;
    }


}
