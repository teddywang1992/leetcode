package ebay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets2 {
    public static void main(String[] args) {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }

    private static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        helper(result, list, nums, 0);

        return result;
    }

    private static void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int pos) {
        result.add(new ArrayList<>(list));

        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            helper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
