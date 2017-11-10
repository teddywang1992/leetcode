package facebook1;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses2 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        helper(result, s, 0, 0, new char[] {'(', ')'});
        return result;
    }

    private void helper(List<String> result, String s, int lastI, int lastJ, char[] par) {
        for (int i = lastI, stack = 0; i < s.length(); i++) {
            if (s.charAt(i) == par[0]) stack++;
            if (s.charAt(i) == par[1]) stack--;
            if (stack >= 0) continue;
            for (int j = lastJ; j <= i; j++) {
                if (s.charAt(j) == par[1] && (j == lastJ || s.charAt(j - 1) != par[1])) {
                    helper(result, s.substring(0, j) + s.substring(j + 1, s.length()), i, j, par);
                }
            }
            return;
        }
        String reverse = new StringBuilder(s).reverse().toString();
        if (par[0] == '(') {
            helper(result, reverse, 0, 0, new char[] {')', '('});
        }
        else result.add(reverse);
    }
}
