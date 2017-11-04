package facebook1;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> list = new ArrayList<>();
        helper(nums, result, list, 0);

        return result;
    }

    private void helper(int[] nums, List<List<Integer>> result, List<Integer> list, int pos) {
        result.add(new ArrayList<>(list));

        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
