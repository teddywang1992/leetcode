package bit_manipulation;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            int countOne = 0;
            for (int num : nums) {
                countOne += (num >> i) & 1;
            }
            result += countOne * (nums.length - countOne);
        }

        return result;
    }
}
