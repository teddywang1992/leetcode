package facebook1;

import java.util.*;

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String s = "(a)())()";
        System.out.println(removeInvalidParentheses(s));
    }

    private static List<String> removeInvalidParentheses(String s) {
        if (s == null || s.length() == 0) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        boolean found = false;
        queue.offer(s);

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            if (isValid(cur)) {
                result.add(cur);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < cur.length(); i++) {
                if (cur.charAt(i) != '(' && cur.charAt(i) != ')') continue;

                String temp  = cur.substring(0, i) + cur.substring(i + 1, cur.length());
                if (!set.contains(temp)) {
                    queue.offer(temp);
                    set.add(temp);
                }
            }
        }

        return result;
    }

    private static boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) return false;
        }

        return count == 0;
    }
}
