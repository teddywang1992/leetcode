package ebay;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (n == 0 || k > n) return result;
        List<Integer> list = new ArrayList<>();

        helper(result, list, k, n, 1);
        // combine(result, list, 1, n, k);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, int k, int n, int pos) {
        if (k == list.size()) {
            result.add(new ArrayList(list));
            return;
        }

        for (int i = pos; i < n + 1; i++) {
            //if (list.contains(i)) continue;
            list.add(i);
            helper(result, list, k, n, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
