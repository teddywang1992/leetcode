package facebook1;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int pre = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            int time = Integer.parseInt(parts[2]);
            if (parts[1].equals("start")) {
                if (!stack.isEmpty()) result[stack.peek()] += time - pre;
                stack.push(id);
                pre = time;
            } else {
                result[stack.pop()] += time - pre + 1;
                pre = time + 1;
            }
        }

        return result;
    }
}
