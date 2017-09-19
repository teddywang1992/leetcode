package string;

import java.util.*;

/*
这道题首先可以用BFS来解，我们先把给定字符串排入队中，然后取出检测其是否合法，若合法直接返回，
不合法的话，我们对其进行遍历，对于遇到的左右括号的字符，我们去掉括号字符生成一个新的字符串，
如果这个字符串之前没有遇到过，将其排入队中，我们用哈希表记录一个字符串是否出现过。
我们对队列中的每个元素都进行相同的操作，直到队列为空还没找到合法的字符串的话，那就返回空集
*/

public class RemoveInvalidParentheses {
    public static void main(String[] args) {
        String s = "0123456";
        System.out.println(s.substring(0,2) + s.substring(2, s.length()));
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        boolean found = false;

        if (s == null) {
            return result;
        }

        queue.offer(s);
        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (isValid(current)) {
                found = true;
                result.add(current);
            }

            if (found) continue;

            for (int i = 0; i < current.length(); i++) {
                if (current.charAt(i) != '(' && current.charAt(i) != ')') continue;
                String temp = current.substring(0, i) + current.substring(i + 1, current.length());
                if (!map.containsKey(temp)) {
                    map.put(temp, 1);
                    queue.offer(temp);
                }
            }
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
