package warmup;

import java.util.Arrays;

public class twoSum {
    public static void main(String[] args) throws IllegalAccessException {
        int[] input = {2, 7, 11, 15};
        int target = 9;
        twoSum obj = new twoSum();
        System.out.println(Arrays.toString(obj.twoSumFunction(input, target)));
    }

    public int[] twoSumFunction(int[] input, int target) throws IllegalAccessException {
        for (int i = 0; i < input.length; i++) {
            for (int j = input.length - 1; j > i; j--) {
                if (input[i] + input[j] == target)
                    return new int[]{i, j};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}