package facebook1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i >0 && nums[i] == nums[i - 1]) continue;//去重
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    while (start + 1 < nums.length && nums[start] == nums[start + 1]) start++;//去重
                    while (end - 1 >= 0 && nums[end] == nums[end - 1]) end--;//去重
                    start++;
                    end--;
                }
                if (sum < 0) start++;
                if (sum > 0) end--;
            }
        }

        return result;
    }
}
