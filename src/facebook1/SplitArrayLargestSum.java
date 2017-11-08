package facebook1;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }
        int start = max;
        int end = sum;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (isValid(nums, m, mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (isValid(nums, m, start)) return start;
        if (isValid(nums, m, end)) return end;
        return sum;
    }

    private boolean isValid(int[] nums, int m, int mid) {
        long sum = 0;
        int count = 1;
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                sum = num;
                if (++count > m) return false;
            }
        }

        return true;
    }
}
