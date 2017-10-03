package ebay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }

    private static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();


        if (nums == null || nums.length == 0) {
            return result;
        }

        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        Arrays.sort(nums);
        helper(result, list, nums, visited);

        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> list,  int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && visited[i - 1] && nums[i] == nums[i - 1])) {
                continue;
            }

            visited[i] = true;
            list.add(nums[i]);
            helper(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
