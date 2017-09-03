package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }
    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();

        if(nums.length < 0 || nums == null) {
            return results;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1] ) {
                continue;
            }

            int target = -nums[i];
            int leftPosition = i + 1;
            int rightPosition = nums.length - 1;

            twoSum(nums, leftPosition, rightPosition, target, results);
        }

        return results;
    }

    private static void twoSum(int[] nums,
                        int leftPosition,
                        int rightPosition,
                        int target,
                        List<List<Integer>> results) {
        while(leftPosition < rightPosition) {
            if(nums[leftPosition] + nums[rightPosition] == target) {
                List<Integer> list = new ArrayList<>();
                list.add(-target);
                list.add(nums[leftPosition]);
                list.add(nums[rightPosition]);
                results.add(list);

                leftPosition++;
                rightPosition--;

                while(leftPosition < rightPosition && nums[leftPosition] == nums[leftPosition - 1]) {
                    leftPosition++;
                }
                while(leftPosition < rightPosition && nums[rightPosition] == nums[rightPosition + 1]) {
                    rightPosition--;
                }
            } else if(nums[leftPosition] + nums[rightPosition] < target) {
                leftPosition++;
            } else {
                rightPosition--;
            }
        }
    }
}
