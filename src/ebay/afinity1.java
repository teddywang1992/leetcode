package ebay;

public class afinity1 {
    int attackingPieces(int[] king, int[][] rooks, int[][] bishops, int[][] queens) {
        if (king == null || king.length == 0) return 0;
        int n = 9;
        int count = 8;
        int[][] matrix = new int[n][n];
        for (int[] rook : rooks) {
            if (rook == null || rook[0] >= n || rook[1] >= n) continue;
            matrix[rook[0]][rook[1]] = 1;   //Rook 1
        }
        for (int[] bishop : bishops) {
            if (bishop == null ||bishop[0] >= n || bishop[1] >= n) continue;
            matrix[bishop[0]][bishop[1]] = 2; // Bishop 2
        }
        for (int[] queen : queens) {
            if (queen == null || queen[0] >= n || queen[1] >= n) continue;
            matrix[queen[0]][queen[1]] = 3;  // Queen 3
        }

        matrix[king[0]][king[1]] = 4;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                if (i * j != 0) {
                    count += check(matrix, king[0], king[1], i, j, 1);
                } else {
                    count += check(matrix, king[0], king[1], i, j, 2);
                }

            }
        }
        return count;
    }

    int check(int[][] matrix, int x, int y, int dx, int dy, int sign) {
        while (x > 0 && y > 0 && x < matrix.length && y < matrix.length) {
            if (matrix[x][y] != sign && matrix[x][y] != 4 && matrix[x][y] != 0) return 0;
            else if (matrix[x][y] == sign) return -1;
            x += dx;
            y += dy;
        }
        return -1;
    }
}
