package graph_BFS_DFS;

import java.util.*;


public class wordLadder {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> dic = new ArrayList<>();
        dic.add("hot");
        dic.add("dot");
        dic.add("lot");
        dic.add("log");
        dic.add("cog");

        System.out.println(ladderLength(start, end, dic));
    }

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0) {
            return 0;
        }

        if (beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0) {
            return 0;
        }

        wordList.add(beginWord);
        wordList.add(endWord);

        Set<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);
        set.add(beginWord);

        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord : getNextWords(word, wordList)) {
                    if (set.contains(nextWord)) {
                        continue;
                    }

                    if (nextWord.equals(endWord)) {
                        return length;
                    }

                    queue.offer(nextWord);
                    set.add(nextWord);
                }
            }
        }
        return 0;
    }

    private static List<String> getNextWords(String word, List<String> wordList) {
        List<String> result = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == c) {
                    continue;
                }

                String newWord = replace(word, i, c);
                if (wordList.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }

        return result;
    }

    private static String replace(String word, int position, char c) {
        char[] chars = word.toCharArray();
        chars[position] = c;
        return new String(chars);
    }
}
