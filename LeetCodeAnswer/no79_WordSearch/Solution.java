package no79_WordSearch;

class Solution {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board, word.toCharArray(), i, j, 0)) return true;
            }
        }
        return false;
    }
    
    private boolean search(char[][] board, char[] word, int i, int j, int len) {
        if (len == word.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word[len]) return false;
        char temp = board[i][j];
        board[i][j] = '*';
        if (search(board, word, i + 1, j, len + 1)) return true;
        if (search(board, word, i - 1, j, len + 1)) return true;
        if (search(board, word, i, j + 1, len + 1)) return true;
        if (search(board, word, i, j - 1, len + 1)) return true;
        board[i][j] = temp;
        return false;
    }
}