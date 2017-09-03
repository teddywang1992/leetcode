package array;

public class twoSumII_InputArrayIsSorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        if(numbers == null || numbers.length < 2) {
            return result;
        }

        int start = 0;
        int end = numbers.length - 1;
        while(start < end) {
            int sum = numbers[start] + numbers[end];
            if(sum == target) {
                return new int[] {start + 1, end + 1};
            } else if(sum > target) {
                end--;
            } else {
                start++;
            }
        }
        return result;
    }
}
