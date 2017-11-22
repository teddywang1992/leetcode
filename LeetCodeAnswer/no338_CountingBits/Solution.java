package no338_CountingBits;

public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = Integer.bitCount(i);
        }
        return result;
    }
}
