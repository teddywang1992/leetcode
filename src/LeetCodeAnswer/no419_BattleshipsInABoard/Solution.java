package LeetCodeAnswer.no419_BattleshipsInABoard;

public class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length, n = board[0].length;
        int count = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == 'X') {
                    if((i + 1 == m || board[i + 1][j] == '.') 
                    && (j + 1 == n || board[i][j + 1] == '.')) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
