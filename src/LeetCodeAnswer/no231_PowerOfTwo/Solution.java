package LeetCodeAnswer.no231_PowerOfTwo;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}