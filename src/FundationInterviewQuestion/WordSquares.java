package FundationInterviewQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordSquares {
    public List<List<String>> wordSquares(String[] words) {
        if (words == null || words.length == 0 || words[0].length() == 0) return new ArrayList<>();
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        Trie root = new Trie(words);
        int length = words[0].length();
        dfs(result, list, root, length);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> list, Trie root, int length) {
        if (list.size() == length) {
            result.add(new ArrayList<>(list));
            return;
        }

        int index = list.size();
        StringBuilder sb = new StringBuilder();
        for (String s : list)
            sb.append(s.charAt(index));
        List<String> startWith = root.findPrefix(sb.toString());
        for (String sw : startWith) {
            list.add(sw);
            dfs(result, list, root, length);
            list.remove(list.size() - 1);
        }
    }

    class Trie {
        TrieNode root;
        public Trie(String[] words) {
            root = new TrieNode();
            root.words = Arrays.asList(words);
            for (String word : words) {
                TrieNode cur = root;
                for (char c : word.toCharArray()) {
                    int index = c - 'a';
                    if (cur.children[index] == null) {
                        cur.children[index] = new TrieNode();
                    }
                    cur.children[index].words.add(word);
                    cur = cur.children[index];
                }
            }
        }

        public List<String> findPrefix(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    return new ArrayList<>();
                }
                cur = cur.children[index];
            }
            return cur.words;
        }
    }

    class TrieNode {
        TrieNode[] children;
        List<String> words;
        public TrieNode() {
            children = new TrieNode[26];
            words = new ArrayList<>();
        }
    }
}
