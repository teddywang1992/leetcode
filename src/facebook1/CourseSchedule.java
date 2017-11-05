package facebook1;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> orderMap = new HashMap<>();
        Map<Integer, Integer> indeMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            indeMap.put(i, 0);
        }

        for (int[] prerequisite : prerequisites) {
            orderMap.putIfAbsent(prerequisite[0], new HashSet<>());
            orderMap.get(prerequisite[0]).add(prerequisite[1]);
            indeMap.put(prerequisite[1], indeMap.getOrDefault(prerequisite[1], 0) + 1);
        }

        for (int key : indeMap.keySet()) {
            if (indeMap.get(key) == 0) {
                queue.offer(key);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (orderMap.containsKey(cur)) {
                for (int next : orderMap.get(cur)) {
                    indeMap.put(next, indeMap.get(next) - 1);
                    if (indeMap.get(next) == 0) queue.offer(next);
                }
            }
        }

        for (int key : indeMap.keySet()) {
            if (indeMap.get(key) != 0) return false;
        }

        return true;
    }
}
