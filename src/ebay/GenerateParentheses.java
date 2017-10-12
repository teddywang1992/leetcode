package ebay;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n <= 0) return result;
        helper(result, "", 0, 0, n);

        return result;
    }

    private void helper(List<String> result, String string, int open, int close, int n) {
        if (string.length() == n * 2) {
            result.add(string);
            return;
        }

        if (open < n) helper(result, string + "(", open + 1, close, n);
        if (close < open) helper(result, string + ")", open, close + 1, n);
    }
}
