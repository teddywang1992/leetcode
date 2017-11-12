package facebook1;

import java.util.HashMap;
import java.util.Map;

public class targetSum2 {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(new HashMap<>(), nums, S, 0);
    }

    private int dfs(Map<String, Integer> map, int[] nums, int s, int pos) {
        String key = pos + "->" + s;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (pos == nums.length) {
            return s == 0 ? 1 : 0;
        }
        int add = dfs(map, nums, s - nums[pos], pos + 1);
        int minus = dfs(map, nums, s + nums[pos], pos + 1);

        map.put(key, add + minus);
        return add + minus;
    }
}
