package facebook3;

import java.util.ArrayList;
import java.util.List;

public class removeInvalidParatheses {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        helper(result, s, 0, 0, new char[]{'(', ')'});
        return result;
    }

    private void helper(List<String> result, String s, int lastI, int lastJ, char[] pair) {
        int count = 0;
        for (int i = lastI; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) count++;
            if (s.charAt(i) == pair[1]) count--;
            if (count >= 0) continue;
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == lastJ || s.charAt(j - 1) != pair[1])) {
                    String str = s.substring(0, j) + s.substring(j + 1);
                    helper(result, str, i, j, pair);
                }
            }
            return;
        }

        String reverse = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            helper(result, reverse, 0, 0, new char[]{')', '('});
        }
        else {
            result.add(reverse);
        }
    }
}
