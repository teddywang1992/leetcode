package graph_BFS_DFS;

public class constantGraph {
    static UndirectedGraphNode node0 = new UndirectedGraphNode(0);
    static UndirectedGraphNode node1 = new UndirectedGraphNode(1);
    static UndirectedGraphNode node2 = new UndirectedGraphNode(2);

    public static UndirectedGraphNode returnSimpleGraph() {
        node0.neighbors.add(node1);
        node0.neighbors.add(node2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node2);

        return node0;
    }
}
