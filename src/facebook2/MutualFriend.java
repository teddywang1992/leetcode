package facebook2;

import java.util.*;

//    find 2nd mutual friend

public class MutualFriend {
    public List<GraphNode> findMutalFriends(GraphNode me) {
        Queue<GraphNode> explore = new LinkedList<>();
        Set<GraphNode> friends = new HashSet<>();
        HashMap<GraphNode, Integer> mutualToCount = new HashMap<>();
        int level = 0;
        explore.offer(me);
        friends.add(me);
        while (!explore.isEmpty() && level <= 2) {
            level++;
            int size = explore.size();
            for (int i = 0; i < size; i++) {
                GraphNode node = explore.poll();
                for (GraphNode friend : node.friend) {
                    if (level == 1) {
                        friends.add(node);
                        explore.offer(node);
                        continue;
                    }
                    if (friends.contains(friend)) {
                        continue;
                    }
                    if (!mutualToCount.containsKey(friend)) {
                        mutualToCount.put(friend, 1);
                    }
                    else {
                        mutualToCount.put(friend, mutualToCount.get(friend) + 1);
                    }
                }

            }
        }
        List<GraphNode> result = new ArrayList<>();
        for (GraphNode node : mutualToCount.keySet()) {
            result.add(node);
        }
        Collections.sort(result, new NodeComparator(mutualToCount));
        return result;
    }
    class NodeComparator implements Comparator<GraphNode> {
        private HashMap<GraphNode, Integer> map;
        public NodeComparator(HashMap<GraphNode, Integer> map) {
            this.map = map;
        }
        @Override
        public int compare(GraphNode node1, GraphNode node2) {
            return map.get(node2) - map.get(node1);
        }
    }
}

class GraphNode {
    String name;
    List<GraphNode> friend;
    public GraphNode(String name) {
        this.name = name;
        this.friend = new ArrayList<>();
    }
}
