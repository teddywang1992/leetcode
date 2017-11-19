package facebook3;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4};
        int[] sums = new int[nums.length];
        int total = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            total += nums[i];
            sums[i] = total;
            System.out.println("total: " + total);
            System.out.println("sums: " + sums[i]);
        }

    }

    public int findTargetSumWays(int[] nums, int S) {
        int[] sums = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            sums[i] += nums[i];
        }
        return dfs(new HashMap<>(), nums, S, 0, sums);
    }

    private int dfs(Map<String, Integer> map, int[] nums, int s, int pos, int[] sums) {
        String key = pos + "->" + s;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        if (pos == nums.length) {
            return s == 0 ? 1 : 0;
        }
        if (sums[pos] < Math.abs(s)) return 0;
        int add = dfs(map, nums, s - nums[pos], pos + 1, sums);
        int minus = dfs(map, nums, s + nums[pos], pos + 1, sums);

        map.put(key, add + minus);
        return add + minus;
    }
}
