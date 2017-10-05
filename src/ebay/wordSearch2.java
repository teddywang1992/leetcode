package ebay;

import java.util.ArrayList;
import java.util.List;

public class wordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TireNode p = buildTire(words);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, result, p);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, List<String> result, TireNode p) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {
            result.add(p.word);
            p.word = null;
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j, result, p);
        if (j > 0) dfs(board, i, j - 1, result, p);
        if (i < board.length - 1) dfs(board, i + 1, j, result, p);
        if (j < board[0].length - 1) dfs(board, i, j + 1, result, p);
        board[i][j] = c;
    }

    private TireNode buildTire(String[] words) {
        TireNode root = new TireNode();

        for (String word : words) {
            TireNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TireNode();
                p = p.next[i];
            }
            p.word = word;
        }

        return root;
    }

    class TireNode {
        TireNode[] next = new TireNode[26];
        String word;
    }
}
