package facebook1;

public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        if (rooms== null || rooms.length == 0 || rooms[0].length == 0) return;

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] rooms, int i, int j, int val) {
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < val) return;
        rooms[i][j] = val;
        dfs(rooms, i - 1, j, val + 1);
        dfs(rooms, i + 1, j, val + 1);
        dfs(rooms, i, j + 1, val + 1);
        dfs(rooms, i, j - 1, val + 1);
    }
}
