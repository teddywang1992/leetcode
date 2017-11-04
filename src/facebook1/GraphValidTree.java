package facebook1;

public class GraphValidTree {


    //     public boolean validTree(int n, int[][] edges) {
//         Set<Integer>[] sets = new HashSet[n];
//         for (int i = 0; i < n; i++) {
//             sets[i] = new HashSet<>();
//         }

//         for (int[] edge : edges) {
//             sets[edge[0]].add(edge[1]);
//             sets[edge[1]].add(edge[0]);
//         }

//         boolean[] visited = new boolean[n];
//         Queue<Integer> queue = new LinkedList<>();
//         queue.offer(0);
//         while (!queue.isEmpty()) {
//             int n1 = queue.poll();
//             if (visited[n1]) {
//                 return false;
//             }
//             visited[n1] = true;

//             for (int n2 : sets[n1]) {
//                 queue.offer(n2);
//                 sets[n2].remove(n1);
//             }
//         }

//         for (boolean b : visited) {
//             if (!b) return false;
//         }

//         return true;

//     }
}
