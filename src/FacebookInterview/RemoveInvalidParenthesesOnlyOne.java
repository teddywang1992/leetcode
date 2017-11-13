package FacebookInterview;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesesOnlyOne {
    public static void main(String[] args) {
        String s = "()))(()()";
//        System.out.println(remove(s));
//        System.out.println(removeWithList(s));
        for (String res : removeWithList(s)) {
            System.out.println(res);
        }
    }

    private static String remove(String s) {
        if (s == null) return "";
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            if (count < 0) {
                return s.substring(0, i) + remove(s.substring(i+1));
            }
        }
        return s;
    }

    private static List<String> removeWithList(String s) {
        List<String> result = new ArrayList<>();
        dfs(result, s, 0, 0, new char[] {'(', ')'});
        return result;
    }

    private static void dfs(List<String> result, String s, int lastI, int lastJ, char[] pair) {
        int count = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) count++;
            if (s.charAt(i) == pair[1]) count--;
            if (count >= 0) continue;
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == lastJ || s.charAt(j - 1) != pair[1])) {
                    String sub = s.substring(0, j) + s.substring(j + 1);
                    dfs(result, sub, i, j, pair);
                }
            }
            return;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            dfs(result, reverse, 0, 0, new char[] {')', '('});
        }
        else {
            result.add(reverse);
        }
    }
}
