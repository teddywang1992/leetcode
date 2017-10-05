package facebook;

import java.util.Arrays;

public class TaskScheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;

    }

    private static int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        int idleCol = count[25] - 1;
        int idleRow = n;
        int idleSpace = idleCol * idleRow;

        for (int i = 24; i >= 0 && count[i] > 0; i--) {
            idleSpace -= Math.min(idleCol, count[i]);
        }

        return tasks.length + Math.max(idleSpace, 0);
    }
}
