package graph_BFS_DFS;

public class WallsAndGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms == null || rooms.length == 0 || rooms[0].length == 0) {
            return;
        }
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    helper(rooms, i - 1, j, 1);
                    helper(rooms, i + 1, j, 1);
                    helper(rooms, i, j + 1, 1);
                    helper(rooms, i, j - 1, 1);
                }
            }
        }
    }

    private void helper(int[][] rooms, int i, int j, int val) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length) return;

        if (val < rooms[i][j]) {
            rooms[i][j] = val;
            helper(rooms, i - 1, j, val + 1);
            helper(rooms, i + 1, j, val + 1);
            helper(rooms, i, j + 1, val + 1);
            helper(rooms, i, j - 1, val + 1);
        }
    }
}
