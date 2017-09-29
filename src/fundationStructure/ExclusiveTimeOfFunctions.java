package fundationStructure;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeOfFunctions {
    public static void main(String[] args) {

    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[n];
        int preTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            if (!stack.isEmpty()) result[stack.peek()] += Integer.parseInt(parts[2]) - preTime;
            preTime = Integer.parseInt(parts[2]);
            if (parts[1].equals("start")) stack.push(Integer.parseInt(parts[0]));
            else {
                preTime++;
                result[stack.pop()]++;
            }
        }

        return result;
    }
}
