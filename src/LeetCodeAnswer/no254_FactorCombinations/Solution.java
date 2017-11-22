package LeetCodeAnswer.no254_FactorCombinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(result, list, n, 2);
        return result;
    }
    private void dfs(List<List<Integer>> result, ArrayList<Integer> list, int n, int start) {
        if (n <= 1) {
            if (list.size() > 1) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
    
        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                list.add(i);
                dfs(result, list, n / i, i);
                list.remove(list.size() - 1);
            }
        }
    }
}
