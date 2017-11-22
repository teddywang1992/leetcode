package LeetCodeAnswer.no22_GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n <= 0) return result;
        dfs(result, "", n, n);
        return result;
    }
    private void dfs(List<String> result, String cur, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(cur);
            return;
        }
        if (left > 0) {
            dfs(result, cur + "(", left - 1, right);
        }
        if (right > 0 && left < right) {
            dfs(result, cur + ")", left, right - 1);
        }
    }
}
