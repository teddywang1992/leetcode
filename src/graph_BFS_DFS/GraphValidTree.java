package graph_BFS_DFS;

import java.util.*;

/*
be careful of two thing
1. is the output condition: the hashset size is not equal n
2. the input must equal n - 1;
*/

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n <= 0) {
            return false;
        }

        if (edges.length != n - 1) {
            return false;
        }

        Map<Integer, Set<Integer>> map = initializeGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hashset = new HashSet<>();

        queue.offer(0);
        hashset.add(0);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (Integer children : map.get(current)) {
                if (hashset.contains(children)) {
                    continue;
                }
                queue.offer(children);
                hashset.add(children);
            }
        }

        return hashset.size() == n;
    }

    private Map<Integer, Set<Integer>> initializeGraph(int n, int[][] edge) {
        Map<Integer, Set<Integer>> hashmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashmap.put(i, new HashSet<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int key = edge[i][0];
            int value = edge[i][1];
            hashmap.get(key).add(value);
            hashmap.get(value).add(key);
        }

        return hashmap;
    }
}
