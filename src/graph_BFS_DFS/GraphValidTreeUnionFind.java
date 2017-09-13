package graph_BFS_DFS;

/*
For Union Find
1. the output condition is two node can't have a same ancestor
*/

public class GraphValidTreeUnionFind {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) {
            return false;
        }

        if (edges.length != n - 1) {
            return false;
        }

        UnionFind  unionFind = new UnionFind(n);
        for (int i = 0; i < edges.length; i++) {
            if (unionFind.find(edges[i][0]) == unionFind.find(edges[i][1])) {
                return false;
            }
            unionFind.union(edges[i][0], edges[i][1]);
        }
        return true;
    }

    private class UnionFind {
        int[] father;

        public UnionFind(int n) {
            father = new int[n];
            for (int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int find(int x) {
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
            int unionX = find(x);
            int unionY = find(y);
            if (unionX != unionY) {
                father[unionX] = unionY;
            }
        }
    }
}
