package facebook1;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, 0, word)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, int pos, String word) {
        if (pos == word.length()) return true;
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(pos)) return false;

        char c = board[i][j];
        board[i][j] = '#';
        boolean result = dfs(board, i - 1, j, pos + 1, word) ||
                dfs(board, i + 1, j, pos + 1, word) ||
                dfs(board, i, j - 1, pos + 1, word) ||
                dfs(board, i, j + 1, pos + 1, word);
        board[i][j] = c;

        return result;
    }
}
