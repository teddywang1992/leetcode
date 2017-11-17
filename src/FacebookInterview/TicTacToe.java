package FacebookInterview;

public class TicTacToe {
    int[] rowVal, colVal;
    int dia, antiDia;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rowVal = new int[n];
        colVal = new int[n];
        dia = 0;
        antiDia = 0;
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
        int val = player == 1 ? 1 : -1;
        int size = rowVal.length;
        rowVal[row] += val;
        colVal[col] += val;
        if (row == col) dia += val;
        if (row == size - 1 - col) antiDia += val;

        if (Math.abs(rowVal[row]) == size || Math.abs(colVal[col]) == size || Math.abs(dia) == size || Math.abs(antiDia) == size) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
