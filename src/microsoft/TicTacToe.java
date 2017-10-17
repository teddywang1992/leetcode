package microsoft;

public class TicTacToe {
    private int[] rowValue;
    private int[] colValue;
    private int dia;
    private int antiDia;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rowValue = new int[n];
        colValue = new int[n];
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
        int add = player == 1 ? 1 : -1;
        rowValue[row] += add;
        colValue[col] += add;

        if (row == col) {
            dia += add;
        }

        if (col == colValue.length - row - 1) {
            antiDia += add;
        }

        int size = rowValue.length;
        System.out.println(colValue[col]);
        if (Math.abs(rowValue[row]) == size
                || Math.abs(colValue[col]) == size
                || Math.abs(dia) == size
                || Math.abs(antiDia) == size) {
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
