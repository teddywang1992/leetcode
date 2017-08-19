package warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subSets {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        subSets obj = new subSets();
        System.out.println(obj.subSetsFunction(nums));

    }

    private List<List<Integer>> subSetsFunction(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        subSetsHelper(result, list, nums, 0);
        return result;
    }

    private void subSetsHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int position) {
        result.add(new ArrayList<>(list));
        for (int i = position; i < nums.length; i++) {
//            if (i != position && nums[i] == nums[i - 1]) {
//                continue;
//            }
            list.add(nums[i]);
            subSetsHelper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
