package no167_TwoSumII;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if (numbers == null || numbers.length < 2) return res;
        int left = 0, right = numbers.length - 1;
        while (left <= right) {
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else if (numbers[left] + numbers[right] < target) {
                left++;
            } else {
                break;
            }
        }
        res[0] = left + 1;
        res[1] = right + 1;
        return res;
    }
}