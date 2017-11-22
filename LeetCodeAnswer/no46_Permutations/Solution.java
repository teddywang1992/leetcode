package no46_Permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(result, list, nums);
        return result;
    }
    private void dfs(List<List<Integer>> result, ArrayList<Integer> list, int[] nums) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            dfs(result, list, nums);
            list.remove(list.size() - 1);
        }
    }
}