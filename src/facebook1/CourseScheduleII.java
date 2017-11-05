package facebook1;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];
        Map<Integer, Set<Integer>> orderMap = new HashMap<>();
        Map<Integer, Integer> indeMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            indeMap.put(i, 0);
        }

        for (int[] prerequisite : prerequisites) {
            orderMap.putIfAbsent(prerequisite[1], new HashSet<>());
            orderMap.get(prerequisite[1]).add(prerequisite[0]);
            indeMap.put(prerequisite[0], indeMap.getOrDefault(prerequisite[0], 0) + 1);
        }

        for (int key : indeMap.keySet()) {
            if (indeMap.get(key) == 0) queue.offer(key);
        }
        int index = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            result[index++] = cur;
            if (orderMap.containsKey(cur)) {
                for (int next : orderMap.get(cur)) {
                    indeMap.put(next, indeMap.get(next) - 1);
                    if (indeMap.get(next) == 0) queue.offer(next);
                }
            }
        }

        for (int key : indeMap.keySet()) {
            if (indeMap.get(key) != 0) return new int[]{};
        }

        return result;
    }
}
