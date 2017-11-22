package no323_NumberOfConnectedComponentsInAnUndirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int countComponents(int n, int[][] edges) {
        if (n < 1) return n;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
        for (int i = 0; i < n; i++) map.put(i, new ArrayList<Integer>());
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet<Integer>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited.add(i)) {
                dfs(i, map, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(int i, HashMap<Integer, ArrayList<Integer>> map, HashSet<Integer> visited) {
        for (int j : map.get(i)) {
            if (visited.add(j)) {
                dfs(j, map, visited);
            }
        }
    }
}