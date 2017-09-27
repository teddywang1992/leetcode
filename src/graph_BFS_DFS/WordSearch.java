package graph_BFS_DFS;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        boolean[][] isVisited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; i++) {
                if (board[i][j] == word.charAt(0) && helper(board, word,isVisited, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, String word, boolean[][] isVisited, int index, int i, int j) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i > board.length || j < 0 || j > board[0].length || isVisited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        isVisited[i][j] = true;
        if (helper(board, word, isVisited, index + 1, i + 1, j)) {
            return true;
        }
        if (helper(board, word, isVisited, index + 1, i - 1, j)) {
            return true;
        }
        if (helper(board, word, isVisited, index + 1, i, j + 1)) {
            return true;
        }
        if (helper(board, word, isVisited, index + 1, i, j - 1)) {
            return true;
        }
        isVisited[i][j] = false;

        return false;
    }
}
