package facebook1;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(result, num, target, 0, 0, 0, "");
        return result;
    }

    private void dfs(List<String> result, String num, int target, int start, long val, long pre, String path) {
        if (start == num.length()) {
            if (target == val) result.add(path);
        }

        for (int i = start + 1; i <= num.length(); i++) {//我们要substring
            if (num.charAt(start) == '0' && i - start > 1) break;

            long v = Long.parseLong(num.substring(start, i));
            if (start == 0) dfs(result, num, target, i, v + val, v, path + v);
            else {
                dfs(result, num, target, i, v + val, v, path + "+" + v);
                dfs(result, num, target, i, val - v, -v, path + "-" + v);
                dfs(result, num, target, i, val - pre + pre * v, pre * v, path + "*" + v);
            }
        }
    }
}
