package no78_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return result;
        Arrays.sort(nums);
        dfs(result, list, nums, 0);
        return result;
    }
    private void dfs(List<List<Integer>> result, ArrayList<Integer> list, int[] nums, int pos) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            dfs(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}