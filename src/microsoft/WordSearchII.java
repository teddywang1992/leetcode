package microsoft;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        if (board == null || words == null || board.length == 0 || board[0].length == 0 || words.length == 0) return result;

        Trie root = buildTrie(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, result, root);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, List<String> result, Trie root) {
        char c = board[i][j];
        if (c == '#' || root.children[c - 'a'] == null) return;
        root = root.children[c - 'a'];
        if (root.word != null) {
            result.add(root.word);
            root.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, result, root);
        if (j > 0) dfs(board, i, j - 1, result, root);
        if (i < board.length - 1) dfs(board, i + 1, j, result, root);
        if (j < board[0].length - 1) dfs(board, i, j + 1, result, root);

        board[i][j] = c;
    }

    private Trie buildTrie(String[] words) {
        Trie head = new Trie();
        Trie cur = null;
        for (String word : words) {
            cur = head;
            for (int i = 0; i < word.length(); i++) {
                if (cur.children[word.charAt(i) - 'a'] == null) {
                    cur.children[word.charAt(i) - 'a'] = new Trie();
                }

                cur = cur.children[word.charAt(i) - 'a'];
                if (i == word.length() - 1) {
                    cur.word = word;
                }
            }
        }

        return head;
    }

    class Trie {
        public Trie[] children;
        public String word;
        public Trie() {
            children = new Trie[26];
            word = null;
        }
    }
}
