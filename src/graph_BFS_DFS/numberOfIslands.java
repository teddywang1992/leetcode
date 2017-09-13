package graph_BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;

public class numberOfIslands {
    private class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfsHelper(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void bfsHelper(char[][] grid, int x, int y) {
        Queue<Coordinate> queue = new LinkedList<>();
        grid[x][y] = '0';

        int[] directX = {1, 0, -1, 0};
        int[] directY = {0, 1, 0, -1};

        queue.offer(new Coordinate(x, y));
        while(!queue.isEmpty()) {
            Coordinate coor = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = coor.x + directX[i];
                int nextY = coor.y + directY[i];
                Coordinate current = new Coordinate(nextX, nextY);

                if (!isBound(grid, current)) {
                    continue;
                }
                if (grid[current.x][current.y] == '1') {
                    grid[current.x][current.y] = '0';
                    bfsHelper(grid, current.x, current.y);
                }
            }
        }
    }

    private boolean isBound(char[][] grid, Coordinate coor) {
        int n = grid.length;
        int m = grid[0].length;
        return coor.x >= 0 && coor.x < n && coor.y >= 0 && coor.y < m;
    }
}
