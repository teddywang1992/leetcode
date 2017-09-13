package graph_BFS_DFS;

/*
For the union find version

make 2 dimention map to a array
*/

public class NumberOfIslandsUnionFind {
    public static void main(String[] args) {
        String line1 = "11110";
        String line2 = "11010";
        String line3 = "11000";
        String line4 = "00001";

        char[][] grid = new char[4][5];
        grid[0] = line1.toCharArray();
        grid[1] = line2.toCharArray();
        grid[2] = line3.toCharArray();
        grid[3] = line4.toCharArray();

        System.out.println(numIslands(grid));
    }

    private static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int total = 0;
        UnionFind unionFind = new UnionFind(n * m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    total++;
                }
            }
        }
        unionFind.setCount(total);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    if (i > 0 && grid[i - 1][j] == '1') unionFind.union(i * m + j, (i - 1) * m + j);
                    if (i < n - 1 && grid[i + 1][j] == '1') unionFind.union(i * m + j, (i + 1) * m + j);
                    if (j > 0 && grid[i][j - 1] == '1') unionFind.union(i * m + j, i * m + j - 1);
                    if (j < m - 1 && grid[i][j + 1] == '1') unionFind.union(i * m + j, i * m + j + 1);
                }
            }
        }

        return unionFind.getCount();
    }
}

class UnionFind{
    int[] father = null;
    int count;

    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int find(int x) {
//        int parent = x;
//        while (parent != father[parent]) {
//            parent = father[parent];
//        }
//        return parent;

        int parent = x;
        while (parent != father[parent]) {
            parent = father[parent];
        }

        int next;

        while (x != father[x]) {
            next = father[x];
            father[x] = parent;
            x = next;
        }
        return parent;

//        if (father[x] == x) {
//            return x;
//        }
//
//        return father[x] = find(father[x]);
    }

    public void union(int x, int y) {
        int unionX = find(x);
        int unionY = find(y);

        if (unionX != unionY) {
            father[unionX] = unionY;
            count--;
        }
    }
}
