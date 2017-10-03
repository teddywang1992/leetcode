package ebay;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    private static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        helper(result, list, nums, 0);

        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        result.add(new ArrayList<>(list));

        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
