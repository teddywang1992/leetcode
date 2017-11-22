package no348_DesignTicTacToe;

public class TicTacToe {

    /** Initialize your data structure here. */
    // int[][] grid;
    int[] rows;
    int[] cols;
    int diag;
    int antiDiag;
    public TicTacToe(int n) {
        // grid = new int[n][n];
        rows = new int[n];
        cols = new int[n];
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        // int n = grid.length;
        // grid[row][col] = player;
        // int i = 0;
        // for (i = 0; i < n; i++) {
        //     if (grid[row][i] != player) break;
        // }
        // if (i == n) return player;
        // for (i = 0; i < n; i++) {
        //     if (grid[i][col] != player) break;
        // }
        // if (i == n) return player;
        // if (row == col) {
        //     for (i = 0; i < n; i++) {
        //         if (grid[i][i] != player) break;
        //     }
        //     if (i == n) return player;
        // }
        // if (row + col == n - 1) {
        //     for (i = 0; i < n; i++) {
        //         if (grid[i][n - i - 1] != player) break;
        //     }
        //     if (i == n) return player;
        // }
        // return 0;
        int size = rows.length;
        int toAdd = player == 1 ? 1 : -1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if (row == col) diag += toAdd;
        if (row == size - 1 - col) antiDiag += toAdd;
        if (Math.abs(rows[row]) == size) return player;
        if (Math.abs(cols[col]) == size) return player;
        if (Math.abs(diag) == size) return player;
        if (Math.abs(antiDiag) == size) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
