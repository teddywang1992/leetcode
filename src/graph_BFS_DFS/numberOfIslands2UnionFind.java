package graph_BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class numberOfIslands2UnionFind {
    public static void main(String[] args) {
        int[][] positions = {{0,0}, {0,1}, {1,2}, {2,1}};
        System.out.println(numIslands2(3, 3, positions));
    }

    private static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        if (positions == null || positions.length == 0 || positions[0].length == 0) {
            return result;
        }

        int[][] island = new int[m][n];
        int count = 0;
        UnionFind2 unionFind = new UnionFind2(n * m);
        int []dx = {0,-1, 0, 1};
        int []dy = {1, 0, -1, 0};

        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if(island[x][y] != 1) {
                count++;
                island[x][y] = 1;
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if(0 <= nx && nx < n && 0 <= ny && ny < m && island[nx][ny] == 1) {
                        int fa = unionFind.compessFind(x * m + y);
                        int ufa = unionFind.compessFind(nx * m + ny);
                        if (fa != ufa) {
                            count--;
                            unionFind.union(fa, ufa);
                        }
                    }
                }
            }

            result.add(count);
        }
        return result;
    }
}

class UnionFind2 {
    int[] father;
    public UnionFind2(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public int compessFind(int x) {
        int parent = father[x];
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
    }

    public void union(int x, int y) {
        int unitX = compessFind(x);
        int unitY = compessFind(y);

        if (unitX != unitY) {
            father[unitX] = unitY;
        }
    }
}
