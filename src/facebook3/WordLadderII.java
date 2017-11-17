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

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if(beginWord == null || endWord == null || wordList == null){
            return res;
        }
        Set<String> wordSet = new HashSet<>();
        wordSet.addAll(wordList);
        Map<String, Integer> stepMap = new HashMap<>();
        Map<String, List<String>> prevMap = new HashMap<>();
        for(String word: wordList){
            stepMap.put(word, Integer.MAX_VALUE);
        }
        int minStep = Integer.MAX_VALUE;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        stepMap.put(beginWord, 1);
        //BFS: Dijisktra search
        while(!q.isEmpty()){
            String word = q.poll();
            int step = stepMap.get(word) + 1;//'step' indicates how many steps are needed to travel to one word.
            if(step > minStep){
                break;
            }
            for(int i = 0; i < word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                for(char c = 'a'; c <= 'z'; c++){
                    sb.setCharAt(i, c);
                    String newWord = sb.toString();
                    if(wordSet.contains(newWord)){
                        if(stepMap.get(newWord) < step){//Check if it is the shortest path to one word.
                            continue;
                        }
                        else if(stepMap.get(newWord) > step){
                            stepMap.put(newWord, step);
                            q.add(newWord);
                        }// It is a KEY line. If one word already appeared in one ladder,
                        // Do not insert the same word inside the queue twice. Otherwise it gets TLE.
                        prevMap.putIfAbsent(newWord, new ArrayList<>());
                        prevMap.get(newWord).add(word);
                        if(newWord.equals(endWord)){
                            minStep = step;
                        }
                    }
                }
            }
        }
        //back tracing
        backTrace(res, new ArrayList<>(), prevMap, beginWord, endWord);
        return res;
    }

    private void backTrace(List<List<String>> res, List<String> list, Map<String, List<String>> prevMap, String beginWord, String endWord){
        if(beginWord.equals(endWord)){
            list.add(0, beginWord);
            res.add(new ArrayList<>(list));
            list.remove(0);
            return;
        }
        list.add(0, endWord);
        if(prevMap.containsKey(endWord)){
            for(String prev: prevMap.get(endWord)){
                backTrace(res, list, prevMap, beginWord, prev);
            }
        }
        list.remove(0);
    }
}
