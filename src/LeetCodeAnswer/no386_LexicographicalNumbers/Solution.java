package LeetCodeAnswer.no386_LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            dfs(result, i, n);
        }
        return result;
    }
    
    private void dfs(List<Integer> result, int cur, int n) {
        if (cur > n) {
            return;
        } else {
            result.add(cur);
            for (int i = 0; i < 10; i++) {
                if (cur * 10 + i > n) {
                    return;
                } else {
                    dfs(result, cur * 10 + i, n);
                }
            }
        }

    }
}