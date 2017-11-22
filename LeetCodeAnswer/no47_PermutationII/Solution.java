package no47_PermutationII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return result;
        int[] visited = new int[nums.length];
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(result ,list, nums, visited);
        return result;
    }
    
    private void dfs(List<List<Integer>> result, ArrayList<Integer> list, int[] nums, int[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == 1) continue;
            if (i != 0 && nums[i] == nums[i - 1] && visited[i - 1] == 0) continue;
            visited[i] = 1;
            list.add(nums[i]);
            dfs(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }
}