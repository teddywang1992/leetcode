package graph_BFS_DFS;

import java.util.*;

public class topologicalSorting {
    public static ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Map<DirectedGraphNode, Integer> map = new HashMap<>();

        if (graph == null || graph.size() == 0) {
            return result;
        }

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    map.put(neighbor, map.get(neighbor) + 1);
                } else {
                    map.put(neighbor, 1);
                }
            }
        }

        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                queue.offer(node);
                result.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode currentNode = queue.poll();
            for (DirectedGraphNode node : currentNode.neighbors) {
                map.put(node, map.get(node) - 1);
                if (map.get(node) == 0) {
                    queue.offer(node);
                    result.add(node);
                }
            }
        }

        return result;
    }
}
