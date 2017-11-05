package facebook1;

import java.util.*;

public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) return null;
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
    }

    private UndirectedGraphNode helper(UndirectedGraphNode node, Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        if (node == null) return null;

        if (map.containsKey(node)) return map.get(node);

        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            newNode.neighbors.add(helper(neighbor, map));
        }

        return newNode;
    }

    public UndirectedGraphNode cloneGraph1(UndirectedGraphNode node) {
        if (node == null) return null;

        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode cur = queue.poll();
            for (UndirectedGraphNode neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }

        return newNode;
    }

    class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };
}
