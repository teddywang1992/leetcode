package no210_CourseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] counts = new int[numCourses];
        List<List<Integer>> links = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) links.add(new ArrayList<Integer>());
        for (int[] edge : prerequisites) {
            counts[edge[0]]++;
            links.get(edge[1]).add(edge[0]);
        }
        int[] res = new int[numCourses];
        Queue<Integer> toVisit = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (counts[i] == 0) toVisit.offer(i);
        }
        int index = 0;
        while (!toVisit.isEmpty()) {
            int from = toVisit.poll();
            res[index++] = from;
            for (int to : links.get(from)) {
                counts[to]--;
                if (counts[to] == 0) toVisit.offer(to);
            }
        }
        return index == numCourses ? res : new int[0];
    }
}