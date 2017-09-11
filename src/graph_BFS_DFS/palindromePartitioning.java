package graph_BFS_DFS;

import java.util.ArrayList;
import java.util.List;

public class palindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
    private static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        partitionHelper(result, list, 0, s);

        return result;
    }

    private static void partitionHelper(List<List<String>> result, List<String> list, int position, String s) {
        if (position == s.length()) {
            result.add(new ArrayList(list));
            return;
        }

        for (int i = position; i < s.length(); i++) {
            String substring = s.substring(position, i + 1);
            if (!isValid(substring)) {
                continue;
            }

            list.add(substring);
            partitionHelper(result, list, i + 1, s);
            list.remove(list.size() - 1);
        }
    }

    private static boolean isValid(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
