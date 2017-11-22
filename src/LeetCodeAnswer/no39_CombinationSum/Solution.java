package LeetCodeAnswer.no39_CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        ArrayList<Integer> list = new ArrayList<Integer>();
        dfs(result, list, nums, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, ArrayList<Integer> list, int [] nums, int remain, int start){
        if(remain < 0) return;
        else if(remain == 0) result.add(new ArrayList<Integer>(list));
        else{ 
            for(int i = start; i < nums.length; i++){
                list.add(nums[i]);
                dfs(result, list, nums, remain - nums[i], i); // not i + 1 because we can reuse same elements
                list.remove(list.size() - 1);
            }
        }
    }
}
