package no7_ReverseInteger;

public class Solution {
    public int reverse(int x) {
        if (x == Integer.MIN_VALUE) return 0;
        if (x < 0) return -1 * reverse(-x);
        if (x / 10 == 0) return x;
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        if (res > Integer.MAX_VALUE) return 0;
        return (int)res;
    }
}