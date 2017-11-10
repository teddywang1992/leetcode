package facebook1;

import java.util.*;

public class AutocompleteSystem {
    class Trie {
        Trie[] children;
        Map<String, Integer> countsMap;
        boolean isWord;
        public Trie() {
            children = new Trie[26];
            countsMap = new HashMap<>();
            isWord = false;
        }
    }

    class Pair {
        String s;
        int c;
        public Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }

    Trie root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    private void add(String sentence, int time) {
        Trie cur = root;
        for (char c : sentence.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c-'a'] = new Trie();
            }

            cur = cur.children[c-'a'];
            cur.countsMap.put(sentence, cur.countsMap.getOrDefault(sentence, 0) + 1);
        }
        cur.isWord = true;
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }

        prefix = prefix + c;
        Trie cur = root;

        for (char cc : prefix.toCharArray()) {
            if (cur.children[cc - 'a'] == null) {
                return new ArrayList<>();
            }
            cur = cur.children[cc - 'a'];
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>((p1, p2) -> (p1.c == p2.c ? p2.s.compareTo(p1.s) : p2.c - p1.c));
        for (String word : cur.countsMap.keySet()) {
            heap.add(new Pair(word, cur.countsMap.get(word)));
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3 && !heap.isEmpty(); i++) {
            result.add(heap.poll().s);
        }

        return result;
    }
}
