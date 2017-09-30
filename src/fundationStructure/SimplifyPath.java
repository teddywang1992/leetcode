package fundationStructure;

import java.util.*;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> set = new HashSet<>(Arrays.asList("..", "", "."));

        for (String string : path.split("/")) {
            if (string.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!set.contains(string)) stack.push(string);
        }
        String result = "";
        for (String string : stack) result = "/" + string + result;
        return result.isEmpty() ? "/" : result;
    }
}
