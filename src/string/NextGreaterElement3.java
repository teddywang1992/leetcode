package string;

import java.util.Arrays;

public class NextGreaterElement3 {
    public static void main(String[] args) {
        int n = 55532134;

        System.out.println(nextGreaterElement(n));
    }

    public static int nextGreaterElement(int n) {
        String val = String.valueOf(n);
        char[] chars = val.toCharArray();
        int i;
        int length = chars.length;

        for (i = length - 1; i > 0; i--) {
            if (chars[i - 1] < chars[i]) {
                break;
            }
        }

        if(i == 0) return -1; //注意如果是倒叙排列的数

        for (int j = length - 1; j > 0; j--) {
            if (chars[j] > chars[i - 1]) {
                char temp = chars[j];
                chars[j] = chars[i - 1];
                chars[i - 1] = temp;
                break;
            }
        }

        Arrays.sort(chars, i, length);
        long result = Long.parseLong(String.valueOf(chars));

        return (result <= Integer.MAX_VALUE) ? (int) result : -1;//注意大小
    }
}
