package facebook1;

import java.util.Arrays;

public class TaskScheduler1 {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }
        Arrays.sort(count);

        int idleRow = count[25] - 1;
        int idleCol = n;
        int idles = idleRow * idleCol;

        for (int i = 24; i >= 0 && count[i] != 0; i--) {
            idles -= Math.min(idleRow, count[i]);
        }

        return tasks.length + Math.max(0, idles);
    }
}
