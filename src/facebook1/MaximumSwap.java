package facebook1;

public class MaximumSwap {
    public int maximumSwap(int num) {
        int[] buckets = new int[10];
        char[] digits = String.valueOf(num).toCharArray();

        for (int i = 0; i < digits.length; i++) {
            buckets[digits[i] - '0'] = i;
        }

        for (int i = 0; i < digits.length; i++) {
            for (int j = 9; j > digits[i] - '0'; j--) {  //不是j >= 0
                if (buckets[j] > i) { //代表这个数在后面
                    char temp = digits[i];
                    digits[i] = digits[buckets[j]];
                    digits[buckets[j]] = temp;
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        return num;
    }
}
