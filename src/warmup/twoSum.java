package warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static void main(String[] args) throws IllegalAccessException {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        twoSum obj = new twoSum();
        System.out.println(Arrays.toString(obj.twoSumTwoPointers(input, target)));
    }

    private int[] twoSumFunctionSillyMethod(int[] input, int target) throws IllegalAccessException {
        for (int i = 0; i < input.length; i++) {
            for (int j = input.length - 1; j > i; j--) {
                if (input[i] + input[j] == target)
                    return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    private int[] twoSumFunctionHashMap(int[] input, int target) throws IllegalAccessException {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length; i++) {
            map.put(input[i], i);
        }
        for (int i = 0; i < input.length; i++) {
            int com = target - input[i];
            if(map.containsKey(com) && map.get(com) != i) {
                return new int[] {map.get(com), i};
            }
        }
        throw new IllegalArgumentException("no result");
    }

    private int[] twoSumTwoPointers(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return null;
        }
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);
        while(i < j) {
            if(nums[i] + nums[j] > target) {
                j--;
            }
            if(nums[i] + nums[j] < target) {
                i++;
            }
            if(nums[i] + nums[j] == target) {
                return new int[] {nums[i], nums[j]};
            }
        }
        return null;
    }


}