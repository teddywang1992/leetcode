package ebay;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }

    private static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        helper(result, list, nums, 0);

        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) continue;
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
