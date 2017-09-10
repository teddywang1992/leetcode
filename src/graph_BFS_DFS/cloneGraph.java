package graph_BFS_DFS;

import java.util.*;

public class cloneGraph {
    public static void main(String[] args) {
        UndirectedGraphNode node = constantGraph.returnSimpleGraph();
        cloneGraph(node);
    }
    private static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }

        Map<UndirectedGraphNode, UndirectedGraphNode> hashmap = new HashMap<>();
        List<UndirectedGraphNode> nodes = getNodes(node);

        for (UndirectedGraphNode n : nodes) {
            hashmap.put(n, new UndirectedGraphNode(n.label));
        }

        for (UndirectedGraphNode n : nodes) {
            UndirectedGraphNode newNode = hashmap.get(n);

            for (UndirectedGraphNode neighbor : n.neighbors) {
                newNode.neighbors.add(hashmap.get(neighbor));
            }
        }

        return hashmap.get(node);
    }

    private static List<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Set<UndirectedGraphNode> hashset = new HashSet<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();

        queue.offer(node);
        hashset.add(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();

            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (hashset.contains(neighbor)) {
                    queue.offer(neighbor);
                    hashset.add(neighbor);
                }
            }
        }

        return new ArrayList<>(hashset);
    }
}