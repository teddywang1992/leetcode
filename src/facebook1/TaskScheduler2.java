package facebook1;

import java.util.Arrays;

public class TaskScheduler2 {
    public int leastInterval(char[] tasks, int n) {
        char[] letters = new char[26];
        for (char task : tasks) {
            letters[task - 'A']++;
        }

        Arrays.sort(letters);
        int idleRow = letters[25] - 1, idleCol = n;
        int idleSpace = idleRow * idleCol;
        for (int i = 24; i >= 0; i--) {
            idleSpace -= Math.min(idleRow, letters[i]);
        }

        return tasks.length + Math.max(0, idleSpace);
    }
}
