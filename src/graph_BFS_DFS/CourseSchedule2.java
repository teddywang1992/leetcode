package graph_BFS_DFS;

import java.util.*;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null) {
            return new int[]{};
        }

        Map<Integer, Integer> indegreeMap = new HashMap<>();
        Map<Integer, Set<Integer>> orderMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        int index = 0;

        for (int i = 0; i < numCourses; i++) {
            indegreeMap.put(i, 0);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            orderMap.putIfAbsent(prerequisites[i][1], new HashSet<>());
            orderMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegreeMap.put(prerequisites[i][0], indegreeMap.getOrDefault(prerequisites[i][0], 0) + 1);
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegreeMap.get(i) == 0) {
                queue.offer(i);
                result[index] = i;
                index++;
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (orderMap.containsKey(current)) {
                for (int key : orderMap.get(current)) {
                    indegreeMap.put(key, indegreeMap.get(key) - 1);
                    if(indegreeMap.get(key) == 0) {
                        result[index] = key;
                        queue.offer(key);
                        index++;
                    }
                }
            }
        }

        for (int i = 0; i < numCourses; i++) {
            if (indegreeMap.get(i) != 0) {
                return new int[]{};
            }
        }

        return result;
    }
}
