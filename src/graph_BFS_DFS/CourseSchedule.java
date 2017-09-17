package graph_BFS_DFS;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }

        if (prerequisites == null) {
            return false;
        }

        Map<Integer, Set<Integer>> orderMap = new HashMap<>();
        Map<Integer, Integer> indegreeMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            indegreeMap.put(i, 0);
        }

        for (int i = 0; i < prerequisites.length; i++) {
            orderMap.putIfAbsent(prerequisites[i][1], new HashSet<>());
            orderMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegreeMap.put(prerequisites[i][0], indegreeMap.getOrDefault(prerequisites[i][0], 0) + 1);
        }

        for (int key : indegreeMap.keySet()) {
            if (indegreeMap.get(key) == 0) {
                queue.offer(key);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (orderMap.containsKey(current)) {
                for (int i : orderMap.get(current)) {
                    indegreeMap.put(i, indegreeMap.get(i) - 1);
                    if (indegreeMap.get(i) == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        for (int key : indegreeMap.keySet()) {
            if (indegreeMap.get(key) != 0) {
                System.out.println(key);
                return false;
            }
        }

        return true;
    }
}
